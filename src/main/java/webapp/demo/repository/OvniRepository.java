package webapp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webapp.demo.model.Ovni;

import java.util.List;

public interface OvniRepository extends JpaRepository<Ovni, Long> {
    List<Ovni> findByLocalContainingIgnoreCaseOrDescricaoContainingIgnoreCase(String local, String descricao);
}
