package br.com.brunolutterbach.forum.repository;

import br.com.brunolutterbach.forum.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    Curso findByNome(String nomeCurso);
}

