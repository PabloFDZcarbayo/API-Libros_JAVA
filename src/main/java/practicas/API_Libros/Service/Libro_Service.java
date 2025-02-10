package practicas.API_Libros.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practicas.API_Libros.Model.Libro;
import practicas.API_Libros.Reposiitory.Libro_Repository;

import java.util.List;

@Service
public class Libro_Service {

    @Autowired
    Libro_Repository libro_Repository;

    public Libro saveLibro(Libro libro) {
        return libro_Repository.save(libro);
    }

    public Libro getLibro(Long id) {
        return libro_Repository.findById(id).get();
    }

    public List<Libro> getLibros() {
        return libro_Repository.findAll();
    }

    public void deleteLibro(Long id) {
        libro_Repository.deleteById(id);
    }


    //Se la pasa por parametro el objeto a actualizar y el id
    public Libro updateLibro(Long id, Libro libro) {
        try {
            //Comprueba si el libro existe
            Libro LibroToUpdate = libro_Repository.findById(id).get();
            if (LibroToUpdate != null) {
                //Actualiza los datos
                LibroToUpdate.setTitulo(libro.getTitulo());
                LibroToUpdate.setAutor(libro.getAutor());
                LibroToUpdate.setAnho(libro.getAnho());
                LibroToUpdate.setGenero(libro.getGenero());

                //Guarda los cambios
                return libro_Repository.save(LibroToUpdate);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

}



