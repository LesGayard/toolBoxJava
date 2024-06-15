package com.example.toolbox.dto;

import java.util.Date;

public record ContactDTO(

        long id,
        Date date,
        String firstname,
        String name,
        String phone
) {
}
