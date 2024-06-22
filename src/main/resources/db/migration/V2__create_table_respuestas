CREATE TABLE respuestas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensaje VARCHAR(255) NOT NULL,
    fechaCreacion DATETIME NOT NULL,
    autor VARCHAR(255) NOT NULL,
    topico_id BIGINT NOT NULL,
    FOREIGN KEY (topico_id) REFERENCES Topicos(id)
);