package com.kognitiv.offer;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class OfferServiceTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void addNewOffer() throws Exception {
        JSONObject request = new JSONObject();
        request.put("name","sale_Test");
        request.put("location","India");
        request.put("validFrom","2021-01-01");
        request.put("validTill","    \"validTill\":\"2021-01-31\",\n");

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/collect/offer")
                .accept(MediaType.APPLICATION_JSON)
                .content(request.toString())
                .contentType(MediaType.APPLICATION_JSON);
        mvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"success\":\"true\"}")));

    }
}
