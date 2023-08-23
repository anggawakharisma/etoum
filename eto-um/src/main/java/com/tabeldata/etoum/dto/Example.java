package com.tabeldata.etoum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Example {
    private Integer id;
    private String name;
    private String createdaAt;
    private String updatedAt;
}
