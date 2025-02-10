package practicas.API_Libros.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import practicas.API_Libros.Model.Libro;
import practicas.API_Libros.Service.Libro_Service;
import java.util.List;

@Controller
@RequestMapping("api/v1/libros")
public class Libro_Controller {

    private final Libro_Service libro_service;

    @Autowired
    public Libro_Controller(Libro_Service libro_service) {
        this.libro_service = libro_service;
    }


    //RequestBody es el encargado de transformar los datos a un objeto java
    @PostMapping
    public ResponseEntity<Libro> save(@RequestBody Libro libro) {
        Libro newLibro = libro_service.saveLibro(libro);
        return ResponseEntity.ok(newLibro);
    }

    //@PathVariable indica que el id es una variable que se aplicara en la URL
    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibro(@PathVariable("id") Long id) {
        Libro libro = libro_service.getLibro(id);
        return ResponseEntity.ok(libro);
    }

    @GetMapping
    public ResponseEntity<List<Libro>> getLibros() {
        List<Libro> libros = libro_service.getLibros();
        return ResponseEntity.ok(libros);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable("id") Long id) {
        libro_service.deleteLibro(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable ("id") Long id, @RequestBody Libro libro) {
        Libro updatedLibro = libro_service.updateLibro(id ,libro);
        return ResponseEntity.ok(updatedLibro);
    }
}
