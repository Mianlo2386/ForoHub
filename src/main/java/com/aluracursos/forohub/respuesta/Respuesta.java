package com.aluracursos.forohub.respuesta;

import com.aluracursos.forohub.topico.Topico;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "respuesta")
@Table(name = "Respuestas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    private String autor;
    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;

    public Respuesta(DatosRegistroRespuesta datosRegistroRespuesta, Topico topico) {
        this.mensaje = datosRegistroRespuesta.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.autor = datosRegistroRespuesta.autor();
        this.topico = topico;
    }
}
