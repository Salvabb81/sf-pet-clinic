package org.sbrubixquert.sfpetclinic.repositories;

import org.sbrubixquert.sfpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

	public Owner findByLastName(String lastName);
	
}
