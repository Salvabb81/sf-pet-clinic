package org.sbrubixquert.sfpetclinic.services;

import java.util.Set;

import org.sbrubixquert.sfpetclinic.model.Pet;

public interface PetService {

	Pet findById(Long id);

	Pet save(Pet pet);

	Set<Pet> finAll();

}
