CREATE TABLE IF NOT EXISTS menu(id INT PRIMARY KEY AUTO_INCREMENT,
    titre VARCHAR(100) NOT NULL,
    description VARCHAR(100) NOT NULL,
    image_url VARCHAR(200),
    score INT,
    position VARCHAR(100),
    created_date VARCHAR(100));

CREATE TABLE IF NOT EXISTS diner(id INT PRIMARY KEY AUTO_INCREMENT,
            titre VARCHAR(100) NOT NULL,
            description VARCHAR(200) NOT NULL,
            image_url VARCHAR(200) NOT NULL,
            score INT NOT NULL,
            position VARCHAR(100) NOT NULL,
            created_date VARCHAR(100) NOT NULL);

CREATE TABLE IF NOT EXISTS commentaire(id INT PRIMARY KEY AUTO_INCREMENT,
                        menu_id INT,
                        commentaire VARCHAR(500),
                        created_date VARCHAR(100),
                        FOREIGN KEY(menu_id) REFERENCES menu(id));

CREATE TABLE IF NOT EXISTS commentaire_diner(id INT PRIMARY KEY AUTO_INCREMENT,
                                diner_id INT,
                                commentaire VARCHAR(500),
                                created_date VARCHAR(100));
CREATE TABLE IF NOT EXISTS login(id INT PRIMARY KEY AUTO_INCREMENT,
                                email VARCHAR(250),
                                password VARCHAR(200),
                                roles VARCHAR(200));

