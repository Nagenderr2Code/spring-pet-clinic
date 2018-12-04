package springpetclinic.services.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import springpetclinic.model.Pet;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
@Slf4j
class PetMapServiceTest {

    @InjectMocks
    PetMapService petMapService;

    Pet pet;
    private final Long petId = 1L;
    private final String name = "smith";

    @BeforeEach
    void setUp() {
        pet=Pet.builder().id(petId).name(name).build();
        petMapService.save(pet);
    }

    @Test
    void findById() {
        Pet foundPet = petMapService.findById(petId);

        assertEquals(petId, foundPet.getId());
    }

    @Test
    void findAll() {
        Set<Pet> pets = new HashSet<>();
        pets.add(pet);

        Set<Pet> foundPets = petMapService.findAll();

        assertEquals(1, foundPets.size());
    }

    @Test
    void save() {
        Pet savedPet = petMapService.save(pet);

        assertEquals(petId, savedPet.getId());
    }

    @Test
    void delete() {
        petMapService.delete(pet);

        assertEquals(0, petMapService.findAll().size());
    }

    @Test
    void deleteById() {

        petMapService.deleteById(petId);

        assertThrows(NullPointerException.class, ()-> {
            petMapService.findById(petId).getId();
        });
    }
}