CREATE TABLE bank (
  account varchar(30) NOT NULL,
  bank varchar(10) NOT NULL,
  name varchar(10) NOT NULL
);

CREATE TABLE crawling (
  nation varchar(5) NOT NULL,
  money float DEFAULT NULL,
  change varchar(45) DEFAULT NULL,
  change_time varchar(50) DEFAULT NULL,
  PRIMARY KEY (nation)
);

CREATE TABLE destination (
  destiName varchar(20) NOT NULL,
  destiKorName varchar(20) NOT NULL,
  destiCountry varchar(3) NOT NULL,
  destiMoney float DEFAULT NULL,
  PRIMARY KEY (destiName),
  FOREIGN KEY (destiCountry) REFERENCES crawling (nation)
);

CREATE TABLE prod (
  prod_id int(11) NOT NULL AUTO_INCREMENT,
  prod_desti varchar(20) DEFAULT NULL,
  prod_kind varchar(20) NOT NULL,
  prod_title varchar(100) NOT NULL,
  prod_price int(11) NOT NULL,
  prod_count int(11) NOT NULL,
  prod_com varchar(30) NOT NULL,
  prod_imgName varchar(200) DEFAULT 'nothing.jpg',
  prod_imgRealName varchar(200) DEFAULT 'nothing.jpg',
  prod_content text NOT NULL,
  reg_date datetime DEFAULT NULL,
  prod_sales int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (prod_id),
  FOREIGN KEY (prod_desti) REFERENCES destination (destiname)
);

CREATE TABLE buy (
  buy_id bigint(20) NOT NULL,
  buyerEmail varchar(50) DEFAULT NULL,
  subsName varchar(10) NOT NULL,
  subsPhone varchar(20) NOT NULL,
  prod_id int(11) DEFAULT NULL,
  prod_kind varchar(20) NOT NULL,
  prod_title varchar(100) NOT NULL,
  buy_price int(11) NOT NULL,
  buy_amount int(11) NOT NULL,
  prod_image varchar(200) DEFAULT 'nothing.jpg',
  buy_date datetime NOT NULL,
  payment varchar(50) NOT NULL,
  subs_date varchar(45) DEFAULT NULL,
  sanction varchar(10) DEFAULT '예약완료',
  FOREIGN KEY (prod_id) REFERENCES prod (prod_id)
);

CREATE TABLE notiboard (
  num int(11) NOT NULL AUTO_INCREMENT,
  writer varchar(10) DEFAULT NULL,
  email varchar(30) DEFAULT NULL,
  subject varchar(50) DEFAULT NULL,
  reg_date datetime DEFAULT NULL,
  readcount int(11) DEFAULT '0',
  content text,
  PRIMARY KEY (num)
);


CREATE TABLE qnaboard (
  num int(11) NOT NULL AUTO_INCREMENT,
  writer varchar(10) DEFAULT NULL,
  email varchar(30) DEFAULT NULL,
  subject varchar(50) DEFAULT NULL,
  reg_date datetime DEFAULT NULL,
  readcount int(11) DEFAULT '0',
  ref int(11) DEFAULT NULL,
  re_step smallint(6) DEFAULT NULL,
  re_level smallint(6) DEFAULT NULL,
  content text,
  ip varchar(20) DEFAULT NULL,
  fileName varchar(200) DEFAULT NULL,
  fileRealName varchar(200) DEFAULT NULL,
  PRIMARY KEY (num)
);

CREATE TABLE member (
  name varchar(10) DEFAULT NULL,
  point int(11) DEFAULT '1000',
  email varchar(50) NOT NULL,
  passwd varchar(20) DEFAULT NULL,
  phone varchar(15) DEFAULT NULL,
  birth varchar(10) DEFAULT NULL,
  zipcode varchar(10) DEFAULT NULL,
  addr varchar(200) DEFAULT NULL,
  PRIMARY KEY (email)
);

CREATE TABLE wishlist (
  wishlist_id int(11) NOT NULL AUTO_INCREMENT,
  wisher varchar(50) NOT NULL,
  prod_id int(11) NOT NULL,
  prod_kind varchar(20) NOT NULL,
  prod_title varchar(100) NOT NULL,
  prod_image varchar(200) DEFAULT 'nothing.jpg',
  prod_com varchar(30) NOT NULL,
  prod_price varchar(30) NOT NULL,
  PRIMARY KEY (wishlist_id),
  FOREIGN KEY (prod_id) REFERENCES prod (prod_id)
);