package guru.springframework.clientexamples.services;

import guru.springframework.api.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by Berkson Ximenes
 * Date: 15/11/2021
 * Time: 23:16
 */
public interface Apiservice {
    List<User> getUsers(Integer limit);

    Flux<User> getUsers(Mono<Integer> limit);
}
