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
public class PeerDto implements BaseDto {

    @NotBlank
    @CsvBindByName(column = "nickname")
    @CsvBindByPosition(position = 0)
    private String nickname;

    @CsvDate(value = "yyyy-MM-dd")
    @CsvBindByName(column = "birthday")
    @CsvBindByPosition(position = 1)
    private LocalDate birthday;
}
