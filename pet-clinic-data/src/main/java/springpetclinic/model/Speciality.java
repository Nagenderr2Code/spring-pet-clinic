package springpetclinic.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "speciality")
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;
}
