-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.19-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para agente_a
CREATE DATABASE IF NOT EXISTS `agente_a` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `agente_a`;

-- Volcando estructura para tabla agente_a.alimentacion
CREATE TABLE IF NOT EXISTS `alimentacion` (
  `codigo_alimentacion` int(11) NOT NULL AUTO_INCREMENT,
  `consumo_diario_ppp` double DEFAULT '0',
  `conversion_kg_huevo` double DEFAULT '0',
  `conversion_docena_huevos` double DEFAULT '0',
  `codigo_registro_ponedoras_fk1` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_alimentacion`),
  KEY `FK_alimentacion_registro_semanal_ponedoras` (`codigo_registro_ponedoras_fk1`),
  CONSTRAINT `FK_alimentacion_registro_semanal_ponedoras` FOREIGN KEY (`codigo_registro_ponedoras_fk1`) REFERENCES `registro_semanal_ponedoras` (`codigo_registro_ponedoras`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='codigo_alimentacion no es auto increment por que cada alimento puede tener un alimento con id';

-- Volcando datos para la tabla agente_a.alimentacion: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `alimentacion` DISABLE KEYS */;
INSERT INTO `alimentacion` (`codigo_alimentacion`, `consumo_diario_ppp`, `conversion_kg_huevo`, `conversion_docena_huevos`, `codigo_registro_ponedoras_fk1`) VALUES
	(1, 0.142857142, 0.5, NULL, 1);
/*!40000 ALTER TABLE `alimentacion` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.asignacion_lote_engorde
CREATE TABLE IF NOT EXISTS `asignacion_lote_engorde` (
  `codigo_asignacion_engorde` int(11) NOT NULL,
  `numero_lote_engorde` int(11) DEFAULT NULL,
  `codigo_usuario` int(11) DEFAULT NULL,
  `fecha_asignacion` date DEFAULT NULL,
  `estado_asignacion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo_asignacion_engorde`),
  KEY `FK_asignacion_lote_engorde_lote_engorde` (`numero_lote_engorde`),
  KEY `FK_asignacion_lote_engorde_usuario` (`codigo_usuario`),
  CONSTRAINT `FK_asignacion_lote_engorde_lote_engorde` FOREIGN KEY (`numero_lote_engorde`) REFERENCES `lote_engorde` (`numero_lote_engorde`) ON UPDATE CASCADE,
  CONSTRAINT `FK_asignacion_lote_engorde_usuario` FOREIGN KEY (`codigo_usuario`) REFERENCES `usuario` (`codigo_usuario`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.asignacion_lote_engorde: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `asignacion_lote_engorde` DISABLE KEYS */;
/*!40000 ALTER TABLE `asignacion_lote_engorde` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.asignacion_lote_levante
CREATE TABLE IF NOT EXISTS `asignacion_lote_levante` (
  `codigo_asignacion_levante` int(11) NOT NULL,
  `numero_lote` int(11) DEFAULT NULL,
  `codigo_usuario` int(11) DEFAULT NULL,
  `fecha_asignacion` date DEFAULT NULL,
  `estado_asignacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_asignacion_levante`),
  KEY `numero_lote` (`numero_lote`),
  KEY `codigo_usuario1` (`codigo_usuario`),
  CONSTRAINT `FK__lote_levante` FOREIGN KEY (`numero_lote`) REFERENCES `lote_levante` (`numero_lote`) ON UPDATE CASCADE,
  CONSTRAINT `FK_asignacion_lote_levante_usuario` FOREIGN KEY (`codigo_usuario`) REFERENCES `usuario` (`codigo_usuario`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.asignacion_lote_levante: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `asignacion_lote_levante` DISABLE KEYS */;
/*!40000 ALTER TABLE `asignacion_lote_levante` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.asignacion_lote_ponedoras
CREATE TABLE IF NOT EXISTS `asignacion_lote_ponedoras` (
  `codigo_asignacion_ponedoras` int(11) NOT NULL AUTO_INCREMENT,
  `numero_lote_ponedoras_fk` int(11) NOT NULL DEFAULT '0',
  `codigo_usuario_fk` int(11) NOT NULL DEFAULT '0',
  `fecha_asignacion` date NOT NULL,
  PRIMARY KEY (`codigo_asignacion_ponedoras`),
  KEY `numero_lote_ponedoras_fk` (`numero_lote_ponedoras_fk`),
  KEY `codigo_usuario_fk` (`codigo_usuario_fk`),
  CONSTRAINT `codigo_usuario_fk` FOREIGN KEY (`codigo_usuario_fk`) REFERENCES `usuario` (`codigo_usuario`) ON UPDATE CASCADE,
  CONSTRAINT `numero_lote_ponedoras_fk` FOREIGN KEY (`numero_lote_ponedoras_fk`) REFERENCES `lote_ponedoras` (`numero_lote_ponedoras`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.asignacion_lote_ponedoras: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `asignacion_lote_ponedoras` DISABLE KEYS */;
/*!40000 ALTER TABLE `asignacion_lote_ponedoras` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.bajas_muertes_diario_engorde_
CREATE TABLE IF NOT EXISTS `bajas_muertes_diario_engorde_` (
  `codigo_bajas_muertes` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad_bajas_muertes` int(11) DEFAULT NULL,
  `fecha_registro_bajas` date DEFAULT NULL,
  `hora_registro_bajas` time DEFAULT NULL,
  `codigo_usuario_fk` int(11) DEFAULT NULL,
  `codigo_registro_engorde` int(11) DEFAULT NULL,
  `observaciones_bajas` text,
  PRIMARY KEY (`codigo_bajas_muertes`),
  KEY `FK_bajas_muertes_diario_engorde__usuario` (`codigo_usuario_fk`),
  KEY `FK_bajas_muertes_diario_engorde__registro_semanal_engorde` (`codigo_registro_engorde`),
  CONSTRAINT `FK_bajas_muertes_diario_engorde__registro_semanal_engorde` FOREIGN KEY (`codigo_registro_engorde`) REFERENCES `registro_semanal_engorde` (`codigo_registro_engorde`) ON UPDATE CASCADE,
  CONSTRAINT `FK_bajas_muertes_diario_engorde__usuario` FOREIGN KEY (`codigo_usuario_fk`) REFERENCES `usuario` (`codigo_usuario`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.bajas_muertes_diario_engorde_: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `bajas_muertes_diario_engorde_` DISABLE KEYS */;
/*!40000 ALTER TABLE `bajas_muertes_diario_engorde_` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.bajas_muertes_diario_levante
CREATE TABLE IF NOT EXISTS `bajas_muertes_diario_levante` (
  `codigo_bajas_muerte` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad_bajas_muerte` int(11) DEFAULT NULL,
  `fecha_registro_bajas` date DEFAULT NULL,
  `horas_registro_bajas` time DEFAULT NULL,
  `codigo_usuario_fk` int(11) DEFAULT NULL,
  `codigo_registro_levante_fk` int(11) DEFAULT NULL,
  `observaciones_bajas` text,
  PRIMARY KEY (`codigo_bajas_muerte`),
  KEY `FK__usuario` (`codigo_usuario_fk`),
  KEY `FK_bajas_muertes_diario_levante_registro_semanal_levante` (`codigo_registro_levante_fk`),
  CONSTRAINT `FK__usuario` FOREIGN KEY (`codigo_usuario_fk`) REFERENCES `usuario` (`codigo_usuario`) ON UPDATE CASCADE,
  CONSTRAINT `FK_bajas_muertes_diario_levante_registro_semanal_levante` FOREIGN KEY (`codigo_registro_levante_fk`) REFERENCES `registro_semanal_levante` (`codigo_registro_levante`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.bajas_muertes_diario_levante: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `bajas_muertes_diario_levante` DISABLE KEYS */;
/*!40000 ALTER TABLE `bajas_muertes_diario_levante` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.clasificacion_huevos
CREATE TABLE IF NOT EXISTS `clasificacion_huevos` (
  `codigo_clasificacion` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_reportes_huevos_fk` int(11) DEFAULT NULL,
  `tipo_huevos` varchar(50) DEFAULT NULL,
  `cantidad_huevos` int(11) DEFAULT NULL,
  `porcentaje_huevos` double DEFAULT NULL,
  `valor_unitario_huevos` int(11) DEFAULT NULL,
  `valor_total_huevos` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_clasificacion`),
  KEY `FK_clasificacion_huevos_reporte_huevos` (`codigo_reportes_huevos_fk`),
  CONSTRAINT `FK_clasificacion_huevos_reporte_huevos` FOREIGN KEY (`codigo_reportes_huevos_fk`) REFERENCES `reporte_huevos` (`codigo_reporte_huevos`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.clasificacion_huevos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `clasificacion_huevos` DISABLE KEYS */;
INSERT INTO `clasificacion_huevos` (`codigo_clasificacion`, `codigo_reportes_huevos_fk`, `tipo_huevos`, `cantidad_huevos`, `porcentaje_huevos`, `valor_unitario_huevos`, `valor_total_huevos`) VALUES
	(1, 1, NULL, NULL, NULL, 9, 50000000);
/*!40000 ALTER TABLE `clasificacion_huevos` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.consumo_alimento_diario_engorde
CREATE TABLE IF NOT EXISTS `consumo_alimento_diario_engorde` (
  `codigo_consumo_alimento` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad_alimento` double DEFAULT NULL,
  `fecha_registro` date DEFAULT NULL,
  `hora_registro_alimento` time DEFAULT NULL,
  `codigo_usuario_fk` int(11) DEFAULT NULL,
  `codigo_registro_engorde_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_consumo_alimento`),
  KEY `FK_consumo_alimento_diario_engorde_usuario` (`codigo_usuario_fk`),
  KEY `FK_consumo_alimento_diario_engorde_registro_semanal_engorde` (`codigo_registro_engorde_fk`),
  CONSTRAINT `FK_consumo_alimento_diario_engorde_registro_semanal_engorde` FOREIGN KEY (`codigo_registro_engorde_fk`) REFERENCES `registro_semanal_engorde` (`codigo_registro_engorde`) ON UPDATE CASCADE,
  CONSTRAINT `FK_consumo_alimento_diario_engorde_usuario` FOREIGN KEY (`codigo_usuario_fk`) REFERENCES `usuario` (`codigo_usuario`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.consumo_alimento_diario_engorde: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `consumo_alimento_diario_engorde` DISABLE KEYS */;
/*!40000 ALTER TABLE `consumo_alimento_diario_engorde` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.consumo_alimento_diario_levante
CREATE TABLE IF NOT EXISTS `consumo_alimento_diario_levante` (
  `codigo_consumo_alimento` int(11) NOT NULL DEFAULT '0',
  `cantidad_alimento` int(11) DEFAULT NULL,
  `fecha_registro_alimento` date DEFAULT NULL,
  `hora_registro_consumo` time DEFAULT NULL,
  `codigo_usuario_fk` int(11) DEFAULT NULL,
  `codigo_registro_levante_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_consumo_alimento`),
  KEY `FK_consumo_alimento_diario_levante_usuario` (`codigo_usuario_fk`),
  KEY `FK_consumo_alimento_diario_levante_registro_semanal_levante` (`codigo_registro_levante_fk`),
  CONSTRAINT `FK_consumo_alimento_diario_levante_registro_semanal_levante` FOREIGN KEY (`codigo_registro_levante_fk`) REFERENCES `registro_semanal_levante` (`codigo_registro_levante`) ON UPDATE CASCADE,
  CONSTRAINT `FK_consumo_alimento_diario_levante_usuario` FOREIGN KEY (`codigo_usuario_fk`) REFERENCES `usuario` (`codigo_usuario`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.consumo_alimento_diario_levante: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `consumo_alimento_diario_levante` DISABLE KEYS */;
/*!40000 ALTER TABLE `consumo_alimento_diario_levante` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.costos_variables_lote_engorde
CREATE TABLE IF NOT EXISTS `costos_variables_lote_engorde` (
  `codigo_costo_variable` int(11) NOT NULL,
  `numero_lote_engorde` int(11) NOT NULL,
  `cantidad_costo_variable` int(11) DEFAULT NULL,
  `valor_unitario_costo` int(11) DEFAULT NULL,
  `total_costo_variable` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_costo_variable`,`numero_lote_engorde`),
  KEY `FK_costos_variables_lote_engorde_lote_engorde` (`numero_lote_engorde`),
  CONSTRAINT `FK_costos_variables_lote_engorde_costo_variable` FOREIGN KEY (`codigo_costo_variable`) REFERENCES `costo_variable` (`codigo_cossto_variable`) ON UPDATE CASCADE,
  CONSTRAINT `FK_costos_variables_lote_engorde_lote_engorde` FOREIGN KEY (`numero_lote_engorde`) REFERENCES `lote_engorde` (`numero_lote_engorde`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.costos_variables_lote_engorde: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `costos_variables_lote_engorde` DISABLE KEYS */;
/*!40000 ALTER TABLE `costos_variables_lote_engorde` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.costos_variables_lote_levante
CREATE TABLE IF NOT EXISTS `costos_variables_lote_levante` (
  `codigo_costo_varieble` int(11) NOT NULL DEFAULT '0',
  `numero_lote` int(11) NOT NULL DEFAULT '0',
  `cantidad_costo_variable` int(11) DEFAULT NULL,
  `valor_unitario_costo` int(11) DEFAULT NULL,
  `total_costo_variable` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_costo_varieble`,`numero_lote`),
  KEY `FK_costos_variables_lote_levante_lote_levante` (`numero_lote`),
  CONSTRAINT `FK_costos_variables_lote_levante_costo_variable` FOREIGN KEY (`codigo_costo_varieble`) REFERENCES `costo_variable` (`codigo_cossto_variable`) ON UPDATE CASCADE,
  CONSTRAINT `FK_costos_variables_lote_levante_lote_levante` FOREIGN KEY (`numero_lote`) REFERENCES `lote_levante` (`numero_lote`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.costos_variables_lote_levante: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `costos_variables_lote_levante` DISABLE KEYS */;
/*!40000 ALTER TABLE `costos_variables_lote_levante` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.costo_variable
CREATE TABLE IF NOT EXISTS `costo_variable` (
  `codigo_cossto_variable` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_costo_variable` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo_cossto_variable`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.costo_variable: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `costo_variable` DISABLE KEYS */;
/*!40000 ALTER TABLE `costo_variable` ENABLE KEYS */;

-- Volcando estructura para procedimiento agente_a.Creacion_campos
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `Creacion_campos`()
BEGIN
insert INTO registro_semanal_ponedoras (registro_semanal_ponedoras.semana_produccion_registro,
registro_semanal_ponedoras.numero_ponedoras_inicial,
registro_semanal_ponedoras.numero_ponedoras_terminar,
registro_semanal_ponedoras.total_huevos_semana,
registro_semanal_ponedoras.total_huevos_segunda_semana,
registro_semanal_ponedoras.total_kg_semana,
registro_semanal_ponedoras.total_mortalidad_semana,
registro_semanal_ponedoras.total_desecho_semana) values
(null,null,null,null,null,null,null,null);

insert into alimentacion (alimentacion.consumo_diario_ppp,
alimentacion.conversion_kg_huevo,
alimentacion.conversion_docena_huevos,
alimentacion.codigo_registro_ponedoras_fk1) values
(null,null,null,null);

insert into clasificacion_huevos (clasificacion_huevos.codigo_reportes_huevos_fk,
clasificacion_huevos.tipo_huevos,
clasificacion_huevos.cantidad_huevos,
clasificacion_huevos.porcentaje_huevos,
clasificacion_huevos.valor_unitario_huevos,
clasificacion_huevos.valor_total_huevos,
clasificacion_huevos.cantidad_huevos_rotos) values
(null,null,null,null,null,null,null);

insert into reporte_huevos (reporte_huevos.numero_pesados_huevos,
reporte_huevos.peso_total_huevos,
reporte_huevos.peso_panales_huevos,
reporte_huevos.peso_huevos,
reporte_huevos.peso_promedio_huevos,
reporte_huevos.codigo_registro_diario_ponedoras_fk) values
(null,null,null,null,null,null);

insert into produccion (produccion.numero_ponedoras_presente_promedio,
produccion.porcentaje_mortalidad,
produccion.numero_huevos_ppe,
produccion.kg_huevos_ppe,
produccion.peso_promedio_x_huevos,
produccion.porcentaje_postura,
produccion.docena_huevos,
produccion.codigo_registro_ponedoras_fk) values
(null,null,null,null,null,null,null,null);

insert into economia (economia.precio_alimento_kg,
economia.costo_alimentacion_total,
economia.costo_alimentacion_huevos,
economia.valor_huevos,
economia.valor_huevos_costo,
economia.otros_ingresos,
economia.otros_costos_directos,
economia.codigo_registro_ponedoras_fk) values
(null,null,null,null,null,null,null,null);
END//
DELIMITER ;

-- Volcando estructura para tabla agente_a.economia
CREATE TABLE IF NOT EXISTS `economia` (
  `codigo_economia` int(11) NOT NULL AUTO_INCREMENT,
  `precio_alimento_kg` int(11) DEFAULT '0',
  `costo_alimentacion_total` int(11) DEFAULT '0',
  `costo_alimentacion_huevos` int(11) DEFAULT '0',
  `valor_huevos` int(11) DEFAULT '0',
  `valor_huevos_costo` int(11) DEFAULT '0',
  `otros_ingresos` int(11) DEFAULT '0',
  `otros_costos_directos` int(11) DEFAULT '0',
  `codigo_registro_ponedoras_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_economia`),
  KEY `FK_economia_registro_semanal_ponedoras` (`codigo_registro_ponedoras_fk`),
  CONSTRAINT `FK_economia_registro_semanal_ponedoras` FOREIGN KEY (`codigo_registro_ponedoras_fk`) REFERENCES `registro_semanal_ponedoras` (`codigo_registro_ponedoras`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.economia: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `economia` DISABLE KEYS */;
INSERT INTO `economia` (`codigo_economia`, `precio_alimento_kg`, `costo_alimentacion_total`, `costo_alimentacion_huevos`, `valor_huevos`, `valor_huevos_costo`, `otros_ingresos`, `otros_costos_directos`, `codigo_registro_ponedoras_fk`) VALUES
	(1, 10000, 50000, 12500, 50000000, -49970, NULL, NULL, 1),
	(2, 0, 0, 0, 0, 0, 0, 0, NULL);
/*!40000 ALTER TABLE `economia` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.enfermedad
CREATE TABLE IF NOT EXISTS `enfermedad` (
  `codigo_enfermedad` int(11) NOT NULL,
  `nombre_enfermedad` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo_enfermedad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.enfermedad: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `enfermedad` DISABLE KEYS */;
/*!40000 ALTER TABLE `enfermedad` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.enfermedades_vacuna
CREATE TABLE IF NOT EXISTS `enfermedades_vacuna` (
  `codigo_vacuna` int(11) NOT NULL,
  `codigo_enfermedad` int(11) NOT NULL,
  PRIMARY KEY (`codigo_vacuna`,`codigo_enfermedad`),
  KEY `FK_enfermedades_vacuna_enfermedad` (`codigo_enfermedad`),
  CONSTRAINT `FK_enfermedades_vacuna_enfermedad` FOREIGN KEY (`codigo_enfermedad`) REFERENCES `enfermedad` (`codigo_enfermedad`) ON UPDATE CASCADE,
  CONSTRAINT `FK_enfermedades_vacuna_vacuna` FOREIGN KEY (`codigo_vacuna`) REFERENCES `vacuna` (`codigo_vacuna`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.enfermedades_vacuna: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `enfermedades_vacuna` DISABLE KEYS */;
/*!40000 ALTER TABLE `enfermedades_vacuna` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.galpon
CREATE TABLE IF NOT EXISTS `galpon` (
  `numero_galpon` int(11) NOT NULL DEFAULT '0',
  `estado_galpon` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`numero_galpon`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.galpon: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `galpon` DISABLE KEYS */;
INSERT INTO `galpon` (`numero_galpon`, `estado_galpon`) VALUES
	(1, 'Ocupado');
/*!40000 ALTER TABLE `galpon` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.guia_vacunacion_lote_engorde
CREATE TABLE IF NOT EXISTS `guia_vacunacion_lote_engorde` (
  `codigo_guia_vacuna` int(11) NOT NULL DEFAULT '0',
  `edad_guia_vacunacion` int(11) DEFAULT NULL,
  `fecha_prevista_vacunacion` date DEFAULT NULL,
  `fecha_real_vacunacion` date DEFAULT NULL,
  `cantidad_vacunacion` double DEFAULT NULL,
  `costo_vacunacion` int(11) DEFAULT NULL,
  `numero_lote_engorde_fk` int(11) DEFAULT NULL,
  `codigo_vacuna_fk` int(11) DEFAULT NULL,
  `codigo_usuario_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_guia_vacuna`),
  KEY `FK_guia_vacunacion_lote_engorde_lote_engorde` (`numero_lote_engorde_fk`),
  KEY `FK_guia_vacunacion_lote_engorde_vacuna` (`codigo_vacuna_fk`),
  KEY `FK_guia_vacunacion_lote_engorde_usuario` (`codigo_usuario_fk`),
  CONSTRAINT `FK_guia_vacunacion_lote_engorde_lote_engorde` FOREIGN KEY (`numero_lote_engorde_fk`) REFERENCES `lote_engorde` (`numero_lote_engorde`) ON UPDATE CASCADE,
  CONSTRAINT `FK_guia_vacunacion_lote_engorde_usuario` FOREIGN KEY (`codigo_usuario_fk`) REFERENCES `usuario` (`codigo_usuario`) ON UPDATE CASCADE,
  CONSTRAINT `FK_guia_vacunacion_lote_engorde_vacuna` FOREIGN KEY (`codigo_vacuna_fk`) REFERENCES `vacuna` (`codigo_vacuna`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.guia_vacunacion_lote_engorde: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `guia_vacunacion_lote_engorde` DISABLE KEYS */;
/*!40000 ALTER TABLE `guia_vacunacion_lote_engorde` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.guia_vacunacion_lote_levante
CREATE TABLE IF NOT EXISTS `guia_vacunacion_lote_levante` (
  `codigo_guia_vacunacion` int(11) NOT NULL DEFAULT '0',
  `edad_guia_vacunacion` int(11) DEFAULT NULL,
  `fecha_prevista_vacunacion` date DEFAULT NULL,
  `fecha_real_vacunacion` date DEFAULT NULL,
  `cantidad_vacunacion` double DEFAULT NULL,
  `costo_vacunacion` int(11) DEFAULT NULL,
  `numero_lote_fk` int(11) DEFAULT NULL,
  `codigo_vacuna_fk` int(11) DEFAULT NULL,
  `codigo_usuario_fk` int(11) DEFAULT NULL,
  `codigo_enfermedad` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_guia_vacunacion`),
  KEY `FK_guia_vacunacion_lote_levante_lote_levante` (`numero_lote_fk`),
  KEY `FK_guia_vacunacion_lote_levante_vacuna` (`codigo_vacuna_fk`),
  KEY `FK_guia_vacunacion_lote_levante_usuario` (`codigo_usuario_fk`),
  KEY `FK_guia_vacunacion_lote_levante_enfermedad` (`codigo_enfermedad`),
  CONSTRAINT `FK_guia_vacunacion_lote_levante_enfermedad` FOREIGN KEY (`codigo_enfermedad`) REFERENCES `enfermedad` (`codigo_enfermedad`),
  CONSTRAINT `FK_guia_vacunacion_lote_levante_lote_levante` FOREIGN KEY (`numero_lote_fk`) REFERENCES `lote_levante` (`numero_lote`) ON UPDATE CASCADE,
  CONSTRAINT `FK_guia_vacunacion_lote_levante_usuario` FOREIGN KEY (`codigo_usuario_fk`) REFERENCES `usuario` (`codigo_usuario`) ON UPDATE CASCADE,
  CONSTRAINT `FK_guia_vacunacion_lote_levante_vacuna` FOREIGN KEY (`codigo_vacuna_fk`) REFERENCES `vacuna` (`codigo_vacuna`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.guia_vacunacion_lote_levante: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `guia_vacunacion_lote_levante` DISABLE KEYS */;
/*!40000 ALTER TABLE `guia_vacunacion_lote_levante` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.guia_vacunacion_lote_ponedoras
CREATE TABLE IF NOT EXISTS `guia_vacunacion_lote_ponedoras` (
  `codigo_guia_vacunacion` int(11) NOT NULL DEFAULT '0',
  `edad_guia_vacunacion` int(11) DEFAULT NULL,
  `fecha_real_vacunacion` date DEFAULT NULL,
  `cantidad_vacunacion` int(11) DEFAULT NULL,
  `costo_vacunacion` int(11) DEFAULT NULL,
  `codigo_vacuna_fk` int(11) DEFAULT NULL,
  `codigo_usuario_fk` int(11) DEFAULT NULL,
  `numero_lote_ponedoras_fk2` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_guia_vacunacion`),
  KEY `FK_guia_vacunacion_lote_ponedoras_1_usuario` (`codigo_usuario_fk`),
  KEY `FK_guia_vacunacion_lote_ponedoras_1_vacuna` (`codigo_vacuna_fk`),
  KEY `FK_guia_vacunacion_lote_ponedoras_1_lote_ponedoras` (`numero_lote_ponedoras_fk2`),
  CONSTRAINT `FK_guia_vacunacion_lote_ponedoras_1_lote_ponedoras` FOREIGN KEY (`numero_lote_ponedoras_fk2`) REFERENCES `lote_ponedoras` (`numero_lote_ponedoras`) ON UPDATE CASCADE,
  CONSTRAINT `FK_guia_vacunacion_lote_ponedoras_1_usuario` FOREIGN KEY (`codigo_usuario_fk`) REFERENCES `usuario` (`codigo_usuario`) ON UPDATE CASCADE,
  CONSTRAINT `FK_guia_vacunacion_lote_ponedoras_1_vacuna` FOREIGN KEY (`codigo_vacuna_fk`) REFERENCES `vacuna` (`codigo_vacuna`) ON UPDATE CASCADE,
  CONSTRAINT `FK_guia_vacunacion_lote_ponedoras_lote_ponedoras` FOREIGN KEY (`numero_lote_ponedoras_fk2`) REFERENCES `lote_ponedoras` (`numero_lote_ponedoras`) ON UPDATE CASCADE,
  CONSTRAINT `FK_guia_vacunacion_lote_ponedoras_usuario` FOREIGN KEY (`codigo_usuario_fk`) REFERENCES `usuario` (`codigo_usuario`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.guia_vacunacion_lote_ponedoras: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `guia_vacunacion_lote_ponedoras` DISABLE KEYS */;
/*!40000 ALTER TABLE `guia_vacunacion_lote_ponedoras` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.lote_engorde
CREATE TABLE IF NOT EXISTS `lote_engorde` (
  `numero_lote_engorde` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_lote_engorde` varchar(50) NOT NULL,
  `numero_galpon_fk` int(11) DEFAULT NULL,
  `fecha_nacimiento_lote_engorde` date DEFAULT NULL,
  `codigo_raza_fk` int(11) DEFAULT NULL,
  `densidad_lote_engorde` int(11) DEFAULT NULL,
  `numero_inicial_engorde` int(11) DEFAULT NULL,
  `peso_inicial_engorde` double DEFAULT NULL,
  `total_peso_promedio_engorde` double DEFAULT NULL,
  `numero_final_engorde` int(11) DEFAULT NULL,
  `total_venta_canal` int(11) DEFAULT NULL,
  `total_venta_vivo` int(11) DEFAULT NULL,
  `peso_venta_vivo` double DEFAULT NULL,
  `peso_venta_canal` double DEFAULT NULL,
  PRIMARY KEY (`numero_lote_engorde`),
  KEY `FK_lote_engorde_galpo` (`numero_galpon_fk`),
  KEY `FK_lote_engorde_raza` (`codigo_raza_fk`),
  CONSTRAINT `FK_lote_engorde_galpo` FOREIGN KEY (`numero_galpon_fk`) REFERENCES `galpon` (`numero_galpon`) ON UPDATE CASCADE,
  CONSTRAINT `FK_lote_engorde_raza` FOREIGN KEY (`codigo_raza_fk`) REFERENCES `raza` (`codigo_raza`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.lote_engorde: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `lote_engorde` DISABLE KEYS */;
/*!40000 ALTER TABLE `lote_engorde` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.lote_levante
CREATE TABLE IF NOT EXISTS `lote_levante` (
  `numero_lote` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_lote_levante` varchar(50) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `numero_galpon_fk` int(11) DEFAULT NULL,
  `numero_pollas_final_lote` int(11) DEFAULT NULL,
  `porcentaje_mortalidad_lote_levante` double DEFAULT NULL,
  `costo_total_sanidad_lote` int(11) DEFAULT NULL,
  `total_costo_variable_lote` int(11) DEFAULT NULL,
  `codigo_raza_fk` int(11) DEFAULT NULL,
  `numero_pollas_iniciar_lote` int(11) DEFAULT NULL,
  `peso_promedio_lote_levante` double DEFAULT NULL,
  PRIMARY KEY (`numero_lote`),
  KEY `FK_lote_levante_galpo` (`numero_galpon_fk`),
  KEY `FK_lote_levante_raza` (`codigo_raza_fk`),
  CONSTRAINT `FK_lote_levante_galpo` FOREIGN KEY (`numero_galpon_fk`) REFERENCES `galpon` (`numero_galpon`) ON UPDATE CASCADE,
  CONSTRAINT `FK_lote_levante_raza` FOREIGN KEY (`codigo_raza_fk`) REFERENCES `raza` (`codigo_raza`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.lote_levante: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `lote_levante` DISABLE KEYS */;
/*!40000 ALTER TABLE `lote_levante` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.lote_ponedoras
CREATE TABLE IF NOT EXISTS `lote_ponedoras` (
  `numero_lote_ponedoras` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_lote_ponedoras` varchar(50) NOT NULL,
  `numero_galpon_fk` int(11) DEFAULT NULL,
  `codigo_raza_fk` int(11) DEFAULT NULL,
  `edad_semanas_lote_ponedoras` int(11) DEFAULT NULL,
  `fecha_inicio_lote_ponedoras` date DEFAULT NULL,
  `numero_ponedoras_encasetadas` int(11) DEFAULT '0',
  `numero_lote_fk` int(11) DEFAULT NULL,
  `comienzo_postura_ponedoras` int(11) DEFAULT '0',
  `semana_comienzo` int(11) DEFAULT '0',
  `total_huevos_lote` int(11) DEFAULT '0',
  `total_huevos_segundo_lote` int(11) DEFAULT '0',
  `total_kg_alimento` double DEFAULT '0',
  `total_mortalidad_lote` int(11) DEFAULT '0',
  `total_desecho_lote` int(11) DEFAULT '0',
  `codigo_produccion_fk` int(11) DEFAULT NULL,
  `codigo_alimentacion_fk` int(11) DEFAULT NULL,
  `codigo_economia_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`numero_lote_ponedoras`),
  KEY `FK_lote_ponedoras_galpon` (`numero_galpon_fk`),
  KEY `FK_lote_ponedoras_raza` (`codigo_raza_fk`),
  KEY `FK_lote_ponedoras_lote_levante` (`numero_lote_fk`),
  KEY `FK_lote_ponedoras_produccion` (`codigo_produccion_fk`),
  KEY `FK_lote_ponedoras_alimentacion` (`codigo_alimentacion_fk`),
  KEY `FK_lote_ponedoras_economia` (`codigo_economia_fk`),
  CONSTRAINT `FK_lote_ponedoras_alimentacion` FOREIGN KEY (`codigo_alimentacion_fk`) REFERENCES `alimentacion` (`codigo_alimentacion`) ON UPDATE CASCADE,
  CONSTRAINT `FK_lote_ponedoras_economia` FOREIGN KEY (`codigo_economia_fk`) REFERENCES `economia` (`codigo_economia`) ON UPDATE CASCADE,
  CONSTRAINT `FK_lote_ponedoras_galpon` FOREIGN KEY (`numero_galpon_fk`) REFERENCES `galpon` (`numero_galpon`) ON UPDATE CASCADE,
  CONSTRAINT `FK_lote_ponedoras_lote_levante` FOREIGN KEY (`numero_lote_fk`) REFERENCES `lote_levante` (`numero_lote`) ON UPDATE CASCADE,
  CONSTRAINT `FK_lote_ponedoras_produccion` FOREIGN KEY (`codigo_produccion_fk`) REFERENCES `produccion` (`codigo_produccion`) ON UPDATE CASCADE,
  CONSTRAINT `FK_lote_ponedoras_raza` FOREIGN KEY (`codigo_raza_fk`) REFERENCES `raza` (`codigo_raza`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.lote_ponedoras: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `lote_ponedoras` DISABLE KEYS */;
INSERT INTO `lote_ponedoras` (`numero_lote_ponedoras`, `codigo_lote_ponedoras`, `numero_galpon_fk`, `codigo_raza_fk`, `edad_semanas_lote_ponedoras`, `fecha_inicio_lote_ponedoras`, `numero_ponedoras_encasetadas`, `numero_lote_fk`, `comienzo_postura_ponedoras`, `semana_comienzo`, `total_huevos_lote`, `total_huevos_segundo_lote`, `total_kg_alimento`, `total_mortalidad_lote`, `total_desecho_lote`, `codigo_produccion_fk`, `codigo_alimentacion_fk`, `codigo_economia_fk`) VALUES
	(1, '', 1, NULL, 12, '2017-03-04', 1, NULL, 1, 1, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL),
	(2, '', NULL, NULL, NULL, '2017-03-05', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(3, '', NULL, NULL, NULL, '2017-03-05', 0, NULL, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL),
	(4, '', 1, NULL, NULL, NULL, 0, NULL, 0, 0, 15, 8, 0, 0, 0, NULL, NULL, NULL),
	(5, '', 1, NULL, NULL, NULL, 0, NULL, 0, 0, 2, 15, 2, 13, 2, NULL, NULL, NULL);
/*!40000 ALTER TABLE `lote_ponedoras` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.produccion
CREATE TABLE IF NOT EXISTS `produccion` (
  `codigo_produccion` int(11) NOT NULL AUTO_INCREMENT,
  `numero_ponedoras_presente_promedio` int(11) DEFAULT '0',
  `porcentaje_mortalidad` double DEFAULT '0',
  `numero_huevos_ppe` double DEFAULT '0',
  `kg_huevos_ppe` double DEFAULT '0',
  `peso_promedio_x_huevos` double DEFAULT '0',
  `porcentaje_postura` double DEFAULT '0',
  `docena_huevos` double DEFAULT '0',
  `codigo_registro_ponedoras_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_produccion`),
  KEY `FK__registro_semanal_ponedoras` (`codigo_registro_ponedoras_fk`),
  CONSTRAINT `FK__registro_semanal_ponedoras` FOREIGN KEY (`codigo_registro_ponedoras_fk`) REFERENCES `registro_semanal_ponedoras` (`codigo_registro_ponedoras`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.produccion: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `produccion` DISABLE KEYS */;
INSERT INTO `produccion` (`codigo_produccion`, `numero_ponedoras_presente_promedio`, `porcentaje_mortalidad`, `numero_huevos_ppe`, `kg_huevos_ppe`, `peso_promedio_x_huevos`, `porcentaje_postura`, `docena_huevos`, `codigo_registro_ponedoras_fk`) VALUES
	(1, 5, 1000, 0.714285714, 1.4285714285714286, 2, 14.2857142, 0.416666666, 1),
	(2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2),
	(3, 0, 0, 0, 0, 0, 0, 0, 3),
	(5, 5, 1800, 0.285714285, 0.2857142857142857, 1, 5.7142857, 0, 5);
/*!40000 ALTER TABLE `produccion` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.programa
CREATE TABLE IF NOT EXISTS `programa` (
  `codigo_programa` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_programa` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo_programa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.programa: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `programa` DISABLE KEYS */;
/*!40000 ALTER TABLE `programa` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.raza
CREATE TABLE IF NOT EXISTS `raza` (
  `codigo_raza` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_raza` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo_raza`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.raza: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `raza` DISABLE KEYS */;
INSERT INTO `raza` (`codigo_raza`, `nombre_raza`) VALUES
	(1, 'prueba');
/*!40000 ALTER TABLE `raza` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.registro_diario_ponedoras
CREATE TABLE IF NOT EXISTS `registro_diario_ponedoras` (
  `codigo_registro_diario_ponedoraas` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_registro_diario` date DEFAULT NULL,
  `total_huevos_segunda_clase_registro` int(11) unsigned DEFAULT '0',
  `total_huevos_registro` int(11) unsigned DEFAULT '0',
  `kg_alimento_registro` double unsigned DEFAULT '0',
  `codigo_tipo_alimento_fk` int(11) DEFAULT NULL,
  `cantidad_mortalidad_registro` int(11) unsigned DEFAULT '0',
  `cantidad_desecho_registro` int(11) unsigned DEFAULT '0',
  `observaciones_registro` text,
  `codigo_registro_ponedoras_fk` int(11) DEFAULT NULL,
  `codigo_usuario_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_registro_diario_ponedoraas`),
  KEY `FK_registro_diario_ponedoras_usuario` (`codigo_usuario_fk`),
  KEY `FK_registro_diario_ponedoras_registro_semanal_ponedoras` (`codigo_registro_ponedoras_fk`),
  KEY `FK_registro_diario_ponedoras_tipo_alimento` (`codigo_tipo_alimento_fk`),
  CONSTRAINT `FK_registro_diario_ponedoras_registro_semanal_ponedoras` FOREIGN KEY (`codigo_registro_ponedoras_fk`) REFERENCES `registro_semanal_ponedoras` (`codigo_registro_ponedoras`) ON UPDATE CASCADE,
  CONSTRAINT `FK_registro_diario_ponedoras_tipo_alimento` FOREIGN KEY (`codigo_tipo_alimento_fk`) REFERENCES `tipo_alimento` (`codigo_tipo_alimento`) ON UPDATE CASCADE,
  CONSTRAINT `FK_registro_diario_ponedoras_usuario` FOREIGN KEY (`codigo_usuario_fk`) REFERENCES `usuario` (`codigo_usuario`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.registro_diario_ponedoras: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `registro_diario_ponedoras` DISABLE KEYS */;
INSERT INTO `registro_diario_ponedoras` (`codigo_registro_diario_ponedoraas`, `fecha_registro_diario`, `total_huevos_segunda_clase_registro`, `total_huevos_registro`, `kg_alimento_registro`, `codigo_tipo_alimento_fk`, `cantidad_mortalidad_registro`, `cantidad_desecho_registro`, `observaciones_registro`, `codigo_registro_ponedoras_fk`, `codigo_usuario_fk`) VALUES
	(1, '2017-03-04', 3, 1, 3, NULL, 5, 5, 'a', 1, NULL),
	(2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL),
	(3, NULL, 0, 0, 0, NULL, 0, 0, NULL, 3, NULL),
	(4, NULL, 3, 5, 0, NULL, 0, 0, NULL, 4, NULL),
	(5, NULL, 2, 2, 2, NULL, 2, 2, NULL, 5, NULL);
/*!40000 ALTER TABLE `registro_diario_ponedoras` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.registro_semanal_engorde
CREATE TABLE IF NOT EXISTS `registro_semanal_engorde` (
  `codigo_registro_engorde` int(11) NOT NULL AUTO_INCREMENT,
  `numero_lote_engorde_fk` int(11) NOT NULL,
  `numero_semana_registro` int(11) NOT NULL,
  `semana_de_registro` date NOT NULL,
  `semana_a_registro` date NOT NULL,
  `codigo_tipo_alimento_fk` int(11) NOT NULL,
  `cantidad_total_semana_alimento_registro` int(11) NOT NULL,
  `costo_total_alimento_registro` int(11) NOT NULL,
  `total_acumulado_registro` int(11) NOT NULL,
  `consumo_por_pollo_registro` int(11) NOT NULL,
  `peso_promedio_registro` double NOT NULL,
  `numero_animales_iniciar_semana` int(11) NOT NULL,
  `numero_animales_final_semana` int(11) NOT NULL,
  `total_muertes_registro` int(11) NOT NULL,
  `porcentaje_muertes_registro` double NOT NULL,
  `observaciones_registro` text NOT NULL,
  PRIMARY KEY (`codigo_registro_engorde`),
  KEY `FK_registro_semanal_engorde_lote_engorde` (`numero_lote_engorde_fk`),
  KEY `FK_registro_semanal_engorde_tipo_alimento` (`codigo_tipo_alimento_fk`),
  CONSTRAINT `FK_registro_semanal_engorde_lote_engorde` FOREIGN KEY (`numero_lote_engorde_fk`) REFERENCES `lote_engorde` (`numero_lote_engorde`) ON UPDATE CASCADE,
  CONSTRAINT `FK_registro_semanal_engorde_tipo_alimento` FOREIGN KEY (`codigo_tipo_alimento_fk`) REFERENCES `tipo_alimento` (`codigo_tipo_alimento`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.registro_semanal_engorde: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `registro_semanal_engorde` DISABLE KEYS */;
/*!40000 ALTER TABLE `registro_semanal_engorde` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.registro_semanal_levante
CREATE TABLE IF NOT EXISTS `registro_semanal_levante` (
  `codigo_registro_levante` int(11) NOT NULL AUTO_INCREMENT,
  `numero_lote_fk` int(11) DEFAULT NULL,
  `numero_semana_registro` int(11) DEFAULT NULL,
  `semana_de_registro` date DEFAULT NULL,
  `semana_a_registro` date DEFAULT NULL,
  `codigo_tipo_alimento_fk` int(11) DEFAULT NULL,
  `cantidad_total_semana_alimento_registro` int(11) DEFAULT NULL,
  `costo_total_alimento_registro` int(11) DEFAULT NULL,
  `peso_promedio_registro` double DEFAULT NULL,
  `numero_pollas_inicial_registro` int(11) DEFAULT NULL,
  `numero_pollas_fina_registro` int(11) DEFAULT NULL,
  `gramos_pollas_por_semana` int(11) DEFAULT NULL,
  `porcentaje_mortalidad_registro` double DEFAULT NULL,
  `total_muertes_registro` int(11) DEFAULT NULL,
  `observaciones_registro` text,
  PRIMARY KEY (`codigo_registro_levante`),
  KEY `FK__tipo_alimento` (`codigo_tipo_alimento_fk`),
  KEY `FK_registro_semanal_levante_lote_levante` (`numero_lote_fk`),
  CONSTRAINT `FK__tipo_alimento` FOREIGN KEY (`codigo_tipo_alimento_fk`) REFERENCES `tipo_alimento` (`codigo_tipo_alimento`) ON UPDATE CASCADE,
  CONSTRAINT `FK_registro_semanal_levante_lote_levante` FOREIGN KEY (`numero_lote_fk`) REFERENCES `lote_levante` (`numero_lote`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.registro_semanal_levante: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `registro_semanal_levante` DISABLE KEYS */;
/*!40000 ALTER TABLE `registro_semanal_levante` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.registro_semanal_ponedoras
CREATE TABLE IF NOT EXISTS `registro_semanal_ponedoras` (
  `codigo_registro_ponedoras` int(11) NOT NULL AUTO_INCREMENT,
  `semana_produccion_registro` int(11) unsigned DEFAULT '0',
  `numero_ponedoras_inicial` int(11) unsigned DEFAULT '0',
  `numero_ponedoras_terminar` int(11) unsigned DEFAULT '0',
  `numero_lote_ponedoras_fk` int(11) DEFAULT NULL,
  `total_huevos_semana` int(11) unsigned DEFAULT '0',
  `total_huevos_segunda_semana` int(11) unsigned DEFAULT '0',
  `total_kg_semana` int(11) unsigned DEFAULT '0',
  `total_mortalidad_semana` int(11) unsigned DEFAULT '0',
  `total_desecho_semana` int(11) unsigned DEFAULT '0',
  PRIMARY KEY (`codigo_registro_ponedoras`),
  KEY `FK__lote_ponedoras` (`numero_lote_ponedoras_fk`),
  CONSTRAINT `FK__lote_ponedoras` FOREIGN KEY (`numero_lote_ponedoras_fk`) REFERENCES `lote_ponedoras` (`numero_lote_ponedoras`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.registro_semanal_ponedoras: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `registro_semanal_ponedoras` DISABLE KEYS */;
INSERT INTO `registro_semanal_ponedoras` (`codigo_registro_ponedoras`, `semana_produccion_registro`, `numero_ponedoras_inicial`, `numero_ponedoras_terminar`, `numero_lote_ponedoras_fk`, `total_huevos_semana`, `total_huevos_segunda_semana`, `total_kg_semana`, `total_mortalidad_semana`, `total_desecho_semana`) VALUES
	(1, 5, 5, 5, 1, 5, 5, 5, 5, 5),
	(2, NULL, NULL, NULL, 2, NULL, NULL, NULL, NULL, NULL),
	(3, 0, 0, 0, 3, 0, 0, 0, 0, 0),
	(4, 0, 0, 0, 4, 15, 5, 0, 0, 0),
	(5, 0, 5, 5, 5, 2, 2, 2, 13, 2);
/*!40000 ALTER TABLE `registro_semanal_ponedoras` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.reporte_huevos
CREATE TABLE IF NOT EXISTS `reporte_huevos` (
  `codigo_reporte_huevos` int(11) NOT NULL AUTO_INCREMENT,
  `numero_pesados_huevos` int(11) DEFAULT '0',
  `peso_total_huevos` double DEFAULT '0',
  `peso_panales_huevos` double DEFAULT '0',
  `peso_huevos` double DEFAULT '0',
  `peso_promedio_huevos` double DEFAULT '0',
  `codigo_registro_diario_ponedoras_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_reporte_huevos`),
  KEY `FK_reporte_huevos_registro_diario_ponedoras` (`codigo_registro_diario_ponedoras_fk`),
  CONSTRAINT `FK_reporte_huevos_registro_diario_ponedoras` FOREIGN KEY (`codigo_registro_diario_ponedoras_fk`) REFERENCES `registro_diario_ponedoras` (`codigo_registro_diario_ponedoraas`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.reporte_huevos: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `reporte_huevos` DISABLE KEYS */;
INSERT INTO `reporte_huevos` (`codigo_reporte_huevos`, `numero_pesados_huevos`, `peso_total_huevos`, `peso_panales_huevos`, `peso_huevos`, `peso_promedio_huevos`, `codigo_registro_diario_ponedoras_fk`) VALUES
	(1, 5, 10, 10, 10, 10, 1),
	(2, NULL, NULL, NULL, NULL, NULL, 2),
	(3, 0, 0, 0, 0, 0, 3),
	(5, 2, 2, 2, 2, 2, 5);
/*!40000 ALTER TABLE `reporte_huevos` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.sacrifio_venta_engorde
CREATE TABLE IF NOT EXISTS `sacrifio_venta_engorde` (
  `codigo_sacrificio_venta` int(11) NOT NULL DEFAULT '0',
  `edad_semana_sacrificio_venta` int(11) DEFAULT NULL,
  `fecha_sacrificio_venta` date DEFAULT NULL,
  `cantidad_sacrificio_venta` int(11) DEFAULT NULL,
  `tipo_sacrificio_venta` varchar(50) DEFAULT NULL,
  `peso_sacrificio_venta` double DEFAULT NULL,
  `precio_kg_sacrificio_venta` double DEFAULT NULL,
  `total_sacrificio_venta` int(11) DEFAULT NULL,
  `numero_lote_engorde_fk` int(11) DEFAULT NULL,
  `codigo_usuario_fk` int(11) DEFAULT NULL,
  `hora_registro_sacrificio_venta` time DEFAULT NULL,
  `fecha_registro_sacrificio_venta` date DEFAULT NULL,
  PRIMARY KEY (`codigo_sacrificio_venta`),
  KEY `FK_sacrifio_venta_engorde_e_usuario` (`codigo_usuario_fk`),
  KEY `FK_sacrifio_venta_engorde_e_lote_engorde` (`numero_lote_engorde_fk`),
  CONSTRAINT `FK_sacrifio_venta_engorde_e_lote_engorde` FOREIGN KEY (`numero_lote_engorde_fk`) REFERENCES `lote_engorde` (`numero_lote_engorde`) ON UPDATE CASCADE,
  CONSTRAINT `FK_sacrifio_venta_engorde_e_usuario` FOREIGN KEY (`codigo_usuario_fk`) REFERENCES `usuario` (`codigo_usuario`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.sacrifio_venta_engorde: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `sacrifio_venta_engorde` DISABLE KEYS */;
/*!40000 ALTER TABLE `sacrifio_venta_engorde` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.sanidad_engorde
CREATE TABLE IF NOT EXISTS `sanidad_engorde` (
  `codigo_sanidad` int(11) NOT NULL DEFAULT '0',
  `edad_semanas_sanidad` int(11) DEFAULT NULL,
  `fecha_sanidad` date DEFAULT NULL,
  `tratamiento_sanidad` varchar(100) DEFAULT NULL,
  `costo_sanidad` int(11) DEFAULT NULL,
  `fecha_registro_sanidad` date DEFAULT NULL,
  `hora_registro_sanidad` time DEFAULT NULL,
  `numero_lote_engorde` int(11) DEFAULT NULL,
  `codigo_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_sanidad`),
  KEY `FK_sanidad_engorde_lote_engorde` (`numero_lote_engorde`),
  KEY `FK_sanidad_engorde_usuario` (`codigo_usuario`),
  CONSTRAINT `FK_sanidad_engorde_lote_engorde` FOREIGN KEY (`numero_lote_engorde`) REFERENCES `lote_engorde` (`numero_lote_engorde`) ON UPDATE CASCADE,
  CONSTRAINT `FK_sanidad_engorde_usuario` FOREIGN KEY (`codigo_usuario`) REFERENCES `usuario` (`codigo_usuario`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.sanidad_engorde: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `sanidad_engorde` DISABLE KEYS */;
/*!40000 ALTER TABLE `sanidad_engorde` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.tipo_alimento
CREATE TABLE IF NOT EXISTS `tipo_alimento` (
  `codigo_tipo_alimento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_tipo_alimento` varchar(100) DEFAULT NULL,
  `valor_kilo_tipo_alimento` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_tipo_alimento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.tipo_alimento: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `tipo_alimento` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_alimento` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `codigo_usuario` int(11) NOT NULL,
  `documento_usuario` bigint(20) DEFAULT NULL,
  `nombre_usuario` varchar(50) DEFAULT NULL,
  `apellido_usuario` varchar(50) DEFAULT NULL,
  `ficha_usuario` int(11) DEFAULT NULL,
  `clave_usuario` varchar(40) DEFAULT NULL,
  `codigo_programa_fk` int(11) DEFAULT NULL,
  `tipo_usuario` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`codigo_usuario`),
  KEY `FK_usuario_programa` (`codigo_programa_fk`),
  CONSTRAINT `FK_usuario_programa` FOREIGN KEY (`codigo_programa_fk`) REFERENCES `programa` (`codigo_programa`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='codigo usuario no lo puse autoincrement \r\npor que creo que es el documento de identidad del usuario';

-- Volcando datos para la tabla agente_a.usuario: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`codigo_usuario`, `documento_usuario`, `nombre_usuario`, `apellido_usuario`, `ficha_usuario`, `clave_usuario`, `codigo_programa_fk`, `tipo_usuario`) VALUES
	(1, 1116235891, 'diana ', 'velandia', NULL, '123', NULL, 'instructor');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.vacuna
CREATE TABLE IF NOT EXISTS `vacuna` (
  `codigo_vacuna` int(11) NOT NULL,
  `nombre_vacuna` varchar(100) DEFAULT NULL,
  `valor_unitario_vacuna` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_vacuna`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.vacuna: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `vacuna` DISABLE KEYS */;
/*!40000 ALTER TABLE `vacuna` ENABLE KEYS */;

-- Volcando estructura para tabla agente_a.vitaminas_engorde
CREATE TABLE IF NOT EXISTS `vitaminas_engorde` (
  `codigo_vitamina` int(11) NOT NULL DEFAULT '0',
  `nombre_vitamina` varchar(100) DEFAULT NULL,
  `dosis_vitamina` double DEFAULT NULL,
  `edad_semas_vitamina` int(11) DEFAULT NULL,
  `fecha_vitamina` date DEFAULT NULL,
  `valor_vitamina` int(11) DEFAULT NULL,
  `codigo_usuario` int(11) DEFAULT NULL,
  `numero_lote_engorde` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_vitamina`),
  KEY `FK_vitaminas_engorde_usuario` (`codigo_usuario`),
  KEY `FK_vitaminas_engorde_lote_engorde` (`numero_lote_engorde`),
  CONSTRAINT `FK_vitaminas_engorde_lote_engorde` FOREIGN KEY (`numero_lote_engorde`) REFERENCES `lote_engorde` (`numero_lote_engorde`) ON UPDATE CASCADE,
  CONSTRAINT `FK_vitaminas_engorde_usuario` FOREIGN KEY (`codigo_usuario`) REFERENCES `usuario` (`codigo_usuario`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla agente_a.vitaminas_engorde: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `vitaminas_engorde` DISABLE KEYS */;
/*!40000 ALTER TABLE `vitaminas_engorde` ENABLE KEYS */;

-- Volcando estructura para disparador agente_a.clasificacion update
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `clasificacion update` AFTER UPDATE ON `clasificacion_huevos` FOR EACH ROW BEGIN
/*##########################--Economia--#####################################################################################*/
/*Valor huevo*/
set @valorTotalHuevo=
new.valor_total_huevos;


update clasificacion_huevos, reporte_huevos, registro_diario_ponedoras, registro_semanal_ponedoras, economia set
economia.valor_huevos=@valorTotalHuevo where clasificacion_huevos.codigo_reportes_huevos_fk=
reporte_huevos.codigo_reporte_huevos and
reporte_huevos.codigo_registro_diario_ponedoras_fk= registro_diario_ponedoras.codigo_registro_diario_ponedoraas and
registro_diario_ponedoras.codigo_registro_ponedoras_fk= registro_semanal_ponedoras.codigo_registro_ponedoras and
economia.codigo_registro_ponedoras_fk= registro_semanal_ponedoras.codigo_registro_ponedoras and
clasificacion_huevos.codigo_clasificacion= old.codigo_clasificacion;

/*Valor huevo Costo*/

set @costoAlimentacionTotal=(select economia.costo_alimentacion_total from economia, registro_semanal_ponedoras,
registro_diario_ponedoras, reporte_huevos, clasificacion_huevos where
clasificacion_huevos.codigo_reportes_huevos_fk=
reporte_huevos.codigo_reporte_huevos and
reporte_huevos.codigo_registro_diario_ponedoras_fk= registro_diario_ponedoras.codigo_registro_diario_ponedoraas and
registro_diario_ponedoras.codigo_registro_ponedoras_fk= registro_semanal_ponedoras.codigo_registro_ponedoras and
economia.codigo_registro_ponedoras_fk= registro_semanal_ponedoras.codigo_registro_ponedoras and
economia.codigo_economia= old.codigo_clasificacion);



END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador agente_a.Economia_update
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `Economia_update` AFTER UPDATE ON `economia` FOR EACH ROW BEGIN


END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador agente_a.Estado-Galpon
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `Estado-Galpon` AFTER INSERT ON `lote_ponedoras` FOR EACH ROW BEGIN
update galpon set 
galpon.estado_galpon='Ocupado' where
galpon.numero_galpon=new.numero_galpon_fk; 
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador agente_a.huevos-formulas-update
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `huevos-formulas-update` AFTER UPDATE ON `reporte_huevos` FOR EACH ROW BEGIN
/*kg de huevos total*/
set @kghuevos=(select reporte_huevos.peso_huevos from reporte_huevos,registro_diario_ponedoras,registro_semanal_ponedoras
where
registro_semanal_ponedoras.codigo_registro_ponedoras=registro_diario_ponedoras.codigo_registro_ponedoras_fk and
registro_diario_ponedoras.codigo_registro_diario_ponedoraas=reporte_huevos.codigo_registro_diario_ponedoras_fk and
registro_diario_ponedoras.codigo_registro_diario_ponedoraas=old.codigo_registro_diario_ponedoras_fk);

update produccion,registro_diario_ponedoras,registro_semanal_ponedoras,reporte_huevos set produccion.kg_huevos_total=@kghuevos 
where
produccion.codigo_registro_ponedoras_fk=registro_semanal_ponedoras.codigo_registro_ponedoras and
registro_semanal_ponedoras.codigo_registro_ponedoras=registro_diario_ponedoras.codigo_registro_ponedoras_fk and
registro_diario_ponedoras.codigo_registro_diario_ponedoraas=reporte_huevos.codigo_registro_diario_ponedoras_fk and
reporte_huevos.codigo_reporte_huevos=old.codigo_reporte_huevos; 

/*kg de huevos ppe*/
set @resultadokgppe=(@kghuevos)/7;

update produccion,registro_diario_ponedoras,registro_semanal_ponedoras,reporte_huevos 
set produccion.kg_huevos_ppe=@resultadokgppe 
where
produccion.codigo_registro_ponedoras_fk=registro_semanal_ponedoras.codigo_registro_ponedoras and
registro_semanal_ponedoras.codigo_registro_ponedoras=registro_diario_ponedoras.codigo_registro_ponedoras_fk and
registro_diario_ponedoras.codigo_registro_diario_ponedoraas=reporte_huevos.codigo_registro_diario_ponedoras_fk and
reporte_huevos.codigo_reporte_huevos=old.codigo_reporte_huevos; 
/*peso promedio por huevos*/
 

set @NumeroPesados=(select reporte_huevos.numero_pesados_huevos from reporte_huevos,registro_diario_ponedoras,registro_semanal_ponedoras
where
registro_semanal_ponedoras.codigo_registro_ponedoras=registro_diario_ponedoras.codigo_registro_ponedoras_fk and
registro_diario_ponedoras.codigo_registro_diario_ponedoraas=reporte_huevos.codigo_registro_diario_ponedoras_fk and
registro_diario_ponedoras.codigo_registro_diario_ponedoraas=old.codigo_registro_diario_ponedoras_fk);

set @Resultadopesopromediohuevos=(@kghuevos/@NumeroPesados);

update produccion,registro_diario_ponedoras,registro_semanal_ponedoras,reporte_huevos 
set produccion.peso_promedio_x_huevos=@Resultadopesopromediohuevos 
where
produccion.codigo_registro_ponedoras_fk=registro_semanal_ponedoras.codigo_registro_ponedoras and
registro_semanal_ponedoras.codigo_registro_ponedoras=registro_diario_ponedoras.codigo_registro_ponedoras_fk and
registro_diario_ponedoras.codigo_registro_diario_ponedoraas=reporte_huevos.codigo_registro_diario_ponedoras_fk and
reporte_huevos.codigo_reporte_huevos=old.codigo_reporte_huevos; 
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador agente_a.registro_semanal_ponedoras_before_update
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `registro_semanal_ponedoras_before_update` AFTER UPDATE ON `registro_semanal_ponedoras` FOR EACH ROW BEGIN
/*Numero de poendoras presente promedio*/
set @inicio= new.numero_ponedoras_inicial;  

set @terminar= new.numero_ponedoras_inicial;  

set @resultadoPPP=(@inicio+@terminar)/2;
update produccion, registro_semanal_ponedoras set produccion.numero_ponedoras_presente_promedio=@resultadoPPP
where produccion.codigo_registro_ponedoras_fk=registro_semanal_ponedoras.codigo_registro_ponedoras and
produccion.codigo_registro_ponedoras_fk=old.codigo_registro_ponedoras;

/*Porcentaje mortalidad*/
set @TotalMortalidad= new.total_mortalidad_semana;

set @resultadoMortalidad=(@TotalMortalidad+@inicio)*100;

update produccion, registro_semanal_ponedoras set produccion.porcentaje_mortalidad=@resultadoMortalidad
where produccion.codigo_registro_ponedoras_fk=registro_semanal_ponedoras.codigo_registro_ponedoras and
produccion.codigo_registro_ponedoras_fk=old.codigo_registro_ponedoras;
/*Numero huevos ppe*/
set @TotalHuevosSemana=new.total_huevos_semana;

set @resultadoTotalHuevosSemana=(@TotalHuevosSemana)/7;
update produccion, registro_semanal_ponedoras set produccion.numero_huevos_ppe=@resultadoTotalHuevosSemana
where produccion.codigo_registro_ponedoras_fk=registro_semanal_ponedoras.codigo_registro_ponedoras and
produccion.codigo_registro_ponedoras_fk=old.codigo_registro_ponedoras;
/*porcentaje postura*/
set @NumeroPonedorasPresentePromedio=
(select produccion.numero_ponedoras_presente_promedio from registro_semanal_ponedoras, produccion where
produccion.codigo_registro_ponedoras_fk=registro_semanal_ponedoras.codigo_registro_ponedoras and
produccion.codigo_registro_ponedoras_fk=old.codigo_registro_ponedoras);

set @resultadoPorcentajepostura=@TotalHuevosSemana/(@NumeroPonedorasPresentePromedio*7)*100;

update produccion, registro_semanal_ponedoras set produccion.porcentaje_postura=@resultadoPorcentajepostura
where  produccion.codigo_registro_ponedoras_fk=registro_semanal_ponedoras.codigo_registro_ponedoras and
produccion.codigo_registro_ponedoras_fk=old.codigo_registro_ponedoras;

/*Docena de huevos*/
set @TotalhuevosSemana=new.total_huevos_semana;
set @resultadoDocenaHuevos=(@TotalhuevosSemana)/12;

update produccion, registro_semanal_ponedoras set produccion.docena_huevos=@resultadoDocenaHuevos
where  produccion.codigo_registro_ponedoras_fk=registro_semanal_ponedoras.codigo_registro_ponedoras and
produccion.codigo_registro_ponedoras_fk=old.codigo_registro_ponedoras;

/*#######################---Alimentacion---######################################################################*/
/*Consumo diario P.P.P(gr)*/

set @totalgksemana=new.total_kg_semana;
set @inicial=new.numero_ponedoras_inicial;
set @consumoDiarioPPP=@totalgksemana/(@inicial*7);

update alimentacion, registro_semanal_ponedoras set alimentacion.consumo_diario_ppp=@consumoDiarioPPP where
alimentacion.codigo_registro_ponedoras_fk1=registro_semanal_ponedoras.codigo_registro_ponedoras and 
alimentacion.codigo_registro_ponedoras_fk1=old.codigo_registro_ponedoras;


/*Convercion por Kg huevo*/
set @Pesohuevos=(select reporte_huevos.peso_huevos from reporte_huevos, registro_diario_ponedoras, registro_semanal_ponedoras
where registro_diario_ponedoras.codigo_registro_ponedoras_fk=
registro_semanal_ponedoras.codigo_registro_ponedoras and 
reporte_huevos.codigo_registro_diario_ponedoras_fk=registro_diario_ponedoras.codigo_registro_diario_ponedoraas and
reporte_huevos.codigo_reporte_huevos=old.codigo_registro_ponedoras);

set @resultadoConvercionKgHuevo=(@totalgksemana/@Pesohuevos);

update alimentacion, registro_semanal_ponedoras set alimentacion.conversion_kg_huevo=@resultadoConvercionKgHuevo where
alimentacion.codigo_registro_ponedoras_fk1=registro_semanal_ponedoras.codigo_registro_ponedoras and 
alimentacion.codigo_registro_ponedoras_fk1=old.codigo_registro_ponedoras;

/*############################################---Economia---#############################################################*/
/*Costo alimentacion total*/
set @precioAlimento=(select economia.precio_alimento_kg from economia, registro_semanal_ponedoras where
economia.codigo_registro_ponedoras_fk= registro_semanal_ponedoras.codigo_registro_ponedoras and
economia.codigo_registro_ponedoras_fk=old.codigo_registro_ponedoras);
set @alimentoSemanal=new.total_kg_semana;
set @resultadoCostoAlimentacion=(@precioAlimento*@alimentoSemanal);
update economia, registro_semanal_ponedoras set economia.costo_alimentacion_total=@resultadoCostoAlimentacion where
economia.codigo_registro_ponedoras_fk= registro_semanal_ponedoras.codigo_registro_ponedoras and
economia.codigo_registro_ponedoras_fk=old.codigo_registro_ponedoras;

/*Costo alimentacion por huevo*/
set @costoalimentaciontotal=(select economia.costo_alimentacion_total from economia, registro_semanal_ponedoras where
economia.codigo_registro_ponedoras_fk=registro_semanal_ponedoras.codigo_registro_ponedoras and
economia.codigo_registro_ponedoras_fk=old.codigo_registro_ponedoras);

set @totalhuevosemana=old.total_huevos_semana;
set @resultadoAlimentacionPorHuevo=@costoalimentaciontotal/@totalhuevosemana;
update economia, registro_semanal_ponedoras set economia.costo_alimentacion_huevos=@resultadoAlimentacionPorHuevo where
economia.codigo_registro_ponedoras_fk= registro_semanal_ponedoras.codigo_registro_ponedoras and
economia.codigo_registro_ponedoras_fk=old.codigo_registro_ponedoras;

END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador agente_a.suma a semanal -Insertar
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `suma a semanal -Insertar` AFTER INSERT ON `registro_diario_ponedoras` FOR EACH ROW BEGIN
update registro_semanal_ponedoras set
registro_semanal_ponedoras.total_huevos_semana=registro_semanal_ponedoras.total_huevos_semana+new.total_huevos_registro,
registro_semanal_ponedoras.total_huevos_segunda_semana=registro_semanal_ponedoras.total_huevos_segunda_semana+new.total_huevos_segunda_clase_registro,
registro_semanal_ponedoras.total_kg_semana=registro_semanal_ponedoras.total_kg_semana+new.kg_alimento_registro,
registro_semanal_ponedoras.total_mortalidad_semana=registro_semanal_ponedoras.total_mortalidad_semana+new.cantidad_mortalidad_registro,
registro_semanal_ponedoras.total_desecho_semana=registro_semanal_ponedoras.total_desecho_semana+new.cantidad_desecho_registro 
where 
registro_semanal_ponedoras.codigo_registro_ponedoras=new.codigo_registro_ponedoras_fk;

update lote_ponedoras, registro_semanal_ponedoras,registro_diario_ponedoras set
lote_ponedoras.total_huevos_lote=lote_ponedoras.total_huevos_lote+new.total_huevos_registro,
lote_ponedoras.total_huevos_segundo_lote=lote_ponedoras.total_huevos_segundo_lote+new.total_huevos_segunda_clase_registro,
lote_ponedoras.total_kg_alimento=lote_ponedoras.total_kg_alimento+new.kg_alimento_registro,
lote_ponedoras.total_mortalidad_lote=lote_ponedoras.total_mortalidad_lote+new.cantidad_mortalidad_registro,
lote_ponedoras.total_desecho_lote=lote_ponedoras.total_desecho_lote+new.cantidad_desecho_registro 
where 
registro_semanal_ponedoras.numero_lote_ponedoras_fk=lote_ponedoras.numero_lote_ponedoras and
registro_diario_ponedoras.codigo_registro_ponedoras_fk=registro_semanal_ponedoras.codigo_registro_ponedoras and
registro_diario_ponedoras.codigo_registro_diario_ponedoraas=
new.codigo_registro_diario_ponedoraas;

/*.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.*/

/*Numero de ponedoras presente promedio*/



END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador agente_a.suma semanal-update
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `suma semanal-update` AFTER UPDATE ON `registro_diario_ponedoras` FOR EACH ROW BEGIN
update registro_semanal_ponedoras set
registro_semanal_ponedoras.total_huevos_semana=(registro_semanal_ponedoras.total_huevos_semana-old.total_huevos_registro)+new.total_huevos_registro,
registro_semanal_ponedoras.total_huevos_segunda_semana=(registro_semanal_ponedoras.total_huevos_segunda_semana-old.total_huevos_segunda_clase_registro)+new.total_huevos_segunda_clase_registro,
registro_semanal_ponedoras.total_kg_semana=(registro_semanal_ponedoras.total_kg_semana-old.kg_alimento_registro)+new.kg_alimento_registro,
registro_semanal_ponedoras.total_mortalidad_semana=(registro_semanal_ponedoras.total_mortalidad_semana-old.cantidad_mortalidad_registro)+new.cantidad_mortalidad_registro,
registro_semanal_ponedoras.total_desecho_semana=(registro_semanal_ponedoras.total_desecho_semana-old.cantidad_desecho_registro) +new.cantidad_desecho_registro 
where 
registro_semanal_ponedoras.codigo_registro_ponedoras=old.codigo_registro_ponedoras_fk;

update lote_ponedoras, registro_semanal_ponedoras,registro_diario_ponedoras set
lote_ponedoras.total_huevos_lote=(lote_ponedoras.total_huevos_lote-old.total_huevos_registro)+new.total_huevos_registro,
lote_ponedoras.total_huevos_segundo_lote=(lote_ponedoras.total_huevos_segundo_lote-old.total_huevos_segunda_clase_registro)+new.total_huevos_segunda_clase_registro,
lote_ponedoras.total_kg_alimento=(lote_ponedoras.total_kg_alimento-old.kg_alimento_registro)+new.kg_alimento_registro,
lote_ponedoras.total_mortalidad_lote=(lote_ponedoras.total_mortalidad_lote-old.cantidad_mortalidad_registro)+new.cantidad_mortalidad_registro,
lote_ponedoras.total_desecho_lote=(lote_ponedoras.total_desecho_lote-old.cantidad_desecho_registro)+new.cantidad_desecho_registro 
where 
registro_semanal_ponedoras.numero_lote_ponedoras_fk=lote_ponedoras.numero_lote_ponedoras and

registro_diario_ponedoras.codigo_registro_ponedoras_fk=registro_semanal_ponedoras.codigo_registro_ponedoras and
registro_diario_ponedoras.codigo_registro_diario_ponedoraas=old.codigo_registro_diario_ponedoraas;

END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
