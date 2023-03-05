package com.wrtecnologia.cpap.resources;

import com.wrtecnologia.cpap.dtos.CpapAverageEventsByMonthDTO;
import com.wrtecnologia.cpap.dtos.CpapEventsDTO;
import com.wrtecnologia.cpap.dtos.CpapPaginationDTO;
import com.wrtecnologia.cpap.services.CpapService;
import com.wrtecnologia.cpap.utils.AppHealth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cpap")
public class CpapResource {

    @Autowired
    private CpapService service;

    @Autowired
    private AppHealth appHealth;

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

    @GetMapping(value = "/eventos-mes-limit")
    public ResponseEntity<List<CpapEventsDTO>> eventsByMonthLimit10() {
        List<CpapEventsDTO> list = service.eventsByMonthLimit10();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/start", produces="text/plain")
    @ResponseBody
    public String startedApplication() {
        return appHealth.startedApplication.toString();
    }

}
