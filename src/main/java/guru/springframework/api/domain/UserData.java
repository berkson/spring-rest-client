package guru.springframework.api.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Berkson Ximenes
 * Date: 15/11/2021
 * Time: 23:18
 */
@Getter
@Setter
public class UserData {
    List<User> data;
}
