package com.aluracursos.forohub.topico;

import com.aluracursos.forohub.respuesta.Respuesta;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "topico")
@Table(name = "Topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private Status status;
    private String autor;
    private String curso;
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Respuesta> respuestas;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechaCreacion = datosRegistroTopico.fechaCreacion();
        this.status = datosRegistroTopico.status();
        this.autor = datosRegistroTopico.autor();
        this.curso = datosRegistroTopico.curso();
        this.respuestas = datosRegistroTopico.respuestas() != null
                ? datosRegistroTopico.respuestas().stream()
                .map(r -> new Respuesta(r, this))
                .collect(Collectors.toList())
                : new ArrayList<>();
    }
}