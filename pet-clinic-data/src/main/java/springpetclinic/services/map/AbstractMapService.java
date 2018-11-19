package springpetclinic.services.map;

import springpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<ID extends  Long, T extends BaseEntity> {

    protected Map<Long, T> map = new HashMap<>();

    T save(T object) {

        if(object.getId() == null){
            object.setId(getNextId());
        }
        map.put(object.getId(), object);

        return object;
    }

    private Long getNextId() {

        Long id = Collections.max(map.keySet()) + 1;

        return id;
    }

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }


}
