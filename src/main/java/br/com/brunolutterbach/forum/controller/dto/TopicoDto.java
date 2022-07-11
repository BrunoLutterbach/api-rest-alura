package br.com.brunolutterbach.forum.controller.dto;

import br.com.brunolutterbach.forum.modelo.Curso;
import br.com.brunolutterbach.forum.modelo.Topico;
import lombok.Data;
import org.springframework.beans.MutablePropertyValues;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class TopicoDto {

    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeCurso;


    public TopicoDto(Topico topico) {
        this.id = topico.getId();
        this.nomeCurso = topico.getCurso().getNome();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
    }

    // Converte uma lista de topicos para uma lista de topicosDto
    public static List<TopicoDto> converter(List<Topico> topicos) {
        return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
    }
}
