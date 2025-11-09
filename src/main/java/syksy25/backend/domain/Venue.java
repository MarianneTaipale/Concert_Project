package syksy25.backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String address;
    private String city;

    public Venue(){

    }

    public Venue(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }

    

    public Venue(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Venue [VenueId=" + id + ", name=" + name + ", address=" + address + ", city=" + city + "]";
    }

    public Venue(Long id) {
        this.id = id;
    }
    
}
