USE chathub;

INSERT INTO User (firstname, surname, username, password, is_admin)
VALUES ('Erik', 'Weidenauer', 'EriikDaKing', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 0),
       ('admin_firstname', 'admin_surname', 'admin', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',
        1);

INSERT INTO ChatServer (name, description, shorty, password, admin_id)
VALUES ('Klassenraum - 3BI', 'Klassenchat von der 3BI', 'talking',
        'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '1'),
       ('Klassenraum - 3AI', 'Klassenchat von der 3AI', 'talking', 'e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855', '2'),
       ('Klassenraum - 3CI', 'Klassenchat von der 3CI', 'talking',
        'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '1'),
       ('SEW-Anfänger', 'Fragen für Java Beginner', 'talking',
        'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '1'),
       ('MEDT-Anfänger', 'Fragen für JavaScript Beginner', 'learning', 'e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855', '2'),
       ('SEW-Profi', 'Fragen für Java Profi', 'talking',
        'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '1'),
       ('MEDT-Profi', 'Fragen für JavaScript Profi', 'learning',
        'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '2');

INSERT INTO Chat (message, owner, date, server_id)
VALUES ('Servus Burschen1','EriikDaKing1','2024-03-28',1),
       ('Servus Mädels1','Aleksa1','2024-03-28',1),
       ('Servus Burschen','EriikDaKing2','2024-03-28',2),
       ('Servus Mädels','Aleksa2','2024-03-28',2);