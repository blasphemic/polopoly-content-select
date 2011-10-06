package com.blasphemic.polopoly.contentselect.list;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.blasphemic.polopoly.contentselect.ContentSelectorTraverser;
import com.polopoly.cm.ContentId;
import com.polopoly.cm.client.CMException;
import com.polopoly.cm.client.CMServer;
import com.polopoly.cm.client.Content;

public class ContentSelectorTraverserList
    implements ContentSelectorTraverser
{
    private static final Logger LOG = Logger.getLogger(ContentSelectorTraverserList.class.getName());

    private final CMServer cmServer;

    public ContentSelectorTraverserList(final CMServer cmServer)
    {
        this.cmServer = cmServer;
    }

    public void traverse(final ContentId contentId,
                         final List<ContentId> result)
    {
        try {
            selectFrom(contentId, result);
        } catch (CMException e) {
            LOG.log(Level.WARNING, "Error while selecting content.", e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private void selectFrom(final ContentId contentId,
                            final List<ContentId> result)
        throws CMException
    {
        if (result.contains(contentId)) {
            return;
        }

        result.add(contentId);

        Content content = (Content) cmServer.getContent(contentId);
        for (String groupName : content.getContentReferenceGroupNames()) {
            for (String name : content.getContentReferenceNames(groupName)) {
                selectFrom(content.getContentReference(groupName, name), result);
            }
        }
    }
}
