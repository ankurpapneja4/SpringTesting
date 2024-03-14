package example.testing.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReturningValueFromMockDemo {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerService ownerService;

    @Test
    void saveOwnerTest() {

        // Given
        when( ownerRepository.save( any(Owner.class)) )
                .thenReturn( owner() );

        // When :
        Owner owner = ownerService.saveOwner( new Owner() );

        // Then
        assertEquals( 1, owner.getId() );
        assertEquals( "John", owner.getFirstName() );
        assertEquals( "Doe", owner.getLastName() );

        verify( ownerRepository ).save( any(Owner.class) );
    }


    private Owner owner() {

        Owner owner = new Owner();
            owner.setId( 1 );
            owner.setFirstName( "John" );
            owner.setLastName( "Doe" );
        return owner;
    }

}
