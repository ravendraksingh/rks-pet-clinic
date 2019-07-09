package com.rks.rkspetclinic.bootstrap;

import com.rks.rkspetclinic.model.Owner;
import com.rks.rkspetclinic.model.Pet;
import com.rks.rkspetclinic.model.PetType;
import com.rks.rkspetclinic.model.Vet;
import com.rks.rkspetclinic.services.OwnerService;
import com.rks.rkspetclinic.services.PetTypeService;
import com.rks.rkspetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

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

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Tim");
        vet2.setLastName("Tom");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
