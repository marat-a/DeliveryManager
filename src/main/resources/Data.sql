
INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('COURIER');
INSERT INTO roles (name) VALUES ('MANAGER');
INSERT INTO roles (name) VALUES ('CUSTOMER');

INSERT INTO users (login,name,password,phone) VALUES ('admin','Marat','$2a$10$lrHxwoGiY2Z2/tTca.4FUeiMZLQnX3McmDduD8jG2FOFniQ22WLru','89122341594');
INSERT INTO user_roles (user_id,role_id) VALUES (1,1);
INSERT INTO user_roles (user_id,role_id) VALUES (1,2);
INSERT INTO user_roles (user_id,role_id) VALUES (1,3);
INSERT INTO user_roles (user_id,role_id) VALUES (1,4);