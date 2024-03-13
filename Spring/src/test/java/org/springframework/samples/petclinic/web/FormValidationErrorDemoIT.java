package org.springframework.samples.petclinic.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringJUnitWebConfig( locations = { "classpath:spring/mvc-core-config.xml", "classpath:spring/test-config.xml" })
public class FormValidationErrorDemoIT {

    @Autowired
    OwnerController ownerController;

    MockMvc mockMvc;

    @BeforeEach
    void intiMockMvc() {
        mockMvc = MockMvcBuilders.standaloneSetup( ownerController ).build();
    }

    @Test
    void formValidationErrorTest() throws Exception {

        mockMvc.perform( post("/owners/new")
                    .param("firstName", "John")
                    .param("lastName","Doe") )
                .andExpect( status().isOk())
                .andExpect( model().attributeHasErrors("owner") )
                .andExpect( model().attributeHasFieldErrors( "owner", "address"))
                .andExpect( model().attributeHasFieldErrors("owner","city"))
                .andExpect( model().attributeHasFieldErrors("owner","telephone") )
                .andExpect( view().name("owners/createOrUpdateOwnerForm") );

    }

}
