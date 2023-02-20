package ru.hlowell.info.controller.data;

import ru.hlowell.info.controller.GenericController;
import ru.hlowell.info.mapper.CheckMapper;
import ru.hlowell.info.model.dto.CheckDto;
import ru.hlowell.info.model.entity.Check;
import ru.hlowell.info.service.CheckService;
import ru.hlowell.info.service.PeerService;
import ru.hlowell.info.service.TaskService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Getter
@RequestMapping("/checks")
@RequiredArgsConstructor
public class CheckController extends GenericController<Check, CheckDto, Long> {

    private final CheckService service;
    private final CheckMapper mapper;
    private final PeerService peerService;
    private final TaskService taskService;

    @Override
    protected Class<CheckDto> getDtoClass() {
        return CheckDto.class;
    }

    @Override
    protected String getEntityName() {
        return "checks";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("peers", peerService.getAllNicknames());
        model.addAttribute("tasks", taskService.getAllTitles());
        return super.update(id, model);
    }

    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("peers", peerService.getAllNicknames());
        model.addAttribute("tasks", taskService.getAllTitles());
        return super.create(model);
    }
}