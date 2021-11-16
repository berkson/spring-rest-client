package guru.springframework.clientexamples.services;

import guru.springframework.api.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Berkson Ximenes
 * Date: 15/11/2021
 * Time: 23:22
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
class apiServiceImplTest {

    @Autowired
    Apiservice apiservice;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testGetUsers() {
        List<User> users = apiservice.getUsers(1);

        assertEquals(1, users.size());
    }
}