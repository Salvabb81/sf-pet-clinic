package org.sbrubixquert.sfpetclinic.services;

import java.util.List;

import org.sbrubixquert.sfpetclinic.model.Owner;

public interface OwnerService extends CommonService<Owner, Long> {

	Owner findByLastName(String lastName);
	
	List<Owner> findAllByLastNameLike(String lastName);
	
}

