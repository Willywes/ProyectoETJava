-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-12-2016 a las 00:37:56
-- Versión del servidor: 10.1.16-MariaDB
-- Versión de PHP: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dejmobile`
--
CREATE DATABASE IF NOT EXISTS `dejmobile` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `dejmobile`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `clave` varchar(45) NOT NULL,
  `rut` varchar(12) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `paterno` varchar(45) NOT NULL,
  `materno` varchar(45) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `numero` varchar(11) NOT NULL,
  `comuna_id` int(11) NOT NULL,
  `telefono` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`clave`, `rut`, `nombre`, `paterno`, `materno`, `direccion`, `numero`, `comuna_id`, `telefono`) VALUES
('202cb962ac59075b964b07152d234b70', '16.483.941-9', 'ALEJANDRO', 'ISLA', 'CARRASCO', 'MADRID', '2663', 5302, 990684339),
('202cb962ac59075b964b07152d234b70', '16.665.454-8', 'JIMMY', 'MENESES', 'OLEA', 'PATRIA VIEJA', '118', 5301, 988826247),
('202cb962ac59075b964b07152d234b70', '17.753.134-0', 'SEBASTIAN', 'CABELLO', 'PASTEN', 'INGLATERRA', '330', 2201, 998826247);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comuna`
--

CREATE TABLE `comuna` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `comuna`
--

