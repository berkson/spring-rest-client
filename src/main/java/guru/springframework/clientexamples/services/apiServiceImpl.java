package guru.springframework.clientexamples.services;

import guru.springframework.api.domain.User;
import guru.springframework.api.domain.UserData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Berkson Ximenes
 * Date: 15/11/2021
 * Time: 23:16
 */
@Service
public class apiServiceImpl implements Apiservice {

    private RestTemplate restTemplate;

    public apiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getUsers(Integer limit) {

        UserData userData = restTemplate
                .getForObject("http://private-anon-85f9034b56-apifaketory.apiary-mock.com/api/user?limit=" + limit, UserData.class);
        return userData.getData();
    }
}
