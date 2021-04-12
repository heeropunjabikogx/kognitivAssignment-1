package com.kognitiv.offer.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Offer {

    @Column(nullable = false, unique = true)
    @Id
    @GeneratedValue
    long Id;
    @Column(unique = true)
    String name;
    @Column
    LocalDate validFrom;
    @Column
    LocalDate validTill;;

    @Column
    String location;
    @Column
    String urlImages;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTill() {
        return validTill;
    }

    public void setValidTill(LocalDate validTill) {
        this.validTill = validTill;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrlImages() {
        return urlImages;
    }

    public void setUrlImages(String urlImages) {
        this.urlImages = urlImages;
    }

}
