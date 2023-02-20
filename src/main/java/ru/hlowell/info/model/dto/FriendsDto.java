package ru.hlowell.info.model.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

@Data
public class FriendsDto implements BaseDto {

    @CsvBindByName(column = "id")
    @CsvBindByPosition(position = 0)
    private Long id;

    @CsvBindByName(column = "peer1")
    @CsvBindByPosition(position = 1)
    private String firstPeer;

    @CsvBindByName(column = "peer2")
    @CsvBindByPosition(position = 2)
    private String secondPeer;
}
