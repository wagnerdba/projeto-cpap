package com.wrtecnologia.cpap.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
//@Table(name = "tb_info_cpap", schema="cpap") //POSTGRES
@Table(name = "tb_info_cpap") //H2
public class Cpap implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private LocalTime horas_uso;
    private Integer vedacao;
    private Double eventos_hora;
    private Integer col_ret_masc;
    private Integer pontuacao;

    public Cpap() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHoras_uso() {
        return horas_uso;
    }

    public void setHoras_uso(LocalTime horas_uso) {
        this.horas_uso = horas_uso;
    }

    public Integer getVedacao() {
        return vedacao;
    }

    public void setVedacao(Integer vedacao) {
        this.vedacao = vedacao;
    }

    public Double getEventos_hora() {
        return eventos_hora;
    }

    public void setEventos_hora(Double eventos_hora) {
        this.eventos_hora = eventos_hora;
    }

    public Integer getCol_ret_masc() {
        return col_ret_masc;
    }

    public void setCol_ret_masc(Integer col_ret_masc) {
        this.col_ret_masc = col_ret_masc;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }
}

