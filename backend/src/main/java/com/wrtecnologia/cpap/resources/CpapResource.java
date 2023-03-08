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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/cpap")
public class CpapResource {

    @Autowired
    private CpapService service;

    @Autowired
    private AppHealth appHealth;

    private static final long start = System.currentTimeMillis();

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
        return appHealth.startedApplication.substring(4, appHealth.startedApplication.length());
    }

    @GetMapping("/uptime")
    public String uptimeApp() {

        long millis = System.currentTimeMillis() - start;

        String uptime = String.format("%03d days %02d hours %02d minutes %02d seconds", TimeUnit.MILLISECONDS.toDays(millis),
                TimeUnit.MILLISECONDS.toHours(millis) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(millis)),
                TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));

        // LocalDateTime date = LocalDateTime.now().plusDays(4); // ADD DAYS IN DATE
        LocalDateTime date = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE dd/MM/uuuu HH:mm:ss");

        return String.format("%s", uptime);

    }

}
