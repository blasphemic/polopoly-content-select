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
        this(new VersionedContentId(contentId, 1));
    }

    public TestContent(final VersionedContentId contentId)
    {
        this.contentId = contentId;

        references = new HashMap<String, Map<String, ContentId>>();
    }

    public VersionedContentId getContentId()
    {
        return new VersionedContentId(contentId, VersionedContentId.UNDEFINED_VERSION);
    }

    public void setContentReference(String group, String name, ContentId ref)
        throws CMException
    {
        if (references.get(group) == null) {
            references.put(group, new HashMap<String, ContentId>());
        }

        references.get(group).put(name, ref);
    }

    public ContentId getContentReference(final String group, final String name)
        throws CMException
    {
        if (references.get(group) != null) {
            return references.get(group).get(name);
        }

        return null;
    }

    public String[] getContentReferenceGroupNames()
        throws CMException
    {
        return references.keySet().toArray(new String[0]);
    }

    public String[] getContentReferenceNames(final String group)
        throws CMException
    {
        if (references.get(group) == null) {
            return new String[0];
        }

        return references.get(group).keySet().toArray(new String[0]);
    }

    public void clearCache()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public void exportFile(String arg0, OutputStream arg1)
        throws CMException, IOException
    {
        throw new RuntimeException("Not implemented");
    }

    public TagInfo[] getAllTagInfos()
    {
        throw new RuntimeException("Not implemented");
    }

    public String getComponent(String arg0, String arg1)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public String[] getComponentGroupNames()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public String[] getComponentNames(String arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public long getContentCreationTime()
    {
        throw new RuntimeException("Not implemented");
    }

    public UserId getCreatedBy()
    {
        throw new RuntimeException("Not implemented");
    }

    public ExternalContentId getExternalId()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public ContentFileInfo getFileInfo(String arg0)
        throws CMException, IOException
    {
        throw new RuntimeException("Not implemented");
    }

    public ContentId getInputTemplateId()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public LockInfo getLockInfo()
    {
        throw new RuntimeException("Not implemented");
    }

    public String getName()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public ContentId getOutputTemplateId(String arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public ContentId[] getReferringContentIds(int arg0, String arg1, String arg2)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public ContentFileInfo[] listFiles(String arg0, boolean arg1)
        throws CMException, IOException
    {
        throw new RuntimeException("Not implemented");
    }

    public ContentList getContentList()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public String[] getAvailableContentListNames()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public ContentList getContentList(String arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public int getLatestCommittedVersion()
    {
        throw new RuntimeException("Not implemented");
    }

    public String getMetaDataComponent(String arg0, String arg1)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public String[] getMetaDataComponentGroupNames()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public String[] getMetaDataComponentNames(String arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public VersionInfo getVersionInfo()
    {
        throw new RuntimeException("Not implemented");
    }

    public boolean isUnversionedContent()
    {
        throw new RuntimeException("Not implemented");
    }

    public WorkflowInfo getWorkflowInfo()
    {
        throw new RuntimeException("Not implemented");
    }

    public boolean checkPermission(String arg0, boolean arg1)
    {
        throw new RuntimeException("Not implemented");
    }

    public AclId getAclId()
    {
        throw new RuntimeException("Not implemented");
    }

    public ContentId getSecurityParentId()
    {
        throw new RuntimeException("Not implemented");
    }

    public AclId createAcl()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public void removeAcl()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public void setSecurityParentId(ContentId arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public void setMetaDataComponent(String arg0, String arg1, String arg2)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public void commit()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public void createDirectory(String arg0, boolean arg1)
        throws CMException, IOException
    {
        throw new RuntimeException("Not implemented");
    }

    public void deleteDirectory(String arg0, boolean arg1)
        throws CMException, IOException
    {
        throw new RuntimeException("Not implemented");
    }

    public void deleteFile(String arg0)
        throws CMException, IOException
    {
        throw new RuntimeException("Not implemented");
    }

    public void flushCache()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public void forcedUnlock()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public void importFile(String arg0, InputStream arg1)
        throws CMException, IOException
    {
        throw new RuntimeException("Not implemented");
    }

    public void lock()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public void lock(long arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public void lockMetaData()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public void lockMetaData(long arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public VersionedContentId[] remove()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public void setComponent(String arg0, String arg1, String arg2)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public void setComponents(ComponentDiff arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public void setContentReferences(ContentReferenceDiff arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public void setExternalId(String arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public void setInputTemplateId(ContentId arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public void setName(String arg0)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public void setOutputTemplateId(String arg0, ContentId arg1)
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }

    public void unlock()
        throws CMException
    {
        throw new RuntimeException("Not implemented");
    }
}
