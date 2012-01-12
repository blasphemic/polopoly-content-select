package com.blasphemic.polopoly.contentselect;

import com.blasphemic.polopoly.contentselect.graph.ContentEdge;

public interface ContentGraphTraverserObserver
{
    void onBeforeContentEdgeTraverse(final ContentEdge contentEdge);
}
