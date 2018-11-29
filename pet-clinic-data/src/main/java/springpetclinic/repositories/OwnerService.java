package springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springpetclinic.model.Owner;

public interface OwnerService extends CrudRepository<Owner, Long> {


}
