-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-12-2025 a las 12:36:53
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
-- Base de datos: `bdinmobiliaria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alquileres`
--

CREATE TABLE `alquileres` (
  `numeroExpediente` varchar(50) NOT NULL,
  `fechaEntrada` date NOT NULL,
  `tiempoAlquiler` int(11) NOT NULL,
  `estadoCobro` varchar(50) DEFAULT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `id_vivienda` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alquileres`
--

INSERT INTO `alquileres` (`numeroExpediente`, `fechaEntrada`, `tiempoAlquiler`, `estadoCobro`, `id_cliente`, `id_vivienda`) VALUES
('EXP-001', '2024-01-10', 6, 'Pagado', 1, 1),
('EXP-002', '2024-02-01', 12, 'Pagado', 2, 2),
('EXP-003', '2024-03-15', 6, 'Pagado', 3, 3),
('EXP-004', '2024-05-20', 3, 'Pagado', 4, 4),
('EXP-005', '2024-07-01', 12, 'Pagado', 5, 5),
('EXP-006', '2024-08-15', 6, 'Atrasado', 1, 2),
('EXP-007', '2024-10-10', 4, 'Pagado', 2, 3),
('EXP-008', '2024-11-01', 12, 'Pagado', 3, 4),
('EXP-009', '2024-12-20', 6, 'Pendiente', 4, 5),
('EXP-010', '2025-01-15', 12, 'Pagado', 5, 1),
('EXP-011', '2025-02-01', 6, 'Atrasado', 1, 3),
('EXP-012', '2025-03-10', 12, 'Pendiente', 2, 4),
('EXP-013', '2025-04-05', 6, 'Pagado', 3, 5),
('EXP-014', '2025-05-20', 24, 'Pendiente', 4, 1),
('EXP-015', '2025-06-01', 12, 'Pagado', 5, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `dni` varchar(12) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `direccionFacturacion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `nombre`, `dni`, `telefono`, `email`, `direccionFacturacion`) VALUES
(1, 'Juan Pérez', '12345678A', '600111222', 'juan@email.com', 'Calle 1, Malaga'),
(2, 'María García', '23456789B', '611222333', 'maria@email.com', 'Calle 2, Sevilla'),
(3, 'Carlos Ruiz', '34567890C', '622333444', 'carlos@email.com', 'Calle 3, Cadiz'),
(4, 'Ana Martínez', '45678901D', '633444555', 'ana@email.com', 'Calle 4, Barcelona'),
(5, 'Luis Fernández', '56789012E', '644555666', 'luis@email.com', 'Calle 5, Madrid');

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_alquileres_completa`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_alquileres_completa` (
`numeroExpediente` varchar(50)
,`fechaEntrada` date
,`tiempoAlquiler` int(11)
,`estadoCobro` varchar(50)
,`id_cliente` int(11)
,`nombre` varchar(100)
,`dni` varchar(12)
,`telefono` varchar(20)
,`email` varchar(100)
,`direccionFacturacion` varchar(255)
,`id_vivienda` int(11)
,`metrosCuadrados` int(11)
,`direccion` varchar(255)
,`numeroHabitaciones` int(11)
,`numeroBanos` int(11)
,`precioMes` double
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `viviendas`
--

CREATE TABLE `viviendas` (
  `id` int(11) NOT NULL,
  `metrosCuadrados` int(11) DEFAULT NULL,
  `direccion` varchar(255) NOT NULL,
  `numeroHabitaciones` int(11) DEFAULT NULL,
  `numeroBanos` int(11) DEFAULT NULL,
  `precioMes` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `viviendas`
--

INSERT INTO `viviendas` (`id`, `metrosCuadrados`, `direccion`, `numeroHabitaciones`, `numeroBanos`, `precioMes`) VALUES
(1, 85, 'Calle 1, Barcelona', 3, 2, 950),
(2, 50, 'Calle 2, Sevilla', 1, 1, 550),
(3, 110, 'Calle 3, Barcelona', 4, 2, 1400),
(4, 70, 'Calle 4, Cadiz', 2, 1, 650),
(5, 150, 'Calle 5, Madrid', 5, 3, 2200);

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_alquileres_completa`
--
DROP TABLE IF EXISTS `vista_alquileres_completa`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_alquileres_completa`  AS SELECT `a`.`numeroExpediente` AS `numeroExpediente`, `a`.`fechaEntrada` AS `fechaEntrada`, `a`.`tiempoAlquiler` AS `tiempoAlquiler`, `a`.`estadoCobro` AS `estadoCobro`, `c`.`id` AS `id_cliente`, `c`.`nombre` AS `nombre`, `c`.`dni` AS `dni`, `c`.`telefono` AS `telefono`, `c`.`email` AS `email`, `c`.`direccionFacturacion` AS `direccionFacturacion`, `v`.`id` AS `id_vivienda`, `v`.`metrosCuadrados` AS `metrosCuadrados`, `v`.`direccion` AS `direccion`, `v`.`numeroHabitaciones` AS `numeroHabitaciones`, `v`.`numeroBanos` AS `numeroBanos`, `v`.`precioMes` AS `precioMes` FROM ((`alquileres` `a` join `clientes` `c` on(`a`.`id_cliente` = `c`.`id`)) join `viviendas` `v` on(`a`.`id_vivienda` = `v`.`id`)) ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alquileres`
--
ALTER TABLE `alquileres`
  ADD PRIMARY KEY (`numeroExpediente`),
  ADD KEY `fk_cliente_alquiler` (`id_cliente`),
  ADD KEY `fk_vivienda_alquiler` (`id_vivienda`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `viviendas`
--
ALTER TABLE `viviendas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `viviendas`
--
ALTER TABLE `viviendas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alquileres`
--
ALTER TABLE `alquileres`
  ADD CONSTRAINT `fk_cliente_alquiler` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`),
  ADD CONSTRAINT `fk_vivienda_alquiler` FOREIGN KEY (`id_vivienda`) REFERENCES `viviendas` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
