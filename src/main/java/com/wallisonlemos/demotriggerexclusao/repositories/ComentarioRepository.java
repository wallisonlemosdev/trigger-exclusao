package com.wallisonlemos.demotriggerexclusao.repositories;

import com.wallisonlemos.demotriggerexclusao.entities.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
}
