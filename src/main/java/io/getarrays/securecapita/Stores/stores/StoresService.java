package io.getarrays.securecapita.Stores.stores;

import java.util.List;

public interface StoresService {

    Stores createStores(Stores stores);

    List<Stores> getAllStores();

    Stores getStoresById(Long id);

    boolean deleteStores(Long id);


}