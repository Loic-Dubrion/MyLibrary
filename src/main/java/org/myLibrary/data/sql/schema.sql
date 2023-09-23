-- Création de la table 'author'
CREATE TABLE author (
    id SERIAL PRIMARY KEY,
    lastName TEXT NOT NULL,
    firstName TEXT
);

-- Création de la table 'publisher'
CREATE TABLE publisher (
    id SERIAL PRIMARY KEY,
    "name" TEXT NOT NULL
);

-- Création de la table 'genre'
CREATE TABLE genre (
    id SERIAL PRIMARY KEY,
    "name" TEXT NOT NULL
);

-- Création de la table 'book'
CREATE TABLE book (
    id SERIAL PRIMARY KEY,
    title TEXT NOT NULL,
    id_author INT NOT NULL,
    id_publisher INT NOT NULL,
    id_genre INT NOT NULL,
    annee_publication INT,
    isbn VARCHAR(13),
    FOREIGN KEY (id_author) REFERENCES author(id),
    FOREIGN KEY (id_publisher) REFERENCES publisher(id),
    FOREIGN KEY (id_genre) REFERENCES genre(id)
);

