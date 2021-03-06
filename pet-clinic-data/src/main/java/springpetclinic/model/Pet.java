package springpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pets")
public class Pet extends NamedEntity {

    @Builder
    public Pet(Long id, String name, Owner owner, PetType petType, LocalDate dob, Set<Visit> visits) {
        super(id, name);
        this.owner = owner;
        this.petType = petType;
        this.dob = dob;
        if (visits == null || visits.size() > 0 ) {
            this.visits = visits;
        }
    }


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @Column(name = "dob")
    private LocalDate dob;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();
}
