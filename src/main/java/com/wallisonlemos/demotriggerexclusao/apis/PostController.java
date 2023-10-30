package com.wallisonlemos.demotriggerexclusao.apis;

import com.wallisonlemos.demotriggerexclusao.entities.Post;
import com.wallisonlemos.demotriggerexclusao.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostRepository repository;

    @PostMapping()
    public ResponseEntity<Void> criarPost(@RequestParam ("texto") String texto) {
        Post post = new Post();
        post.setTexto(texto);
        repository.save(post);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    public ResponseEntity<Void> deletarPost(@RequestParam ("id") Integer id ) {
        repository.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
