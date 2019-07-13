package com.rks.rkspetclinic.bootstrap;

import com.rks.rkspetclinic.model.*;
import com.rks.rkspetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


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
        if (count ==0) {
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
        //radiology.setId(1L);
        Speciality savedRadiology = specialityService.save(radiology);


        Speciality sergery = new Speciality();
        sergery.setDescription("Sergery");
        //radiology.setId(2L);
        Speciality savedSergery = specialityService.save(sergery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        //radiology.setId(3L);
        Speciality savedDentistry = specialityService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Ravendra");
        owner1.setLastName("Singh");
        owner1.setAddress("B-121");
        owner1.setCity("Noida");
        owner1.setTelephone("1234");

        Pet ravendrasPet = new Pet();
        ravendrasPet.setPetType(savedDogPetType);
        ravendrasPet.setOwner(owner1);
        ravendrasPet.setBirthDate(LocalDate.now());
        ravendrasPet.setName("Rosco");
        owner1.getPets().add(ravendrasPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Sarita");
        owner2.setLastName("Singh");
        owner2.setAddress("G903R");
        owner2.setCity("Delhi");
        owner2.setTelephone("93820234");

        Pet saritasPet = new Pet();
        saritasPet.setPetType(savedCatPetType);
        saritasPet.setOwner(owner2);
        saritasPet.setBirthDate(LocalDate.now());
        saritasPet.setName("Meaw");
        owner2.getPets().add(saritasPet);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(saritasPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy kitty");

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Tim");
        vet2.setLastName("Tom");
        vet2.getSpecialities().add(savedSergery);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
