package springpetclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public abstract class AbstractMapService<ID, T> {

    protected Map<ID, T> map = new HashMap<>();

    T save(ID id, T object) {
        map.put(id, object);

        return object;
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
