package org.sbrubixquert.sfpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.sbrubixquert.sfpetclinic.model.Pet;
import org.sbrubixquert.sfpetclinic.repositories.PetRepository;
import org.sbrubixquert.sfpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class PetSDJPAService implements PetService {

	private final PetRepository petRepository;

	public PetSDJPAService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@Override
	public Pet findById(Long id) {
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet object) {
		return petRepository.save(object);
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		petRepository.findAll().forEach(pets::add);
		return pets;
	}

	@Override
	public void delete(Pet object) {
		petRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
	}

}
