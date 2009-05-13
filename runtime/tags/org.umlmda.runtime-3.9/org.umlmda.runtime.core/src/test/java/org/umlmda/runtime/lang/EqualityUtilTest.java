/*
 * Copyright: (C) 2009 COR AG Financial Technologies
 * Name:      $Id: EqualityUtilTest.java,v $Version 12.05.2009 22:15:15 {user} Exp $
 */
package org.umlmda.runtime.lang;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

public class EqualityUtilTest extends TestCase {
   @SuppressWarnings("unchecked")
   public void testEqualsCollection() {
      Set aSet = new HashSet();
      Set bSet = new HashSet();
      
      aSet.add(new TDomainA("A1", "12"));
      aSet.add(new TDomainB("B1", "34"));
      
      bSet.add(new TDomainA("A1", "12"));
      bSet.add(new TDomainB("B1", "34-2"));
      
      assertTrue(EqualityUtil.equals(aSet, bSet));
      
      aSet.add(new TDomainA("A2", "12"));
      aSet.add(new TDomainA("A3", "12"));

      assertFalse(EqualityUtil.equals(aSet, bSet));
   }

   @SuppressWarnings("unchecked")
   public void testEqualsList() {
      List aList = new ArrayList();
      List bList = new ArrayList();
      
      aList.add(new TDomainA("A1", "12"));
      aList.add(new TDomainB("B1", "34"));
      
      bList.add(new TDomainA("A1", "12"));
      bList.add(new TDomainB("B1", "34-2"));
      
      assertTrue(EqualityUtil.equals(aList, bList));

      aList.clear();
      bList.clear();
      
      aList.add(new TDomainB("B1", "34"));
      aList.add(new TDomainA("A1", "12"));
      
      bList.add(new TDomainA("A1", "12"));
      bList.add(new TDomainB("B1", "34-2"));
      
      assertFalse(EqualityUtil.equals(aList, bList));
   }
}
