package org.sbrubixquert.sfpetclinic.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sbrubixquert.sfpetclinic.model.Owner;
import org.sbrubixquert.sfpetclinic.services.OwnerService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

	@Mock
	OwnerService ownerService;

	@InjectMocks
	OwnerController ownerController;

	Set<Owner> owners;

	MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		owners = new HashSet<>();
		Owner owner1 = new Owner();
		Owner owner2 = new Owner();
		owner1.setId(1L);
		owner2.setId(2L);
		owners.add(owner1);
		owners.add(owner2);

		mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
	}

	@Test
	void testFindOwners() throws Exception {
		mockMvc.perform(get("/owners/find")).andExpect(status().isOk()).andExpect(view().name("owners/findOwners"))
			.andExpect(model().attributeExists("owner"));

		verifyNoInteractions(ownerService);
	}

	@Test
    void testProcessFindFormReturnMany() throws Exception {
		Owner owner1 = new Owner();
		owner1.setId(1L);
		Owner owner2 = new Owner();
		owner2.setId(2L);
		
        when(ownerService.findAllByLastNameLike(anyString()))
                .thenReturn(Arrays.asList(owner1, owner2));

        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attribute("selections", hasSize(2)));
    }

    @Test
    void testProcessFindFormReturnOne() throws Exception {
    	Owner owner = new Owner();
		owner.setId(1L);
        when(ownerService.findAllByLastNameLike(anyString())).thenReturn(Arrays.asList(owner));

        mockMvc.perform(get("/owners"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));
    }

    @Test
    void processFindFormEmptyReturnMany() throws Exception {
        when(ownerService.findAllByLastNameLike(anyString()))
                .thenReturn(Arrays.asList(Owner.builder().id(1l).build(),
                        Owner.builder().id(2l).build()));

        mockMvc.perform(get("/owners")
                        .param("lastName",""))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attribute("selections", hasSize(2)));;
    }
    
	@Test
	void testDisplayOwner() throws Exception {
		Owner owner = new Owner();
		owner.setId(1L);
		when(ownerService.findById(anyLong())).thenReturn(owner);

		mockMvc.perform(get("/owners/123")).andExpect(status().isOk()).andExpect(view().name("owners/ownerDetails"))
				.andExpect(model().attribute("owner", hasProperty("id", is(1l))));
	}
	
	@Test
    void testInitCreationForm() throws Exception {
        mockMvc.perform(get("/owners/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createOrUpdateOwnerForm"))
                .andExpect(model().attributeExists("owner"));

        verifyNoInteractions(ownerService);
    }

    @Test
    void testProcessCreationForm() throws Exception {
    	Owner owner = new Owner();
		owner.setId(1L);
		
        when(ownerService.save(ArgumentMatchers.any())).thenReturn(owner);

        mockMvc.perform(post("/owners/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"))
                .andExpect(model().attributeExists("owner"));

        verify(ownerService).save(ArgumentMatchers.any());
    }

    @Test
    void testInitUpdateOwnerForm() throws Exception {
    	Owner owner = new Owner();
		owner.setId(1L);
    	
        when(ownerService.findById(anyLong())).thenReturn(owner);

        mockMvc.perform(get("/owners/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createOrUpdateOwnerForm"))
                .andExpect(model().attributeExists("owner"));

        verifyNoMoreInteractions(ownerService);
    }

    @Test
    void testProcessUpdateOwnerForm() throws Exception {
    	Owner owner = new Owner();
		owner.setId(1L);
    	
        when(ownerService.save(ArgumentMatchers.any())).thenReturn(owner);

        mockMvc.perform(post("/owners/1/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"))
                .andExpect(model().attributeExists("owner"));

        verify(ownerService).save(ArgumentMatchers.any());
    }

}
