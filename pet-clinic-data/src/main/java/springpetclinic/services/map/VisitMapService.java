package springpetclinic.services.map;

import org.springframework.stereotype.Service;
import springpetclinic.model.Visit;
import springpetclinic.services.VisitService;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Long, Visit> implements VisitService {

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit save(Visit visit) {
        return super.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
