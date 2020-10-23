package org.sbrubixquert.sfpetclinic.services;

import java.util.Set;

import org.sbrubixquert.sfpetclinic.model.Vet;

public interface VetService {

	Vet findById(Long id);

	Vet save(Vet vet);

	Set<Vet> finAll();
}
