package org.springframework.samples.petclinic.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration( locations = { "classpath:spring/mvc-core-config.xml", "classpath:spring/test-config.xml" })
@WebAppConfiguration
public class LoadWebApplicationContextDemoIT {

    @Autowired
    OwnerController ownerController;

    @Autowired
    ClinicService clinicService;

    MockMvc mockMvc;

    @BeforeEach
    void initMock() {
        mockMvc = MockMvcBuilders.standaloneSetup( ownerController ).build();
    }

    @Test
    void findOwnerByLastnameTest() throws Exception {

        given( clinicService.findOwnerByLastName("") )
                .willReturn( ownerList() );

        mockMvc.perform( get( "/owners") )
                .andExpect( status().isOk() )
                .andExpect( view().name("owners/ownersList") )
                .andExpect( model().attributeExists("selections") );



    }

    @AfterEach
    void resetMock() {
        // Because Mock Bean is Managed By Spring ApplicationContext,
        // It needs to be reset after each test

        reset( clinicService );
    }

    private List<Owner> ownerList() {
        return List.of( new Owner(), new Owner() );
    }


}
