CREATE TABLE `rus_videos`.`partido` (
  `id` INT NOT NULL,
  `idequipo` INT NOT NULL,
  `fechaHora` DATETIME NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idequipoFK_idx` (`idequipo` ASC) INVISIBLE,
  CONSTRAINT `idpartido_equipoFK`
    FOREIGN KEY (`idequipo`)
    REFERENCES `rus_videos`.`equipo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
