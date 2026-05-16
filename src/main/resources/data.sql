INSERT INTO zonas (id, mapbox_json, nombre_zona, peligrosidad) VALUES (1, '[coords...]', 'Castillo de San Fernando', 2);
INSERT INTO zonas (id, mapbox_json, nombre_zona, peligrosidad) VALUES (2, '[coords...]', 'El Palamo', 1);
INSERT INTO zonas (id, mapbox_json, nombre_zona, peligrosidad) VALUES (3, '[coords...]', 'San Juan Playa', 0);
INSERT INTO zonas (id, mapbox_json, nombre_zona, peligrosidad) VALUES (4, '[coords...]', 'Sant Vicent', 2);
INSERT INTO zonas (id, mapbox_json, nombre_zona, peligrosidad) VALUES (5, '[coords...]', 'Sant Joan', 1);
INSERT INTO zonas (id, mapbox_json, nombre_zona, peligrosidad) VALUES (6, '[coords...]', 'Aeroport Alicante-Elche', 1);
INSERT INTO zonas (id, mapbox_json, nombre_zona, peligrosidad) VALUES (7, '[coords...]', 'Canada del Fenollar', 2);
INSERT INTO zonas (id, mapbox_json, nombre_zona, peligrosidad) VALUES (8, '[coords...]', 'Castillo de Santa Barbara', 2);

ALTER TABLE zonas ALTER COLUMN id RESTART WITH (SELECT COALESCE(MAX(id), 0) + 1 FROM zonas);


INSERT INTO tipos_objeto (id, nombre_tipo, icono) VALUES (1, 'Escalera', './escalera.png');
INSERT INTO tipos_objeto (id, nombre_tipo, icono) VALUES (2, 'Ascensor', './ascensor.png');
INSERT INTO tipos_objeto (id, nombre_tipo, icono) VALUES (3, 'Construccion', './construccion.png');
INSERT INTO tipos_objeto (id, nombre_tipo, icono) VALUES (4, 'Pasarela peatonal', './pasarela_peatonal.png');
INSERT INTO tipos_objeto (id, nombre_tipo, icono) VALUES (5, 'Puente', './Puente.png');
INSERT INTO tipos_objeto (id, nombre_tipo, icono) VALUES (6, 'Godzilla', './godzilla.png');
INSERT INTO tipos_objeto (id, nombre_tipo, icono) VALUES (7, 'Escalera mecanica', './escalera_mecanica.png');
INSERT INTO tipos_objeto (id, nombre_tipo, icono) VALUES (8, 'Pasaje subterraneo', './Pasaje_subterraneo.png');
INSERT INTO tipos_objeto (id, nombre_tipo, icono) VALUES (9, 'Parque', './parque.png');

ALTER TABLE tipos_objeto ALTER COLUMN id RESTART WITH (SELECT COALESCE(MAX(id), 0) + 1 FROM tipos_objeto);


