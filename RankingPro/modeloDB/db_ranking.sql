-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-08-2015 a las 10:36:32
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `db_ranking`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_carrera`
--

CREATE TABLE IF NOT EXISTS `tbl_carrera` (
  `id_carrera` int(11) NOT NULL AUTO_INCREMENT,
  `carrera` varchar(100) NOT NULL,
  PRIMARY KEY (`id_carrera`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=60 ;

--
-- Volcado de datos para la tabla `tbl_carrera`
--

INSERT INTO `tbl_carrera` (`id_carrera`, `carrera`) VALUES
(1, 'LICENCIATURA EN DERECHO'),
(2, 'LICENCIATURA EN ANTROPOLOGIA'),
(3, 'LICENCIATURA EN PERIODISMO'),
(4, 'LICENCIATURA EN PSICOLOGIA'),
(5, 'LICENCIATURA EN PEDAGOGIA'),
(6, 'LICENCIATURA EN TRABAJO SOCIAL'),
(7, 'LICENCIATURA EN HISTORIA'),
(8, 'LICENCIATURA EN LETRAS'),
(9, 'LICENCIATURA EN FILOSOFIA'),
(10, 'LICENCIATURA EN SOCIOLOGIA'),
(11, 'LICENCIATURA EN EDUCACION FISICA'),
(12, 'LICENCIATURA EN LEN. EXT.CON ORIE.INGL. Y FRANCES'),
(13, 'LICENCIATURA EN MUSICA'),
(14, 'LICENCIATURA EN DESARROLLO LOCAL'),
(15, 'INGENIERIA CIVIL'),
(16, 'INGENIERIA MECANICA INDUSTRIAL'),
(17, 'INGENIERIA QUIMICA INDUSTRIAL'),
(18, 'INGENIERIA ELECTRICA INDUSTRIAL'),
(19, 'INGENIERIA INDUSTRIAL'),
(20, 'INGENIERIA EN SISTEMAS'),
(21, 'LICENCIATURA EN QUIMICA INDUSTRIAL'),
(22, 'ARQUITECTURA'),
(23, 'LICENCIATURA EN MATEMATICAS'),
(24, 'LICENCIATURA EN FISICA'),
(25, 'LICENCIATURA EN ASTRONOMIA Y ASTROFISICA'),
(26, 'MEDICINA'),
(27, 'ODONTOLOGIA'),
(28, 'LICENCIATURA EN NUTRICION'),
(29, 'QUIMICA Y FARMACIA'),
(30, 'ENFERMERIA'),
(31, 'MICROBIOLOGIA'),
(32, 'LICENCIATURA EN BIOLOGIA'),
(33, 'LICENCIATURA EN ADMINISTRACION DE EMPRESAS'),
(34, 'LICENCIATURA EN ADMINISTRACION PUBLICA'),
(35, 'LICENCIATURA EN ECONOMIA'),
(36, 'LICENCIATURA EN CONTADURIA PUBLICA Y FINANZAS'),
(37, 'LICENCIATURA EN ADMINISTRACION ADUANERA'),
(38, 'LICENCIATURA EN ADMINISTRACION DE BANCA Y FINANZAS'),
(39, 'LICENTURA EN COMERCIO INTERNACIONAL'),
(40, 'LICENCIATURA EN INFORMATICA ADMINISTRATIVA'),
(41, 'LICENCIATURA EN MERCADOTECNIA'),
(42, 'INGENIERIA AGRONOMICA'),
(43, 'INGENIERIA FORESTAL'),
(44, 'INGENIERIA AGROINDUSTRIAL'),
(45, 'INGENIERIA EN CIENCIAS ACUICOLAS Y  RECURSOS MARINOS COSTEROS'),
(46, 'LICENCIATURA EN ECONOMIA AGRICOLA'),
(47, 'LICENCIATURA EN ECOTURISMO'),
(48, 'LICENCIATURA EN COM.INTERNACIONAL CON ORIENT.EN AGROIND.'),
(49, 'TECNICO UNIVERSITARIO EN PROCESAMIENTO DE LACTEOS'),
(50, 'TECNICO UNIVERSITARIO EN EDUCACION BASICA PARA LA ENSENANZA DEL ESPAÑOL'),
(51, 'TECNICO UNIVERSITARIO EN METALURGIA'),
(52, 'TECNICO UNIVERSITARIO EN PRODUCCION PECUARIA'),
(53, 'TECNICO UNIVERSITARIO EN PRODUCCION AGRICOLA '),
(54, 'TECNICO UNIVERSITARIO EN TECNOLOGIA DE ALIMENTOS'),
(55, 'TECNICO UNIVERSITARIO EN TERAPIA FUNCIONAL'),
(56, 'TECNICO UNIVERSITARIO EN  RADIOTECNOLOGIAS (RADIOLOGIA E IMAGENES)'),
(57, 'TECNICO UNIVERSITARIO EN MICROFINANZAS'),
(58, 'TECNICO UNIVERSITARIO EN ALIMENTOS Y BEBIDAS'),
(59, 'TECNICO UNIVERSITARIO EN CALIDAD DEL CAFÉ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_origen`
--

