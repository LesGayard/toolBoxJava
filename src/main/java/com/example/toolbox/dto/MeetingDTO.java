package com.example.toolbox.dto;

import java.util.Date;

public record MeetingDTO(
        Long id,
        Date date,
        String title,
        ContactDTO contactDTO
) {
}