INSERT INTO objetos (id, mapbox_json, nombre_objeto, descripcion, imagen, peligrosidad, id_zona, id_tipo_objeto) VALUES (1, '[coords...]', 'Escalera de Castillo De San Fernando', 'Escaleras de arte para subir al Castillo de San Fernando', './escalera_castillo_san_fernanodo.png', 1, 1, 1);
INSERT INTO objetos (id, mapbox_json, nombre_objeto, descripcion, imagen, peligrosidad, id_zona, id_tipo_objeto) VALUES (2, '[coords...]', 'Parque de San Juan', 'El parque de San Juan cerca de NTT Data', './parque_san_juan.png', 1, 3, 9);
INSERT INTO objetos (id, mapbox_json, nombre_objeto, descripcion, imagen, peligrosidad, id_zona, id_tipo_objeto) VALUES (3, '[coords...]', 'Ascensor de Castillo de Santa Barbara', 'Ascensor de castillo de Santa Barbara para subrise', './ascensor_castillo.png', 0, 8, 2);
INSERT INTO objetos (id, mapbox_json, nombre_objeto, descripcion, imagen, peligrosidad, id_zona, id_tipo_objeto) VALUES (4, '[coords...]', 'Construccion de Castillo De San Fernando', 'Construccion de Castillo de San Fernando', './construccion_castillo_san_fernando.png', 2, 1, 3);
INSERT INTO objetos (id, mapbox_json, nombre_objeto, descripcion, imagen, peligrosidad, id_zona, id_tipo_objeto) VALUES (5, '[coords...]', 'Ascensor de Castillo De San Fernando', 'Ascensor  para subir al Castillo de San Fernando', './ascensor_castillo_san_fernando.png', 1, 1, 2);
INSERT INTO objetos (id, mapbox_json, nombre_objeto, descripcion, imagen, peligrosidad, id_zona, id_tipo_objeto) VALUES (6, '[coords...]', 'Escalera de Castillo de Santa Barbara', 'Escaleras de arte para subir al Castillo de San Fernando', './escalera_castillo_santa_barbara.png', 1, 8, 1);
INSERT INTO objetos (id, mapbox_json, nombre_objeto, descripcion, imagen, peligrosidad, id_zona, id_tipo_objeto) VALUES (7, '[coords...]', 'Puente de Canada', 'Puente en Canadadel Fenollar', './puente_canada_fenollar.png', 0, 7, 5);
INSERT INTO objetos (id, mapbox_json, nombre_objeto, descripcion, imagen, peligrosidad, id_zona, id_tipo_objeto) VALUES (8, '[coords...]', 'Puente de Sant Vicent', 'Puente de Sant Vicent', './puente_sant_vicent.png', 2, 4, 5);
INSERT INTO objetos (id, mapbox_json, nombre_objeto, descripcion, imagen, peligrosidad, id_zona, id_tipo_objeto) VALUES (9, '[coords...]', 'Parque de Sant Joan', 'El Parque de Sant Joan', './parque_sant_joan.png', 1, 5, 9);
INSERT INTO objetos (id, mapbox_json, nombre_objeto, descripcion, imagen, peligrosidad, id_zona, id_tipo_objeto) VALUES (10, '[coords...]', 'Pasarela peatrol de San Juan', 'Pasarela peatrol de San Juan para pasar', './pasarela_peatrol_san_juan.png', 2, 3, 4);
INSERT INTO objetos (id, mapbox_json, nombre_objeto, descripcion, imagen, peligrosidad, id_zona, id_tipo_objeto) VALUES (11, '[coords...]', 'Pasarela peatrol Aeroporte Alicante-Elche', 'Pasarela peatrol en Aeroporte de Alicante-Elche', './pasarela_peatrol_aeropuerte_alicante_elche.png', 0, 6, 4);
INSERT INTO objetos (id, mapbox_json, nombre_objeto, descripcion, imagen, peligrosidad, id_zona, id_tipo_objeto) VALUES (12, '[coords...]', 'Construccion de Castillo de Santa Barbara', 'Construccion de Castillo de Santa Barbara muy peligrosa', './construccion_castillo_santa_barbara.png', 2, 8, 3);
INSERT INTO objetos (id, mapbox_json, nombre_objeto, descripcion, imagen, peligrosidad, id_zona, id_tipo_objeto) VALUES (13, '[coords...]', 'Escalera mecanica Aeroporte Alicante-Elche', 'Escalera mecanica en Aeroporte de Alicante-Elche para subirse', './escalera_mecanica_aeropuerte_alicante_elche.png', 1, 6, 7);
INSERT INTO objetos (id, mapbox_json, nombre_objeto, descripcion, imagen, peligrosidad, id_zona, id_tipo_objeto) VALUES (14, '[coords...]', 'Godzilla from movies', 'Big and scary Godzilla', './godzilla.png', 1, 7, 6);
INSERT INTO objetos (id, mapbox_json, nombre_objeto, descripcion, imagen, peligrosidad, id_zona, id_tipo_objeto) VALUES (15, '[coords...]', 'Pasaje subterraneo de El Palamo', 'Pasaje subterraneo de El Palamoe para pasar', './pasaje_subterraneo_el_palamoe.png', 0, 2, 8);
INSERT INTO objetos (id, mapbox_json, nombre_objeto, descripcion, imagen, peligrosidad, id_zona, id_tipo_objeto) VALUES (16, '[coords...]', 'Pasarela peatrol de El Palamo', 'Pasarela peatrol de El Palamo para pasar', './pasarela_peatrol_el_palamoe.png', 2, 2, 4);

ALTER TABLE objetos ALTER COLUMN id RESTART WITH (SELECT COALESCE(MAX(id), 0) + 1 FROM objetos);

