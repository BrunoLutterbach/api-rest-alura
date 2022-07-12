package br.com.brunolutterbach.forum.controller.dto;

import br.com.brunolutterbach.forum.modelo.Resposta;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RespostaDto {

    private Long id;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;

    public RespostaDto (Resposta resposta) {
        this.id = resposta.getId();
        this.mensagem = resposta.getMensagem();
        this.dataCriacao = resposta.getDataCriacao();
        this.nomeAutor = resposta.getAutor().getNome();
    }
}
