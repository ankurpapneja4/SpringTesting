package example.testing.mockito.createmock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class MockAnnotationDemo {

    @Mock
    List<String> list;

    @BeforeEach
    void initMock(){
        MockitoAnnotations.openMocks( this );
    }

    @Test
    void mockAnnotationDemo() {

        list.add("Element1");
        list.add("Element2");
    }


}
