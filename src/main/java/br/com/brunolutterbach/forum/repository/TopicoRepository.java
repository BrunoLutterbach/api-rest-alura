package br.com.brunolutterbach.forum.repository;

import br.com.brunolutterbach.forum.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

}

