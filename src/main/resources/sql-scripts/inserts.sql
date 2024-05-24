USE chathub;

INSERT INTO User (firstname, surname, username, password, is_admin)
VALUES ('Erik', 'Weidenauer', 'EriikDaKing', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 0),
       ('admin_firstname', 'admin_surname', 'admin', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',
        1);

INSERT INTO ChatServer (name, description, shorty, password, admin_id)
VALUES ('3BI', 'Klassenchat von der 3BI', 'talking',
        'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '1'),
       ('3AI', 'Klassenchat von der 3AI', 'talking', '', '2'),
       ('3CI', 'Klassenchat von der 3CI', 'talking',
        'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '1'),
       ('SEW-Anfänger', 'Fragen für Java Beginner', 'talking',
        'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '1'),
       ('MEDT-Anfänger', 'Fragen für JavaScript Beginner', 'learning', '', '2'),
       ('SEW-Profi', 'Fragen für Java Profi', 'talking',
        'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '1'),
       ('MEDT-Profi', 'Fragen für JavaScript Profi', 'learning',
        'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '2');

INSERT INTO Chat (message, owner, date, server_id)
VALUES ('Servus Burschen','EriikDaKing','2024-03-28',1);