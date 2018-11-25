package springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springpetclinic.model.*;
import springpetclinic.services.*;

import java.time.LocalDate;

@Component
public class DataInitilizer implements CommandLineRunner {


    private OwnerService ownerService;
    private VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataInitilizer(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
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

        Speciality speciality1 = new Speciality();
        speciality1.setDescription("Dog Specialist");
        specialityService.save(speciality1);

        Vet vet1 = new Vet();
        vet1.setFirstName("Vasantha");
        vet1.setLastName("Ettikala");
        vet1.getSepciality().add(speciality1);

        vetService.save(vet1);

        Speciality speciality2 = new Speciality();
        speciality2.setDescription("Cat Specialist");
        specialityService.save(speciality2);

        Vet vet2 = new Vet();
        vet2.setFirstName("Krishna");
        vet2.setLastName("Ettikala");
        vet2.getSepciality().add(speciality2);
        vetService.save(vet2);
    }
}
