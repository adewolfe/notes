CREATE TABLE IF NOT EXISTS `notes` (
    `note_id` INT NOT NULL AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `text` VARCHAR(1000) NOT NULL,
    `created_on` TIMESTAMP NOT NULL,
    `updated_on` TIMESTAMP NOT NULL,
    PRIMARY KEY (`note_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