CREATE TABLE IF NOT EXISTS `tbl_origen` (
  `id_origen` int(11) NOT NULL AUTO_INCREMENT,
  `origen` varchar(100) NOT NULL,
  PRIMARY KEY (`id_origen`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=19 ;

--
-- Volcado de datos para la tabla `tbl_origen`
--

INSERT INTO `tbl_origen` (`id_origen`, `origen`) VALUES
(1, 'Islas de la Bahía'),
(2, 'Cortés'),
(3, 'Atlántida'),
(4, 'Colón'),
(5, 'Gracias a Dios'),
(6, 'Copán'),
(7, 'Santa Bárbara'),
(8, 'Yoro'),
(9, 'Olancho'),
(10, 'Ocotepeque'),
(11, 'Lempira'),
(12, 'Intibucá'),
(13, 'Comayagua'),
(14, 'Francisco Morazán'),
(15, 'El Paraíso'),
(16, 'La Paz'),
(17, 'Valle'),
(18, 'Choluteca');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_ranking`
--

CREATE TABLE IF NOT EXISTS `tbl_ranking` (
  `cuenta` varchar(11) NOT NULL,
  `primer_nombre` varchar(45) NOT NULL,
  `segundo_nombre` varchar(45) NOT NULL,
  `primer_apellido` varchar(45) NOT NULL,
  `segundo_apellido` varchar(45) NOT NULL,
  `id_sexo` int(11) NOT NULL,
  `id_origen` int(11) NOT NULL,
  `id_carrera` int(11) NOT NULL,
  `edad` int(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `previamente` int(11) NOT NULL,
  `puntos` int(11) NOT NULL,
  `foto` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tbl_ranking_tbl_sexo_idx` (`id_sexo`),
  KEY `fk_tbl_ranking_tbl_origen1_idx` (`id_origen`),
  KEY `fk_tbl_ranking_tbl_carrera1_idx` (`id_carrera`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=41 ;

--
-- Volcado de datos para la tabla `tbl_ranking`
--

INSERT INTO `tbl_ranking` (`cuenta`, `primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `id_sexo`, `id_origen`, `id_carrera`, `edad`, `email`, `telefono`, `id`, `previamente`, `puntos`, `foto`) VALUES
('20121902480', 'Nelson', 'Eduardor', 'ORELLANA', 'TERCERO', 1, 16, 5, 21, 'nelson_orellana18@yahoo.es', '31734973', 15, 8, 2040, ''),
('20131900127', 'Alejandro', 'Jose', 'FLORES', 'MORALES', 1, 13, 15, 20, 'alejflores94@gmail.com', '99634810', 16, 7, 2135, ''),
('20141900298', 'Nohelia', 'Cristina', 'EUCEDA', 'FIGUEROA', 2, 14, 20, 18, 'noheliaeucedaf@yahoo.com', '32478405', 17, 11, 1800, ''),
('20141011000', 'Alfredo', 'Alfredo', 'LOPEZ', 'MORAZAN', 1, 14, 12, 21, 'almnazer94@yahoo.es', '32070790', 18, 3, 2070, ''),
('20111900174', 'Héctor', 'Fernando', 'LOBO', 'CHÁVEZ', 1, 13, 20, 22, 'hector.lobo10000@gmail.com', '33314240', 19, 5, 2180, ''),
('20151003771', 'Armando', 'David', 'FLORES', 'MORALES', 1, 13, 22, 18, 'armandodavidflores@gmail.com', '97673140', 20, 15, 1900, ''),
('20121902433', 'Mario', 'Roberto', 'GUIFARRO', 'ORELLANA', 1, 4, 1, 22, 'marioguifa@gmail.com', '98917471', 21, 21, 1355, ''),
('20141900349', 'Maryuri', 'Nineth', 'HERNANDEZ', 'VALLECILLO', 2, 13, 15, 21, 'MhernandezV@yahoo.com', '87335542', 22, 22, 675, ''),
('20141012316', 'Guillermo', 'Andrés', 'MUÑOZ', 'MARADIAGA', 1, 14, 26, 18, 'gmunoztt@gmail.com', '96303413', 23, 1, 3735, ''),
('20131008831', 'Kristel', 'Annette', 'LOPEZ', 'OSORTO', 2, 14, 1, 20, 'kristelannette@gmail.com', '95770566', 24, 27, 545, ''),
('20121015746', 'Rebecca', 'Gabrielle', 'AYESTAS', 'AVALOS', 2, 14, 28, 20, 'ayestasrebecca@gmail.com', '95088452', 25, 10, 1875, ''),
('20123000733', 'Norman', 'Josue', 'DUEÑAS', 'ROSALES', 1, 2, 36, 23, 'nduenasr@gmail.com', '96813035', 26, 32, 940, ''),
('20131006347', 'Eduardo', 'Josue', 'MONTOYA', 'GUTIERREZ', 1, 14, 31, 19, 'eduardo.montoya99@hotmail.com', '33491749', 27, 0, 50, ''),
('20123002215', 'Kevin', 'Josue', 'MARTINEZ', 'ZELAYA', 1, 2, 43, 22, 'rmakm@hotmil.com', '95006324', 28, 0, 50, ''),
('20151020408', 'Miguel', 'Angel', 'CANALES', 'VASQUEZ', 1, 2, 22, 20, 'angelvasquez563@gmail.com', '87597213', 29, 34, 725, ''),
('20141030409', 'Diana', 'Sofia', 'ROSALES', 'IZAGUIRRE', 2, 13, 27, 18, 'dianasofia211@hotmail.com', '99945053', 30, 0, 50, ''),
('20151002090', 'Rudy', 'Rene', 'ÁLVAREZ', 'RAMOS', 1, 9, 19, 18, 'rudyalvarezramos1@gmail.com', '97733384', 31, 0, 145, ''),
('20131000982', 'Ana', 'Gabriela', 'MORALES', 'AGUILUZ', 2, 13, 1, 20, 'anagabriela_moralesaguiluz@yahoo.es', '97199641', 32, 19, 1645, ''),
('20101902008', 'Jose', 'Avilio', 'URBINA', 'RIVERA', 1, 13, 11, 24, 'joseavilio0402@yahoo.es', '88427355', 33, 2, 3350, ''),
('20151001797', 'Ronald', 'Alexander', 'GIRÓN', 'SANCHEZ', 1, 13, 16, 19, 'ronaldgiron576@yahoo.com', '99804945', 34, 0, 50, ''),
('20151023449', 'Victor', 'Manuel', 'VALLADARES', 'MONTENEGRO', 1, 14, 55, 18, 'victor_montenegro33@hotmail.com', '87839587', 35, 0, 50, ''),
('20131009563', 'Silvia', 'Paola', 'GIRÓN', 'SÁNCHEZ', 2, 13, 12, 21, 'paogi50@outlook.com', '95220154', 36, 48, 95, ''),
('20151004630', 'Jeysie', 'Eliany', 'SOTO', 'REYES', 2, 1, 36, 18, 'elianysoto@hotmail.com', '87995461', 37, 46, 355, ''),
('20151000359', 'Abner', 'Danilo', 'BANEGAS', 'ZELAYA', 1, 14, 4, 19, 'danilozelayaambu@gmail.com', '96289169', 38, 0, 50, ''),
('20101003952', 'Josue', 'David', 'RIVERA', 'RAMIREZ', 1, 7, 40, 23, 'bandacpg_sanluis@hotmail.com', '98160022', 39, 0, 50, ''),
('20151023946', 'Osman', 'Eduardo', 'HERNÁNDEZ', 'MURILLO', 1, 14, 22, 18, 'osman_hernandez11@yahoo.com', '98032042', 40, 37, 225, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_sexo`
--

CREATE TABLE IF NOT EXISTS `tbl_sexo` (
  `id_sexo` int(11) NOT NULL AUTO_INCREMENT,
  `sexo` varchar(45) NOT NULL,
  PRIMARY KEY (`id_sexo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `tbl_sexo`
--

INSERT INTO `tbl_sexo` (`id_sexo`, `sexo`) VALUES
(1, 'Masculino'),
(2, 'Femenino');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbl_ranking`
--
ALTER TABLE `tbl_ranking`
  ADD CONSTRAINT `fk_tbl_ranking_tbl_carrera1` FOREIGN KEY (`id_carrera`) REFERENCES `tbl_carrera` (`id_carrera`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tbl_ranking_tbl_origen1` FOREIGN KEY (`id_origen`) REFERENCES `tbl_origen` (`id_origen`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tbl_ranking_tbl_sexo` FOREIGN KEY (`id_sexo`) REFERENCES `tbl_sexo` (`id_sexo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
