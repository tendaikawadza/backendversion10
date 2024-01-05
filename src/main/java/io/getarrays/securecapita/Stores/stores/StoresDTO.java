package io.getarrays.securecapita.Stores.stores;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StoresDTO {
    private Long id;
    private String fromWhomReceived;
    private String productReceived;
    private Date date;
    private int runningBalance;
    private int quantity;
}
