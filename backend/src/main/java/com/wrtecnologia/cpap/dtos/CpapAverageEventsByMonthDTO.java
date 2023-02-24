package com.wrtecnologia.cpap.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CpapAverageEventsByMonthDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String data;
    private Double eventos_hora;

}
