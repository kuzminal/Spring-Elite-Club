package com.kuzmin.eliteclub.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubDTO {
    private String clubName;
    private short rating;

}
