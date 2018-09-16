package issue;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class ControllerTests {

    static EmbeddedServer embeddedServer;

    @BeforeClass
    public static void setup() {
        embeddedServer = ApplicationContext.run(
                EmbeddedServer.class,
                Collections.emptyMap()
        );
    }

    @AfterClass
    public static void cleanup() {
        if (embeddedServer != null) {
            embeddedServer.stop();
        }
    }

    @Test
    public void bodyLast() {
        ControllerTestClient client = embeddedServer.getApplicationContext().getBean(ControllerTestClient.class);
        Book result = client.ok("Micronaut", new Book("Test")).blockingGet();
        assertEquals("Micronaut", result.getTitle());
    }


    @Test
    public void bodyFirst() {
        ControllerTestClient client = embeddedServer.getApplicationContext().getBean(ControllerTestClient.class);
        Book result = client.fail(new Book("Test"), "Micronaut").blockingGet();
        assertEquals("Micronaut", result.getTitle());
    }

}
