package ru.eshakin.schoolinfo.model.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CheckDto implements BaseDto {

    @CsvBindByName(column = "id")
    @CsvBindByPosition(position = 0)
    private Long id;

    @NotBlank
    @CsvBindByName(column = "peer")
    @CsvBindByPosition(position = 1)
    private String peer;

    @NotBlank
    @CsvBindByName(column = "task")
    @CsvBindByPosition(position = 2)
    private String task;

    @CsvDate(value = "yyyy-MM-dd")
    @CsvBindByName(column = "date")
    @CsvBindByPosition(position = 3)
    private LocalDate date;
}
