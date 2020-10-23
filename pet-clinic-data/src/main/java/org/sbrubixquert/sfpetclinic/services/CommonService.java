package org.sbrubixquert.sfpetclinic.services;

import java.util.Set;

public interface CommonService<T, ID> {

	T findById(ID id);

	T save(T owner);

	Set<T> finAll();

	void delete(T object);
	
	void deleteById(ID id);
	
}
