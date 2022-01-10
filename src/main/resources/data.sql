INSERT INTO Course (id,libelle, ects) VALUES ('INT', 'Introduction', 10),
('MAT1', 'Mathematics 2', 3),
('CAI1', 'Anglais', 2),
('DEV1', 'Developpement 1', 10),
('DEV2', 'Developpement 2', 10),
('WEBG2', 'Developpement web 1', 5);

INSERT INTO Student (id,matricule, name, gender, section) VALUES (1,53735, 'Bryan', 'MALE', 'GESTION'),(2,53736,'Brastof','MALE','RESEAU');

INSERT INTO student_course (student_id, course_id) VALUES(1,'DEV2'),(1,'INT'),(2,'MAT1'),(2,'INT');

INSERT INTO User (username,password,enabled) VALUES ('53735', '{noop}53735', true);
INSERT INTO Authority (id,username,authority) VALUES (2,'53735','SECRETARIAT');

INSERT INTO User (username,password,enabled) VALUES ('prof', '{noop}prof',true);
INSERT INTO Authority (id, username, authority) VALUES (3,'prof','PROF');

INSERT INTO User (username,password,enabled) VALUES ('etudiant','{noop}etudiant',true);
INSERT INTO Authority (id,username,authority) VALUES (4,'etudiant','STUDENT');
