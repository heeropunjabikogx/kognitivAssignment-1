package com.kognitiv.offer.service;

import com.kognitiv.offer.model.Offer;
import com.kognitiv.offer.model.OfferDao;
import com.kognitiv.offer.model.OfferDao;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service("OfferService")
public class OfferService {

    @Autowired
    OfferDao existingOffers;

    public List<Offer> fetchAllOffers(){
        List<Offer> result = new ArrayList<Offer>();
        List<Offer> offer = existingOffers.getData();
        Iterator<Offer> itr = offer.iterator();
        while(itr.hasNext()) {
            result.add(itr.next());
        }
    return result;
    }

    public boolean addNewOffer(Offer request){
        Offer offer = new Offer();
        offer.setName(request.getName());
        offer.setLocation(request.getLocation());
        offer.setValidFrom(request.getValidFrom());
        offer.setValidTill(request.getValidTill());
        offer.setUrlImages("https://jsonplaceholder.typicode.com/photos");
        existingOffers.save(offer);

        return true;
    }
}
