package org.sbrubixquert.sfpetclinic.services.springdatajpa;

import java.util.Set;

import org.sbrubixquert.sfpetclinic.model.Vet;
import org.sbrubixquert.sfpetclinic.repositories.VetRepository;
import org.sbrubixquert.sfpetclinic.services.CommonService;
import org.sbrubixquert.sfpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VetSDJPAService implements VetService {
	private final VetRepository vetRepository;
	
	public VetSDJPAService(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	@Override
	public Vet findById(Long id) {
		return vetRepository.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet object) {
		return vetRepository.save(object);
	}

	@Override
	public Set<Vet> findAll() {
		;
		return (Set<Vet>) vetRepository.findAll();
	}

	@Override
	public void delete(Vet object) {
		vetRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);
	}

}
