-- SPRINT Modulo 5 - Grupo 01 

-- Crear una base de datos empresa de prevencion de riesgos
DROP DATABASE IF EXISTS empresaprevencionriesgos;
CREATE DATABASE empresaprevencionriesgos DEFAULT CHARACTER SET utf8mb4;
-- Crear un usuario con todos los privilegios para trabajar con la base de datos recién creada.   
CREATE USER 'adminepr'@'localhost' IDENTIFIED BY 'password';
SET PASSWORD FOR 'adminepr'@'localhost' = '123456';

-- Totalidad de permisos a la base de datos creada.
GRANT ALL PRIVILEGES ON empresaprevencionriesgos.* TO 'adminepr'@'localhost';
-- Se cargan los privilegios del usuario.
FLUSH PRIVILEGES;

SHOW DATABASES;
-- SHOW TABLES;
USE empresaprevencionriesgos;

-- TABLAS

DROP TABLE IF EXISTS empresaprevencionriesgos.sistema_salud; 
CREATE TABLE empresaprevencionriesgos.sistema_salud (
   sistema_salud_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT, 
   nombre VARCHAR(10) NOT NULL UNIQUE, 
   PRIMARY KEY (sistema_salud_id)
) DEFAULT CHARSET=utf8mb4;
DESCRIBE empresaprevencionriesgos.sistema_salud; 
INSERT INTO empresaprevencionriesgos.sistema_salud (sistema_salud_id, nombre) VALUES (1,'fonasa'), (2,'isapre');
SELECT * FROM empresaprevencionriesgos.sistema_salud;

DROP TABLE IF EXISTS empresaprevencionriesgos.afp ; 
CREATE TABLE empresaprevencionriesgos.afp (
   afp_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT, 
   nombre VARCHAR(50) NOT NULL UNIQUE, 
   PRIMARY KEY (afp_id)
) DEFAULT CHARSET=utf8mb4;
DESCRIBE empresaprevencionriesgos.afp; 
INSERT INTO empresaprevencionriesgos.afp (afp_id, nombre) VALUES (1,'afp capital'), (2,'afp provida'), (3,'afp cuprum'),(4,'afp habitat'),(5,'afp plan vital'),(6,'afp modelo'),(7,'afp uno');
SELECT * FROM empresaprevencionriesgos.afp;

DROP TABLE IF EXISTS empresaprevencionriesgos.dia; 
CREATE TABLE empresaprevencionriesgos.dia (
   dia_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT, 
   nombre VARCHAR(10) NOT NULL UNIQUE, 
   PRIMARY KEY (dia_id)
) DEFAULT CHARSET=utf8mb4;
DESCRIBE empresaprevencionriesgos.dia; 
INSERT INTO empresaprevencionriesgos.dia (dia_id,nombre) VALUES (1,'lunes'), (2,'martes'), (3,'miércoles'),(4,'jueves'),(5,'viernes'),(6,'sábado'),(7,'domingo');
SELECT * FROM empresaprevencionriesgos.dia;

DROP TABLE IF EXISTS empresaprevencionriesgos.perfil; 
CREATE TABLE empresaprevencionriesgos.perfil (
   perfil_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT, 
   nombre VARCHAR(50) NOT NULL UNIQUE, 
   PRIMARY KEY (perfil_id)
) DEFAULT CHARSET=utf8mb4;
DESCRIBE empresaprevencionriesgos.perfil; 
INSERT INTO empresaprevencionriesgos.perfil (perfil_id, nombre) VALUES (1,'administrativo'), (2,'cliente'), (3,'profesional');
SELECT * FROM empresaprevencionriesgos.perfil;

