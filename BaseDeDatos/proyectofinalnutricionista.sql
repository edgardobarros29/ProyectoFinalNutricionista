-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-11-2023 a las 15:58:05
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectofinalnutricionista`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comida`
--

CREATE TABLE `comida` (
  `idComida` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `detalle` varchar(100) NOT NULL,
  `cantCalorias` int(11) NOT NULL,
  `Estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `comida`
--

INSERT INTO `comida` (`idComida`, `nombre`, `detalle`, `cantCalorias`, `Estado`) VALUES
(1, 'Hamburguesa', 'Hamburguesa de carne, con pan, lechuga y tomate, sin aderezos', 3500, 1),
(2, 'lomo con ensalada verde', 'medallon de lomo de 200gr con ensalada de hojas verdes(lechuga, rucula,albahaca)', 1500, 1),
(3, 'tallarines con salsa', 'porcion de tallarines con salsa filetto', 450, 1),
(4, 'ensalada de fruta', 'banana, manzana, naranja', 100, 1),
(5, 'Milanesa', 'Carne, pan rallado', 1500, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dieta`
--

CREATE TABLE `dieta` (
  `idDieta` int(11) NOT NULL,
  `idPaciente` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFinal` date DEFAULT NULL,
  `pesoInicial` double NOT NULL,
  `pesoBuscado` double NOT NULL,
  `pesoActual` double NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dieta`
--

INSERT INTO `dieta` (`idDieta`, `idPaciente`, `nombre`, `fechaInicio`, `fechaFinal`, `pesoInicial`, `pesoBuscado`, `pesoActual`, `estado`) VALUES
(1, 1, 'libre de gluten', '2023-02-14', '2023-10-02', 108, 80, 90, 0),
(4, 5, 'sin azucar', '2023-10-15', '2023-10-31', 95, 90, 85, 1),
(5, 1, 'ensalada', '2023-10-25', '2023-11-05', 90, 85, 89, 1),
(6, 6, 'Sin azucar', '2023-10-25', '2023-10-31', 80, 79, 75, 1),
(7, 7, 'libre de gluten ', '2023-10-25', '2023-11-26', 120, 100, 90, 1),
(8, 8, 'jorge', '2023-10-28', '2023-10-31', 56.3, 89.6, 89.6, 1),
(9, 9, 'Sin gluten', '2023-10-24', '2023-11-10', 90, 80, 88, 1),
(10, 10, 'sin azucar', '2023-10-30', '2023-11-18', 100, 80, 80, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dietacomida`
--

CREATE TABLE `dietacomida` (
  `idDietaComida` int(11) NOT NULL,
  `idDieta` int(11) NOT NULL,
  `idComida` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dietacomida`
--

INSERT INTO `dietacomida` (`idDietaComida`, `idDieta`, `idComida`) VALUES
(5, 1, 1),
(6, 1, 3),
(7, 1, 2),
(9, 5, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `idPaciente` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `dni` bigint(20) NOT NULL,
  `telefono` bigint(20) NOT NULL,
  `domicilio` varchar(60) NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`idPaciente`, `nombre`, `apellido`, `dni`, `telefono`, `domicilio`, `estado`) VALUES
(1, 'juan cruz', 'Perez', 35539000, 261209424, 'Olascoaga 7150', 1),
(2, 'fernando', 'gutierrez', 234569, 266459872, 'san martin 123', 1),
(3, 'edgardo', 'barros', 21382111, 266488174, 'bolivar 842', 1),
(5, 'edgardo', 'barros', 17387117, 266458580, 'bolivar 842', 1),
(6, 'Edgardo', 'Mora', 41807490, 26647878, 'Ayacucho 833', 1),
(7, 'Valentin', 'Barros', 44782781, 266487895, 'Pedernera 833', 0),
(8, 'jorge', 'santiago', 12345678, 266478954, 'ayacuccho', 1),
(9, 'Facundo David', 'Ahumada ', 98765432, 26647895, 'Ayacucho 833', 1),
(10, 'alberto', 'barros', 5555555, 266458589, 'pedernera 899', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comida`
--
ALTER TABLE `comida`
  ADD PRIMARY KEY (`idComida`);

--
-- Indices de la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD PRIMARY KEY (`idDieta`),
  ADD KEY `idPaciente` (`idPaciente`);

--
-- Indices de la tabla `dietacomida`
--
ALTER TABLE `dietacomida`
  ADD PRIMARY KEY (`idDietaComida`),
  ADD UNIQUE KEY `idComida` (`idComida`),
  ADD KEY `idDieta` (`idDieta`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`idPaciente`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comida`
--
ALTER TABLE `comida`
  MODIFY `idComida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `dieta`
--
ALTER TABLE `dieta`
  MODIFY `idDieta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `dietacomida`
--
ALTER TABLE `dietacomida`
  MODIFY `idDietaComida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `idPaciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD CONSTRAINT `dieta_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`);

--
-- Filtros para la tabla `dietacomida`
--
ALTER TABLE `dietacomida`
  ADD CONSTRAINT `dietacomida_ibfk_1` FOREIGN KEY (`idDieta`) REFERENCES `dieta` (`idDieta`),
  ADD CONSTRAINT `dietacomida_ibfk_2` FOREIGN KEY (`idComida`) REFERENCES `comida` (`idComida`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
