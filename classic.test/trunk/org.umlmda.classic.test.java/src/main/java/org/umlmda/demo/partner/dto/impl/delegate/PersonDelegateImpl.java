package org.umlmda.demo.partner.dto.impl.delegate;

import org.umlmda.demo.partner.dto.Person;
import org.umlmda.demo.partner.dto.PersonDelegate;

public class PersonDelegateImpl extends PartnerDelegateImpl implements PersonDelegate {

   public PersonDelegateImpl(Person person) {
      super(person);
   }

   public int getAge() {
      // TODO Auto-generated method stub
      return 0;
   }

   public void setAge(int age) {
      // TODO Auto-generated method stub

   }

}
