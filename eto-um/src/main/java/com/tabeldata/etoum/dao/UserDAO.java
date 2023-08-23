package com.tabeldata.etoum.dao;


import com.tabeldata.etoum.dto.UserDTO;
import com.tabeldata.etoum.entity.Pengguna;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Slf4j
@Repository
public class UserDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    public String create(Pengguna param){
        String query = "INSERT INTO public.tr_user\n" +
                "\t(id, fullname, password, citizen_number, place_of_birth, date_of_birth, gender, citizenship, address, phone, mother_name, job)\n" +
                "values\n" +
                "\t(newid(), :fullname, :password, :citizen_number, :place_of_birth, :date_of_birth, :gender, :citizenship, :address, :phone, :mother_name, :job);";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", param.getId());
        parameterSource.addValue("fullname", param.getFullname());
        parameterSource.addValue("password", param.getPassword());
        parameterSource.addValue("citizenNumber", param.getCitizenNumber());
        parameterSource.addValue("placeOfBirth", param.getPlaceOfBirth());
        parameterSource.addValue("dateOfBirth", param.getDateOfBirth());
        parameterSource.addValue("gender", param.getGender());
        parameterSource.addValue("citizenship", param.getCitizenship());
        parameterSource.addValue("address", param.getAddress());
        parameterSource.addValue("phone", param.getPhone());
        parameterSource.addValue("motherName", param.getMotherName());
        parameterSource.addValue("job", param.getJob());

        return jdbcTemplate.queryForObject(
                query, parameterSource, (resultSet, i) -> resultSet.getString("id"));
    }

    public Optional<Pengguna> findPenggunaLoginByPenggunaOptional(String penggunaLogin) {
        String query = "SELECT i_id as id, n_fullname as fullname, n_password as password, n_citizen_number as citizenNumber, " +
                "n_place_of_birth as getPlaceOfBirth, n_gender as gender, n_citizenship as citizenship, n_address as address, " +
                "n_phone as phone , n_mother_name as motherName, n_job as job, d_date_of_birth as dateOfBirth\n" +
                "FROM public.tr_user;\n";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("pengguna", penggunaLogin);
        try {
            Pengguna pengguna = jdbcTemplate.queryForObject(query, parameterSource, new BeanPropertyRowMapper<>(Pengguna.class));
            return Optional.of(pengguna);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
