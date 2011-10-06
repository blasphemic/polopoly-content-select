package com.blasphemic.polopoly.contentselect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.polopoly.cm.ContentHistory;
import com.polopoly.cm.ContentId;
import com.polopoly.cm.ContentInfo;
import com.polopoly.cm.ExternalContentId;
import com.polopoly.cm.LockInfo;
import com.polopoly.cm.MajorInfo;
import com.polopoly.cm.TagInfo;
import com.polopoly.cm.VersionInfo;
import com.polopoly.cm.VersionedContentId;
import com.polopoly.cm.WorkflowInfo;
import com.polopoly.cm.client.CMException;
import com.polopoly.cm.client.CMServer;
import com.polopoly.cm.client.Content;
import com.polopoly.cm.client.ContentRead;
import com.polopoly.cm.client.filter.ContentListFilterChain;
import com.polopoly.cm.search.db.SearchExpression;
import com.polopoly.cm.workflow.WorkflowAction;
import com.polopoly.cm.workflow.WorkflowState;
import com.polopoly.user.server.Caller;

public class TestCmServer
    implements CMServer
{
    private List<Content> contents = null;
    
    public TestCmServer()
    {
        contents = new ArrayList<Content>();
    }
    
    public void addContent(final Content content)
    {
        contents.add(content);
    }
    
    public void addContent(final Content... contents)
    {
        this.contents.addAll(Arrays.asList(contents));
    }
    
    @Override
    public ContentRead getContent(ContentId contentId)
        throws CMException
    {
        for (Content content : contents) {
            if (content.getContentId().equalsIgnoreVersion(contentId)) {
                return content;
            }
        }
        
        return null;
    }

    @Override
    public boolean checkPermission(ContentId arg0, String arg1, boolean arg2)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public int countContentIdsBySearchExpression(SearchExpression arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public VersionedContentId findContentIdByExternalId(ExternalContentId arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public VersionedContentId[] findContentIdsBySearchExpression(SearchExpression arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public VersionedContentId[] findContentIdsBySearchExpression(SearchExpression arg0, int arg1)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public VersionedContentId[] findContentIdsBySearchExpression(SearchExpression arg0, int arg1, int arg2)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public TagInfo[] getAllTagInfos(ContentId arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public ContentHistory getContentHistory(ContentId arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public ContentInfo getContentInfo(ContentId arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public ContentListFilterChain getContentListFilterChain()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public ContentRead getContentUnfiltered(ContentId arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Caller getCurrentCaller()
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public MajorInfo[] getHandledMajors()
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public LockInfo getLockInfo(ContentId arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public int getMajorByName(String arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public MajorInfo getMajorInfo(int arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public ContentId[] getReferringContentIds(ContentId arg0, int arg1)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public ContentId[] getReferringContentIds(ContentId arg0, int arg1, String arg2, String arg3)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public ContentId[] getSecurityChildren(ContentId arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public int getTagIdByName(String arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public String getTagNameById(int arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public VersionInfo getVersionInfo(VersionedContentId arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public WorkflowInfo getWorkflowInfo(VersionedContentId arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void setCurrentCaller(Caller arg0)
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public VersionedContentId translateSymbolicContentId(ContentId arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public boolean contentExists(ContentId arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public VersionedContentId[] abortContents(VersionedContentId[] arg0, boolean arg1)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void assertLocked(ContentId arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void commitContents(VersionedContentId[] arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public VersionedContentId createContent(VersionedContentId arg0, VersionedContentId arg1, ContentId arg2)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Content[] createLockedContents(VersionedContentId[] arg0, VersionedContentId[] arg1, ContentId arg2)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public LockInfo[] findAllLocks()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void forceUnlock(ContentId arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public WorkflowAction[] getAllActions(ContentId arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public WorkflowState[] getAllStates(ContentId arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void lock(ContentId arg0, int arg1, long arg2)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void removeContent(ContentId arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public VersionedContentId[] removeContentVersion(VersionedContentId arg0)
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void unlock(ContentId arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }
}
