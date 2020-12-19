insert into category (id, name, active, iconurl) values (1, 'Elektronika', true, '/resources/images/electronics.png');
insert into category (id, name, active, iconurl) values (2, 'Nieruchomosci', true, '/resources/images/real-estate.png');
insert into category (id, name, active, iconurl) values (3, 'Motoryzacja', true, '/resources/images/cars.png');
insert into category (id, name, active, iconurl) values (4, 'Dom i Ogród', true, '/resources/images/house.png');
insert into category (id, name, active, iconurl) values (5, 'Sport', true, '/resources/images/electronics.png');

INSERT INTO USER VALUES (1, 'klasik@wp.pl', true, 'Klasicki', 'Mar','Marcin' ,'$2y$12$4MbeKwHGlxAcOSQeDEHyr.Jyp9Nr91w6KBiZjsQWVhIMgbc6WqAhi');
INSERT INTO USER VALUES (2, 'kla@wp.pl', true, 'Stefański', 'Stef','Stefan' ,'$2y$12$4MbeKwHGlxAcOSQeDEHyr.Jyp9Nr91w6KBiZjsQWVhIMgbc6WqAhi');

INSERT INTO PRODUCT (id, image, product_name, product_price, product_description, category_id, user_id) VALUES (1,'rower.jpg', 'Cube 34ZX ', 123, 'Rower górski marki Cube, używany w dobrym stanie', 5, 1);
INSERT INTO PRODUCT (id, image, product_name, product_price, product_description, category_id, user_id) VALUES (2,'garmin.jpg', 'Garmin XYZ ', 950,'Wielodyscyplinowy zegarek GPS fēnix 6 łączy w sobie najlepsze cechy naszych zegarków fitness i zegarków treningowych.', 1, 2);
INSERT INTO PRODUCT (id, image, product_name, product_price, product_description, category_id, user_id) VALUES (3,'kurtka.jpg', 'Kurtka Hilfiger ', 130,'Nowa kurtka kultowej marki, rosmiar S. ', 4, 2);
INSERT INTO PRODUCT (id, image, product_name, product_price, product_description, category_id, user_id) VALUES (4,'sluchawki.jpg', 'Air 3 Pro ', 80,'NOWE!!! Słuchawki bezprzewodowe Air 3 Pro TWS AirPods IOS, Android.', 1, 1);
INSERT INTO PRODUCT (id, image, product_name, product_price, product_description, category_id, user_id) VALUES (5,'hamak.jpg', 'Hamak na ogród ', 120,'OGRODOWY HAMAK Z PROFILOWANYM STELAŻEM 80x200CM WYPRZEDAŻ HIT CENOWY !!! SUPER CENA !!', 4, 1);


