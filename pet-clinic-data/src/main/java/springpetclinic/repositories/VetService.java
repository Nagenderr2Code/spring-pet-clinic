package springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springpetclinic.model.Vet;

public interface VetService extends CrudRepository<Vet, Long> {


}