INSERT INTO `comuna` (`id`, `nombre`) VALUES
(1101, 'ARICA'),
(1106, 'CAMARONES'),
(1201, 'IQUIQUE'),
(1203, 'PICA'),
(1204, 'POZO ALMONTE'),
(1206, 'HUARA'),
(1208, 'CAMINA'),
(1210, 'COLCHANE'),
(1211, 'ALTO HOSPICIO'),
(1301, 'PUTRE'),
(1302, 'GENERAL LAGOS'),
(2101, 'TOCOPILLA'),
(2103, 'MARIA ELENA'),
(2201, 'ANTOFAGASTA'),
(2202, 'TALTAL'),
(2203, 'MEJILLONES'),
(2206, 'SIERRA GORDA'),
(2301, 'CALAMA'),
(2302, 'OLLAGUE'),
(2303, 'SAN PEDRO DE ATACAMA'),
(3101, 'CHANARAL'),
(3102, 'DIEGO DE ALMAGRO'),
(3201, 'COPIAPO'),
(3202, 'CALDERA'),
(3203, 'TIERRA AMARILLA'),
(3301, 'VALLENAR'),
(3302, 'FREIRINA'),
(3303, 'HUASCO'),
(3304, 'ALTO DEL CARMEN'),
(4101, 'LA SERENA'),
(4102, 'LA HIGUERA'),
(4103, 'COQUIMBO'),
(4104, 'ANDACOLLO'),
(4105, 'VICUNA'),
(4106, 'PAIHUANO'),
(4201, 'OVALLE'),
(4203, 'MONTE PATRIA'),
(4204, 'PUNITAQUI'),
(4205, 'COMBARBALA'),
(4206, 'RIO HURTADO'),
(4301, 'ILLAPEL'),
(4302, 'SALAMANCA'),
(4303, 'LOS VILOS'),
(4304, 'CANELA'),
(5101, 'ISLA DE PASCUA'),
(5201, 'LA LIGUA'),
(5202, 'PETORCA'),
(5203, 'CABILDO'),
(5204, 'ZAPALLAR'),
(5205, 'PAPUDO'),
(5301, 'VALPARAISO'),
(5302, 'VINA DEL MAR'),
(5303, 'VILLA ALEMANA'),
(5304, 'QUILPUE'),
(5305, 'CASABLANCA'),
(5306, 'QUINTERO'),
(5307, 'PUCHUNCAVI'),
(5308, 'JUAN FERNANDEZ'),
(5309, 'CONCON'),
(5401, 'SAN ANTONIO'),
(5402, 'SANTO DOMINGO'),
(5403, 'CARTAGENA'),
(5404, 'EL TABO'),
(5405, 'EL QUISCO'),
(5406, 'ALGARROBO'),
(5501, 'QUILLOTA'),
(5502, 'NOGALES'),
(5503, 'HIJUELAS'),
(5504, 'LA CALERA'),
(5505, 'LA CRUZ'),
(5506, 'LIMACHE'),
(5507, 'OLMUE'),
(5601, 'SAN FELIPE'),
(5602, 'PANQUEHUE'),
(5603, 'CATEMU'),
(5604, 'PUTAENDO'),
(5605, 'SANTA MARIA'),
(5606, 'LLAY-LLAY'),
(5701, 'LOS ANDES'),
(5702, 'CALLE LARGA'),
(5703, 'SAN ESTEBAN'),
(5704, 'RINCONADA'),
(6101, 'RANCAGUA'),
(6102, 'MACHALI'),
(6103, 'GRANEROS'),
(6104, 'SAN FRANCISCO DE MOSTAZAL'),
(6105, 'DONIHUE'),
(6106, 'COLTAUCO'),
(6107, 'CODEGUA'),
(6108, 'PEUMO'),
(6109, 'LAS CABRAS'),
(6110, 'SAN VICENTE'),
(6111, 'PICHIDEGUA'),
(6112, 'RENGO'),
(6113, 'REQUINOA'),
(6114, 'OLIVAR'),
(6115, 'MALLOA'),
(6116, 'COINCO'),
(6117, 'QUINTA DE TILCOCO'),
(6201, 'SAN FERNANDO'),
(6202, 'CHIMBARONGO'),
(6203, 'NANCAGUA'),
(6204, 'PLACILLA'),
(6205, 'SANTA CRUZ'),
(6206, 'LOLOL'),
(6207, 'PALMILLA'),
(6208, 'PERALILLO'),
(6209, 'CHEPICA'),
(6214, 'PUMANQUE'),
(6301, 'PICHILEMU'),
(6302, 'NAVIDAD'),
(6303, 'LITUECHE'),
(6304, 'LA ESTRELLA'),
(6305, 'MARCHIGUE'),
(6306, 'PAREDONES'),
(7101, 'CURICO'),
(7102, 'TENO'),
(7103, 'ROMERAL'),
(7104, 'RAUCO'),
(7105, 'LICANTEN'),
(7106, 'VICHUQUEN'),
(7107, 'HUALANE'),
(7108, 'MOLINA'),
(7109, 'SAGRADA FAMILIA'),
(7201, 'TALCA'),
(7202, 'SAN CLEMENTE'),
(7203, 'PELARCO'),
(7204, 'RIO CLARO'),
(7205, 'PENCAHUE'),
(7206, 'MAULE'),
(7207, 'CUREPTO'),
(7208, 'CONSTITUCION'),
(7209, 'EMPEDRADO'),
(7210, 'SAN RAFAEL'),
(7301, 'LINARES'),
(7302, 'YERBAS BUENAS'),
(7303, 'COLBUN'),
(7304, 'LONGAVI'),
(7305, 'PARRAL'),
(7306, 'RETIRO'),
(7309, 'VILLA ALEGRE'),
(7310, 'SAN JAVIER'),
(7401, 'CAUQUENES'),
(7402, 'PELLUHUE'),
(7403, 'CHANCO'),
(8101, 'CHILLAN'),
(8102, 'PINTO'),
(8103, 'COIHUECO'),
(8104, 'QUIRIHUE'),
(8105, 'NINHUE'),
(8106, 'PORTEZUELO'),
(8107, 'COBQUECURA'),
(8108, 'TREHUACO'),
(8109, 'SAN CARLOS'),
(8110, 'NIQUEN'),
(8111, 'SAN FABIAN'),
(8112, 'SAN NICOLAS'),
(8113, 'BULNES'),
(8114, 'SAN IGNACIO'),
(8115, 'QUILLON'),
(8116, 'YUNGAY'),
(8117, 'PEMUCO'),
(8118, 'EL CARMEN'),
(8119, 'RANQUIL'),
(8120, 'COELEMU'),
(8121, 'CHILLAN VIEJO'),
(8201, 'CONCEPCION'),
(8202, 'PENCO'),
(8203, 'HUALQUI'),
(8204, 'FLORIDA'),
(8205, 'TOME'),
(8206, 'TALCAHUANO'),
(8207, 'CORONEL'),
(8208, 'LOTA'),
(8209, 'SANTA JUANA'),
(8210, 'SAN PEDRO DE LA PAZ'),
(8211, 'CHIGUAYANTE'),
(8212, 'HUALPEN'),
(8301, 'ARAUCO'),
(8302, 'CURANILAHUE'),
(8303, 'LEBU'),
(8304, 'LOS ALAMOS'),
(8305, 'CANETE'),
(8306, 'CONTULMO'),
(8307, 'TIRUA'),
(8401, 'LOS ANGELES'),
(8402, 'SANTA BARBARA'),
(8403, 'LAJA'),
(8404, 'QUILLECO'),
(8405, 'NACIMIENTO'),
(8406, 'NEGRETE'),
(8407, 'MULCHEN'),
(8408, 'QUILACO'),
(8409, 'YUMBEL'),
(8410, 'CABRERO'),
(8411, 'SAN ROSENDO'),
(8412, 'TUCAPEL'),
(8413, 'ANTUCO'),
(8414, 'ALTO BIOBIO'),
(9101, 'ANGOL'),
(9102, 'PUREN'),
(9103, 'LOS SAUCES'),
(9104, 'RENAICO'),
(9105, 'COLLIPULLI'),
(9106, 'ERCILLA'),
(9107, 'TRAIGUEN'),
(9108, 'LUMACO'),
(9109, 'VICTORIA'),
(9110, 'CURACAUTIN'),
(9111, 'LONQUIMAY'),
(9201, 'TEMUCO'),
(9202, 'VILCUN'),
(9203, 'FREIRE'),
(9204, 'CUNCO'),
(9205, 'LAUTARO'),
(9206, 'PERQUENCO'),
(9207, 'GALVARINO'),
(9208, 'NUEVA IMPERIAL'),
(9209, 'CARAHUE'),
(9210, 'SAAVEDRA'),
(9211, 'PITRUFQUEN'),
(9212, 'GORBEA'),
(9213, 'TOLTEN'),
(9214, 'LONCOCHE'),
(9215, 'VILLARRICA'),
(9216, 'PUCON'),
(9217, 'MELIPEUCO'),
(9218, 'CURARREHUE'),
(9219, 'TEODORO SCHMIDT'),
(9220, 'PADRE LAS CASAS'),
(9221, 'CHOLCHOL'),
(10101, 'VALDIVIA'),
(10102, 'MARIQUINA'),
(10103, 'LANCO'),
(10104, 'LOS LAGOS'),
(10105, 'FUTRONO'),
(10106, 'CORRAL'),
(10107, 'MAFIL'),
(10108, 'PANGUIPULLI'),
(10109, 'LA UNION'),
(10110, 'PAILLACO'),
(10111, 'RIO BUENO'),
(10112, 'LAGO RANCO'),
(10201, 'OSORNO'),
(10202, 'SAN PABLO'),
(10203, 'PUERTO OCTAY'),
(10204, 'PUYEHUE'),
(10205, 'RIO NEGRO'),
(10206, 'PURRANQUE'),
(10207, 'SAN JUAN DE LA COSTA'),
(10301, 'PUERTO MONTT'),
(10302, 'COCHAMO'),
(10303, 'PUERTO VARAS'),
(10304, 'FRESIA'),
(10305, 'FRUTILLAR'),
(10306, 'LLANQUIHUE'),
(10307, 'MAULLIN'),
(10308, 'LOS MUERMOS'),
(10309, 'CALBUCO'),
(10401, 'CASTRO'),
(10402, 'CHONCHI'),
(10403, 'QUEILEN'),
(10404, 'QUELLON'),
(10405, 'PUQUELDON'),
(10406, 'ANCUD'),
(10407, 'QUEMCHI'),
(10408, 'DALCAHUE'),
(10410, 'CURACO DE VELEZ'),
(10415, 'QUINCHAO'),
(10501, 'CHAITEN'),
(10502, 'HUALAIHUE'),
(10503, 'FUTALEUFU'),
(10504, 'PALENA'),
(11101, 'AYSEN'),
(11102, 'CISNES'),
(11104, 'GUAITECAS'),
(11201, 'CHILE CHICO'),
(11203, 'RIO IBANEZ'),
(11301, 'COCHRANE'),
(11302, 'OHIGGINS'),
(11303, 'TORTEL'),
(11401, 'COYHAIQUE'),
(11402, 'LAGO VERDE'),
(12101, 'NATALES'),
(12103, 'TORRES DEL PAINE'),
(12202, 'RIO VERDE'),
(12204, 'SAN GREGORIO'),
(12205, 'PUNTA ARENAS'),
(12206, 'LAGUNA BLANCA'),
(12301, 'PORVENIR'),
(12302, 'PRIMAVERA'),
(12304, 'TIMAUKEL'),
(12401, 'CABO DE HORNOS'),
(13101, 'SANTIAGO'),
(13134, 'SANTIAGO OESTE'),
(13135, 'SANTIAGO SUR'),
(13159, 'RECOLETA'),
(13167, 'INDEPENDENCIA'),
(14107, 'QUINTA NORMAL'),
(14109, 'MAIPU'),
(14111, 'PUDAHUEL'),
(14113, 'RENCA'),
(14114, 'QUILICURA'),
(14127, 'CONCHALI'),
(14155, 'LO PRADO'),
(14156, 'CERRO NAVIA'),
(14157, 'ESTACION CENTRAL'),
(14158, 'HUECHURABA'),
(14166, 'CERRILLOS'),
(14201, 'COLINA'),
(14202, 'LAMPA'),
(14203, 'TIL-TIL'),
(14501, 'TALAGANTE'),
(14502, 'ISLA DE MAIPO'),
(14503, 'EL MONTE'),
(14504, 'PENAFLOR'),
(14505, 'PADRE HURTADO'),
(14601, 'MELIPILLA'),
(14602, 'MARIA PINTO'),
(14603, 'CURACAVI'),
(14604, 'SAN PEDRO'),
(14605, 'ALHUE'),
(15103, 'PROVIDENCIA'),
(15105, 'NUNOA'),
(15108, 'LAS CONDES'),
(15128, 'LA FLORIDA'),
(15132, 'LA REINA'),
(15151, 'MACUL'),
(15152, 'PENALOLEN'),
(15160, 'VITACURA'),
(15161, 'LO BARNECHEA'),
(16106, 'SAN MIGUEL'),
(16110, 'LA CISTERNA'),
(16131, 'LA GRANJA'),
(16153, 'SAN RAMON'),
(16154, 'LA PINTANA'),
(16162, 'PEDRO AGUIRRE CERDA'),
(16163, 'SAN JOAQUIN'),
(16164, 'LO ESPEJO'),
(16165, 'EL BOSQUE'),
(16301, 'PUENTE ALTO'),
(16302, 'PIRQUE'),
(16303, 'SAN JOSE DE MAIPO'),
(16401, 'SAN BERNARDO'),
(16402, 'CALERA DE TANGO'),
(16403, 'BUIN'),
(16404, 'PAINE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `minuto`
--

CREATE TABLE `minuto` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `precio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `minuto`
--

INSERT INTO `minuto` (`id`, `descripcion`, `precio`) VALUES
(1, '800 Minutos', 1000),
(2, '2000 Minutos', 3000),
(3, '3000 Minutos', 5000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `navegacion`
--

CREATE TABLE `navegacion` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `precio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `navegacion`
--

INSERT INTO `navegacion` (`id`, `descripcion`, `precio`) VALUES
(1, '5 Gigas', 4000),
(2, '7 Gigas', 6000),
(3, '10 Gigas', 8000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitud`
--

CREATE TABLE `solicitud` (
  `id` int(11) NOT NULL,
  `entrega` tinyint(1) NOT NULL,
  `total` int(11) NOT NULL,
  `fecha_hora` datetime NOT NULL,
  `cliente_rut` varchar(12) NOT NULL,
  `navegacion_id` int(11) NOT NULL,
  `minuto_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `solicitud`
--

INSERT INTO `solicitud` (`id`, `entrega`, `total`, `fecha_hora`, `cliente_rut`, `navegacion_id`, `minuto_id`) VALUES
(3, 1, 123123, '2016-12-30 05:16:00', '17.753.134-0', 2, 2),
(4, 0, 123123, '2016-12-27 00:17:00', '17.753.134-0', 1, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`rut`,`comuna_id`),
  ADD KEY `cliente_comuna` (`comuna_id`);

--
-- Indices de la tabla `comuna`
--
ALTER TABLE `comuna`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `minuto`
--
ALTER TABLE `minuto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `navegacion`
--
ALTER TABLE `navegacion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `solicitud`
--
ALTER TABLE `solicitud`
  ADD PRIMARY KEY (`id`),
  ADD KEY `solicitud_navegacion` (`navegacion_id`),
  ADD KEY `solicitud_minuto` (`minuto_id`),
  ADD KEY `solicitud_cliente` (`cliente_rut`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `minuto`
--
ALTER TABLE `minuto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `navegacion`
--
ALTER TABLE `navegacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `solicitud`
--
ALTER TABLE `solicitud`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_comuna` FOREIGN KEY (`comuna_id`) REFERENCES `comuna` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `solicitud`
--
ALTER TABLE `solicitud`
  ADD CONSTRAINT `solicitud_cliente` FOREIGN KEY (`cliente_rut`) REFERENCES `cliente` (`rut`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `solicitud_minuto` FOREIGN KEY (`minuto_id`) REFERENCES `minuto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `solicitud_navegacion` FOREIGN KEY (`navegacion_id`) REFERENCES `navegacion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
