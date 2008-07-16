// -----------------------------------------------------------------------------
//   $Header: /cvsroot/umlmda/GeneratorBase/src/org/netbeans/junit/diff/DiffException.java,v 1.1 2003/07/15 21:33:49 moroff Exp $
//   $Source: /cvsroot/umlmda/GeneratorBase/src/org/netbeans/junit/diff/DiffException.java,v $
// $Revision: 1.1 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2003/07/15 21:33:49 $
//   $Locker:  $
// -----------------------------------------------------------------------------
// Quelle http://www.netbeans.org
// -----------------------------------------------------------------------------

/*
 *                 Sun Public License Notice
 * 
 * The contents of this file are subject to the Sun Public License
 * Version 1.0 (the "License"). You may not use this file except in
 * compliance with the License. A copy of the License is available at
 * http://www.sun.com/
 * 
 * The Original Code is NetBeans. The Initial Developer of the Original
 * Code is Sun Microsystems, Inc. Portions Copyright 1997-2000 Sun
 * Microsystems, Inc. All Rights Reserved.
 */

/*
 * DiffException.java
 *
 * Created on February 8, 2001, 3:03 PM
 */

package org.netbeans.junit.diff;

/**
 *
 * @author  vstejskal
 * @version 
 */
public class DiffException extends java.io.IOException {
    /** Creates new DiffException */
    public DiffException() {
    }

    public DiffException(String message) {
        super(message);
    }
}

// -----------------------------------------------------------------------------
// $Log: DiffException.java,v $
// Revision 1.1  2003/07/15 21:33:49  moroff
// Initial import
//
// Revision 1.1  2003/02/18 14:28:02  moroff
// Initiale Freigabe
//
// Revision 1.1  2003/02/18 14:12:08  moroff
// Initiale Freigabe
//
// Revision 1.1  2002/09/12 16:14:26  moroff
// Initial revision
//
// -----------------------------------------------------------------------------