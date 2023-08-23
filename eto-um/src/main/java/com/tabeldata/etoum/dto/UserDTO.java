package com.tabeldata.etoum.dto;


import com.tabeldata.etoum.entity.Pengguna;
import com.tabeldata.etoum.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserDTO {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RequestUpdate{

      private Pengguna pengguna;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateRes{

        private String id;
        private String fullname;
        private String phone;

    }


}
