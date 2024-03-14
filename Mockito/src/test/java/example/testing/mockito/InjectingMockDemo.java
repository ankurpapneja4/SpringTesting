package example.testing.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class InjectingMockDemo {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerService ownerService;

    @Test
    void deleteOwnerTest() {
        ownerService.deleteOwner( 1 );

    }


}
