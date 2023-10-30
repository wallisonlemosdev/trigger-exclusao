package com.wallisonlemos.demotriggerexclusao.apis;

import com.wallisonlemos.demotriggerexclusao.entities.Comentario;
import com.wallisonlemos.demotriggerexclusao.repositories.ComentarioRepository;
import com.wallisonlemos.demotriggerexclusao.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comentarios")
@RequiredArgsConstructor
public class ComentarioController {

    private final ComentarioRepository repository;
    private final PostRepository postRepository;

    @PostMapping()
    public ResponseEntity<Void> criarComentario(@RequestParam("id") Integer postId, @RequestParam("texto") String texto) {
        Comentario comentario = new Comentario();
        comentario.setTexto(texto);
        comentario.setPost(postRepository.getReferenceById(postId));
        repository.save(comentario);
        return ResponseEntity.ok().build();
    }
}
