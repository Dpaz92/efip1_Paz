CREATE TABLE `rus_videos`.`video` (
  `id` INT NOT NULL,
  `idpartido` INT NOT NULL,
  `route` VARCHAR(255) NULL,
  `urlHudl` VARCHAR(255) NULL,
  `estado` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
CONSTRAINT `idpartidovideoFK`
    FOREIGN KEY (`idpartido`)
    REFERENCES `rus_videos`.`partido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
