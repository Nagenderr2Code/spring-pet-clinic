package springpetclinic.model;

import java.util.Set;

public class Owner extends Person{

    private String address;
    private String city;
    private String telephone;
    private Set<Pet> pet;

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Pet> getPet() {
        return this.pet;
    }

    public void setPet(Set<Pet> pet) {
        this.pet = pet;
    }
}
