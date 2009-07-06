/*
 * Copyright (C) All rights reserved 2005 - 2009, 
 * UMLMDA, http://www.umlmda.org
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 * 
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307, USA. The text of license can be also found
 * at http://www.gnu.org/copyleft/lgpl.html
 * 
 * Created on 13.05.2009 (Dieter Moroff)
 */
package org.umlmda.runtime.lang;

import java.util.List;

/**
 * Interface for domain keys. It is important that the complete primary key of an object is not derived from the domain key,
 * otherwise the {@link #equals(Object)} or {@linkplain DomainKey#hashCode()} methods won't work correctly.
 * 
 * @author Dieter Moroff (13.03.2009)
 */
public interface DomainKey
{

   public static class Element
   {
      public final String name;
      public final Object value;

      public Element(String name, Object value) {
         this.name = name;
         this.value = value;
      }
      
      /* (non-Javadoc)
       * @see java.lang.Object#toString()
       */
      @Override
      public String toString() {
         StringBuilder sb = new StringBuilder();
         sb.append("DomainKey.Element [name=").append(name).append(", value='").append(value).append("']");
         return sb.toString();
      }
      
   }

   boolean equals(Object obj);

   int hashCode();

   List<Element> getElements();
}
