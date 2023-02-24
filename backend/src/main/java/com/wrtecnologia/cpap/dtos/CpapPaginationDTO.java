package com.wrtecnologia.cpap.dtos;

import com.wrtecnologia.cpap.entities.Cpap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CpapPaginationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDate data;
    private LocalTime horas_uso;
    private Integer vedacao;
    private Double eventos_hora;
    private Integer col_ret_masc;
    private Integer pontuacao;

    public CpapPaginationDTO(Cpap entity) {
        id = entity.getId();
        data = entity.getData();
        eventos_hora = entity.getEventos_hora();
        horas_uso = entity.getHoras_uso();
        vedacao = entity.getVedacao();
        col_ret_masc = entity.getCol_ret_masc();
        pontuacao = entity.getPontuacao();
    }
}