DROP TABLE IF EXISTS empresaprevencionriesgos.usuario; 
CREATE TABLE empresaprevencionriesgos.usuario (
   usuario_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT, 
   nick VARCHAR(50) NOT NULL UNIQUE, 
   password1 VARCHAR(50) NOT NULL, 
   rut VARCHAR(15) NOT NULL UNIQUE,
   nombres VARCHAR(50) NOT NULL, 
   apellidos VARCHAR(50) NOT NULL, 
   fecha_de_nacimiento DATE NOT NULL,
   perfil_id SMALLINT UNSIGNED NOT NULL,
   PRIMARY KEY (usuario_id),
   CONSTRAINT usuario_ibfk_1  FOREIGN KEY (perfil_id) REFERENCES empresaprevencionriesgos.perfil (perfil_id) ON DELETE CASCADE
) DEFAULT CHARSET=utf8mb4;
DESCRIBE empresaprevencionriesgos.usuario; 

DROP TABLE IF EXISTS empresaprevencionriesgos.cliente; 
CREATE TABLE empresaprevencionriesgos.cliente (
   cliente_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT, 
   telefono VARCHAR(15),
   email VARCHAR(250) NOT NULL, 
   afp_id SMALLINT UNSIGNED NOT NULL,
   sistema_salud_id SMALLINT UNSIGNED NOT NULL,
   direccion VARCHAR(100), 
   comuna VARCHAR(50), 
   organizacion VARCHAR(100) NOT NULL, 
   usuario_id SMALLINT UNSIGNED NOT NULL,
   PRIMARY KEY (cliente_id),
   CONSTRAINT cliente_ibfk_1  FOREIGN KEY (afp_id) REFERENCES empresaprevencionriesgos.afp (afp_id) ON DELETE CASCADE,
   CONSTRAINT cliente_ibfk_2  FOREIGN KEY (sistema_salud_id) REFERENCES empresaprevencionriesgos.sistema_salud (sistema_salud_id) ON DELETE CASCADE,
   CONSTRAINT cliente_ibfk_3  FOREIGN KEY (usuario_id) REFERENCES empresaprevencionriesgos.usuario (usuario_id) ON DELETE CASCADE
) DEFAULT CHARSET=utf8mb4;
DESCRIBE empresaprevencionriesgos.cliente; 

DROP TABLE IF EXISTS empresaprevencionriesgos.administrativo; 
CREATE TABLE empresaprevencionriesgos.administrativo (
   administrativo_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT, 
   area VARCHAR(50), 
   experiencia_previa VARCHAR(100), 
   usuario_id SMALLINT UNSIGNED NOT NULL,
   PRIMARY KEY (administrativo_id),
   CONSTRAINT administrativo_ibfk_1  FOREIGN KEY (usuario_id) REFERENCES empresaprevencionriesgos.usuario (usuario_id) ON DELETE CASCADE
) DEFAULT CHARSET=utf8mb4;
DESCRIBE empresaprevencionriesgos.administrativo; 

DROP TABLE IF EXISTS empresaprevencionriesgos.profesional; 
CREATE TABLE empresaprevencionriesgos.profesional (
   profesional_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT, 
   titulo VARCHAR(100), 
   fecha_de_ingreso DATE,  
   usuario_id SMALLINT UNSIGNED NOT NULL,
   PRIMARY KEY (profesional_id),
   CONSTRAINT profesional_ibfk_1  FOREIGN KEY (usuario_id) REFERENCES empresaprevencionriesgos.usuario (usuario_id) ON DELETE CASCADE
) DEFAULT CHARSET=utf8mb4;
DESCRIBE empresaprevencionriesgos.profesional; 

DROP TABLE IF EXISTS empresaprevencionriesgos.capacitacion; 
CREATE TABLE empresaprevencionriesgos.capacitacion (
   capacitacion_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT, 
   identificador LONG NOT NULL,
   dia_id SMALLINT UNSIGNED NOT NULL,
   hora VARCHAR(6), 
   lugar VARCHAR(100), 
   duracion SMALLINT UNSIGNED, 
   cantidad_de_asistentes SMALLINT UNSIGNED,
   cliente_id SMALLINT UNSIGNED NOT NULL,
   PRIMARY KEY (capacitacion_id),
   CONSTRAINT capacitacion_ibfk_1  FOREIGN KEY (dia_id) REFERENCES empresaprevencionriesgos.dia (dia_id) ON DELETE CASCADE,
   CONSTRAINT capacitacion_ibfk_2  FOREIGN KEY (cliente_id) REFERENCES empresaprevencionriesgos.cliente (cliente_id) ON DELETE CASCADE
) DEFAULT CHARSET=utf8mb4;
DESCRIBE empresaprevencionriesgos.capacitacion; 

