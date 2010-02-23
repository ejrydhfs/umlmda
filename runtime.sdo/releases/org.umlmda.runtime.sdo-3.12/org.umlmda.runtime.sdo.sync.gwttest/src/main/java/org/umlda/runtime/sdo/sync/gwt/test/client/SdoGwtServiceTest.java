package org.umlda.runtime.sdo.sync.gwt.test.client;

import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SdoGwtServiceTest implements EntryPoint, SdoGwtServiceTestEnvironment {
    private static final String NEW_LINE = "\n";

    private TextBox runCountTextBox;
    private TextBox runTimeTextBox;
    private Button startButton;
    private Button clearButton;
    private int runCount;
    private int runTime;

    private TextArea testOutputArea;
    private int finishedCount;

    //Checks if all calls completed correctly
    class TimeoutTimer extends Timer {

        @Override
        public void run() {
            enableUI(true);
            boolean success = (finishedCount == getRunCount());
            if (success) {
                log("All calls completed correctly...");
            }
            else {
                String msg = "Not all calls completed correctly (" + finishedCount + "/" + getRunCount() + "...";
                log(msg);
                throw new IllegalStateException(msg);
            }
        }

    }

    public synchronized void incrementFinishedCount() {
        finishedCount++;
    }

    public void onModuleLoad() {
        RootPanel rootPanel = RootPanel.get();

        rootPanel.add(new Label("Total time: "));
        runTimeTextBox = new TextBox();
        runTimeTextBox.setText("5000");
        rootPanel.add(runTimeTextBox);
        rootPanel.add(new Label("Run count: "));
        runCountTextBox = new TextBox();
        runCountTextBox.setText("10");
        rootPanel.add(runCountTextBox);

        startButton = new Button("Start test");
        rootPanel.add(startButton);
        startButton.addClickListener(new ClickListener() {
            public void onClick(Widget sender) {
                startConversations();
            }
        });
        clearButton = new Button("Clear output");
        rootPanel.add(clearButton);
        clearButton.addClickListener(new ClickListener() {
            public void onClick(Widget sender) {
                testOutputArea.setText("");
            }
        });

        testOutputArea = new TextArea();
        rootPanel.add(testOutputArea, 5, 34);
        testOutputArea.setReadOnly(true);
        testOutputArea.setSize("100%", "328px");
        rootPanel.add(testOutputArea);
    }

    private void startConversations() {
        runCount = Integer.parseInt(runCountTextBox.getText());
        runTime = Integer.parseInt(runTimeTextBox.getText());

        enableUI(false);

        finishedCount = 0;
        for (int i = 1; i <= getRunCount(); i++) {
            String name = "Test " + i;
            new SdoGwtClientSession(this, name).delayedStart(Random.nextInt(getRunTime()));
        }

        //will check whether all calls completed correctly
        new TimeoutTimer().schedule(getRunTime() * 3 + 5000);
    }

    private void enableUI(boolean enabled) {
        runCountTextBox.setEnabled(enabled);
        runTimeTextBox.setEnabled(enabled);
        startButton.setEnabled(enabled);
        clearButton.setEnabled(enabled);
    }

    public void log(String str) {
        StringBuilder b = new StringBuilder();
        b.append(testOutputArea.getText());
        b.append(NEW_LINE);
        b.append(new Date());
        b.append(" ");
        b.append(str);
        testOutputArea.setText(b.toString());
    }

    private int getRunCount() {
        return runCount;
    }

    public int getRunTime() {
        return runTime;
    }

}
