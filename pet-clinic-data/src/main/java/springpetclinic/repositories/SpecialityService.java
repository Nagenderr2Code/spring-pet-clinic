package springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springpetclinic.model.Speciality;

public interface SpecialityService extends CrudRepository<Speciality, Long> {
}
