DELETE FROM books;
DELETE FROM authors;

INSERT INTO authors (id, name, last_name, second_name) VALUES (1, 'AuthorName', 'AuthorLastName', 'AuthorSecondName');

INSERT INTO books (id, name, genre, description, author_id) VALUES (1, 'Test Book', 'Genre', 'Description', 1);
