// UMLMDA, GeneratorBase-API
//  
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Library General Public
// License as published by the Free Software Foundation; either
// version 2 of the License, or (at your option) any later version.
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Library General Public License for more details.
//
// You should have received a copy of the GNU Library General Public
// License along with this library; if not, write to the
// Free Software Foundation, Inc., 59 Temple Place - Suite 330,
// Boston, MA  02111-1307, USA. The text of license can be also found
// at http://www.gnu.org/copyleft/lgpl.html
// 
// Original author: Dieter Moroff (moroff@users.sourceforge.net)
// 
package org.umlmda.generator.model.util;

/**
 * Interface for the generator to give feedback about the progress of the work
 * 
 * @author Dieter Moroff
 */
public interface Feedback
{
   int ERROR   = 0;
   int WARNING = 1;
   int INFO    = 2;
   int DEBUG   = 3;

   /**
    * Give information if the generator enters an new step (generate, merge, ...)
    * 
    * @param newStep
    */
   void tellNewStep(String newStep);

   /**
    * Give information about the current work
    * 
    * @param message
    */
   void tellWork(String message);

   /**
    * Gives message back to the caller about errors, warnings or informations
    * 
    * @param severity
    *           severity of the message
    * @param message
    *           content of the message
    */
   void message(int severity, String message);

   /**
    * Prints the Stacktrace
    */
   void printStackTrace(Throwable throwable);
}