DROP TABLE IF EXISTS empresaprevencionriesgos.contacto; 
CREATE TABLE empresaprevencionriesgos.contacto (
   contacto_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,  
   mensaje VARCHAR(250), 
   cliente_id SMALLINT UNSIGNED NOT NULL,
   PRIMARY KEY (contacto_id),
   CONSTRAINT contacto_ibfk_1  FOREIGN KEY (cliente_id) REFERENCES empresaprevencionriesgos.cliente (cliente_id) ON DELETE CASCADE
) DEFAULT CHARSET=utf8mb4;
DESCRIBE empresaprevencionriesgos.contacto; 

/**Datos base***/
delete from empresaprevencionriesgos.usuario where perfil_id>0;
insert into empresaprevencionriesgos.usuario (usuario_id, nick, password1, rut, nombres, apellidos, fecha_de_nacimiento, perfil_id)  
values (1,'ada','1234','11.000.000-1','Ada','Lovelace','1815-12-10',1),
(2,'turin','1234','12.000.000-2','Alan','Turin','1912-06-23',1),
(3,'awake','1234','13.000.000-3','Awake','Lab','2000-01-30',2),
(4,'edutec','1234','14.000.000-4','Edu','Tecno','2000-01-01',3);
select * from empresaprevencionriesgos.usuario inner join empresaprevencionriesgos.perfil on usuario.perfil_id=perfil.perfil_id;

insert into empresaprevencionriesgos.administrativo (administrativo_id, area,experiencia_previa,usuario_id) 
values (1, 'area TI','mucha experiencia previa',1),(2, 'area TI','mucha experiencia previa',2) ;
select * from  empresaprevencionriesgos.administrativo 
inner join empresaprevencionriesgos.usuario on administrativo.usuario_id=usuario.usuario_id
inner join empresaprevencionriesgos.perfil on usuario.perfil_id=perfil.perfil_id;

insert into empresaprevencionriesgos.cliente (cliente_id,telefono,email,afp_id,sistema_salud_id,direccion,comuna, organizacion,usuario_id) 
values (1, 988774455,'awake@gmail.com',1,1,'calle adas 1111','valparaiso','AdalidAwake',3);
select * from  empresaprevencionriesgos.cliente 
inner join empresaprevencionriesgos.usuario on cliente.usuario_id=usuario.usuario_id
inner join empresaprevencionriesgos.perfil on usuario.perfil_id=perfil.perfil_id;

insert into empresaprevencionriesgos.profesional (profesional_id,titulo,fecha_de_ingreso,usuario_id) 
values (1, 'titulo ti','2022-12-01',4);
select * from  empresaprevencionriesgos.profesional 
inner join empresaprevencionriesgos.usuario on profesional.usuario_id=usuario.usuario_id
inner join empresaprevencionriesgos.perfil on usuario.perfil_id=perfil.perfil_id;

insert into contacto (mensaje,cliente_id) values ('hola cobol',1);
Select * from contacto;

Select * from capacitacion;

select identificador, dia.nombre as dia, hora, lugar,duracion,cantidad_de_asistentes, rut from usuario 
inner join cliente on usuario.usuario_id=cliente.usuario_id 
inner join capacitacion on cliente.cliente_id=capacitacion.cliente_id
inner join dia on capacitacion.dia_id=dia.dia_id;

select nick,password1,rut, perfil_id from usuario;
select * from contacto;
select * from capacitacion;
select * from usuario;
select * from profesional;

-- delete from usuario where rut='14.000.000-4';

-- insert into empresaprevencionriesgos.usuario (usuario_id, nick, password1, rut, nombres, apellidos, fecha_de_nacimiento, perfil_id)  
-- values (2,'turin','1234','12.000.000-2','Alan','Turin','1912-06-23',1)


