package springpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

    private Set<Speciality> sepciality;

    public Set<Speciality> getSepciality() {

        if (sepciality == null) {
            return this.sepciality = new HashSet<>();
        } else {
            return this.sepciality;
        }


    }

    public void setSepciality(Set<Speciality> sepciality) {
        this.sepciality = sepciality;
    }
}
