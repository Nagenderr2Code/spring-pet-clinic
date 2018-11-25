package springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springpetclinic.model.Owner;
import springpetclinic.model.Pet;
import springpetclinic.model.PetType;
import springpetclinic.model.Vet;
import springpetclinic.services.OwnerService;
import springpetclinic.services.PetService;
import springpetclinic.services.PetTypeService;
import springpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataInitilizer implements CommandLineRunner {


    private OwnerService ownerService;
    private VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;

    public DataInitilizer(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("DOG");
        petTypeService.save(dog);


        PetType cat = new PetType();
        dog.setName("Dancy");
        petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Nagneder");
        owner1.setLastName("Ettikala");
        owner1.setAddress("1234 staats");
        owner1.setCity("S filed");
        owner1.setTelephone("343453443");

        Pet petDog = new Pet();
        petDog.setName("Nancy");
        petDog.setDob(LocalDate.now());
        petDog.setOwner(owner1);
        petDog.setPetType(dog);

        petService.save(petDog);


        owner1.getPet().add(petDog);

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Soujanya");
        owner2.setLastName("Ettikala");
        owner2.setAddress("123 staats");
        owner2.setCity("S plain");
        owner2.setTelephone("8765468976");

        Pet petCat = new Pet();
        petCat.setName("");
        petCat.setDob(LocalDate.now());
        petCat.setOwner(owner2);
        petCat.setPetType(cat);
        petService.save(petCat);

        owner2.getPet().add(petCat);

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
