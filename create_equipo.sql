CREATE TABLE `rus_videos`.`equipo` (
  `id` INT NOT NULL,
  `division` INT NOT NULL,
  `categoria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `division_UNIQUE` (`division` ASC, `categoria` ASC) VISIBLE);
