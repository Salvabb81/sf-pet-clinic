package org.sbrubixquert.sfpetclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sbrubixquert.sfpetclinic.model.Owner;
import org.sbrubixquert.sfpetclinic.repositories.OwnerRepository;
import org.sbrubixquert.sfpetclinic.repositories.PetRepository;
import org.sbrubixquert.sfpetclinic.repositories.PetTypeRepository;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class OwnerSDJPAServiceTest {
	
	public static final String LAST_NAME = "Smith";
	
	@Mock
	OwnerRepository ownerRepository;
	@Mock
	PetRepository petRepository;
	@Mock
	PetTypeRepository petTypeRepository;
	
	@InjectMocks
	OwnerSDJPAService service;

	Owner returnOwner;
	
	@BeforeEach
	void setUp() throws Exception {
		returnOwner = new Owner();
		returnOwner.setId(1L);
		returnOwner.setLastName("Smith");
	}

	@Test
	void testFindById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1L);

        assertNotNull(owner);
	}
	
	@Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(1L);

        assertNull(owner);
    }

	@Test
	void testSave() {
		Owner ownerToSave = new Owner();
		ownerToSave.setId(1L);

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
	}

	@Test
	void testFindAll() {
		Set<Owner> returnOwnersSet = new HashSet<>();
		Owner owner1 = new Owner();
		owner1.setId(1L);
		
		Owner owner2 = new Owner();
		owner1.setId(2L);
		
        returnOwnersSet.add(owner1);
        returnOwnersSet.add(owner2);

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
	}

	@Test
	void testDelete() {
		service.delete(returnOwner);

        //default is 1 times
        verify(ownerRepository, times(1)).delete(any());
	}

	@Test
	void testDeleteById() {
		service.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
	}

	@Test
	void testFindByLastName() {
		Owner returnOwner = new Owner();
		returnOwner.setId(1L);
		returnOwner.setLastName(LAST_NAME);
		
		when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
		
		Owner smith = service.findByLastName(LAST_NAME);
		
		assertEquals(LAST_NAME, smith.getLastName());
		
		verify(ownerRepository).findByLastName(any());
	}

}
