package guru.springframework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Berkson Ximenes
 * Date: 16/11/2021
 * Time: 19:59
 */
public class RestTemplateExamples {
    public static final String API_ROOT = "https://api.predic8.de:443/shop";
    private static RestTemplate restTemplate;

    @BeforeAll
    static void beforeAll() {
        restTemplate = new RestTemplate();
    }

    @Test
    void getCategories() {
        String apiUrl = API_ROOT + "/categories/";

        JsonNode jsonNode = restTemplate.getForObject(apiUrl, JsonNode.class);

        System.out.println("Response");
        System.out.println(jsonNode.toString());
    }

    //Problema com a api de teste não está criando o customer
    @Test
    void createCustomer() {
        String apiUrl = API_ROOT + "/customers/";

        // java object to parse to json
        Map<String, String> postMap = new HashMap<>();
        postMap.put("firstname", "James");
        postMap.put("lastname", "Ochoa");

        JsonNode jsonNode = restTemplate.postForObject(apiUrl, postMap, JsonNode.class);

        System.out.println("Response");
        System.out.println(jsonNode.toString());
    }

    //Problema com a api de teste.
    @Test
    void updateCustomer() {
        UriComponents uriBuilder = UriComponentsBuilder
                .fromUriString(API_ROOT)
                .path("/customers/").build();
        // java object to parse to json
        Map<String, Object> map = new HashMap<>();
        map.put("firstname", "Jorge");
        map.put("lastname", "Uchoa");

        JsonNode jsonNode = restTemplate.postForObject(uriBuilder.toString(), map, JsonNode.class);

        System.out.println("Response");
        System.out.println(jsonNode.toString());

        String customerUrl = jsonNode.get("customer_url").textValue();

        String id = customerUrl.split("/")[3];

        System.out.println("Created customer id: " + id);

        map.put("firstname", "Joao");
        map.put("lastname", "Bosco");

        restTemplate.put(uriBuilder.toString() + id, map);

        JsonNode updatedNode = restTemplate.getForObject(uriBuilder.toString() + id, JsonNode.class);

        System.out.println(updatedNode.toString());
    }
}
