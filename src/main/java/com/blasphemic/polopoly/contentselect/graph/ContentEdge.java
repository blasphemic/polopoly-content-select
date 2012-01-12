package com.blasphemic.polopoly.contentselect.graph;

public class ContentEdge
{
    private final ContentVertex sourceVertex;
    private final ContentVertex targetVertex;
    
    public ContentEdge(final ContentVertex sourceVertex,
                       final ContentVertex targetVertex)
    {
        this.sourceVertex = sourceVertex;
        this.targetVertex = targetVertex;
    }
    
    public ContentVertex getSourceContentVertex()
    {
        return sourceVertex;
    }
    
    public ContentVertex getTargetContentVertex()
    {
        return targetVertex;
    }
}
