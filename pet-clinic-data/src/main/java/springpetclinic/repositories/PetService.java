package springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springpetclinic.model.Pet;

public interface PetService extends CrudRepository<Pet, Long> {

}
