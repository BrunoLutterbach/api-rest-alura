package br.com.brunolutterbach.forum.config.validacao;


import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;


import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class ErroDeValidacaoHandler {

    private final MessageSource messageSource;

    public ErroDeValidacaoHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    // Intercepta a exception de validacao e retorna um json com os erros
    @ResponseStatus(code = BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDeFormularioDto> handle(MethodArgumentNotValidException exception) {
        List<ErroDeFormularioDto> dto = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroDeFormularioDto erro = new ErroDeFormularioDto(e.getField(), mensagem);
            dto.add(erro);
        });
        return dto;
    }
}
