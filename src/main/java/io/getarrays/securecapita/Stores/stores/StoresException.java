package io.getarrays.securecapita.Stores.stores;

import java.io.Serial;

public class StoresFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -7541208107922250009L;

    public StoresException () {
        super(StoresExceptionEnum.STORES_EXCEPTION.getMessage());
    }
}
