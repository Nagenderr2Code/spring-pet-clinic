package springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import springpetclinic.model.Owner;
import springpetclinic.model.Vet;
import springpetclinic.services.OwnerService;
import springpetclinic.services.VetService;
import springpetclinic.services.map.OwnerMapService;
import springpetclinic.services.map.VetMapService;

public class DataInitilizer implements CommandLineRunner {


    private OwnerService ownerService;
    private VetService vetService;


    public DataInitilizer() {
        ownerService = new OwnerMapService();
        vetService = new VetMapService();
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
