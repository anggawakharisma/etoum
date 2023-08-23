package com.tabeldata.etoum.service;

import com.tabeldata.etoum.dao.UserDAO;
import com.tabeldata.etoum.dto.UserDTO;
import com.tabeldata.etoum.entity.Pengguna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService    {

    @Autowired
    private UserDAO dao;
    @Transactional
    public Optional<Pengguna> create(UserDTO.RequestUpdate param, Integer userId)
            throws EmptyResultDataAccessException {
        String hashPassword = BCrypt.hashpw(param.getPengguna().getPassword(), BCrypt.gensalt(12));
        Integer idPengguna = userDAO.getId();
        param.getPengguna().setId(idPengguna);
        param.getPengguna().setPassword(hashPassword);
        param.getPengguna().setUserId(userId);
        dao.create(param.getPengguna());
        return dao.findPenggunaLoginByPenggunaOptional(idPengguna);
    }

    public Optional<Pengguna> findPenggunaLoginByPenggunaOptional(String penggunaLogin) {
        return dao.findPenggunaLoginByPenggunaOptional(penggunaLogin);
    }
}
