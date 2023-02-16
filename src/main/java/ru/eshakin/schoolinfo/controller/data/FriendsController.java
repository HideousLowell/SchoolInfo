package ru.eshakin.schoolinfo.controller.data;

import ru.eshakin.schoolinfo.controller.GenericController;
import ru.eshakin.schoolinfo.mapper.FriendsMapper;
import ru.eshakin.schoolinfo.model.dto.FriendsDto;
import ru.eshakin.schoolinfo.model.entity.Friends;
import ru.eshakin.schoolinfo.service.FriendsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/friends")
public class FriendsController extends GenericController<Friends, FriendsDto, Long> {

    public FriendsController(FriendsService service, FriendsMapper mapper) {
        super(service, mapper);
    }

    @Override
    protected Class<FriendsDto> getDtoClass() {
        return FriendsDto.class;
    }

    @Override
    protected String getEntityName() {
        return "friends";
    }
}