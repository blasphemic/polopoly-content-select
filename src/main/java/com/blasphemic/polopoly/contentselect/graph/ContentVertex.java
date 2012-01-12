package com.blasphemic.polopoly.contentselect.graph;

import java.util.ArrayList;
import java.util.List;

import com.polopoly.cm.VersionedContentId;

public class ContentVertex
{
    private List<ContentEdge> edges = new ArrayList<ContentEdge>();
    
    private final VersionedContentId contentId;
    
    public ContentVertex(final VersionedContentId contentId)
    {
        this.contentId = contentId;
    }
    
    public VersionedContentId getContentId()
    {
        return contentId;
    }
    
    public void addContentEdge(ContentEdge edge)
    {
        edges.add(edge);
    }
}
