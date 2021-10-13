package com.kuzmin.eliteclub.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClubDTO {
    private final String clubName;
    private short rating;

}
