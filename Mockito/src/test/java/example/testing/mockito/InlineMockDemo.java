package example.testing.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class InlineMockDemo {

    @Test
    void mockListDemo() {

        // Create Mock Object
        List<String> list = Mockito.mock( List.class );

        list.add(0 , "Element1");
        list.add(0 , "Element2");


    }
}
