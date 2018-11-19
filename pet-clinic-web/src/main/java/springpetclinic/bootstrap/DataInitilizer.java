package springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springpetclinic.model.Owner;
import springpetclinic.model.Vet;
import springpetclinic.services.OwnerService;
import springpetclinic.services.VetService;

@Component
public class DataInitilizer implements CommandLineRunner {


    private OwnerService ownerService;
    private VetService vetService;

    public DataInitilizer(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Nagneder");
        owner1.setLastName("Ettikala");

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Soujanya");
        owner2.setLastName("Ettikala");

        ownerService.save(owner2);

        System.out.println("Initilizig Owner Data");
        Vet vet1 = new Vet();
        vet1.setFirstName("Vasantha");
        vet1.setLastName("Ettikala");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Krishna");
        vet2.setLastName("Ettikala");
        vetService.save(vet2);

        System.out.println("Initilizig vet Data");
    }
}
