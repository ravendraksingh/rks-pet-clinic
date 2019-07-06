package com.rks.rkspetclinic.bootstrap;

import com.rks.rkspetclinic.model.Owner;
import com.rks.rkspetclinic.model.Vet;
import com.rks.rkspetclinic.services.OwnerService;
import com.rks.rkspetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Ravendra");
        owner1.setLastName("Singh");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Sarita");
        owner2.setLastName("Singh");

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
