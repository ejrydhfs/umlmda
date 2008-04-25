package org.umlmda.runtime.bean;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import junit.framework.TestCase;

public class PropertyChangeSupportingListWrapperTest extends TestCase {
   static class Element {
      String name;
      
      public Element(String name) {
         this.name = name;
      }

   }
   
   PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
   boolean gotEvent = false;
   List<Element> elements = new PropertyChangeSupportingListWrapper<Element>(propertyChangeSupport, "elements", new ArrayList<Element>());
   
   
   public void testAddIntT() {
      gotEvent = false;
      propertyChangeSupport.addPropertyChangeListener("elements", new PropertyChangeListener() {

         public void propertyChange(PropertyChangeEvent evt) {
            gotEvent = true;
            
         }});

      elements.add(new Element("Hallo"));
      assertTrue(gotEvent);
      assertTrue(elements.size() == 1);
      
      Iterator<Element> it = elements.iterator();
      
      assertTrue(it.hasNext());
      assertNotNull(it.next());
      assertFalse(it.hasNext());
   }

   public void testListIterator() {
      setupList();
      
      gotEvent = false;
      ListIterator<Element> listIterator = elements.listIterator();
      
      listIterator.next();
      listIterator.remove();
      assertTrue(gotEvent);
   }

   public void testRemoveInt() {
      setupList();

      gotEvent = false;
      
      elements.remove(0);
      assertTrue(gotEvent);
   }

   public void testClear() {
      setupList();

      gotEvent = false;
      
      elements.clear();
      assertTrue(gotEvent);
   }

   private void setupList() {
      propertyChangeSupport.addPropertyChangeListener("elements", new PropertyChangeListener() {

         public void propertyChange(PropertyChangeEvent evt) {
            gotEvent = true;
            
         }});

      elements.add(new Element("Hallo"));
   }

}
