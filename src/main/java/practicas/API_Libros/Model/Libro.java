package practicas.API_Libros.Model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;
    private String autor;
    private int anho;
    private String genero;
}
