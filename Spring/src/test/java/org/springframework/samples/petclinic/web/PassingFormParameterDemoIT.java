package org.springframework.samples.petclinic.web;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@SpringJUnitWebConfig( locations = { "classpath:spring/mvc-core-config.xml", "classpath:spring/test-config.xml" })
public class PassingFormParameterDemoIT {

    @Autowired
    ClinicService clinicService;

    @Autowired
    OwnerController ownerController;

    MockMvc mockMvc;

    @BeforeEach
    void initMock() {
        mockMvc = MockMvcBuilders.standaloneSetup( ownerController ).build();
    }

    @Test
    void findOwnerByLastNameTest() throws Exception {

        given( clinicService.findOwnerByLastName("doe") )
                .willReturn( Collections.emptyList() );

        mockMvc.perform( get("/owners")
                    .param( "lastName", "doe")
                    .param("firstName", "john") )
                .andExpect( status().isOk() )
                .andExpect( view().name("owners/findOwners") );
    }


}
