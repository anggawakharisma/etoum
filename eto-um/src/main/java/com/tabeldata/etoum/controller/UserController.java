package com.tabeldata.etoum.controller;

import com.tabeldata.etoum.dto.CustomMessage;
import com.tabeldata.etoum.dto.ResponseDTO;
import com.tabeldata.etoum.dto.UserDTO;
import com.tabeldata.etoum.entity.Pengguna;
import com.tabeldata.etoum.error.clienterror.BadRequestError;
import com.tabeldata.etoum.error.clienterror.ForbiddenError;
import com.tabeldata.etoum.error.clienterror.NotFoundError;
import com.tabeldata.etoum.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.badRequest;


@RestController
    @RequestMapping("/api/user")
    @RequiredArgsConstructor
    public class UserController {


        private final UserService userService;

        @PostMapping("/save")
        public ResponseEntity<?> create (@RequestBody UserDTO.RequestUpdate request,
                Principal principal) {
            Optional<Pengguna> pengguna = userService.findPenggunaLoginByPenggunaOptional(principal.getName());
            if(!pengguna.isPresent())
                return badRequest().body(new CustomMessage(HttpStatus.BAD_REQUEST, "Pengguna Login Tidak Ditemukan"));
            Optional<Pengguna> penggunaOptional= userService.create(request, pengguna.get().getId());
            return penggunaOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
        }

}

