package ru.eshakin.schoolinfo.model.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceDto implements BaseDto {

    @CsvBindByName(column = "id")
    @CsvBindByPosition(position = 0)
    private Long id;

    @NotNull
    @CsvBindByName(column = "check_id")
    @CsvBindByPosition(position = 1)
    private Long checkId;

    @Min(value = 0, message = "XP amount can not be less than 0")
    @CsvBindByName(column = "xp_amount")
    @CsvBindByPosition(position = 2)
    private Long amount;
}