INSERT INTO usuarios (id, nombre, apellido, username, password, email,  email_sec, tel, fecha_nac, administrador) VALUES (1, 'Admin','Administrador', 'admin',  '$2a$10$fzcGgF.8xODz7ptkmZC.OeX1Kj5GDI//FhW2sG0vlshW6ZAKJky0e', 'admin@balmis.com','admin@balmis.es',  '34642745222', '1999-12-23', TRUE); -- password: 5678
INSERT INTO usuarios (id, nombre, apellido, username, password, email,  email_sec, tel, fecha_nac, administrador) VALUES (2, 'Vadim','Elshin', 'kotvtrysax',  '$2a$10$fzcGgF.8xODz7ptkmZC.OeX1Kj5GDI//FhW2sG0vlshW6ZAKJky0e', 'vadimelshin@balmis.com','vadimelshin@balmis.es',  '34644825222', '2001-11-01', TRUE); -- password: 5678
INSERT INTO usuarios (id, nombre, apellido, username, password, email,  email_sec, tel, fecha_nac, administrador) VALUES (3, 'Javier', 'Catala', 'profesor',  '$2a$10$fzcGgF.8xODz7ptkmZC.OeX1Kj5GDI//FhW2sG0vlshW6ZAKJky0e', 'javier@balmis.com','javier@balmis.es',  '34644984222', '2026-05-16',  TRUE); -- password: 1234
INSERT INTO usuarios (id, nombre, apellido, username, password, email,  email_sec, tel, fecha_nac, administrador) VALUES (4, 'Joe', 'Doe', 'user',  '$2a$10$ayw3FCBIkupFt5n9lrmJQe9XZMJhZiNCjaoOkXo/Ba0KZgymO01ce', 'joe@balmis.com','joe@balmis.es',  '33754984222', '2026-05-16',  FALSE); -- password: 1234
INSERT INTO usuarios (id, nombre, apellido, username, password, email,  email_sec, tel, fecha_nac, administrador) VALUES (5, 'Jose', 'Lopez', 'jose',  '$2a$10$ayw3FCBIkupFt5n9lrmJQe9XZMJhZiNCjaoOkXo/Ba0KZgymO01ce', 'jose@balmis.com','jose@balmis.es',  '33754994622', '1999-03-16',  FALSE); -- password: 1234
INSERT INTO usuarios (id, nombre, apellido, username, password, email,  email_sec, tel, fecha_nac, administrador) VALUES (6, 'Albert', 'White', 'albert',  '$2a$10$ayw3FCBIkupFt5n9lrmJQe9XZMJhZiNCjaoOkXo/Ba0KZgymO01ce', 'albert@balmis.com','albert@balmis.es',  '33754987652', '2000-12-01',  FALSE); -- password: 1234
INSERT INTO usuarios (id, nombre, apellido, username, password, email,  email_sec, tel, fecha_nac, administrador) VALUES (7, 'Arthur', 'Morgan', 'morgan',  '$2a$10$ayw3FCBIkupFt5n9lrmJQe9XZMJhZiNCjaoOkXo/Ba0KZgymO01ce', 'morgan@balmis.com','morgan@balmis.us',  '33754994622', '1863-12-12',  FALSE); -- password: 1234
INSERT INTO usuarios (id, nombre, apellido, username, password, email,  email_sec, tel, fecha_nac, administrador) VALUES (8, 'Isaac', 'Clark', 'clark',  '$2a$10$ayw3FCBIkupFt5n9lrmJQe9XZMJhZiNCjaoOkXo/Ba0KZgymO01ce', 'isaac@balmis.com','isaac@balmis.es',  '38544984222', '2465-01-01',  FALSE); -- password: 1234
INSERT INTO usuarios (id, nombre, apellido, username, password, email,  email_sec, tel, fecha_nac, administrador) VALUES (9, 'Leon', 'Kennedy', 'leon',  '$2a$10$ayw3FCBIkupFt5n9lrmJQe9XZMJhZiNCjaoOkXo/Ba0KZgymO01ce', 'leon@balmis.com','leon@balmis.es',  '33754765622', '1977-03-03',  FALSE); -- password: 1234

ALTER TABLE usuarios ALTER COLUMN id RESTART WITH (SELECT COALESCE(MAX(id), 0) + 1 FROM usuarios);


