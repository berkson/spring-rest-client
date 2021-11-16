package guru.springframework.api.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Berkson Ximenes
 * Date: 15/11/2021
 * Time: 23:03
 */
@Getter
@Setter
public class ExpirationDate implements Serializable {
    private String date;
    private String timezoneType;
    private String timezone;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
