package org.umlmda.demo.partner.dto.impl.delegate;

import org.umlmda.demo.partner.dto.Partner;
import org.umlmda.demo.partner.dto.PartnerDelegate;

public class PartnerDelegateImpl implements PartnerDelegate {

   private final Partner partner;

   public PartnerDelegateImpl(Partner partner) {
      this.partner = partner;
   }

   public String getFullName() {
      // TODO Auto-generated method stub
      return null;
   }

}
