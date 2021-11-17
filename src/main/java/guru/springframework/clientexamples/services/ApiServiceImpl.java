package guru.springframework.clientexamples.services;

import guru.springframework.api.domain.User;
import guru.springframework.api.domain.UserData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by Berkson Ximenes
 * Date: 15/11/2021
 * Time: 23:16
 */
@Service
public class ApiServiceImpl implements Apiservice {

    private final RestTemplate restTemplate;
    private final String api_url;

    public ApiServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String api_url) {
        this.restTemplate = restTemplate;
        this.api_url = api_url;
    }

    /**
     * It's deprecated because restTemplate is deprecated too.
     * @param limit quantity of users to show
     * @return
     */
    @Deprecated
    @Override
    public List<User> getUsers(Integer limit) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromUriString(api_url)
                .queryParam("limit", limit);

        UserData userData = restTemplate
                .getForObject(uriComponentsBuilder.toUriString(), UserData.class);
        return userData.getData();
    }

    /**
     * Can be used with blocking way or reactive way
     * @param limit quantity os users to show
     * @return
     */
    @Override
    public Flux<User> getUsers(Mono<Integer> limit) {
        return WebClient.create(api_url)
                .get()
                .uri(uriBuilder -> uriBuilder.queryParam("limit", limit.then()).build())
                .exchangeToFlux(clientResponse -> clientResponse.bodyToMono(UserData.class)
                        .flatMapIterable(UserData::getData));
    }


}
