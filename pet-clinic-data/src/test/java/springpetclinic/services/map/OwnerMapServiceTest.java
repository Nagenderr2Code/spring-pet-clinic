package springpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import springpetclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    private final Long ownerId = 1L;
    private final String firstName = "smith";
    private final String lastName = "jane";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService();
        ownerMapService.save(Owner.builder().id(ownerId).firstName(firstName).lastName(lastName).build());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(lastName);
        assertEquals(lastName, owner.getLastName());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();

        assertEquals(1, owners.size());
    }

    @Test
    void save() {
        Long id = 2L;
        Owner owner = ownerMapService.save(Owner.builder().id(id).firstName("nagender").lastName("ettikala").build());

        assertEquals(id, owner.getId());
    }

    @Test
    void delete() {

        ownerMapService.delete(ownerMapService.findById(ownerId));

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);

        assertEquals(0, ownerMapService.findAll().size());
    }
}