package springpetclinic.services.map;

import org.springframework.stereotype.Service;
import springpetclinic.model.Pet;
import springpetclinic.services.PetService;

import java.util.Set;

@Service
public class PetMapService extends AbstractMapService<Long, Pet> implements PetService {

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