INSERT INTO rutas (id, mapbox_json, nombre_ruta, descripcion, fecha_pub, likes_count, published, id_zona, id_usuario_autor) VALUES (1, '[coords...]', 'Subir a Castillo de San Fernando', 'La ruta para subir a Castillo de San Fernando', '2026-05-16', 30, false, 1, 1);
INSERT INTO rutas (id, mapbox_json, nombre_ruta, descripcion, fecha_pub, likes_count, published, id_zona, id_usuario_autor) VALUES (2, '[coords...]', 'Bajar de Castillo de San Fernando', 'La ruta para bajar de Castillo de San Fernando', '2026-05-16', 44, true, 1, 1);
INSERT INTO rutas (id, mapbox_json, nombre_ruta, descripcion, fecha_pub, likes_count, published, id_zona, id_usuario_autor) VALUES (3, '[coords...]', 'Rodear el Castillo de San Fernando', 'La ruta para rodear el Castillo de San Fernando', '2026-05-16', 35, false, 1, 1);
INSERT INTO rutas (id, mapbox_json, nombre_ruta, descripcion, fecha_pub, likes_count, published, id_zona, id_usuario_autor) VALUES (4, '[coords...]', 'Subir a Castillo de Santa Barbara', 'La ruta para subir a Castillo de Santa Barbara', '2026-05-16', 18, true, 8, 2);
INSERT INTO rutas (id, mapbox_json, nombre_ruta, descripcion, fecha_pub, likes_count, published, id_zona, id_usuario_autor) VALUES (5, '[coords...]', 'Bajar de Castillo de Santa Barbara', 'La ruta para bajar de Castillo de Santa Barbara', '2026-05-16', 7, false, 8, 2);
INSERT INTO rutas (id, mapbox_json, nombre_ruta, descripcion, fecha_pub, likes_count, published, id_zona, id_usuario_autor) VALUES (6, '[coords...]', 'Rodear el Castillo de Santa Barbara', 'La ruta para rodear el Castillo de Santa Barbara', '2026-05-16', 31, true, 8, 2);
INSERT INTO rutas (id, mapbox_json, nombre_ruta, descripcion, fecha_pub, likes_count, published, id_zona, id_usuario_autor) VALUES (7, '[coords...]', 'Paseo San Juan', 'La ruta para pasear por San Juan', '2026-05-16', 59, true, 3, 3);
INSERT INTO rutas (id, mapbox_json, nombre_ruta, descripcion, fecha_pub, likes_count, published, id_zona, id_usuario_autor) VALUES (8, '[coords...]', 'Paseo San Vicent', 'La ruta para pasear por San Vicent', '2026-05-16', 11, false, 4, 4);
INSERT INTO rutas (id, mapbox_json, nombre_ruta, descripcion, fecha_pub, likes_count, published, id_zona, id_usuario_autor) VALUES (9, '[coords...]', 'Paseo San Joan', 'La ruta para pasear por San Joan', '2026-05-16', 33, false, 5, 5);
INSERT INTO rutas (id, mapbox_json, nombre_ruta, descripcion, fecha_pub, likes_count, published, id_zona, id_usuario_autor) VALUES (10, '[coords...]', 'Paseo El Palamo', 'La ruta para pasear por El Palamo', '2026-05-16', 48, false, 2, 6);
INSERT INTO rutas (id, mapbox_json, nombre_ruta, descripcion, fecha_pub, likes_count, published, id_zona, id_usuario_autor) VALUES (11, '[coords...]', 'Paseo Canada de Fenollar', 'La ruta para pasear por Canada de Fenollar', '2026-05-16', 20, false, 7, 7);
INSERT INTO rutas (id, mapbox_json, nombre_ruta, descripcion, fecha_pub, likes_count, published, id_zona, id_usuario_autor) VALUES (12, '[coords...]', 'Como llegar al aeropuerto', 'La ruta para llegar al Aeropuerto Alicante-Elche', '2026-05-16',15, false, 6, 8);
INSERT INTO rutas (id, mapbox_json, nombre_ruta, descripcion, fecha_pub, likes_count, published, id_zona, id_usuario_autor) VALUES (13, '[coords...]', 'Como salir del aeropuerto', 'La ruta para salir del Aeropuerto Alicante-Elche', '2026-05-16', 9, false, 6, 8);
INSERT INTO rutas (id, mapbox_json, nombre_ruta, descripcion, fecha_pub, likes_count, published, id_zona, id_usuario_autor) VALUES (14, '[coords...]', 'Como salidar Godzilla', 'La ruta para saludar Gozilla', '2026-05-16', 54, true, 1, 9);
INSERT INTO rutas (id, mapbox_json, nombre_ruta, descripcion, fecha_pub, likes_count, published, id_zona, id_usuario_autor) VALUES (15, '[coords...]', 'Como huir de Godzilla', 'La ruta para huir de Gozilla', '2026-05-16', 54, true, 1, 9);

