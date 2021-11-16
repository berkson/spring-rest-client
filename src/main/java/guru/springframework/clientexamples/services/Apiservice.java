package guru.springframework.clientexamples.services;

import guru.springframework.api.domain.User;

import java.util.List;

/**
 * Created by Berkson Ximenes
 * Date: 15/11/2021
 * Time: 23:16
 */
public interface Apiservice {
    List<User> getUsers(Integer limit);
}
