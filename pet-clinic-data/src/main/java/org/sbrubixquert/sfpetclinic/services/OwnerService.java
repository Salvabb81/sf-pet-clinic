package org.sbrubixquert.sfpetclinic.services;

import org.sbrubixquert.sfpetclinic.model.Owner;

public interface OwnerService extends CommonService<Owner, Long> {

	Owner findByLastName(String lastName);
	
}

