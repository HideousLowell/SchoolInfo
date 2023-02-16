package ru.eshakin.schoolinfo.model.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransferredPointsDto implements BaseDto {

    @CsvBindByName(column = "id")
    @CsvBindByPosition(position = 0)
    private Long id;

    @NotBlank
    @CsvBindByName(column = "checking_peer")
    @CsvBindByPosition(position = 1)
    private String checkingPeer;

    @NotBlank
    @CsvBindByName(column = "checked_peer")
    @CsvBindByPosition(position = 2)
    private String checkedPeer;

    @NotNull
    @CsvBindByName(column = "points_amount")
    @CsvBindByPosition(position = 3)
    private Long amount;
}
