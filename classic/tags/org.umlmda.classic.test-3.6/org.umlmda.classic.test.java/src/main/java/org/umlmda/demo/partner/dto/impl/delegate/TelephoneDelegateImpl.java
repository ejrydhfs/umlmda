package org.umlmda.demo.partner.dto.impl.delegate;

import org.umlmda.demo.partner.dto.Telephone;
import org.umlmda.demo.partner.dto.TelephoneDelegate;

public class TelephoneDelegateImpl implements TelephoneDelegate {

   
   private final Telephone telephone;

   public TelephoneDelegateImpl(Telephone telephone) {
      this.telephone = telephone;
   }

   public String getFullNumber() {
      // TODO Auto-generated method stub
      return null;
   }

   public void setFullNumber(String fullNumber) {
      // TODO Auto-generated method stub

   }

}
