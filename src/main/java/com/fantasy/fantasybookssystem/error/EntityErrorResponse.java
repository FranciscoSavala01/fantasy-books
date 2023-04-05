package com.fantasy.fantasybookssystem.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
