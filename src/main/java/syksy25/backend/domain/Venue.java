package syksy25.backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long VenueId;

    private String name;
    private String address;
    private String city;

    public Venue(){

    }

    public Venue(Long venueId) {
        VenueId = venueId;
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


    public Long getVenueId() {
        return VenueId;
    }

    public void setVenueId(Long venueId) {
        VenueId = venueId;
    }

    @Override
    public String toString() {
        return "Venue [VenueId=" + VenueId + ", name=" + name + ", address=" + address + ", city=" + city + "]";
    }

    
    
}
