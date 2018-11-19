package springpetclinic.services;

import springpetclinic.model.Owner;

public interface OwnerService extends CurdService<Owner, Long>{

    Owner findByLastName(String lastName);

}
