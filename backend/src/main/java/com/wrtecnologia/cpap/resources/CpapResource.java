package com.wrtecnologia.cpap.resources;

import com.wrtecnologia.cpap.dtos.CpapAverageEventsByMonthDTO;
import com.wrtecnologia.cpap.dtos.CpapEventsDTO;
import com.wrtecnologia.cpap.dtos.CpapPaginationDTO;
import com.wrtecnologia.cpap.services.CpapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cpap")
public class CpapResource {

    @Autowired
    private CpapService service;

    @GetMapping
    public Page<CpapPaginationDTO> findByData(
            @RequestParam(value="minDate", defaultValue = "") String minDate,
            @RequestParam(value="maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {

        Page<CpapPaginationDTO> page = service.findByData(minDate, maxDate, pageable);

        return ResponseEntity.ok().body(page).getBody();
    }

    @GetMapping(value = "/eventos-mes")
    public ResponseEntity<List<CpapEventsDTO>> eventsByMonth() {
        List<CpapEventsDTO> list = service.eventsByMonth();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/media-eventos-mes")
    public ResponseEntity<List<CpapAverageEventsByMonthDTO>> averageEventsByMonth() {
        List<CpapAverageEventsByMonthDTO> list = service.averageEventsByMonth();
        return ResponseEntity.ok(list);
    }
}
