package com.blasphemic.polopoly.contentselect;

import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

public class ContentSelectorTreeStyleTest
{
    private static final Logger LOG = Logger.getLogger(ContentSelectorTreeStyleTest.class.getName());

    private TestCmServer cmServer;
    private ContentSelector selector;

    @Before
    public void setup()
    {
        cmServer = new TestCmServer();
        selector = new ContentSelector(cmServer);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSelectNull()
        throws Exception
    {
        selector.selectAsTree(null);
    }
}
