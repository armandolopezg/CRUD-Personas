-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-07-2024 a las 18:50:50
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `personas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `apellido_paterno` varchar(255) NOT NULL,
  `apellido_materno` varchar(255) NOT NULL,
  `fecha_registro` datetime(6) NOT NULL,
  `curp` varchar(255) NOT NULL,
  `fecha_modificacion` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id`, `nombre`, `apellido_paterno`, `apellido_materno`, `fecha_registro`, `curp`, `fecha_modificacion`) VALUES
(1, 'Armando', 'Lopez', 'Gondar', '2024-07-15 12:46:43.000000', 'LOGA000321HDFPNRA6', '2024-07-16 09:45:53.000000'),
(4, 'Mauro', 'Varela', 'Garcia', '2024-07-16 09:47:54.000000', 'GAVM540516HJCRRR02', '2024-07-16 09:47:54.000000'),
(5, 'Agustin', 'Mendoza', 'Cisneros', '2024-07-16 09:48:47.000000', 'CIMA561206HSPSNG00', '2024-07-16 09:48:47.000000'),
(6, 'Anacleto', 'Tovar', 'Vazquez', '2024-07-16 09:49:23.000000', 'VATA540713HSPZVN06', '2024-07-16 09:49:23.000000'),
(7, 'Damian', 'Vazquez', 'Contreras', '2024-07-16 09:50:34.000000', 'COVD510819HSPNZM00', '2024-07-16 09:50:34.000000'),
(8, 'Catalina', 'Velasquez', 'Castro', '2024-07-16 09:51:22.000000', 'CAVC570405MSPSLT08', '2024-07-16 09:51:22.000000'),
(9, 'Luisa', 'Muñiz', 'Galavis', '2024-07-16 09:52:12.000000', 'GAML320621MSPLXS09', '2024-07-16 09:52:12.000000'),
(10, 'Tereso', 'Cortez', 'Lopez', '2024-07-16 09:52:45.000000', 'LOCT691015HSPPRR06', '2024-07-16 09:52:45.000000'),
(11, 'Felipe', 'Ruiz', 'Ciros', '2024-07-16 09:54:18.000000', 'CIRF610822HSPLZL05', '2024-07-16 09:54:18.000000'),
(12, 'Arturo', 'Garcia', 'Rodriguez', '2024-07-16 09:55:22.000000', 'ROGA441215HSPDRR02', '2024-07-16 09:55:22.000000');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK61iikbeit2s1auuwc28a131lx` (`curp`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
