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
public class FriendsDto implements BaseDto {

    @CsvBindByName(column = "id")
    @CsvBindByPosition(position = 0)
    private Long id;

    @NotBlank
    @CsvBindByName(column = "peer1")
    @CsvBindByPosition(position = 1)
    private String firstPeer;

    @NotBlank
    @CsvBindByName(column = "peer2")
    @CsvBindByPosition(position = 2)
    private String secondPeer;
}
