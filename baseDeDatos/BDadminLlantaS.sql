-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 12-12-2022 a las 20:45:53
-- Versión del servidor: 8.0.31
-- Versión de PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `adminllantas`
--
CREATE DATABASE IF NOT EXISTS `adminllantas` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `adminllantas`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Producto`
--

CREATE TABLE `Producto` (
  `idProducto` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  `precio` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provedor`
--

CREATE TABLE `provedor` (
  `idProveedor` int NOT NULL,
  `nombreEmpresa` varchar(45) DEFAULT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  `estatus` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `provedor`
--

INSERT INTO `provedor` (`idProveedor`, `nombreEmpresa`, `categoria`, `estatus`) VALUES
(1, 'LALA', 'alimentos', '1'),
(11, 'asdasd', 'asdad', '1'),
(12, 'Hola', 'Hola', '1'),
(13, 'Bimbo', 'panes', '1'),
(14, 'Michelin', 'llantas de carreras', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `idRol` int NOT NULL,
  `rol` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`idRol`, `rol`) VALUES
(1, 'empleado'),
(2, 'administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursal`
--

CREATE TABLE `sucursal` (
  `idsucursal` int NOT NULL,
  `nombreSucursal` varchar(45) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `sucursal`
--

INSERT INTO `sucursal` (`idsucursal`, `nombreSucursal`, `ciudad`) VALUES
(1, 'Denilson', 'Xalapa'),
(2, 'Javier', 'Perote');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `ID` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidoPaterno` varchar(45) DEFAULT NULL,
  `apellidoMaterno` varchar(45) DEFAULT NULL,
  `correoElectronico` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `estatus` int DEFAULT NULL,
  `idRol` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID`, `nombre`, `apellidoPaterno`, `apellidoMaterno`, `correoElectronico`, `direccion`, `telefono`, `password`, `estatus`, `idRol`) VALUES
(4, 'Andres', 'Herrera', 'Rodriguez', 'andresR@gmail.com', 'Mexico', '2278452387', '123', 1, 2),
(28, 'prueba ', 'prueba', 'prueba', 'prueba', 'prueba', '1234', 'qwerty', 1, 1),
(29, 'Javier', 'lopez', 'hernandez', 'hernandez@gmail.com', 'Jalapa', '2244338811', 'qwerty', 1, 1),
(31, 'Monica ', 'Colorado', 'Pimentel', 'rcolorado@gmail.com', 'av mexico, Xalapa', '2299443311', 'qwerty', 1, 1),
(34, 'Denilson', 'Perez', 'Cortina', 'denilsonPerezCortina@gmail.com', 'Coatepec ', '2299392230', '1234', 1, 2),
(35, 'Javier', 'Lopez', 'Hernandez', 'javierAdmin@gmail.com', 'Javier', '2299392211', '12345', 1, 2),
(36, 'jorge', 'fuentes', 'de jesus', 'arev@gmail.com', 'xalapa', '2323', '123456', 1, 1),
(37, 'jorge', 'fuentes', 'de jesus', 'arev@gmail.com', 'xalapa', '2323', '123456', 1, 1),
(38, 'jorge', 'fuentes', 'de jesus', 'arev@gmail.com', 'xalapa', '2323', '123456', 1, 1),
(39, 'jorge', 'fuentes', 'de jesus', 'arev@gmail.com', 'xalapa', '2323', '123456', 1, 1),
(41, 'jorge', 'fuentes', 'de jesus', 'arev@gmail.com', 'xalapa', '2323', '123456', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `idventa` int NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `cantidadVendido` int DEFAULT NULL,
  `idEmpleado` int DEFAULT NULL,
  `idSucursal` int DEFAULT NULL,
  `idProducto` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Producto`
--
ALTER TABLE `Producto`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `provedor`
--
ALTER TABLE `provedor`
  ADD PRIMARY KEY (`idProveedor`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idRol`);

--
-- Indices de la tabla `sucursal`
--
ALTER TABLE `sucursal`
  ADD PRIMARY KEY (`idsucursal`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `forenKeyidRol_idx` (`idRol`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`idventa`),
  ADD KEY `fk_idEmpleado_idx` (`idEmpleado`),
  ADD KEY `fk_idProducto_idx` (`idProducto`),
  ADD KEY `fk_idSucursal_idx` (`idSucursal`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Producto`
--
ALTER TABLE `Producto`
  MODIFY `idProducto` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `provedor`
--
ALTER TABLE `provedor`
  MODIFY `idProveedor` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `sucursal`
--
ALTER TABLE `sucursal`
  MODIFY `idsucursal` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `ID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `idventa` int NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fkIdRol` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `fk_idEmpleado` FOREIGN KEY (`idEmpleado`) REFERENCES `usuario` (`ID`),
  ADD CONSTRAINT `fk_idProducto` FOREIGN KEY (`idProducto`) REFERENCES `Producto` (`idProducto`),
  ADD CONSTRAINT `fk_idSucursal` FOREIGN KEY (`idSucursal`) REFERENCES `sucursal` (`idsucursal`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
