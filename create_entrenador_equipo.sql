CREATE TABLE `rus_videos`.`entrenador_equipo` (
  `identrenador_equipo` INT NOT NULL,
  `identrenador` INT NOT NULL,
  `idequipo` INT NOT NULL,
  PRIMARY KEY (`identrenador_equipo`),
  INDEX `idequipoFK_idx` (`idequipo` ASC) VISIBLE,
  UNIQUE INDEX `identrenador_UNIQUE` (`identrenador` ASC, `idequipo` ASC) VISIBLE,
  CONSTRAINT `identrenadorFK`
    FOREIGN KEY (`identrenador`)
    REFERENCES `rus_videos`.`entrenador` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idequipoFK`
    FOREIGN KEY (`idequipo`)
    REFERENCES `rus_videos`.`equipo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
