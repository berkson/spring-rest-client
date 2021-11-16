package guru.springframework.api.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Berkson Ximenes
 * Date: 15/11/2021
 * Time: 23:02
 */
@Getter
@Setter
public class Card implements Serializable {
    private String type;
    private String number;
    private ExpirationDate expirationDate;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
