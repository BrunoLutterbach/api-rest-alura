package br.com.brunolutterbach.forum.controller;

import br.com.brunolutterbach.forum.controller.dto.TopicoDto;
import br.com.brunolutterbach.forum.controller.dto.form.TopicoForm;
import br.com.brunolutterbach.forum.modelo.Topico;
import br.com.brunolutterbach.forum.repository.CursoRepository;
import br.com.brunolutterbach.forum.repository.TopicoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    public final TopicoRepository topicoRepository;
    private final CursoRepository cursoRepository;

    public TopicosController(TopicoRepository topicoRepository, CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.cursoRepository = cursoRepository;
    }

    @GetMapping()
    public List<TopicoDto> lista(String nomeCurso) {
        if (nomeCurso == null) {
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDto.converter(topicos);
        } else {
            List<Topico> topicos = topicoRepository.listarPorNomeDoCurso(nomeCurso);
            return TopicoDto.converter(topicos);
        }
    }

    @PostMapping()
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody TopicoForm form, UriComponentsBuilder uriBuilder) {
        Topico topico = form.converter(cursoRepository);
        topicoRepository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }
}
