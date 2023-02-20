package ru.hlowell.info.controller.data;

import ru.hlowell.info.controller.GenericController;
import ru.hlowell.info.mapper.TransferredPointsMapper;
import ru.hlowell.info.model.dto.TransferredPointsDto;
import ru.hlowell.info.model.entity.TransferredPoints;
import ru.hlowell.info.service.PeerService;
import ru.hlowell.info.service.TransferredPointsService;
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
@RequestMapping("/transferredPoints")
public class TransferredPointsController extends GenericController<TransferredPoints, TransferredPointsDto, Long> {

    private final TransferredPointsService service;
    private final TransferredPointsMapper mapper;
    private final PeerService peerService;

    @Override
    protected Class<TransferredPointsDto> getDtoClass() {
        return TransferredPointsDto.class;
    }

    @Override
    protected String getEntityName() {
        return "transferredPoints";
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
