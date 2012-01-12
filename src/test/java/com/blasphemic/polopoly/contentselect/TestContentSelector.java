package com.blasphemic.polopoly.contentselect;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.polopoly.cm.ContentId;
import com.polopoly.cm.VersionedContentId;
import com.polopoly.cm.client.Content;

public class TestContentSelector
{
    private TestCmServer cmServer;
    private ContentSelector selector;

    @Before
    public void before()
    {
        cmServer = new TestCmServer();
        selector = new ContentSelector(cmServer);
    }

    @Test(expected=IllegalArgumentException.class)
    public void test_content_select_with_null_root_id()
        throws Exception
    {
        selector.select(null, null, null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void test_content_select_with_non_existing_content()
        throws Exception
    {
        selector.select(new VersionedContentId(new ContentId(1, 100), 1), null, null);
    }

    @Test
    public void test_content_select_with_single_node()
        throws Exception
    {
        Content content = new TestContent(new ContentId(1, 100));

        cmServer.addContent(content);

        ContentGraphTraverseResult result = selector.select(content.getContentId(), null, null);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getResultRootVertex());

        assertContentGraphConsistsOf(result, content.getContentId());
    }

    @Test
    public void test_content_select_with_simple_two_node_chain()
        throws Exception
    {
        Content content1 = new TestContent(new ContentId(1, 100));
        Content content2 = new TestContent(new ContentId(1, 200));

        content1.setContentReference("test", "test", new ContentId(1, 200));

        cmServer.addContent(content1, content2);

        ContentGraphTraverseResult result = selector.select(content1.getContentId(), null, null);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getResultRootVertex());

        assertContentGraphConsistsOf(result, content1.getContentId(), content2.getContentId());
    }

    @Test
    public void test_content_select_with_simple_tree()
        throws Exception
    {
        Content content1 = new TestContent(new ContentId(1, 100));
        Content content2 = new TestContent(new ContentId(1, 200));
        Content content3 = new TestContent(new ContentId(1, 300));

        content1.setContentReference("test", "test", new ContentId(1, 200));
        content1.setContentReference("test", "test2", new ContentId(1, 300));

        cmServer.addContent(content1, content2, content3);

        ContentGraphTraverseResult result = selector.select(content1.getContentId(), null, null);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getResultRootVertex());

        assertContentGraphConsistsOf(result, content1.getContentId(), content2.getContentId(), content3.getContentId());
    }

    @Test
    public void test_content_select_with_simple_looped_graph()
        throws Exception
    {
        Content content1 = new TestContent(new ContentId(1, 100));
        Content content2 = new TestContent(new ContentId(1, 200));

        content1.setContentReference("test", "test", new ContentId(1, 200));
        content2.setContentReference("test", "test", new ContentId(1, 100));

        cmServer.addContent(content1, content2);

        ContentGraphTraverseResult result = selector.select(content1.getContentId(), null, null);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getResultRootVertex());

        assertContentGraphConsistsOf(result, content1.getContentId(), content2.getContentId());
    }

    @Test
    public void test_content_select_with_multiple_looped_graph()
        throws Exception
    {
        Content content1 = new TestContent(new ContentId(1, 100));
        Content content2 = new TestContent(new ContentId(1, 200));
        Content content3 = new TestContent(new ContentId(1, 300));

        content1.setContentReference("test", "test", new ContentId(1, 200));
        content1.setContentReference("test", "test2", new ContentId(1, 300));
        content2.setContentReference("test", "test", new ContentId(1, 100));
        content3.setContentReference("test", "test", new ContentId(1, 200));

        cmServer.addContent(content1, content2, content3);

        ContentGraphTraverseResult result = selector.select(content1.getContentId(), null, null);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getResultRootVertex());

        assertContentGraphConsistsOf(result, content1.getContentId(), content2.getContentId(), content3.getContentId());
    }

    private void assertContentGraphConsistsOf(final ContentGraphTraverseResult result,
                                              final ContentId... contentIds)
    {
        Assert.assertEquals(contentIds.length, result.getResultNodeCount());

        List<ContentId> expectedContentIds = new ArrayList<ContentId>(result.getAllResultContentIds());

        for (ContentId contentId : contentIds) {
            expectedContentIds.remove(contentId);
        }

        Assert.assertEquals("Still had the following in list: " + expectedContentIds, 0, expectedContentIds.size());
    }
}
