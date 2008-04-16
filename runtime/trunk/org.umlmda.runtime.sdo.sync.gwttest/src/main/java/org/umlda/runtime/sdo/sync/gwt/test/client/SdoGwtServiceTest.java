package org.umlda.runtime.sdo.sync.gwt.test.client;

import java.util.Date;
import java.util.List;

import org.umlmda.runtime.sdo.sync.Recorder;
import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;
import org.umlmda.runtime.sdo.sync.gwt.client.SyncServiceAsync;
import org.umlmda.runtime.sdo.sync.gwt.client.SyncServiceLocator;
import org.umlmda.runtime.sdo.sync.impl.SynchronizerImpl;
import org.umlmda.runtime.sdo.sync.test.dto.RootClass;
import org.umlmda.runtime.sdo.sync.test.dto.TestFactory;
import org.umlmda.runtime.sdo.sync.test.dto.impl.TestFactoryImpl;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SdoGwtServiceTest implements EntryPoint {
   private Button clickMeButton;
   private TextArea testOutputArea;
   public void onModuleLoad() {
      RootPanel rootPanel = RootPanel.get();

      clickMeButton = new Button();
      rootPanel.add(clickMeButton);
      clickMeButton.setText("Start Test ...");
      clickMeButton.addClickListener(new ClickListener() {
         public void onClick(Widget sender) {
            startTest();
         }
      });

      testOutputArea = new TextArea();
      rootPanel.add(testOutputArea, 5, 34);
      testOutputArea.setReadOnly(true);
      testOutputArea.setSize("100%", "328px");
   }
   
   void startTest() {
      Recorder recorder = new SynchronizerImpl();
      TestFactory factory = new TestFactoryImpl(recorder);
      SyncServiceAsync serviceAsync = SyncServiceLocator.getInstance();
      RootClass root = factory.createRootClass();
      
      root.setRootChild(factory.createRootChild());
      
      serviceAsync.synchronizeChanges(recorder.getChangeEntries(), new AsyncCallback<List<AbstractChangeLogEntry>>() {

         public void onFailure(Throwable caught) {
            StringBuffer buffer = new StringBuffer();

            buffer.append(new Date()+"\n\n");
            buffer.append(caught.getMessage());
            for (int i = 0; i < caught.getStackTrace().length; i++) {
               StackTraceElement element = caught.getStackTrace()[i];
               
               buffer.append(element.toString());
               buffer.append("\n");
            }
            testOutputArea.setText(buffer.toString());
            
         }

         public void onSuccess(List<AbstractChangeLogEntry> result){
            StringBuffer buffer = new StringBuffer();

            buffer.append(new Date()+"\n\n");
            for (AbstractChangeLogEntry logEntry : result) {
               buffer.append(logEntry.toString());
               buffer.append("\n");
            }
            testOutputArea.setText(buffer.toString());
         }});
      
   }
}
