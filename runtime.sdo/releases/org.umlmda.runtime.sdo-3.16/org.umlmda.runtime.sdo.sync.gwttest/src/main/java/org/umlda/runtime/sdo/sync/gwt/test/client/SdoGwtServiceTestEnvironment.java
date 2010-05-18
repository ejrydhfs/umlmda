package org.umlda.runtime.sdo.sync.gwt.test.client;

public interface SdoGwtServiceTestEnvironment {

    void log(String msg);

    void incrementFinishedCount();

    int getRunTime();

}
