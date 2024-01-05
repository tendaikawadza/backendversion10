package io.getarrays.securecapita.Stores.stores;

import io.getarrays.securecapita.exception.ApiException;
import io.getarrays.securecapita.purchaserequestnew.PurchaseRequestQueries;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

import static io.getarrays.securecapita.Stores.stores.StoresQuery.SELECT_STORES_BY_ID_QUERY;
import static org.springframework.boot.autoconfigure.condition.ConditionMessage.of;

@Repository
@RequiredArgsConstructor
@Slf4j

public class StoresJdbc implements StoresRepository<Stores> {

    private final StoresQuery storesQuery;

    private final NamedParameterJdbcTemplate jdbc;
    //where but department code there, rs is resultSet it must same with column datamase, you can matching with column database

    RowMapper<Stores> rowMapper = (rs, rowNum) -> {
        Stores stores = new Stores();
        stores.setId(rs.getLong("id"));
        stores.setDate(rs.getDate("date"));
        stores.setQuantity(rs.getInt("quantity"));
        stores.setFromWhomReceived(rs.getString("fromWhomReceived"));
        stores.setProductReceived(rs.getString(("productReceived")));
        stores.setRunningBalance(rs.getInt("runningBalance"));
        return stores;
    };
    //its the same the format must same, an example before  wait i want explain. ab example before departmentCode become department_code it must same with database

    @Override
    public List<Stores> list() {
        try {
            String query = "SELECT * FROM stores;";
            List<Stores> stores= jdbc.query(query, rowMapper);                        //query(query, new UserRowMapper());
            return stores;
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new ApiException("An error occurred while retrieving the list of stores. Please try again.");
        }

    }


    @Override
    public Stores create(Stores stores) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = getSqlParameterSource(stores);
        jdbc.update(storesQuery.INSERT_Stores_QUERY, parameters, holder, new String[]{"id"});
        stores.setId(holder.getKey().longValue());
        return stores;
    }

    private SqlParameterSource getSqlParameterSource(Stores stores, Long userId) {
        return new MapSqlParameterSource()
                .addValue("id", stores.getId())
                .addValue("date", stores.getDate())
                .addValue("quantity", stores.getQuantity())
                .addValue("fromWhomReceived", stores.getFromWhomReceived())
                .addValue("productReceived", stores.getProductReceived())
                .addValue("runningBalance", stores.getRunningBalance());
    }


    @Override
    public Stores get(Long id) {
        try {
            return jdbc.queryForObject(storesQuery.SELECT_STORES_BY_ID_QUERY, Collections.singletonMap("id", id), rowMapper);
        } catch (EmptyResultDataAccessException exception) {
            throw new ApiException("No Stores found by id: " + id);
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new ApiException("An error occurred. Please try again.");
        }
    }

//    @Override
//    public void update(Stores stores, Long id) {
//
//    }

//    @Override
//    public void update(Stores stores, Long id) {
//        try {
//
//            String UPDATE_STORES_BY_ID = "UPDATE STORES SET productReceived=?,Date=?,fromWhomReceived=? WHERE id = :Id";
//
//            jdbcTemplate.update(UPDATE_STORES_BY_ID, stores.getProductReceived(),stores.getDate(),fromWhomReceived.getFromWhomReceived(),id);
//            return;
//
//        }
//        catch (Exception exception) {
//            log.error(exception.getMessage());
//            throw new ApiException("An error occurred. Please try again.");
//        }
//
//    }


    @Override
    public boolean delete(Long id) {
        try {
            String DELETE_FROM_STORES_BY_ID = "DELETE FROM STORES WHERE id = :Id";
            jdbc.update(DELETE_FROM_STORES_BY_ID, Collections.singletonMap("Stores", id));
            return true;
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new ApiException("An error occurred. Please try again.");
        }

    }
}
