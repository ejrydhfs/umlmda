package org.umlda.runtime.sdo.sync.gwt.test.client;

public interface SdoGwtServiceTestEnvironment {

    public void log(String msg);

    public void incrementFinishedCount();

    public int getRunTime();

}
