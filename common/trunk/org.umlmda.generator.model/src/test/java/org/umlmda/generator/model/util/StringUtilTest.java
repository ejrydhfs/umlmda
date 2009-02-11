/*
 *   $Header: /cvsroot/umlmda/org.umlmda.generator.model/test/org/umlmda/generator/model/util/StringUtilTest.java,v 1.1.2.2 2008/04/17 19:33:12 moroff Exp $
 *   $Source: /cvsroot/umlmda/org.umlmda.generator.model/test/org/umlmda/generator/model/util/StringUtilTest.java,v $
 * $Revision: 1.1.2.2 $
 *     $Name:  $
 *     $Date: 2008/04/17 19:33:12 $
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
 * Created on 08.08.2006 (Dieter Moroff)
 */
package org.umlmda.generator.model.util;

import org.apache.oro.text.regex.PatternCompiler;
import org.umlmda.generator.model.util.StringUtil.PatternNotMatchException;

import junit.framework.TestCase;

/**
 * @author MOROFF
 *
 */
public class StringUtilTest extends TestCase {

   /**
    * Test method for {@link org.umlmda.generator.model.util.StringUtil#regexReplacement(java.lang.String, java.lang.String, java.lang.String)}.
    * @throws PatternNotMatchException 
    */
   public void testRegexReplacement() throws PatternNotMatchException {
      
      String replaced = StringUtil.regexReplacement("sample", "(.*)", "\\u$1Factory");
      assertEquals("SampleFactory", replaced);
   }

//   public void testOroVersion() {
//      Package oroPackage = PatternCompiler.class.getPackage();
//      
//      assertEquals("2.0.8", oroPackage.getImplementationVersion());
//   }
}
