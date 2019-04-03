package com.dataart.dt.proto.k8s.db.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class DataWriter {

    private final JdbcTemplate tpl;

    public DataWriter(JdbcTemplate tpl) {
        this.tpl = tpl;
    }

    public void writeValue(int value) {
        tpl.update(
                "INSERT INTO data (time_mark, sum) VALUES ( ?,? ) ON CONFLICT (time_mark) DO UPDATE  SET sum = data.sum + EXCLUDED.sum",
                LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES),
                value);
    }

}
