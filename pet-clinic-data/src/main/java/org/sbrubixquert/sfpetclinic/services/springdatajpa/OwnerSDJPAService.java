package org.sbrubixquert.sfpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.sbrubixquert.sfpetclinic.model.Owner;
import org.sbrubixquert.sfpetclinic.repositories.OwnerRepository;
import org.sbrubixquert.sfpetclinic.repositories.PetRepository;
import org.sbrubixquert.sfpetclinic.repositories.PetTypeRepository;
import org.sbrubixquert.sfpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class OwnerSDJPAService implements OwnerService {

	private final OwnerRepository ownerRepository;
//	private final PetRepository petRepository;
//	private final PetTypeRepository petTypeRepository;

	public OwnerSDJPAService(OwnerRepository ownerRepository, PetRepository petRepository,
			PetTypeRepository petTypeRepository) {
		this.ownerRepository = ownerRepository;
//		this.petRepository = petRepository;
//		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Owner findById(Long id) {

		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Owner save(Owner object) {
		return ownerRepository.save(object);
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);

	}

	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

}
