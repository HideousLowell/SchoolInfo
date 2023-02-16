package ru.eshakin.schoolinfo.controller;

import ru.eshakin.schoolinfo.mapper.GenericMapper;
import ru.eshakin.schoolinfo.model.BaseModel;
import ru.eshakin.schoolinfo.model.dto.BaseDto;
import ru.eshakin.schoolinfo.service.GenericService;
import ru.eshakin.schoolinfo.util.FileConverter;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

/**
 * @param <M> extends BaseModel
 * @param <D> extends BaseDto
 * @param <K> Primary key type (String/Long etc.)
 */
@Controller
@RequiredArgsConstructor
public abstract class GenericController<M extends BaseModel, D extends BaseDto, K> {

    private final GenericService<M, K> service;
    private final GenericMapper<M, D> mapper;

    protected abstract Class<D> getDtoClass();

    protected abstract String getEntityName();

    @GetMapping("")
    public String getAll(Model model) {
        List<M> models = service.getAll();
        List<D> dtos = mapper.toDtos(models);
        model.addAttribute(getEntityName(), dtos);
        return getEntityName() + "/viewAll";
    }

    @GetMapping("/add")
    public String create() {
        return getEntityName() + "/add";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("modelForm") @Valid D dto) {
        service.create(mapper.toEntity(dto));
        return "redirect:/" + getEntityName();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable K id) {
        service.delete(id);
        return "redirect:/" + getEntityName();
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable K id, Model model) {
        Optional<M> entity = service.getOne(id);
        entity.ifPresent(e -> model.addAttribute(getEntityName(), mapper.toDto(e)));
        return getEntityName() + "/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("modelForm") @Valid D dto) {
        service.update(mapper.toEntity(dto));
        return "redirect:/" + getEntityName();
    }

    @PostMapping(value = "/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        List<D> dtos = FileConverter.convertCsvToList(file, getDtoClass());
        service.saveAll(mapper.toEntities(dtos));
        return "redirect:/" + getEntityName();
    }

    @SneakyThrows
    @RequestMapping(path = "/unload")
    public void handleFileUnload(HttpServletResponse servletResponse) {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition", "attachment; filename=\"%s.csv\"".formatted(getEntityName()));
        FileConverter.writeCsvFromBean(servletResponse.getWriter(), mapper.toDtos(service.getAll()), getDtoClass());
    }

}
