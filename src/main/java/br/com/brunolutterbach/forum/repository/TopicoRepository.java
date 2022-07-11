package br.com.brunolutterbach.forum.repository;

import br.com.brunolutterbach.forum.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    @Query("SELECT t FROM Topico t WHERE t.curso.nome LIKE %:nomeCurso%")
    List<Topico> listarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso);

}

