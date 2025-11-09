package syksy25.backend.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;


@Entity
public class Concert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @NotNull(message = "Enter artists name")
    private Artist artist;

    @ManyToOne
    @NotNull(message = "Enter venue")
    private Venue venue;

    @NotNull(message = "Date is required")
    private LocalDate date;

    public Concert(){

    }

    public Concert(Artist artist, Venue venue, LocalDate date) {
        this.artist = artist;
        this.venue = venue;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Concert [id=" + id + ", artist=" + artist + ", venue=" + venue + ", date=" + date + "]";
    }

}
