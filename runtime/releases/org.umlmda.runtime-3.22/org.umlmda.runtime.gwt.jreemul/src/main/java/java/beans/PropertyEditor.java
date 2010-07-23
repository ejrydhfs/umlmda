/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package java.beans;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * GWT compatible interface (derived from Harmony).
 * 
 * @author Dieter Moroff
 */
public interface PropertyEditor
{

   // Supported stuff
   void setValue(Object value);

   Object getValue();

   void removePropertyChangeListener(PropertyChangeListener listener);

   void addPropertyChangeListener(PropertyChangeListener listener);

   // Future supported stuff
   String getAsText();

   void setAsText(String text) throws IllegalArgumentException;

   String[] getTags();

   String getJavaInitializationString();

   // Unsupported stuff, for compatibility only
   void paintValue(Graphics gfx, Rectangle box);

   Component getCustomEditor();

   boolean supportsCustomEditor();

   boolean isPaintable();

}
