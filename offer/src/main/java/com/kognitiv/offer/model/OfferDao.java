package com.kognitiv.offer.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface OfferDao extends JpaRepository<Offer, String> {

    public Optional<Offer> findById(String Id);
    public Offer findByName(String name);

    @Query(value = "select Offer.Id,Offer.name,Offer.valid_from,Offer.valid_till,Offer.location, Offer.url_images from Offer",nativeQuery = true)
    public List<Offer> getData();
}
