package org.springframework.samples.petclinic.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class OwnerControllerStandaloneTest {

    @Mock
    ClinicService clinicService;

    @InjectMocks
    OwnerController orderController;

    MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup( orderController ).build();
    }

    @Test
    void processFindFormTest() throws Exception {

        given( clinicService.findOwnerByLastName("") )
                .willReturn( ownerList() );

        mockMvc.perform( get( "/owners") )
                .andExpect( status().isOk() )
                .andExpect( view().name("owners/ownersList") )
                .andExpect( model().attributeExists( "selections") );
    }


    private List<Owner> ownerList() {
        return List.of( new Owner(), new Owner() );
    }
}
