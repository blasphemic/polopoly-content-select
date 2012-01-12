package com.blasphemic.polopoly.contentselect;

import com.blasphemic.polopoly.contentselect.graph.ContentVertex;
import com.polopoly.cm.VersionedContentId;
import com.polopoly.cm.client.CMException;
import com.polopoly.cm.client.CMServer;
import com.polopoly.cm.client.ContentRead;

public class ContentSelector
{
    private CMServer cmServer;
    private ContentGraphTraverser graphTraverser;

    public ContentSelector(final CMServer cmServer)
    {
        this(cmServer, new ContentGraphTraverser(cmServer));
    }

    public ContentSelector(final CMServer cmServer,
                           final ContentGraphTraverser traverser)
    {
        this.cmServer = cmServer;
        this.graphTraverser = traverser;
    }

    public ContentGraphTraverseResult select(final VersionedContentId rootContentId,
                                             final ContentGraphTraverserFilter filter,
                                             final ContentGraphTraverserObserver observer)
    {
        if (rootContentId == null) {
            throw new IllegalArgumentException("The root content id cannot be null!");
        }

        assertContentExists(rootContentId);

        graphTraverser = new ContentGraphTraverser(cmServer, filter, observer);

        ContentVertex rootVertex = new ContentVertex(rootContentId);
        ContentGraphTraverseResult result = graphTraverser.traverseAndFilter(rootVertex);

        return result;
    }

    private void assertContentExists(final VersionedContentId contentId)
    {
        ContentRead content = null;

        try {
            content = cmServer.getContent(contentId);
        } catch (CMException cme) {
            // Assume it does not exist
        }

        if (content == null) {
            throw new IllegalArgumentException(String.format("Content '%s' does not exist!", contentId.getContentIdString()));
        }
    }
}
