package org.sbrubixquert.sfpetclinic.services;

import java.util.Set;

public interface CommonService<T, ID> {

	T findById(ID id);

	T save(T object);

	Set<T> findAll();

	void delete(T object);
	
	void deleteById(ID id);
	
}
