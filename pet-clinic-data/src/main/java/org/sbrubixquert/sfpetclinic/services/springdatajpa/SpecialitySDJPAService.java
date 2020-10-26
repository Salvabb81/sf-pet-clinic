package org.sbrubixquert.sfpetclinic.services.springdatajpa;

import java.util.Set;

import javax.persistence.Entity;

import org.sbrubixquert.sfpetclinic.model.Speciality;
import org.sbrubixquert.sfpetclinic.repositories.SpecialityRepository;
import org.sbrubixquert.sfpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;

@Entity
@Profile("springdatajpa")
public class SpecialitySDJPAService implements SpecialityService {

	private final SpecialityRepository specialityRepository;

	public SpecialitySDJPAService(SpecialityRepository specialityRepository) {
		this.specialityRepository = specialityRepository;
	}

	@Override
	public Speciality findById(Long id) {
		return specialityRepository.findById(id).orElse(null);
	}

	@Override
	public Speciality save(Speciality object) {
		return specialityRepository.save(object);
	}

	@Override
	public Set<Speciality> findAll() {
		return (Set<Speciality>) specialityRepository.findAll();
	}

	@Override
	public void delete(Speciality object) {
		specialityRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		specialityRepository.deleteById(id);
	}

}
