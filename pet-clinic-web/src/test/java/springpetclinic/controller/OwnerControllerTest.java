package springpetclinic.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import springpetclinic.model.Owner;
import springpetclinic.services.OwnerService;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController ownerController;

    Set<Owner> owners;

    MockMvc mockMvc;

    private final Long ownerId = 1L;
    private final String firstName = "smith";
    private final String lastName = "jane";

    @BeforeEach
    public void setUp() {
        owners = new HashSet<>();
        owners.add(Owner.builder().id(ownerId).firstName(firstName).lastName(lastName).build());

        mockMvc= MockMvcBuilders.standaloneSetup(ownerController)
                .build();
    }

    @Test
    void owners() {

        when(ownerService.findAll()).thenReturn(owners);
        try {
            mockMvc.perform(get("/owners"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("owners/index"))
                    .andExpect(model().attribute("owners", hasSize(1)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void findOwners() throws Exception {

        mockMvc.perform(get("/owners/find"))
                .andExpect(view().name("notimplemented"));
    }
}