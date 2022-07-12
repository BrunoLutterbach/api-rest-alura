package br.com.brunolutterbach.forum.config.validacao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErroDeFormularioDto {

    private String campo;
    private String erro;

}
