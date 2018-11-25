package springpetclinic.services.map;

import springpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<ID extends  Long, T extends BaseEntity> {

    protected Map<Long, T> map = new HashMap<>();

    T save(T object) {
        System.out.println("Saving the Object of Type.." + object.getClass());
        if(object.getId() == null){
            object.setId(getNextId());
        }
        map.put(object.getId(), object);

        return object;
    }

    private Long getNextId() {
        Long id;
        try{
            id = Collections.max(map.keySet()) + 1;
        }catch (NoSuchElementException e){
            System.out.println("Exception Occured while fetching Id.." + e.getMessage());
            id=1L;
        }



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
