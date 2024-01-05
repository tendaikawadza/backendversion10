package io.getarrays.securecapita.Stores.stores;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Data
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_DEFAULT)

public class Stores {
    private Long id;
    private Date date;
    private int quantity;
    private String fromWhomReceived;
    private String productReceived;
    private int runningBalance;
}
