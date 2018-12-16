package springpetclinic.services;

import springpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CurdService<Owner, Long>{

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}
