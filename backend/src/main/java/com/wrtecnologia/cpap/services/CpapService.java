package com.wrtecnologia.cpap.services;

import com.wrtecnologia.cpap.dtos.CpapAverageEventsByMonthDTO;
import com.wrtecnologia.cpap.dtos.CpapEventsDTO;
import com.wrtecnologia.cpap.dtos.CpapPaginationDTO;
import com.wrtecnologia.cpap.repositories.CpapRepository;
import com.wrtecnologia.cpap.entities.Cpap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class CpapService {

    @Autowired
    private CpapRepository repository;

    @Transactional
    public Page<CpapPaginationDTO> findByData(String minDate, String maxDate, Pageable pageable) {

        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);

        Page<Cpap> page = repository.findByData(min, max, pageable);
        return page.map(CpapPaginationDTO::new);
    }

    @Transactional(readOnly=true)
    public List<CpapEventsDTO> eventsByMonth() {
        return repository.eventsByMonth();
    }

    @Transactional(readOnly=true)
    public List<CpapAverageEventsByMonthDTO> averageEventsByMonth() {
        return repository.averageEventsByMonth();
    }

    @Transactional(readOnly=true)
    public List<CpapEventsDTO> eventsByMonthLimit10() {
        return repository.eventsByMonthLimit10();
    }
}
