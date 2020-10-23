package org.sbrubixquert.sfpetclinic.services;

import java.util.Set;

import org.sbrubixquert.sfpetclinic.model.Owner;

public interface OwnerService {

	Owner findById(Long id);
	
	Owner findByLastName(String lastName);
	
	Owner save(Owner owner);
	
	Set<Owner> finAll();
}
