package guru.springframework.api.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Berkson Ximenes
 * Date: 15/11/2021
 * Time: 23:01
 */
@Getter
@Setter
public class Billing implements Serializable {
    private Card card;
    private String iban;
    private String swift;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
