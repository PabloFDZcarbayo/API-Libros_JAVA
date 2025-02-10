package practicas.API_Libros.Reposiitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practicas.API_Libros.Model.Libro;

@Repository
public interface Libro_Repository extends JpaRepository<Libro, Long> {
}
