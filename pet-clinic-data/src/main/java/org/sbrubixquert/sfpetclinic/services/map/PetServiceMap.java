package org.sbrubixquert.sfpetclinic.services.map;

import java.util.Set;

import org.sbrubixquert.sfpetclinic.model.Pet;
import org.sbrubixquert.sfpetclinic.services.CommonService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CommonService<Pet, Long> {

	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}

	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Pet save(Pet object) {
		return super.save(object.getId(), object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Pet object) {
		super.delete(object);
	}

}
