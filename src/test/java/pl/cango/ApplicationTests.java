package pl.cango;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        // Ensure that the context is loaded and all required beans are available
        assert(context != null);
        // Add checks for specific beans if necessary
        // assert(context.getBean(RequiredBean.class) != null);
    }
}