ALTER TABLE rutas ALTER COLUMN id RESTART WITH (SELECT COALESCE(MAX(id), 0) + 1 FROM rutas);


INSERT INTO likes (id_usuario, id_ruta) VALUES (1, 1);
INSERT INTO likes (id_usuario, id_ruta) VALUES (2, 1);

INSERT INTO comentarios (id, comentario, fecha_pub, id_usuario, id_ruta) VALUES (1, 'Wow, que buena ruta!', '2026-05-16', 2, 1);
INSERT INTO comentarios (id, comentario, fecha_pub, id_usuario, id_ruta) VALUES (2, 'Perfecto', '2026-05-16', 1, 2);
INSERT INTO comentarios (id, comentario, fecha_pub, id_usuario, id_ruta) VALUES (3, 'Me gustaba', '2026-05-16', 3, 4);
INSERT INTO comentarios (id, comentario, fecha_pub, id_usuario, id_ruta) VALUES (4, 'Para mi no sirve, pero...', '2026-05-16', 4, 3);
INSERT INTO comentarios (id, comentario, fecha_pub, id_usuario, id_ruta) VALUES (5, 'Sirve para me', '2026-05-16', 4, 5);
INSERT INTO comentarios (id, comentario, fecha_pub, id_usuario, id_ruta) VALUES (6, 'Hay cosas que me gustaron, pero...', '2026-05-16', 4, 6);
INSERT INTO comentarios (id, comentario, fecha_pub, id_usuario, id_ruta) VALUES (7, 'Ruta muy buena', '2026-05-16', 6, 1);
INSERT INTO comentarios (id, comentario, fecha_pub, id_usuario, id_ruta) VALUES (8, 'Podria ser mejor', '2026-05-16', 6, 2);
INSERT INTO comentarios (id, comentario, fecha_pub, id_usuario, id_ruta) VALUES (9, 'Bueno', '2026-05-16', 6, 3);
INSERT INTO comentarios (id, comentario, fecha_pub, id_usuario, id_ruta) VALUES (10, 'Terrible', '2026-05-16', 8, 1);
INSERT INTO comentarios (id, comentario, fecha_pub, id_usuario, id_ruta) VALUES (11, 'Qué bonito', '2026-05-16', 7, 14);
INSERT INTO comentarios (id, comentario, fecha_pub, id_usuario, id_ruta) VALUES (12, 'Qué horror', '2026-05-16', 7, 15);

ALTER TABLE comentarios ALTER COLUMN id RESTART WITH (SELECT COALESCE(MAX(id), 0) + 1 FROM comentarios);

INSERT INTO mensajes (id, titulo, mensaje, nombre, email, tel, fecha_pub) VALUES (1, 'Necesito una ayuda', 'The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by Inglés versions from the 1914 translation by H. Rackham.', 'Fernando Krasni', 'fernando@gmail.com', '34644825654', '2025-11-01');
INSERT INTO mensajes (id, titulo, mensaje, nombre, email, tel, fecha_pub) VALUES (2, 'Quiero informar de un error', 'The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by Inglés versions from the 1914 translation by H. Rackham.', 'John Karmak', 'john@gmail.com', '12344825654', '2025-11-01');
INSERT INTO mensajes (id, titulo, mensaje, nombre, email, tel, fecha_pub) VALUES (3, '¿Como crear ruta?', 'The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by Inglés versions from the 1914 translation by H. Rackham.', 'Danila Handsome', 'danila@gmail.com', '34765825654', '2025-11-01');
INSERT INTO mensajes (id, titulo, mensaje, nombre, email, tel, fecha_pub) VALUES (4, 'Ayudame!', 'The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by Inglés versions from the 1914 translation by H. Rackham.', 'Fernando Krasni', 'fernando@gmail.com', '34644825654', '2025-11-01');
INSERT INTO mensajes (id, titulo, mensaje, nombre, email, tel, fecha_pub) VALUES (5, 'Mi idea', 'The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by Inglés versions from the 1914 translation by H. Rackham.', 'John Karmak', 'john@gmail.com', '12344825654', '2025-11-01');
INSERT INTO mensajes (id, titulo, mensaje, nombre, email, tel, fecha_pub) VALUES (6, '¿Como publicar mi ruta?', 'The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by Inglés versions from the 1914 translation by H. Rackham.', 'Danila Handsome', 'danila@gmail.com', '34765825654', '2025-11-01');

 ALTER TABLE mensajes ALTER COLUMN id RESTART WITH (SELECT COALESCE(MAX(id), 0) + 1 FROM mensajes);


