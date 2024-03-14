package example.testing.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class VerifyMockInteractionDemo {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerService ownerService;

    @Test
    void deleteOwnerTest() {

        // When
        ownerService.deleteOwner( 1 );

        // Then : verify ownerRepository.deleteOwner( 1 ) was called 1 times
        verify( ownerRepository ).deleteOwner( 1 );


    }
}
