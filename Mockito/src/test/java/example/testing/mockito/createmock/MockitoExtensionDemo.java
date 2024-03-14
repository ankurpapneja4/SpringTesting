package example.testing.mockito.createmock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith( MockitoExtension.class )
public class MockitoExtensionDemo {

    @Mock
    List<String> list;

    @Test
    void mockitoExtensionDemo() {

        list.add("Element1");
        list.add("Element2");
    }
}
