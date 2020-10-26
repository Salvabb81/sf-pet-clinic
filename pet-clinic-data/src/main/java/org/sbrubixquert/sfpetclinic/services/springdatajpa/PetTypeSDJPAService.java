package org.sbrubixquert.sfpetclinic.services.springdatajpa;

import java.util.Set;

import org.sbrubixquert.sfpetclinic.model.PetType;
import org.sbrubixquert.sfpetclinic.repositories.PetTypeRepository;
import org.sbrubixquert.sfpetclinic.services.CommonService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class PetTypeSDJPAService implements CommonService<PetType, Long> {

	private final PetTypeRepository petTypeRepository;

	public PetTypeSDJPAService(PetTypeRepository petTypeRepository) {
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType object) {
		return petTypeRepository.save(object);
	}

	@Override
	public Set<PetType> findAll() {
		return (Set<PetType>) petTypeRepository.findAll();
	}

	@Override
	public void delete(PetType object) {
		petTypeRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
	}

}
