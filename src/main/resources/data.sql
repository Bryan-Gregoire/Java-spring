insert into Course(id,libelle, ects) values ('INT', 'Introduction', 10), ('MAT1', 'Mathematics 2', 3), ('CAI1', 'Anglais', 2), ('DEV1', 'Developpement 1', 10),('DEV2', 'Developpement 2', 10), ('WEBG2', 'Developpement web 1', 5)

insert into Student(matricule, name, gender, section) values (1, 'Bryan', 'MALE', 'GESTION'), (2, 'Brastof','MALE','RESEAU')

insert into student_course(student_id, course_id) values(1,'DEV2'),(1,'INT'),(2,'MAT1'),(2,'INT')