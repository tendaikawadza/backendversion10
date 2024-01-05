package io.getarrays.securecapita.Stores.stores;


import java.util.List;

public interface StoresRepository<T extends Stores> {
        List<T> list();

        T create(T data);

        T get(Long id);

        boolean delete(Long id);

        /* More Complex */


    }


