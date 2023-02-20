package ru.hlowell.info.controller.data;

import ru.hlowell.info.controller.GenericController;
import ru.hlowell.info.mapper.ExperienceMapper;
import ru.hlowell.info.model.dto.ExperienceDto;
import ru.hlowell.info.model.entity.Experience;
import ru.hlowell.info.service.CheckService;
import ru.hlowell.info.service.ExperienceService;
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
@RequestMapping("/experience")
public class ExperienceController extends GenericController<Experience, ExperienceDto, Long> {

    private final ExperienceService service;
    private final ExperienceMapper mapper;
    private final CheckService checkService;

    @Override
    protected Class<ExperienceDto> getDtoClass() {
        return ExperienceDto.class;
    }

    @Override
    protected String getEntityName() {
        return "experience";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("checkIds", checkService.getAllIds());
        return super.update(id, model);
    }

    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("checkIds", checkService.getAllIds());
        return super.create(model);
    }
}