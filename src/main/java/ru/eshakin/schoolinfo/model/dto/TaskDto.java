package ru.eshakin.schoolinfo.model.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvNumber;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto implements BaseDto {

    @NotBlank
    @CsvBindByName(column = "title")
    @CsvBindByPosition(position = 0)
    private String title;

    @CsvBindByName(column = "parent_task")
    @CsvBindByPosition(position = 1)
    private String parentTask;

    @CsvBindByName(column = "max_xp")
    @CsvBindByPosition(position = 2)
    @CsvNumber("#")
    @NotNull
    @Min(value = 1, message = "maximum xp value should be > 0")
    private Long maxExperience;
}
