package example.testing.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith( MockitoExtension.class )
public class BDDMockitoDemo {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerService ownerService;

    @Test
    void saveOwnerBDDTest() {

        // BDD Style : Given
        given( ownerRepository.save( any( Owner.class)) )
                .willReturn( owner() );

        // When :
        Owner owner = ownerService.saveOwner( new Owner() );

        // BDD Style: Then
        then( ownerRepository ).should().save( any(Owner.class) ); // Verify Interaction

        assertEquals( 1, owner.getId() );
        assertEquals( "John", owner.getFirstName() );
        assertEquals( "Doe", owner.getLastName() );


    }


    private Owner owner() {

        Owner owner = new Owner();
        owner.setId( 1 );
        owner.setFirstName( "John" );
        owner.setLastName( "Doe" );
        return owner;
    }

}

