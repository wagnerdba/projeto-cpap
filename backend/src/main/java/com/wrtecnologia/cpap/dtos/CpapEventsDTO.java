package com.wrtecnologia.cpap.dtos;

import com.wrtecnologia.cpap.entities.Cpap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CpapEventsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String data;
    private Double eventos_hora;
}
