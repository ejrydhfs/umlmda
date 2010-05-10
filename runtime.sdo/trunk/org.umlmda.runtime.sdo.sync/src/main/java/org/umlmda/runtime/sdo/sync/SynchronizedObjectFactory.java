package org.umlmda.runtime.sdo.sync;

import java.io.Serializable;

import org.umlmda.runtime.model.ModeledElementProxy;

public interface SynchronizedObjectFactory extends Serializable
{

   SynchronizedObject create(ModeledElementProxy className);

   Recorder getRecorder();

}
