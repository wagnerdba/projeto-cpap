package com.wrtecnologia.cpap.utils;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Component
public class AppHealth implements HealthIndicator {

    protected static final Map<String, Object> map = new HashMap<>();

    public String startedApplication;

    @Override
    public Health health(){
        map.put("ActualDateTimeAppServer...: ", getDataHora());
        return Health.up().withDetails(map).build();
    }

    @PostConstruct
    public void init() {
        startedApplication = getDataHora();
        map.put("StartedSpringApplicationIn: ", startedApplication);
    }

    public void run() {
    }

    private String getDataHora() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE dd/MM/uuuu HH:mm:ss");
        return date.format(formatter);
    }
}
