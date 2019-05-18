CREATE TABLE user (
  name varchar(10) DEFAULT NULL,
  point int DEFAULT '1000',
  email varchar(50) NOT NULL,
  passwd varchar(20) DEFAULT NULL,
  phone varchar(15) DEFAULT NULL,
  birth varchar(10) DEFAULT NULL,
  zipcode varchar(10) DEFAULT NULL,
  addr varchar(200) DEFAULT NULL,
  PRIMARY KEY (email)
)