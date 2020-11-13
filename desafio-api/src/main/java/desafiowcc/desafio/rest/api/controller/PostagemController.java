package desafiowcc.desafio.rest.api.controller;


import desafiowcc.desafio.rest.api.Services.PostagemService;
import desafiowcc.desafio.rest.api.models.Postagem;
import desafiowcc.desafio.rest.api.repositories.PostagensRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/postagens")
@Api(value="API REST para gerenciamento de conteúdo em blogs")
@CrossOrigin(origins="*")
public class PostagemController {

    @Autowired
    private PostagemService postagemService;

    @GetMapping(value="/{id}")
    @ApiOperation(value = "Exibe uma postagem específico de acordo com o id informado")
    public ResponseEntity<?> findPost(@PathVariable Integer id) {

        Postagem postObj = postagemService.searchPost(id);
        return ResponseEntity.ok().body(postObj);
    }

    @GetMapping(value="/all")
    @ApiOperation(value = "Exibe todas as postagens existentes na base de dados")
    public ResponseEntity<List<Postagem>> getAllPosts() {

        List<Postagem> allPosts = postagemService.searchAllPosts();
        return ResponseEntity.ok().body(allPosts);
    }

    @PostMapping(value="/newPosts")
    @ApiOperation(value = "Cria e insere diversas postagens na base de dados com uma única requisição")
    public ResponseEntity<String> addNewPosts(@RequestBody List<Postagem> postagens){

        String insertedPost = postagemService.newManyPosts(postagens);
        return ResponseEntity.ok().body(insertedPost);
    }

    @PostMapping(value="/new")
    @ApiOperation(value = "Cria e insere na base de dados uma única nova postagem")
    public ResponseEntity<Postagem> addNewPost(@RequestBody Postagem postagem){

        Postagem insertedPost = postagemService.newPost(postagem);
        return ResponseEntity.ok().body(insertedPost);
    }

    @DeleteMapping(value="/delete/{id}")
    @ApiOperation(value = "Exclui a postagem indicado de acordo com seu id")
    public ResponseEntity<String> deletePost(@PathVariable Integer id) {
        return ResponseEntity.ok().body(postagemService.deletePost(id));
    }

    @PutMapping(value="/update/{id}")
    @ApiOperation(value = "Altera o título, o autor e o conteúdo de uma postagem")
    public ResponseEntity<Postagem> updatePost(@PathVariable Integer id, @RequestBody Postagem updatedPost){
        Postagem postObj = postagemService.updatePost(id, updatedPost);
        return ResponseEntity.ok().body(postObj);
    }











}
