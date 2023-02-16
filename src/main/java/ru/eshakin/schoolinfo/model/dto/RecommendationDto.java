package ru.eshakin.schoolinfo.model.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationDto implements BaseDto {


    @CsvBindByName(column = "id")
    @CsvBindByPosition(position = 0)
    private Long id;

    @NotBlank
    @CsvBindByName(column = "peer")
    @CsvBindByPosition(position = 1)
    private String peer;

    @NotBlank
    @CsvBindByName(column = "recommended_peer")
    @CsvBindByPosition(position = 2)
    private String recommendedPeer;
}