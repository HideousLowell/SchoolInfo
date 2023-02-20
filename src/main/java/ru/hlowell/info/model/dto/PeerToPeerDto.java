package ru.hlowell.info.model.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import lombok.*;

import java.time.LocalTime;

@Data
public class PeerToPeerDto implements BaseDto {

    @CsvBindByName(column = "id")
    @CsvBindByPosition(position = 0)
    private Long id;

    @CsvBindByName(column = "check_id")
    @CsvBindByPosition(position = 1)
    private Long checkId;

    @CsvBindByName(column = "checking_peer")
    @CsvBindByPosition(position = 2)
    private String checkingPeer;

    @CsvBindByName(column = "state")
    @CsvBindByPosition(position = 3)
    private String status;

    @CsvBindByName(column = "time")
    @CsvBindByPosition(position = 4)
    @CsvDate(value = "HH:mm:ss")
    private LocalTime time;
}
