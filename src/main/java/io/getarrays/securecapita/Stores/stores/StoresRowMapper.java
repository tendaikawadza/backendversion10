package io.getarrays.securecapita.Stores.stores;

import io.getarrays.securecapita.domain.PurchaseRequisition;
import io.getarrays.securecapita.domain.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class StoresRowMapper implements RowMapper<Stores> {
    @Override
    public Stores mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return Stores.builder()
                .id(resultSet.getLong("id"))
                .date(resultSet.getDate("date"))
                .departmentCode(resultSet.getInt("runningBalance"))
                .reason(resultSet.getString("fromWhomReceived"))
                .itemDescription(resultSet.getString("productReceived"))
                .unitPrice(resultSet.getInt("runningBalance"))
                .quantity(resultSet.getInt("quantity"))
                .build();
    }
}
