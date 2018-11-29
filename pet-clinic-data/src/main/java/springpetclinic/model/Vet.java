package springpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialities",
    joinColumns =@JoinColumn(name = "vet_id"),
    inverseJoinColumns = @JoinColumn(name = "speciality_id"))
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
