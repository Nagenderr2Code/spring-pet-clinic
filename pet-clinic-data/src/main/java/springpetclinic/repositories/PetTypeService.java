package springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springpetclinic.model.PetType;

public interface PetTypeService extends CrudRepository<PetType, Long> {
}
