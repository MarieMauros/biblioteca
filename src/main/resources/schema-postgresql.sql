CREATE TABLE IF NOT EXISTS livro (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    sinopse VARCHAR(200) NOT NULL,
    autor VARCHAR(50) NOT NULL,
    editora VARCHAR(50),
    ano VARCHAR(4) NOT NULL  -- Alteração para VARCHAR ao invés de INT
);