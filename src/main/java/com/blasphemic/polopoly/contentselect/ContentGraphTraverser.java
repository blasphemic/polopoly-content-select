package com.blasphemic.polopoly.contentselect;

import com.blasphemic.polopoly.contentselect.graph.ContentEdge;
import com.blasphemic.polopoly.contentselect.graph.ContentGraphStatistics;
import com.blasphemic.polopoly.contentselect.graph.ContentVertex;
import com.polopoly.cm.ContentId;
import com.polopoly.cm.VersionedContentId;
import com.polopoly.cm.client.CMException;
import com.polopoly.cm.client.CMServer;
import com.polopoly.cm.client.ContentRead;

public class ContentGraphTraverser
{
    private final CMServer cmServer;

    private final ContentGraphTraverserFilter filter;
    private final ContentGraphTraverserObserver observer;

    private final ContentGraphStatistics statistics = new ContentGraphStatistics();

    public ContentGraphTraverser(final CMServer cmServer)
    {
        this(cmServer, null, null);
    }

    public ContentGraphTraverser(final CMServer cmServer,
                                 final ContentGraphTraverserFilter filter,
                                 final ContentGraphTraverserObserver observer)
    {
        this.cmServer = cmServer;

        this.filter = filter;
        this.observer = observer;
    }

    public ContentGraphTraverseResult traverseAndFilter(final ContentVertex rootVertex)
    {
        // The root vertex is always included
        statistics.addContentId(rootVertex.getContentId());

        traverse(rootVertex);
        return new ContentGraphTraverseResult(rootVertex, statistics.getAllContentIds(), statistics.getNodeCount());
    }

    private void traverse(final ContentVertex vertex)
    {
        try {
            ContentRead content = cmServer.getContent(vertex.getContentId());

            for (String groupName : content.getContentReferenceGroupNames()) {
                for (String name : content.getContentReferenceNames(groupName)) {
                    // TODO: vertices need to be identified by content id (versioned !?!)

                    ContentId referredContentId = content.getContentReference(groupName, name);

                    // I actually have to fetch the content, right (in order to get the versioned content id)?
                    referredContentId = cmServer.getContent(referredContentId).getContentId();
                    
                    if (statistics.getAllContentIds().contains(referredContentId)) {
                        continue;
                    }

                    ContentVertex referencedVertex = new ContentVertex((VersionedContentId) referredContentId);
                    ContentEdge contentEdge = new ContentEdge(vertex, referencedVertex);

                    if (shouldTraverse(contentEdge)) {
                        informObserverOfTraversal(contentEdge);

                        statistics.addContentId(referredContentId);
                        vertex.addContentEdge(contentEdge);

                        traverse(referencedVertex);
                    }
                }
            }
        } catch (CMException cme) {

        }
    }

    private void informObserverOfTraversal(final ContentEdge contentEdge)
    {
        if (observer != null) {
            observer.onBeforeContentEdgeTraverse(contentEdge);
        }
    }

    private boolean shouldTraverse(final ContentEdge contentEdge)
    {
        boolean shouldTraverse = true;

        if (filter != null) {
            ContentGraphTraverserSignal signal = filter.shouldTraverse(contentEdge, statistics);

            if (signal == ContentGraphTraverserSignal.HALT_TRAVERSAL) {
                throw new RuntimeException("Content graph traversal halted!");
            }

            shouldTraverse = (signal == ContentGraphTraverserSignal.TRAVERSE_NODE) ? true : false;
        }

        return shouldTraverse;
    }
}
