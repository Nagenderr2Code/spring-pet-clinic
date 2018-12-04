package springpetclinic.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@Setter
@Getter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class NamedEntity extends BaseEntity {

    public NamedEntity(Long id, String name) {
        super(id);
        this.name = name;
    }

    @Column(name = "name")
    private String name;
}
