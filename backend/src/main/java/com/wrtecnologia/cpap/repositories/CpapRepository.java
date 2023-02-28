package com.wrtecnologia.cpap.repositories;

import com.wrtecnologia.cpap.dtos.CpapAverageEventsByMonthDTO;
import com.wrtecnologia.cpap.dtos.CpapEventsDTO;
import com.wrtecnologia.cpap.entities.Cpap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CpapRepository extends JpaRepository<Cpap, Long> {

    // Consulta paginada (GERAL)
    @Query("SELECT obj FROM Cpap obj WHERE obj.data BETWEEN :min AND :max ORDER BY obj.id DESC")
    Page<Cpap> findByData(LocalDate min, LocalDate max, Pageable pageable);

    // Consulta sem paginacao (GERAL)
    @Query("SELECT new com.wrtecnologia.cpap.dtos.CpapEventsDTO(obj.id, TO_CHAR(obj.data,'DD/MM/YYYY'), obj.eventos_hora) "
            + " FROM Cpap AS obj ORDER BY obj.data")  //JPQL WHERE obj.id >= 37 // WHERE EXTRACT(MONTH FROM obj.data) = 2 //
    List<CpapEventsDTO> eventsByMonth();

    // Consulta da média de ventos por mês
    @Query("SELECT new com.wrtecnologia.cpap.dtos.CpapAverageEventsByMonthDTO(" +

            "CASE WHEN TO_CHAR(EXTRACT(MONTH FROM obj.data), 'fm00') = '01' THEN 'Janeiro'" +
                 "WHEN TO_CHAR(EXTRACT(MONTH FROM obj.data), 'fm00') = '02' THEN 'Fevereiro'" +
                 "WHEN TO_CHAR(EXTRACT(MONTH FROM obj.data), 'fm00') = '03' THEN 'Março'" +
                 "WHEN TO_CHAR(EXTRACT(MONTH FROM obj.data), 'fm00') = '04' THEN 'Abril'" +
                 "WHEN TO_CHAR(EXTRACT(MONTH FROM obj.data), 'fm00') = '05' THEN 'Maio'" +
                 "WHEN TO_CHAR(EXTRACT(MONTH FROM obj.data), 'fm00') = '06' THEN 'Junho'" +
                 "WHEN TO_CHAR(EXTRACT(MONTH FROM obj.data), 'fm00') = '07' THEN 'Julho'" +
                 "WHEN TO_CHAR(EXTRACT(MONTH FROM obj.data), 'fm00') = '08' THEN 'Agosto'" +
                 "WHEN TO_CHAR(EXTRACT(MONTH FROM obj.data), 'fm00') = '09' THEN 'Setembro'" +
                 "WHEN TO_CHAR(EXTRACT(MONTH FROM obj.data), 'fm00') = '10' THEN 'Outubro'" +
                 "WHEN TO_CHAR(EXTRACT(MONTH FROM obj.data), 'fm00') = '11' THEN 'Novembro'" +
            "ELSE 'Dezembro' END," +

            " SUM(obj.eventos_hora) / COUNT(obj.id))"
            + " FROM Cpap AS obj GROUP BY EXTRACT(MONTH FROM obj.data) ORDER BY EXTRACT(MONTH FROM obj.data)")
    List<CpapAverageEventsByMonthDTO> averageEventsByMonth();

    // Consulta as últimas 10 marcações
    @Query("SELECT new com.wrtecnologia.cpap.dtos.CpapEventsDTO(obj.id, TO_CHAR(obj.data,'DD/MM/YYYY'), obj.eventos_hora) "
            + " FROM Cpap AS obj WHERE obj.id > (SELECT MAX(obj.id) - 10 FROM obj) ORDER BY obj.data")  //JPQL WHERE obj.id >= 37 // WHERE EXTRACT(MONTH FROM obj.data) = 2 //
    List<CpapEventsDTO> eventsByMonthLimit10();


}

