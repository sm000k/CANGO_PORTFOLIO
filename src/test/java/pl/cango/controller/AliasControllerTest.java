package pl.cango.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.cango.dto.CreateAliasRequest;
import pl.cango.dto.CreateAliasResponse;
import pl.cango.service.AliasService;
import pl.cango.service.ServiceTypeNotFound;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AliasController.class)
class AliasControllerTest {

    @MockBean
    AliasService aliasService;

    MockMvc mockMvc;

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.standaloneSetup()
                .setControllerAdvice(AliasControllerAdvice.class)
                .build();
    }

    @Test
    @DisplayName("Should return HTTP 404 when service throws ServiceTypeNotFound exception")
    void shouldReturn404IfServiceNotFound() throws Exception {
        when(aliasService.createAlias(any(CreateAliasRequest.class))).thenThrow(new ServiceTypeNotFound("mock"));
        
        mockMvc.perform(
                        post("/alias/non-existing-id/alias")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{}")
                )
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldCreateAliasSuccessfully() {
//        CreateAliasRequest request = new CreateAliasRequest();
//        request.setAlias("testAlias");
//        CreateAliasResponse response = new CreateAliasResponse("testAlias", "1234");
    }
}
