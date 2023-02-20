package ru.hlowell.info.controller.data;

import ru.hlowell.info.controller.GenericController;
import ru.hlowell.info.mapper.VerterMapper;
import ru.hlowell.info.model.dto.VerterDto;
import ru.hlowell.info.model.entity.Verter;
import ru.hlowell.info.service.CheckService;
import ru.hlowell.info.service.VerterService;
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
@RequestMapping("/verter")
public class VerterController extends GenericController<Verter, VerterDto, Long> {

    private final VerterService service;
    private final VerterMapper mapper;
    private final CheckService checkService;

    @Override
    protected Class<VerterDto> getDtoClass() {
        return VerterDto.class;
    }

    @Override
    protected String getEntityName() {
        return "verter";
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
