CREATE TABLE `users` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `full_name` varchar(255),
  `posicion` varchar(255),
  `compania` varchar(255),
  `ubicacion` varchar(255),
  `created_at` timestamp,
  `country_code` int
);

CREATE TABLE `user_experience` (
  `experience_id` int PRIMARY KEY,
  `user_id` int
);

CREATE TABLE `experience` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `posicion` varchar(255),
  `compania` varchar(255),
  `imagen` varchar(255),
  `modo` varchar(255),
  `fechaDeInicio` date,
  `fechaDeFin` date
);

CREATE TABLE `user_education` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `education_id` int,
  `user_id` int,
  `gpa` float8,
  `fechaDeInicio` date,
  `fechaDeFin` date
);

CREATE TABLE `education` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `escuela` varchar(255),
  `titulo` varchar(255),
  `imagen` varchar(255),
  `carrera` varchar(255)
);

ALTER TABLE `user_experience` ADD FOREIGN KEY (`experience_id`) REFERENCES `experience` (`id`);

ALTER TABLE `user_experience` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `user_education` ADD FOREIGN KEY (`education_id`) REFERENCES `education` (`id`);

ALTER TABLE `user_education` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
