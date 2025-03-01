package pl.cango.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AliasControlerTestTryOut {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void IntegrationContextLoads(ApplicationContext context) {
        System.out.println("**********");
        System.out.println("count of definition names");
        System.out.println(Arrays.stream(context.getBeanDefinitionNames()).count());
        System.out.println("**********");
    }

    @Test
    void ResponseTestError() throws Exception {
        this.mockMvc.perform(get("/alias/test"))
                .andExpect(content().string(containsString("success"))).andExpect(status().isOk());
    }

}
