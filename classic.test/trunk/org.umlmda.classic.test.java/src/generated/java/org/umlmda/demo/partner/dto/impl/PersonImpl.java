//@@Generated file, please edit UserSections only
//@@UserSection-Begin RCSHeader
// $Header$
// $Source$
// $Revision$
// $State$
// $Name$
// $Date$
// $Locker$
//@@UserSection-End RCSHeader

package org.umlmda.demo.partner.dto.impl;

import java.io.Serializable;
import java.util.Iterator;
import org.umlmda.runtime.xml.XMLMarshalContext;
import org.umlmda.runtime.xml.XMLSerializable;

import org.umlmda.demo.common.dto.Sex;
import org.umlmda.demo.partner.dto.Partner;
import org.umlmda.demo.partner.dto.PartnerVisitor;
import org.umlmda.demo.partner.dto.Person;
import org.umlmda.demo.partner.dto.Profession;
//@@UserSection-Begin Person.Imports
//@@UserSection-End Person.Imports

/**
 * 
 */
public class PersonImpl  extends PartnerImpl  implements Person, Serializable, XMLSerializable, org.umlmda.runtime.visitor.Visitable
{
   // Version information from BusinessComponent org.umlmda.demo.partner
   private static final String modelVersion = "1.0";
//@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long serialVersionUID = 1000L;
//@@UserSection-End VersionInfo
   
   
   // Delegate for none generatable features
   private transient org.umlmda.demo.partner.dto.PersonDelegate thePersonDelegate = null;

   /**
    * Lazy creation of the delegate for none generateable features. 
    */
   protected org.umlmda.demo.partner.dto.PersonDelegate getPersonDelegate() {
      if ( thePersonDelegate == null ) {
         thePersonDelegate = new org.umlmda.demo.partner.dto.impl.delegate.PersonDelegateImpl(this);
      }
      return thePersonDelegate;
   }

   /**
    * Overwritten creation of the delegate for none generateable features from abstract base classes
    */
   protected org.umlmda.demo.partner.dto.PartnerDelegate getPartnerDelegate() {
      return getPersonDelegate();
   }
   private String firstname = "null";
   private javax.xml.datatype.XMLGregorianCalendar birthdate;
   private Sex sex = null;
   private boolean employee;
   private java.math.BigDecimal salary;
   private String[] nationalities = null;
   private Profession _profession = null;

   /**
    * Default Ctor
    */
   protected PersonImpl() {
      super();
   }
   

   

   /**
   * Get firstname
   */
   public String getFirstname() {
      return firstname;
   }
   
   /**
   * Set firstname
   */
   public void setFirstname(String firstname) {
      this.firstname = firstname;
   }

   /**
   * Get birthdate
   */
   public javax.xml.datatype.XMLGregorianCalendar getBirthdate() {
      return birthdate;
   }
   
   /**
   * Set birthdate
   */
   public void setBirthdate(javax.xml.datatype.XMLGregorianCalendar birthdate) {
      this.birthdate = birthdate;
   }

   /**
   * Get sex
   */
   public Sex getSex() {
      return sex;
   }
   
   /**
   * Set sex
   */
   public void setSex(Sex sex) {
      this.sex = sex;
   }

   /**
   * Get age
   */
   public int getAge() {
      return getPersonDelegate().getAge();
   }
   
   /**
   * Set age
   */
   public void setAge(int age) {
      getPersonDelegate().setAge(age);
   }

   /**
   * Get employee
   */
   public boolean isEmployee() {
      return employee;
   }
   
   /**
   * Set employee
   */
   public void setEmployee(boolean employee) {
      this.employee = employee;
   }

   /**
   * Get salary
   */
   public java.math.BigDecimal getSalary() {
      return salary;
   }
   
   /**
   * Set salary
   */
   public void setSalary(java.math.BigDecimal salary) {
      this.salary = salary;
   }

   /**
   * Get nationalities
   */
   public String[] getNationalities() {
      return nationalities;
   }
   
   /**
   * Set nationalities
   */
   public void setNationalities(String[] nationalities) {
      this.nationalities = nationalities;
   }


   public Profession get_profession() {
      return _profession;
   }

   public void set_profession(Profession _profession) {
      this._profession = _profession;
      }
   /**
    * Delivers the full name of the partner. Might be overwritten in subclasses.
    */
    public String getFullName () {
      return getPersonDelegate().getFullName();
    }

		

   //@@UserSection-Begin Person.NonGeneratedMembers
   //@@UserSection-End Person.NonGeneratedMembers

   /**
    * Factory method, only called by the factory implementation in the same package
    */
   static PersonImpl createPersonImpl() {
      return new PersonImpl();
   }
    
   
   /** 
    * Accept the visitor
    * @param visitor
    *           must be instance of org.umlmda.demo.partner.dto.PartnerVisitor.
    * @see org.umlmda.demo.partner.dto.PartnerVisitor.
    */
    public void accept(org.umlmda.runtime.visitor.Visitor visitor) {
       if ( visitor instanceof PartnerVisitor ) {
          PartnerVisitor aVisitor = (PartnerVisitor)visitor;
          
          aVisitor.visit(this);
       }
    }
    

   /**
    * Diagnostics
    */
   public String toString() {
//@@UserSection-Begin toString
		return toXmlString();
//@@UserSection-End toString
   }

   /**
    * XML serialization
    */
   public String toXmlString() {
      XMLMarshalContext context = new XMLMarshalContext();
      
      marshal("PersonImpl", context, true);
      return context.toString();
   }
   
   /**
    * XML serialization of the elements and all children
    */
   public void marshal(String elementName, XMLMarshalContext context, boolean isRoot) {
      context.startElement(elementName, this, isRoot);
      marshalAttributes(context);
      marshalChildren(context);
      marshalReferences(context);
      context.endElement(elementName, this, isRoot);
   }

   /**
    * Marshal attributes
    */
   protected void marshalAttributes(XMLMarshalContext context) {
      super.marshalAttributes(context);
      context.simpleElement("firstname", getFirstname());
      context.simpleElement("birthdate", getBirthdate());
      if ( getSex() != null ) {
         context.simpleElement("sex", getSex().getValue());
      } 
      context.simpleElement("employee", isEmployee());
      context.simpleElement("salary", getSalary());
      context.simpleElement("nationalities", getNationalities());
   }

   /**
    * Marshal children
    */
   protected void marshalChildren(XMLMarshalContext context) {
      super.marshalChildren(context);
         if ( _profession instanceof XMLSerializable )
            ((XMLSerializable)_profession).marshal("_profession", context, false);
   }
   
   /**
    * @param context
    */
   protected void marshalReferences(XMLMarshalContext context) {
      super.marshalReferences(context);
   }

}

//@@UserSection-Begin RCSLog
// $Log$
//@@UserSection-End RCSLog
