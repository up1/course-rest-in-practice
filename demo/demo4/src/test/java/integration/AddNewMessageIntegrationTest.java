package integration;

import api.Application;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class AddNewMessageIntegrationTest {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void newMessageShouldBeCreated() throws JsonProcessingException {
        //Arrange
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("name", "somkiat");
        requestBody.put("description", "my data");
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity =
                new HttpEntity<String>(OBJECT_MAPPER.writeValueAsString(requestBody), requestHeaders);
        //Act
        Map<String, Object> apiResponse =
                restTemplate.postForObject("http://localhost:8888/message", httpEntity, Map.class, Collections.EMPTY_MAP);

        //Assert
        assertNotNull(apiResponse);
        assertNotNull(apiResponse.get("id"));
        assertEquals("somkiat", apiResponse.get("name"));
        assertEquals("my data", apiResponse.get("description"));
    }


}
