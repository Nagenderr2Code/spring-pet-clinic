package springpetclinic.services.map;

import springpetclinic.model.Vet;
import springpetclinic.services.VetService;

public class VetMapService extends AbstractMapService<Long, Vet> implements VetService {

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
