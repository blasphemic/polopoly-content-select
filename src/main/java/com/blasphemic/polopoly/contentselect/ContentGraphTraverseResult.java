package com.blasphemic.polopoly.contentselect;

import java.util.List;

import com.blasphemic.polopoly.contentselect.graph.ContentVertex;
import com.polopoly.cm.ContentId;

public class ContentGraphTraverseResult
{
    private final ContentVertex resultRootVertex;
    private final long resultNodeCount;
    private final List<ContentId> allContentIds;

    public ContentGraphTraverseResult(final ContentVertex resultRootVertex,
                                      final List<ContentId> allContentIds,
                                      final long resultNodeCount)
    {
        this.resultRootVertex = resultRootVertex;
        this.allContentIds = allContentIds;
        this.resultNodeCount = resultNodeCount;
    }

    public ContentVertex getResultRootVertex()
    {
        return resultRootVertex;
    }

    public long getResultNodeCount()
    {
        return resultNodeCount;
    }

    public List<ContentId> getAllResultContentIds()
    {
        return allContentIds;
    }
}
