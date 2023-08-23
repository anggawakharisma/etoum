package com.tabeldata.etoum.dao;

import com.tabeldata.etoum.dto.Example;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ExampleDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public List<Example> findAll(){
        String query = "SELECT id, name, pin, phone, email, is_active, i_id_agent, phone_otp_gen, phone_otp_valid, phone_otp_exp\n" +
                "FROM public.tr_user\n";

        return this.jdbcTemplate.query(query, new RowMapper<Example>(){

            @Override
            public Example mapRow(ResultSet rs, int rowNum) throws SQLException {
                Example data = new Example();
                data.setId(rs.getInt("id"));
                data.setName(rs.getString("name"));
                return data;
            }
        });
    }

}
