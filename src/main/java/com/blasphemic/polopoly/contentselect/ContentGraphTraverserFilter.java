package com.blasphemic.polopoly.contentselect;

import com.blasphemic.polopoly.contentselect.graph.ContentEdge;
import com.blasphemic.polopoly.contentselect.graph.ContentGraphStatistics;

public interface ContentGraphTraverserFilter
{
    ContentGraphTraverserSignal shouldTraverse(final ContentEdge edge, final ContentGraphStatistics statistics);
}
