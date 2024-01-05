package io.getarrays.securecapita.Stores.stores;

import java.util.Date;

public class StoresQuery {
    public static final String SELECT_STORES_BY_ID_QUERY = "SELECT * FROM Stores WHERE id = :id";
    public static final String INSERT_Stores_QUERY = "INSERT INTO Stores (date, quantity,fromWhomReceived, productReceived, runningBalance) VALUES (:date, :quantity,:fromWhomReceived, :productReceived, :runningBalance)";

    public static final String SELECT_ALL_STORES = "SELECT * FROM stores";

}
