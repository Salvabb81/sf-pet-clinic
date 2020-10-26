package org.sbrubixquert.sfpetclinic.repositories;

import org.sbrubixquert.sfpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
