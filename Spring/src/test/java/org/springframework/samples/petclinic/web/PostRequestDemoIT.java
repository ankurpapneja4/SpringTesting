package org.springframework.samples.petclinic.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringJUnitWebConfig( locations = { "classpath:spring/mvc-core-config.xml", "classpath:spring/test-config.xml" })
public class PostRequestDemoIT {

    @Autowired
    ClinicService clinicService;

    @Autowired
    OwnerController ownerController;

    MockMvc mockMvc;

    @BeforeEach
    void initMock() {
        mockMvc = MockMvcBuilders.standaloneSetup( ownerController).build();
    }

    @Test
    void performPost() throws Exception {

        MultiValueMap<String,String> formParams = new LinkedMultiValueMap<>();
            formParams.set( "firstName", "John");
            formParams.set( "lastName", "Doe");
            formParams.set( "address", "Foo Street");
            formParams.set( "city", "West");
            formParams.set( "telephone","9876543210");


        mockMvc.perform( post("/owners/new")
                        .params( formParams ) )
                .andExpect( status().is3xxRedirection() );
    }


}
