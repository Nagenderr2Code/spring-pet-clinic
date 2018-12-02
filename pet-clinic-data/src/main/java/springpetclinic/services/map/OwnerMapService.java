package springpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springpetclinic.model.Owner;
import springpetclinic.services.OwnerService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Long, Owner> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        return map.entrySet().stream()
                .filter(owner-> owner.getValue().getLastName().equalsIgnoreCase(lastName))
                .map(owner-> owner.getValue())
                .findFirst()
                .orElse(null);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
