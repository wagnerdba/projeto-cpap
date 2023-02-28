package com.wrtecnologia.cpap.repositories;

import com.wrtecnologia.cpap.dtos.CpapAverageEventsByMonthDTO;
import com.wrtecnologia.cpap.dtos.CpapEventsDTO;
import com.wrtecnologia.cpap.entities.Cpap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface CpapRepository extends JpaRepository<Cpap, Long> {

    @Query("SELECT obj FROM Cpap obj WHERE obj.data BETWEEN :min AND :max ORDER BY obj.id DESC")
    // Page<Log> findByData(@Param("min") LocalDate min, @Param("max") LocalDate max, Pageable pageable);
    Page<Cpap> findByData(LocalDate min, LocalDate max, Pageable pageable);

    @Query("SELECT new com.wrtecnologia.cpap.dtos.CpapEventsDTO(obj.id, TO_CHAR(obj.data,'DD/MM/YYYY'), obj.eventos_hora) "
            + " FROM Cpap AS obj ORDER BY obj.data")  //JPQL WHERE obj.id >= 37 // WHERE EXTRACT(MONTH FROM obj.data) = 2 //
    List<CpapEventsDTO> eventsByMonth();

    // TODO: CONSULTA A SER CONSTRUIDA (MEDIA DE EVENTOS POR MÊS)

    @Query("SELECT new com.wrtecnologia.cpap.dtos.CpapAverageEventsByMonthDTO(TO_CHAR(EXTRACT(MONTH FROM obj.data), 'fm00'), SUM(obj.eventos_hora) / COUNT(obj.id))"
            + " FROM Cpap AS obj GROUP BY EXTRACT(MONTH FROM obj.data) ORDER BY EXTRACT(MONTH FROM obj.data)")
    List<CpapAverageEventsByMonthDTO> averageEventsByMonth();

    @Query("SELECT new com.wrtecnologia.cpap.dtos.CpapEventsDTO(obj.id, TO_CHAR(obj.data,'DD/MM/YYYY'), obj.eventos_hora) "
            + " FROM Cpap AS obj WHERE obj.id > (SELECT MAX(obj.id) - 10 FROM obj) ORDER BY obj.data")  //JPQL WHERE obj.id >= 37 // WHERE EXTRACT(MONTH FROM obj.data) = 2 //
    List<CpapEventsDTO> eventsByMonthLimit10();


}

