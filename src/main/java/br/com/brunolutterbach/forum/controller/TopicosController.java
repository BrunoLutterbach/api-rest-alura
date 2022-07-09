package br.com.brunolutterbach.forum.controller;

import br.com.brunolutterbach.forum.modelo.Curso;
import br.com.brunolutterbach.forum.modelo.Topico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {

    @RequestMapping("/topicos")
    public List<Topico> lista() {
        Topico topico = new Topico("Duvida", "Como funciona o Spring MVC?", new Curso("Spring", "Programação"));

        return Arrays.asList(topico, topico, topico);
    }
}
