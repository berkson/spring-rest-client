package guru.springframework.api.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Berkson Ximenes
 * Date: 15/11/2021
 * Time: 23:05
 */
@Getter
@Setter
public class Job implements Serializable {
    private String title;
    private String company;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
