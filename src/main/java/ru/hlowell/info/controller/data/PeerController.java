package ru.hlowell.info.controller.data;

import ru.hlowell.info.controller.GenericController;
import ru.hlowell.info.mapper.PeerMapper;
import ru.hlowell.info.model.dto.PeerDto;
import ru.hlowell.info.model.entity.Peer;
import ru.hlowell.info.service.PeerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Getter
@RequestMapping("/peer")
public class PeerController extends GenericController<Peer, PeerDto, String> {

    private final PeerService service;
    private final PeerMapper mapper;

    @Override
    protected Class<PeerDto> getDtoClass() {
        return PeerDto.class;
    }

    @Override
    protected String getEntityName() {
        return "peer";
    }

}