INSERT INTO lineas_objetos (id_ruta, id_objeto) VALUES (1, 1);
INSERT INTO lineas_objetos (id_ruta, id_objeto) VALUES (1, 2);
INSERT INTO lineas_objetos (id_ruta, id_objeto) VALUES (2, 3);
INSERT INTO lineas_objetos (id_ruta, id_objeto) VALUES (3, 4);


INSERT INTO lineas_rutas_fav (id_usuario, id_ruta) VALUES (1, 1);
INSERT INTO lineas_rutas_fav (id_usuario, id_ruta) VALUES (2, 1);
INSERT INTO lineas_rutas_fav (id_usuario, id_ruta) VALUES (1, 2);


INSERT INTO ajustes (id, tema, idioma, foto, recibir_noticias, recibir_notificaciones, id_usuario) VALUES (1, 'Dark', 'Inglés', './foto_example.jpg', true, false, 1);
INSERT INTO ajustes (id, tema, idioma, foto, recibir_noticias, recibir_notificaciones, id_usuario) VALUES (2, 'Light', 'Español', './foto_example.jpg', false, false, 2);
INSERT INTO ajustes (id, tema, idioma, foto, recibir_noticias, recibir_notificaciones, id_usuario) VALUES (3, 'Dark', 'Inglés', './foto_example.jpg', true, true, 3);
INSERT INTO ajustes (id, tema, idioma, foto, recibir_noticias, recibir_notificaciones, id_usuario) VALUES (4, 'Dark', 'Inglés', './foto_example.jpg', true, false, 4);
INSERT INTO ajustes (id, tema, idioma, foto, recibir_noticias, recibir_notificaciones, id_usuario) VALUES (5, 'Light', 'Español', './foto_example.jpg', false, false, 5);
INSERT INTO ajustes (id, tema, idioma, foto, recibir_noticias, recibir_notificaciones, id_usuario) VALUES (6, 'Dark', 'Inglés', './foto_example.jpg', true, true, 6);
INSERT INTO ajustes (id, tema, idioma, foto, recibir_noticias, recibir_notificaciones, id_usuario) VALUES (7, 'Dark', 'Inglés', './foto_example.jpg', true, false, 7);
INSERT INTO ajustes (id, tema, idioma, foto, recibir_noticias, recibir_notificaciones, id_usuario) VALUES (8, 'Light', 'Español', './foto_example.jpg', false, false, 8);
INSERT INTO ajustes (id, tema, idioma, foto, recibir_noticias, recibir_notificaciones, id_usuario) VALUES (9, 'Dark', 'Inglés', './foto_example.jpg', true, true, 9);

ALTER TABLE ajustes ALTER COLUMN id RESTART WITH (SELECT COALESCE(MAX(id), 0) + 1 FROM ajustes);


INSERT INTO solicitudes (id_usuario, id_ruta, fecha_pub, aprobada) VALUES (1, 1, '2026-05-16', null);
INSERT INTO solicitudes (id_usuario, id_ruta, fecha_pub, aprobada) VALUES (1, 3, '2026-05-16', null);
INSERT INTO solicitudes (id_usuario, id_ruta, fecha_pub, aprobada) VALUES (2, 5, '2026-05-16', null);
INSERT INTO solicitudes (id_usuario, id_ruta, fecha_pub, aprobada) VALUES (4, 8, '2026-05-16', null);
INSERT INTO solicitudes (id_usuario, id_ruta, fecha_pub, aprobada) VALUES (5, 9, '2026-05-16', null);
INSERT INTO solicitudes (id_usuario, id_ruta, fecha_pub, aprobada) VALUES (6, 10, '2026-05-16', null);