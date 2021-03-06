package br.com.brunolutterbach.forum.controller.dto;

import br.com.brunolutterbach.forum.modelo.StatusTopico;
import br.com.brunolutterbach.forum.modelo.Topico;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class DetalhesDoTopicoDto {

    private Long id;
    private String nomeCurso;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;
    private StatusTopico status;
    private List<RespostaDto> respostas;

    public DetalhesDoTopicoDto(Topico topico) {
        this.id = topico.getId();
        this.nomeCurso = topico.getCurso().getNome();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        this.nomeAutor = topico.getAutor().getNome();
        this.status = topico.getStatus();
        this.respostas = new ArrayList<>();
        this.respostas.addAll(topico.getRespostas().stream().map(RespostaDto::new).collect(ArrayList::new, ArrayList::add, ArrayList::addAll));
    }
}