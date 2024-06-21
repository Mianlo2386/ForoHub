

CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    autor VARCHAR(255) NOT NULL,
    curso VARCHAR(255) NOT NULL,
    fecha_creacion VARCHAR(255) NOT NULL,
    mensaje VARCHAR(255) NOT NULL,
    respuestas VARCHAR(255),
    status ENUM('ABIERTO', 'CERRADO') NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

