package org.sbrubixquert.sfpetclinic.bootstrap;

import java.time.LocalDate;

import org.sbrubixquert.sfpetclinic.model.Owner;
import org.sbrubixquert.sfpetclinic.model.Pet;
import org.sbrubixquert.sfpetclinic.model.PetType;
import org.sbrubixquert.sfpetclinic.model.Speciality;
import org.sbrubixquert.sfpetclinic.model.Vet;
import org.sbrubixquert.sfpetclinic.model.Visit;
import org.sbrubixquert.sfpetclinic.services.OwnerService;
import org.sbrubixquert.sfpetclinic.services.PetTypeService;
import org.sbrubixquert.sfpetclinic.services.SpecialityService;
import org.sbrubixquert.sfpetclinic.services.VetService;
import org.sbrubixquert.sfpetclinic.services.VisitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	private final VisitService visitService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialityService specialityService, VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {

		int count = petTypeService.findAll().size();

		if (count == 0) {
			loadData();
		}

	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);

		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality savedRadiology = specialityService.save(radiology);

		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");
		Speciality savedSurgery = specialityService.save(surgery);

		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");
		Speciality savedDentistry = specialityService.save(dentistry);

		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("221B Baker Street");
		owner1.setCity("London");
		owner1.setTelephone("4415647712");

		Pet michaelsPet = new Pet();
		michaelsPet.setPetType(savedDogPetType);
		michaelsPet.setOwner(owner1);
		michaelsPet.setBirthDate(LocalDate.now());
		michaelsPet.setName("Watson");
		owner1.getPets().add(michaelsPet);

		this.ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAddress("221B Baker Street");
		owner2.setCity("London");
		owner2.setTelephone("4415647712");

		Pet fionasPet = new Pet();
		fionasPet.setPetType(savedCatPetType);
		fionasPet.setOwner(owner2);
		fionasPet.setBirthDate(LocalDate.now());
		fionasPet.setName("Moriarty");
		owner2.getPets().add(fionasPet);

		this.ownerService.save(owner2);

		Visit catVisit = new Visit();
		catVisit.setPet(fionasPet);
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("Sneezy Kitty");

		visitService.save(catVisit);

		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialities().add(savedRadiology);

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vet2.getSpecialities().add(savedSurgery);

		vetService.save(vet2);
	}

}
