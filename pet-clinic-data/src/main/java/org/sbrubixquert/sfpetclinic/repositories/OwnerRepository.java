package org.sbrubixquert.sfpetclinic.repositories;

import java.util.List;

import org.sbrubixquert.sfpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

	public Owner findByLastName(String lastName);
	
	public List<Owner> findAllByLastNameLike(String lastName);
	
}
