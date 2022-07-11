package br.com.brunolutterbach.forum.controller;

import br.com.brunolutterbach.forum.controller.dto.TopicoDto;
import br.com.brunolutterbach.forum.repository.TopicoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {

    public final TopicoRepository topicoRepository;

    public TopicosController(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    @RequestMapping("/topicos")
    public List<TopicoDto> lista() {
        return TopicoDto.converter(topicoRepository.findAll());
    }
}
