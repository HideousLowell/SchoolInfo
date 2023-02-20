package ru.hlowell.info.model.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvNumber;
import lombok.*;

@Data
public class TaskDto implements BaseDto {

    @CsvBindByName(column = "title")
    @CsvBindByPosition(position = 0)
    private String title;

    @CsvBindByName(column = "parent_task")
    @CsvBindByPosition(position = 1)
    private String parentTask;

    @CsvBindByName(column = "max_xp")
    @CsvBindByPosition(position = 2)
    @CsvNumber("#")
    private Long maxExperience;
}
