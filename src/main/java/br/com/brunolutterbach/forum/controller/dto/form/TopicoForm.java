package br.com.brunolutterbach.forum.controller.dto.form;

import br.com.brunolutterbach.forum.modelo.Curso;
import br.com.brunolutterbach.forum.modelo.Topico;
import br.com.brunolutterbach.forum.repository.CursoRepository;
import lombok.Data;

@Data
public class TopicoForm {

    private String titulo;
    private String mensagem;
    private String nomeCurso;

    public Topico converter(CursoRepository repository) {
        Curso curso = repository.findByNome(nomeCurso);
        return new Topico(titulo, mensagem, curso);
    }
}
