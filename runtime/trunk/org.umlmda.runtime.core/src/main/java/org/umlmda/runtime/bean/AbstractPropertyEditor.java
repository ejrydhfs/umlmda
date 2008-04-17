package org.umlmda.runtime.bean;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyEditor;

public abstract class AbstractPropertyEditor<TBeanClass> implements PropertyEditor {

   private final String propertyName;
   private final TBeanClass bean;

   public AbstractPropertyEditor(TBeanClass bean, String propertyName) {
      this.bean = bean;
      this.propertyName = propertyName;
   }

   protected final String getPropertyName() {
      return propertyName;
   }
   
   protected final TBeanClass getBean() {
      return bean;
   }
   
   public void addPropertyChangeListener(PropertyChangeListener listener) {
      if ( bean instanceof PropertyChangeSupport ) {
         ((PropertyChangeSupport)bean).addPropertyChangeListener(propertyName, listener);
      }
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      if ( bean instanceof PropertyChangeSupport ) {
         ((PropertyChangeSupport)bean).removePropertyChangeListener(propertyName, listener);
      }
   }

   public abstract Object getValue();

   public abstract void setValue(Object value);
   
   public String getAsText() {
      throw new UnsupportedOperationException("Supported in future release");
   }

   public String getJavaInitializationString() {
      throw new UnsupportedOperationException("Supported in future release");
   }

   public String[] getTags() {
      throw new UnsupportedOperationException("Supported in future release");
   }

   public void setAsText(String text) throws IllegalArgumentException {
      throw new UnsupportedOperationException("Supported in future release");
   }

   public boolean isPaintable() {
      throw new UnsupportedOperationException();
   }

   public void paintValue(Graphics gfx, Rectangle box) {
      throw new UnsupportedOperationException();
   }

   public Component getCustomEditor() {
      throw new UnsupportedOperationException();
   }

   public boolean supportsCustomEditor() {
      throw new UnsupportedOperationException();
   }

}
