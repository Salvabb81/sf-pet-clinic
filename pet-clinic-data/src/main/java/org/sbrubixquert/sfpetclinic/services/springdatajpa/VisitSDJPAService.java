package org.sbrubixquert.sfpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.sbrubixquert.sfpetclinic.model.Visit;
import org.sbrubixquert.sfpetclinic.repositories.VisitRepository;
import org.sbrubixquert.sfpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VisitSDJPAService implements VisitService {

	private final VisitRepository visitRepository;

	public VisitSDJPAService(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}

	@Override
	public Visit findById(Long id) {
		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public Visit save(Visit object) {
		return visitRepository.save(object);
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<>();
		visitRepository.findAll().forEach(visits::add);
		return visits;
	}

	@Override
	public void delete(Visit object) {
		visitRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);
	}

}
