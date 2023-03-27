CREATE TABLE users (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
	lastName VARCHAR(255),
  email VARCHAR(255) UNIQUE,
  password VARCHAR(255),
	phone VARCHAR(10),
	birthDate VARCHAR(255)
);