package com.blasphemic.polopoly.contentselect;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import com.polopoly.cm.ComponentDiff;
import com.polopoly.cm.ContentFileInfo;
import com.polopoly.cm.ContentId;
import com.polopoly.cm.ContentReferenceDiff;
import com.polopoly.cm.ExternalContentId;
import com.polopoly.cm.LockInfo;
import com.polopoly.cm.TagInfo;
import com.polopoly.cm.VersionInfo;
import com.polopoly.cm.VersionedContentId;
import com.polopoly.cm.WorkflowInfo;
import com.polopoly.cm.client.CMException;
import com.polopoly.cm.client.Content;
import com.polopoly.cm.collections.ContentList;
import com.polopoly.user.server.AclId;
import com.polopoly.user.server.UserId;

public class TestContent
    implements Content
{
    private final ContentId contentId;

    private final Map<String, Map<String, ContentId>> references;

    public TestContent(final ContentId contentId)
    {
        this.contentId = contentId;
        references = new HashMap<String, Map<String, ContentId>>();
    }

    @Override
    public VersionedContentId getContentId()
    {
        return new VersionedContentId(contentId, VersionedContentId.UNDEFINED_VERSION);
    }

    @Override
    public void setContentReference(String group, String name, ContentId ref)
        throws CMException
    {
        if (references.get(group) == null) {
            references.put(group, new HashMap<String, ContentId>());
        }
        
        references.get(group).put(name, ref);
    }
    
    @Override
    public ContentId getContentReference(final String group, final String name)
        throws CMException
    {
        if (references.get(group) != null) {
            return references.get(group).get(name);
        }
        
        return null;
    }

    @Override
    public String[] getContentReferenceGroupNames()
        throws CMException
    {
        return references.keySet().toArray(new String[0]);
    }

    @Override
    public String[] getContentReferenceNames(final String group)
        throws CMException
    {
        if (references.get(group) == null) {
            return new String[0];
        }
        
        return references.get(group).keySet().toArray(new String[0]);
    }

    @Override
    public void clearCache()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void exportFile(String arg0, OutputStream arg1)
        throws CMException, IOException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public TagInfo[] getAllTagInfos()
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public String getComponent(String arg0, String arg1)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public String[] getComponentGroupNames()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public String[] getComponentNames(String arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public long getContentCreationTime()
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public UserId getCreatedBy()
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public ExternalContentId getExternalId()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public ContentFileInfo getFileInfo(String arg0)
        throws CMException, IOException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public ContentId getInputTemplateId()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public LockInfo getLockInfo()
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public String getName()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public ContentId getOutputTemplateId(String arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public ContentId[] getReferringContentIds(int arg0, String arg1, String arg2)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public ContentFileInfo[] listFiles(String arg0, boolean arg1)
        throws CMException, IOException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public ContentList getContentList()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public String[] getAvailableContentListNames()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public ContentList getContentList(String arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public int getLatestCommittedVersion()
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public String getMetaDataComponent(String arg0, String arg1)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public String[] getMetaDataComponentGroupNames()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public String[] getMetaDataComponentNames(String arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public VersionInfo getVersionInfo()
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public boolean isUnversionedContent()
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public WorkflowInfo getWorkflowInfo()
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public boolean checkPermission(String arg0, boolean arg1)
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public AclId getAclId()
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public ContentId getSecurityParentId()
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public AclId createAcl()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void removeAcl()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void setSecurityParentId(ContentId arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void setMetaDataComponent(String arg0, String arg1, String arg2)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void commit()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void createDirectory(String arg0, boolean arg1)
        throws CMException, IOException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void deleteDirectory(String arg0, boolean arg1)
        throws CMException, IOException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void deleteFile(String arg0)
        throws CMException, IOException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void flushCache()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void forcedUnlock()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void importFile(String arg0, InputStream arg1)
        throws CMException, IOException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void lock()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void lock(long arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void lockMetaData()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void lockMetaData(long arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public VersionedContentId[] remove()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void setComponent(String arg0, String arg1, String arg2)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void setComponents(ComponentDiff arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void setContentReferences(ContentReferenceDiff arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void setExternalId(String arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void setInputTemplateId(ContentId arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void setName(String arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void setOutputTemplateId(String arg0, ContentId arg1)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void unlock()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }
}
