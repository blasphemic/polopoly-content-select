package com.blasphemic.polopoly.contentselect;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.polopoly.cm.ContentId;
import com.polopoly.cm.client.CMException;
import com.polopoly.cm.client.CMServer;
import com.polopoly.cm.client.Content;

public class ContentSelector
{
    private static final Logger LOG = Logger.getLogger(ContentSelector.class.getName());

    private final CMServer cmServer;

    public ContentSelector(final CMServer cmServer)
    {
        this.cmServer = cmServer;
    }

    public List<ContentId> select(final ContentId rootContentId)
    {
        if (rootContentId == null) {
            throw new IllegalArgumentException("Null argument not allowed!");
        }

        List<ContentId> result = new ArrayList<ContentId>();

        try {
            selectFrom(rootContentId, result);
        } catch (CMException e) {
            LOG.log(Level.WARNING, "Error while selecting content.", e);
            throw new RuntimeException(e.getMessage(), e);
        }

        return result;
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
