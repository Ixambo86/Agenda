CREATE DATABASE `agenda`;
USE agenda;
CREATE TABLE `personas`
(
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  `TipoTelefono` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `FechaNacimiento` varchar(20) NOT NULL,
  `Calle` varchar(45) NOT NULL,
  `Altura` varchar(20) NOT NULL,
  `Piso` varchar(20) NOT NULL,
  `Departamento` varchar(45) NOT NULL,
  `Pais` varchar(45) NOT NULL,
  `Provincia` varchar(45) NOT NULL,
  `Localidad` varchar(45) NOT NULL,
  `TipoContacto` varchar(45) NOT NULL,
  PRIMARY KEY (`idPersona`)
);

CREATE TABLE `tipocontacto`
(
  `idTipo` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
   PRIMARY KEY (`idTipo`)
);