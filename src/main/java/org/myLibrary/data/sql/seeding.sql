-- Seed authors table
INSERT INTO author ("lastname") VALUES
('author One'),
('author Two'),
('author Three'),
('author Four'),
('author Five');

-- Seed publishers table
INSERT INTO publisher ("name") VALUES
('publisher One'),
('publisher Two');

-- Seed genre table
INSERT INTO genre ("name") VALUES
('Genre One'),
('Genre Two'),
('Genre Three');

-- Seed book table
INSERT INTO book (title, id_author, id_publisher, id_genre) VALUES
('book title 1', 1, 1, 1),
('book title 2', 2, 1, 2),
('book title 3', 3, 1, 3),
('book title 4', 4, 1, 1),
('book title 5', 5, 1, 2),
('book title 6', 1, 2, 3),
('book title 7', 2, 2, 1),
('book title 8', 3, 2, 2),
('book title 9', 4, 2, 3),
('book title 10', 5, 2, 1),
('book title 11', 1, 1, 2),
('book title 12', 2, 1, 3),
('book title 13', 3, 1, 1),
('book title 14', 4, 1, 2),
('book title 15', 5, 1, 3),
('book title 16', 1, 2, 1),
('book title 17', 2, 2, 2),
('book title 18', 3, 2, 3),
('book title 19', 4, 2, 1),
('book title 20', 5, 2, 2);

