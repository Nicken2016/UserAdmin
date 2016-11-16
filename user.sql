CREATE SCHEMA `test` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE test.user
(
id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,

			    name VARCHAR(25),
    
			    age INT(11),
    
			    isAdmin BIT(1),
    
			    createdDate TIMESTAMP(6)
);
INSERT into test.user ( name, age, isAdmin, createdDate) values ( 'User One', 	20, 0, '16-11-30 10:33:44');
INSERT into test.user ( name, age, isAdmin, createdDate) values ( 'User Two', 	22, 0, '15-10-25 15:35:05');
INSERT into test.user ( name, age, isAdmin, createdDate) values ( 'User Three', 	26, 0, '16-11-14 10:33:44');
INSERT into test.user ( name, age, isAdmin, createdDate) values ( 'User Four', 	25, 0, '15-10-24 15:30:05');
INSERT into test.user ( name, age, isAdmin, createdDate) values ( 'User Five', 	24, 0, '16-11-17 12:32:00');
INSERT into test.user ( name, age, isAdmin, createdDate) values ( 'User Six', 	23, 0, '14-10-25 13:33:00');
INSERT into test.user ( name, age, isAdmin, createdDate) values ( 'User Seven', 	28, 0, '16-11-30 15:36:43');
INSERT into test.user ( name, age, isAdmin, createdDate) values ( 'User Eight', 	22, 0, '15-10-29 18:37:07');
INSERT into test.user ( name, age, isAdmin, createdDate) values ( 'Administrator One', 	27, 1, '16-11-30 10:20:44');
INSERT into test.user ( name, age, isAdmin, createdDate) values ( 'User Nine', 	22, 0, '15-10-25 19:35:05');
INSERT into test.user ( name, age, isAdmin, createdDate) values ( 'Administrator Two', 	21, 1, '16-11-30 16:35:01');
INSERT into test.user ( name, age, isAdmin, createdDate) values ( 'User Ten', 	22, 0, '15-10-25 10:30:00');