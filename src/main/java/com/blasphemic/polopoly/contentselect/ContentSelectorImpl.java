//package com.blasphemic.polopoly.contentselect;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.blasphemic.polopoly.contentselect.list.ContentSelectorTraverserList;
//
//public class ContentSelectorImpl
//{
//    private ContentSelectorTraverser listTraverser = null;
//
//    public ContentSelectorImpl(final CMServer cmServer)
//    {
//        listTraverser = new ContentSelectorTraverserList(cmServer);
//    }
//
//    public List<ContentId> select(final ContentId rootContentId)
//    {
//        if (rootContentId == null) {
//            throw new IllegalArgumentException("Null argument not allowed!");
//        }
//
//        List<ContentId> result = new ArrayList<ContentId>();
//        listTraverser.traverse(rootContentId, result);
//
//        return result;
//    }
//
//    public void selectAsTree(final ContentId rootContentId)
//    {
//        if (rootContentId == null) {
//            throw new IllegalArgumentException("Null argument not allowed!");
//        }
//    }
//}
