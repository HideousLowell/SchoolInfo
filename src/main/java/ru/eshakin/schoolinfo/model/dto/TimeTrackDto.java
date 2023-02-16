package ru.eshakin.schoolinfo.model.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TimeTrackDto implements BaseDto {

    @CsvBindByName(column = "id")
    @CsvBindByPosition(position = 0)
    private Long id;

    @NotBlank
    @CsvBindByName(column = "peer")
    @CsvBindByPosition(position = 1)
    private String peer;

    @CsvBindByName(column = "date")
    @CsvBindByPosition(position = 2)
    @CsvDate(value = "yyyy-MM-dd")
    private LocalDate date;

    @CsvBindByName(column = "time")
    @CsvBindByPosition(position = 3)
    @CsvDate(value = "HH:mm:ss")
    private LocalTime time;

    @CsvBindByName(column = "state")
    @CsvBindByPosition(position = 4)
    private Integer state;
}

