package com.blasphemic.polopoly.contentselect;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.polopoly.cm.ContentId;
import com.polopoly.cm.client.Content;

public class ContentSelectorTest
{
    private static final Logger LOG = Logger.getLogger(ContentSelectorTest.class.getName());

    private TestCmServer cmServer;
    private ContentSelector selector;

    @Before
    public void setup()
    {
        cmServer = new TestCmServer();
        selector = new ContentSelector(cmServer);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSelectNull()
        throws Exception
    {
        selector.select(null);
    }

    @Test
    public void testSelectSingleContent()
        throws Exception
    {
        Content content1 = new TestContent(new ContentId(1, 100));
        cmServer.addContent(content1);

        List<ContentId> result = selector.select(content1.getContentId());

        Assert.assertNotNull(result);

        assertListContains(result, content1.getContentId());
    }

    @Test
    public void testSelectLinkedContent()
        throws Exception
    {
        Content content1 = new TestContent(new ContentId(1, 100));
        Content content2 = new TestContent(new ContentId(2, 100));

        content1.setContentReference("group", "name", content2.getContentId());

        cmServer.addContent(content1, content2);

        List<ContentId> result = selector.select(content1.getContentId());

        Assert.assertNotNull(result);

        assertListContains(result, content1.getContentId(), content2.getContentId());
    }

    @Test
    public void testSelectMultipleContentLinks()
        throws Exception
    {
        Content content1 = new TestContent(new ContentId(1, 100));
        Content content2 = new TestContent(new ContentId(2, 100));
        Content content3 = new TestContent(new ContentId(3, 100));

        content1.setContentReference("group1", "name1", content2.getContentId());
        content1.setContentReference("group2", "name2", content3.getContentId());

        cmServer.addContent(content1, content2, content3);

        List<ContentId> result = selector.select(content1.getContentId());

        Assert.assertNotNull(result);

        assertListContains(result, content1.getContentId(), content2.getContentId(), content3.getContentId());
    }

    @Test
    public void testSelectContentReferencedFromMultipleLinks()
        throws Exception
    {
        Content content1 = new TestContent(new ContentId(1, 100));
        Content content2 = new TestContent(new ContentId(2, 100));
        Content content3 = new TestContent(new ContentId(3, 100));

        content1.setContentReference("group1", "name1", content2.getContentId());
        content1.setContentReference("group2", "name2", content3.getContentId());
        content2.setContentReference("group1", "name1", content3.getContentId());

        cmServer.addContent(content1, content2, content3);

        List<ContentId> result = selector.select(content1.getContentId());

        Assert.assertNotNull(result);

        assertListContains(result, content1.getContentId(), content2.getContentId(), content3.getContentId());
    }

    @Test
    public void testSelectContentWithCircularLinks()
        throws Exception
    {
        Content content1 = new TestContent(new ContentId(1, 100));
        Content content2 = new TestContent(new ContentId(2, 100));

        content1.setContentReference("group1", "name1", content2.getContentId());
        content2.setContentReference("group1", "name1", content1.getContentId());

        cmServer.addContent(content1, content2);

        List<ContentId> result = selector.select(content1.getContentId());

        Assert.assertNotNull(result);

        assertListContains(result, content1.getContentId(), content2.getContentId());
    }

    private void assertListContains(final List<ContentId> result,
                                    final ContentId... contentIds)
    {
        try {
            Assert.assertEquals(result.size(), contentIds.length);

            for (ContentId contentId : contentIds) {
                Assert.assertTrue(result.contains(contentId));
            }
        } catch (AssertionError ae) {
            LOG.log(Level.WARNING, "List was: " + result);
            throw ae;
        }
    }
}
