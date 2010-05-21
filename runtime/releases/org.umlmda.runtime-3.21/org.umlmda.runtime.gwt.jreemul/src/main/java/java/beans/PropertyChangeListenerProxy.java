package java.beans;

public class PropertyChangeListenerProxy extends java.beans.EventListenerProxy implements PropertyChangeListener
{

   private String propertyName;

   public PropertyChangeListenerProxy(String propertyName, PropertyChangeListener listener) {
      super(listener);
      this.propertyName = propertyName;
   }

   public void propertyChange(PropertyChangeEvent evt) {
      PropertyChangeListener lsnr = (PropertyChangeListener) getListener();
      lsnr.propertyChange(evt);
   }

   public String getPropertyName() {
      return propertyName;
   }

}
