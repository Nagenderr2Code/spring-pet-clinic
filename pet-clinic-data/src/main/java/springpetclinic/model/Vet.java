package springpetclinic.model;

import java.util.Set;

public class Vet extends Person {

    private Set<Speciality> sepciality;

    public Set<Speciality> getSepciality() {
        return this.sepciality;
    }

    public void setSepciality(Set<Speciality> sepciality) {
        this.sepciality = sepciality;
    }
}
