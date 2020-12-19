package guru.springframework.mrhpetclcinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="vets")
public class Vet extends Person{
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "vet_specialities",joinColumns = @JoinColumn(name = "vet_id"),inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Specialty> specialities = new HashSet<>();

    public Set<Specialty> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Specialty> specialities) {
        this.specialities = specialities;
    }

    @Override
    public String toString() {
        return "Vet{" +
                "firstName="+getFirstName()+ ", "+
                "lastName="+getLastName()+", "+
                "specialities=" + specialities +
                '}';
    }
}
