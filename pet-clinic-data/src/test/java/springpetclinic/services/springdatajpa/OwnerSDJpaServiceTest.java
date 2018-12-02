package springpetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import springpetclinic.model.Owner;
import springpetclinic.repositories.OwnerRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    private Owner owner;

    private final Long ownerId = 1L;
    private final String firstName = "smith";
    private final String lastName = "jane";

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(ownerId).firstName(firstName).lastName(lastName).build();
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(anyString())).thenReturn(owner);

        Owner savedOwner = ownerSDJpaService.findByLastName(lastName);
        assertEquals(lastName, savedOwner.getLastName());

    }

    @Test
    void findById() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));

        Owner savedOwner = ownerSDJpaService.findById(ownerId);
        assertEquals(ownerId, savedOwner.getId());
    }

    @Test
    void findAll() {

        Set<Owner> owners = new HashSet<>();
        owners.add(owner);

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> savedOwners =ownerSDJpaService.findAll();
        assertEquals(1, savedOwners.size());
    }

    @Test
    void save() {
        Owner saveOwner= ownerSDJpaService.save(owner);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void delete() {

        ownerSDJpaService.delete(owner);

        assertEquals(0, ownerSDJpaService.findAll().size());
    }

    @Test
    void deleteById() {

        ownerSDJpaService.deleteById(ownerId);

        assertEquals(null, ownerSDJpaService.findById(ownerId));
    }
}