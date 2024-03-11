package example.springtesting.spring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @TestPropertySource:
 *
 *   Purpose:
 *   The @TestPropertySource annotation is used to specify which properties files
 *   should be loaded when running a test class.
 *
 *   Precedence:
 *   Test property sources defined using @TestPropertySource have the
 *   highest precedence among all other property sources. This means that they
 *   override properties from other sources.
 *
 */
@ExtendWith(SpringExtension.class) // Create Spring ApplicationContext
@ContextConfiguration( classes = MyService.class)  // Load Required Beans Into Context
@TestPropertySource( "classpath:application-test.properties" ) // Add Property Source
public class TestPropertySourceDemo {

    @Autowired
    MyService myservice;


    @Test
    void getApplicationNameTest() {

        // When: Using @TestPropertySource
        String applicationName = myservice.getApplicationName() ;

        // Then: Properties from test property source are injected.
        assertEquals( "testing-with-spring", applicationName );
    }
}
