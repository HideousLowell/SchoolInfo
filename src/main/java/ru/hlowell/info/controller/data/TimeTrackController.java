package ru.hlowell.info.controller.data;

import ru.hlowell.info.controller.GenericController;
import ru.hlowell.info.mapper.TimeTrackMapper;
import ru.hlowell.info.model.dto.TimeTrackDto;
import ru.hlowell.info.model.entity.TimeTrack;
import ru.hlowell.info.service.PeerService;
import ru.hlowell.info.service.TimeTrackService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Getter
@RequestMapping("/timeTrack")
public class TimeTrackController extends GenericController<TimeTrack, TimeTrackDto, Long> {

    private final TimeTrackService service;
    private final TimeTrackMapper mapper;
    private final PeerService peerService;

    @Override
    protected Class<TimeTrackDto> getDtoClass() {
        return TimeTrackDto.class;
    }

    @Override
    protected String getEntityName() {
        return "timeTrack";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("peers", peerService.getAllNicknames());
        return super.update(id, model);
    }

    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("peers", peerService.getAllNicknames());
        return super.create(model);
    }
}
