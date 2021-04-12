package com.kognitiv.offer.controller;

import com.kognitiv.offer.model.ApiResponse;
import com.kognitiv.offer.model.Offer;
import com.kognitiv.offer.model.Offer;
import com.kognitiv.offer.service.OfferService;
import com.kognitiv.offer.model.ApiResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/collect/")
public class OfferController {

    @Autowired
    OfferService OfferService;

    @RequestMapping(value = "offer", method = RequestMethod.GET)
    private ApiResponse getOffers() {
        if (OfferService.fetchAllOffers() != null) {
            JSONObject response = new JSONObject();
            JSONArray resultArray = new JSONArray();
            List<Offer> allOffers = OfferService.fetchAllOffers();
            Iterator<Offer> itr = allOffers.iterator();
            while(itr.hasNext()) {
                JSONObject offer = new JSONObject();
                Offer offerObj = itr.next();
                offer.put("Id",offerObj.getId());
                offer.put("name",offerObj.getName());
                offer.put("ValidFrom",offerObj.getValidFrom());
                offer.put("ValidTill",offerObj.getValidTill());
                offer.put("location",offerObj.getLocation());
                offer.put("url_image",offerObj.getUrlImages());
                resultArray.add(offer);
            }
            response.put("Offer",resultArray);
            return new ApiResponse(HttpStatus.OK, response.toJSONString());
        } else {
            return new ApiResponse(HttpStatus.OK, "No Offers found");
        }
    }

    @RequestMapping(value = "offer", method = RequestMethod.POST)
    private ApiResponse createOffers(@RequestBody Offer request) {
        if (request == null || request.equals("")) {
            return new ApiResponse(HttpStatus.BAD_REQUEST, "");
        } else {
            if(OfferService.addNewOffer(request)) {
                JSONObject response = new JSONObject();
                response.put("Success", "true");
                return new ApiResponse(HttpStatus.OK,response.toJSONString());
            } else {
                return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "");
            }
        }
    }

}
