package org.apache.olingo.odata2.janos.processor.core.util;

import org.apache.olingo.odata2.api.annotation.edm.EdmNavigationProperty;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AnnotatedNavigationInfoTest {

  @Test
  public void testBidirectional() throws Exception {
    AnnotatedNavigationInfo navInfo = new AnnotatedNavigationInfo(BidirectionalSource.class, BidirectionalTarget.class);
    assertTrue(navInfo.isBidirectional());
  }

  private class BidirectionalSource {
    @EdmNavigationProperty
    BidirectionalTarget bidiTarget1;
  }
  private class BidirectionalTarget {
    @EdmNavigationProperty
    List<BidirectionalSource> bidiSources;
  }

}