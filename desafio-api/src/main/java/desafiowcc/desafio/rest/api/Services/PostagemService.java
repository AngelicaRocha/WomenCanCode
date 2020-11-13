package desafiowcc.desafio.rest.api.Services;


import desafiowcc.desafio.rest.api.models.Postagem;
import desafiowcc.desafio.rest.api.repositories.PostagensRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostagemService {

    @Autowired
    private PostagensRepository postagemRepository;

    public Postagem searchPost(Integer id){
        Optional<Postagem> postObj = postagemRepository.findById(id);
        return postObj.orElse(null);
    }

    public List<Postagem> searchAllPosts(){
        List<Postagem> listaPostagens = postagemRepository.findAll();
        return listaPostagens;
    }

    public Postagem newPost(Postagem postagem){
        Postagem insertedPost = postagemRepository.save(postagem);
        return insertedPost;
    }

    public String newManyPosts(List<Postagem> listaPostagens){

        String idPosts = "";
        for (Postagem post:listaPostagens) {
            Postagem insertedPost = postagemRepository.save(post);
            idPosts.concat(" "+post.getId());
        }
        return "Posts " + idPosts + "incluídos";
    }

    public String deletePost(Integer id){
        try {
            postagemRepository.deleteById(id);
            return "O post " + id + " foi excluído";
        } catch (Exception ex) {
            return "Aconteceu um erro ao excluir o post: " + ex.getMessage();
        }
    }

    public Postagem updatePost(Integer id, Postagem updatedPost){
        Optional<Postagem> postObj = postagemRepository.findById(id).map(
                postagem -> {
                    postagem.setTitle(updatedPost.getTitle());
                    postagem.setContent(updatedPost.getContent());
                    postagem.setAuthor(updatedPost.getAuthor());
                    Postagem newPost = postagemRepository.save(postagem);
                    return newPost;
                });
        return postObj.orElse(null);
    }

}
