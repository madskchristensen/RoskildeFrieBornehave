DROP DATABASE IF EXISTS school;
CREATE DATABASE school;

USE school;

CREATE TABLE Guardian(
	id	INT	AUTO_INCREMENT	PRIMARY KEY,
	first_name VARCHAR(20)	NOT NULL,
    last_name	VARCHAR(50)	NOT NULL,
    address	VARCHAR(100)	NOT NULL,
    telefon VARCHAR(15)		NOT NULL,
    email	VARCHAR(100)	NOT NULL
);

CREATE TABLE class(
	id INT	AUTO_INCREMENT PRIMARY KEY,
    color_name VARCHAR(15)	NOT NULL
);

CREATE TABLE child(
	id	INT AUTO_INCREMENT	PRIMARY KEY,
    first_name VARCHAR(20)	NOT NULL,
    last_name	VARCHAR(50)	NOT NULL,
    class	INT,
	birthday 	DATE NOT NULL,
    CONSTRAINT fk_class
		FOREIGN KEY (class)
        REFERENCES class(id)
);

CREATE TABLE teacher(
	id	INT		AUTO_INCREMENT	PRIMARY KEY,
    first_name VARCHAR(20)	NOT NULL,
    last_name	VARCHAR(50)	NOT NULL,
    address	VARCHAR(100)	NOT NULL,
    phoneNr	VARCHAR(15)		NOT NULL,
    email	VARCHAR(100)	NOT NULL
);

CREATE TABLE child_guardian_relationship(
	guardian_id	INT,
    child_id INT,
    CONSTRAINT fk_guardian_id
		FOREIGN KEY(guardian_id)
        REFERENCES guardian(id),
	CONSTRAINT fk_child_id
		FOREIGN KEY(child_id)
        REFERENCES child(id)
);

CREATE TABLE teacher_class_relationship(
	teacher_id	INT,
    class_id INT,
	CONSTRAINT fk_teacher_id
		FOREIGN KEY(teacher_id)
        REFERENCES teacher(id),
	CONSTRAINT fk_class_id
		FOREIGN KEY(class_id)
        REFERENCES class(id)
);

DROP USER IF EXISTS employee@localhost;
DROP USER IF EXISTS administrator@localhost;

CREATE USER employee@localhost IDENTIFIED BY "password";
GRANT SELECT
	ON school.*
	TO employee@localhost;
    
CREATE USER administrator@localhost IDENTIFIED BY "admin_pass";
GRANT SELECT, INSERT, UPDATE, DELETE 
	ON school.*
	TO administrator@localhost;