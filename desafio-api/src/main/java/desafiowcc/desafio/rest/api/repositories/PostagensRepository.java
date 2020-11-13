package desafiowcc.desafio.rest.api.repositories;

import desafiowcc.desafio.rest.api.models.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagensRepository extends JpaRepository<Postagem, Integer> {

}
