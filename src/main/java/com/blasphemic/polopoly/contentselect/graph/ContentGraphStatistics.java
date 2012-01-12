package com.blasphemic.polopoly.contentselect.graph;

import java.util.ArrayList;
import java.util.List;

import com.polopoly.cm.ContentId;

public class ContentGraphStatistics
{
    private List<ContentId> allContentIds;
    
    public ContentGraphStatistics()
    {
        allContentIds = new ArrayList<ContentId>();
    }
    
    public long getNodeCount()
    {
        return allContentIds.size();
    }
    
    public void addContentId(final ContentId contentId)
    {
        allContentIds.add(contentId);
    }
    
    public List<ContentId> getAllContentIds()
    {
        return allContentIds;
    }
}
