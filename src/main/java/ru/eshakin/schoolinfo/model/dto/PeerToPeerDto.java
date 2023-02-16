package ru.eshakin.schoolinfo.model.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PeerToPeerDto implements BaseDto {

    @CsvBindByName(column = "id")
    @CsvBindByPosition(position = 0)
    private Long id;

    @NotNull
    @CsvBindByName(column = "check_id")
    @CsvBindByPosition(position = 1)
    private Long checkId;

    @NotBlank
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
