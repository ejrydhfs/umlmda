//jUMLMDA, UMLModel-API
//
//$Header: /cvsroot/umlmda/UMLMDAProfile/src/org/umlmda/profile/ModelTaggedValues.java,v 1.4 2007/07/31 12:52:35 moroff Exp $
//$Source: /cvsroot/umlmda/UMLMDAProfile/src/org/umlmda/profile/ModelTaggedValues.java,v $
//$Revision: 1.4 $
// $State: Exp $
//  $Name:  $
//  $Date: 2007/07/31 12:52:35 $
//$Locker:  $
//
//This library is free software; you can redistribute it and/or
//modify it under the terms of the GNU Library General Public
//License as published by the Free Software Foundation; either
//version 2 of the License, or (at your option) any later version.
//This library is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//Library General Public License for more details.
//
//You should have received a copy of the GNU Library General Public
//License along with this library; if not, write to the
//Free Software Foundation, Inc., 59 Temple Place - Suite 330,
//Boston, MA  02111-1307, USA. The text of license can be also found
//at http://www.gnu.org/copyleft/lgpl.html
//
//Created on Sep 22, 2005
package org.umlmda.profile;

public interface ModelTaggedValues {


	public static final String CORBA_MODULE       = "CORBAModule";
	public static final String CPP_NAMESPACE      = "CPPNamespace";
	public static final String DB_COLUMN          = "DBColumn";
	public static final String DB_COL_LENGTH      = "DBColLength";
	public static final String DB_MAPPING         = "DBMapping";
	public static final String DB_PKEY_INHERIT    = "inheritParentKeys";
	public static final String DB_TABLE           = "DBTable";
	
	public static final String EBJ_COMPONENT      = "EJBComponent";
	public static final String WSNAMESPACE        = "WSNamespace";
	public static final String WSNAMESPACE_PREFIX = "WSNamespacePrefix";
    public static final String MINOR_VERSION      = "MinorVersion";
    public static final String MAJOR_VERSION      = "MajorVersion";
}
