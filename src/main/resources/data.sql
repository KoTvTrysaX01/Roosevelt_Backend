INSERT INTO zonas (id, mapbox_json, nombre_zona, peligrosidad) VALUES (1, 'qweqwe', 'qweq', 1);
INSERT INTO zonas (id, mapbox_json, nombre_zona, peligrosidad) VALUES (2, 'qwqwd', 'asd', 2);
INSERT INTO zonas (id, mapbox_json, nombre_zona, peligrosidad) VALUES (3, 'coords: ...', 'Ensanche Diputación', 2);

ALTER TABLE zonas ALTER COLUMN id RESTART WITH (SELECT COALESCE(MAX(id), 0) + 1 FROM zonas);

INSERT INTO tipos_objeto (id, nombre_tipo, icono) VALUES (1, 'Escalera', './escalera.png');
INSERT INTO tipos_objeto (id, nombre_tipo, icono) VALUES (2, 'Ascensor', './ascensor.png');
INSERT INTO tipos_objeto (id, nombre_tipo, icono) VALUES (3, 'Construcción', './construcción.png');

ALTER TABLE tipos_objeto ALTER COLUMN id RESTART WITH (SELECT COALESCE(MAX(id), 0) + 1 FROM tipos_objeto);

INSERT INTO objetos (id, mapbox_json, nombre_objeto, descripcion, imagen, peligrosidad, id_zona, id_tipo_objeto) VALUES (1, '[-0.481472302211273, 38.34839297758327]', 'Escalera de Castillo', 'Escalera muy grande', './escalera_castillo.png', 1, 1, 1);
INSERT INTO objetos (id, mapbox_json, nombre_objeto, descripcion, imagen, peligrosidad, id_zona, id_tipo_objeto) VALUES (2, '[-0.4803870927337073, 38.34908023870918]', 'Escalera de Castillo 2', 'Escalera muy muy grande', './escalera_castillo.png', 1, 1, 1);
INSERT INTO objetos (id, mapbox_json, nombre_objeto, descripcion, imagen, peligrosidad, id_zona, id_tipo_objeto) VALUES (3, '[-0.47735138279091416, 38.3471234043368]', 'Ascensor de Castillo', 'Ascensor muy grande', './ascensor_castillo.png', 0, 1, 2);
INSERT INTO objetos (id, mapbox_json, nombre_objeto, descripcion, imagen, peligrosidad, id_zona, id_tipo_objeto) VALUES (4, '[-0.47811194504853916, 38.35206531783055]', 'Construccion de Castillo', 'Construccion muy grande', './construccion_castillo.png', 2, 1, 3);

ALTER TABLE objetos ALTER COLUMN id RESTART WITH (SELECT COALESCE(MAX(id), 0) + 1 FROM objetos);


INSERT INTO usuarios (id, nombre, apellido, username, password, email,  email_sec, tel, fecha_nac, administrador) VALUES
(1, 'vadim','elshin', 'admin',  '$2a$10$fzcGgF.8xODz7ptkmZC.OeX1Kj5GDI//FhW2sG0vlshW6ZAKJky0e', 'admin@balmis.com','admin1@balmis.com',  '100000000', '1990-01-01',  TRUE), -- password: 5678
(2, 'john', 'doe', 'user',  '$2a$10$ayw3FCBIkupFt5n9lrmJQe9XZMJhZiNCjaoOkXo/Ba0KZgymO01ce', 'user@balmis.com','us@balmis.com',  '200000000', '1991-01-01',  FALSE), -- password: 1234
(3, 'Jose', 'Lopez', 'user1',  '$2a$10$ayw3FCBIkupFt5n9lrmJQe9XZMJhZiNCjaoOkXo/Ba0KZgymO01ce', 'user1@balmis.com','us1@balmis.com',  '200000000', '1991-01-01',  FALSE), -- password: 1234
(4, 'algo', 'otro', 'user2',  '$2a$10$ayw3FCBIkupFt5n9lrmJQe9XZMJhZiNCjaoOkXo/Ba0KZgymO01ce', 'user2@balmis.com','us2@balmis.com',  '200000000', '1991-01-01',  FALSE); -- password: 1234

-- '$2a$10$n1/e13.wUb0ESrCxjZUNsunO4h/Go9QH1/25co1Scd6DQx1O51/KC' ==>  password: password
-- '$2a$10$APUnUaXbTtPf8AjQqzeHAOTzTw.wFUimrqrSn33dKD6hrO4JR.jcu' ==> password: admin

ALTER TABLE usuarios ALTER COLUMN id RESTART WITH (SELECT COALESCE(MAX(id), 0) + 1 FROM usuarios);


INSERT INTO rutas (id, mapbox_json, nombre_ruta, descripcion, fecha_pub, likes_count, published, id_zona, id_usuario_autor) VALUES (1, 'coords...', 'Sun', '123', '1990-01-01', 3, false, 1, 1);
INSERT INTO rutas (id, mapbox_json, nombre_ruta, descripcion, fecha_pub, likes_count, published, id_zona, id_usuario_autor) VALUES (2, 'coords...', 'Moon', '456', '1990-01-01', 4, false, 1, 2);
INSERT INTO rutas (id, mapbox_json, nombre_ruta, descripcion, fecha_pub, likes_count, published, id_zona, id_usuario_autor) VALUES (3, 'coords...', 'Ruta #3', '789', '1990-01-01', 5, false, 1, 2);

ALTER TABLE rutas ALTER COLUMN id RESTART WITH (SELECT COALESCE(MAX(id), 0) + 1 FROM rutas);


INSERT INTO likes (id_usuario, id_ruta) VALUES (1, 1);
INSERT INTO likes (id_usuario, id_ruta) VALUES (2, 1);

-- INSERT INTO likes (id_usuario, id_ruta) VALUES (2, 1);
-- INSERT INTO likes (id_usuario, id_ruta) VALUES (3, 2);

INSERT INTO comentarios (id, comentario, fecha_pub, id_usuario, id_ruta) VALUES (1, 'Ruta muy buena', '1991-01-01', 1, 1);
INSERT INTO comentarios (id, comentario, fecha_pub, id_usuario, id_ruta) VALUES (2, 'Perfecto', '1991-01-01', 2, 2);
INSERT INTO comentarios (id, comentario, fecha_pub, id_usuario, id_ruta) VALUES (3, 'Me gustaba', '1991-01-01', 3, 2);

ALTER TABLE comentarios ALTER COLUMN id RESTART WITH (SELECT COALESCE(MAX(id), 0) + 1 FROM comentarios);

INSERT INTO mensajes (id, titulo, mensaje, nombre, email, tel, fecha_pub) VALUES (1, 'Ayuda', 'The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.', 'vadim', 'example@gmail.com', '123456789', '2025-11-01');
INSERT INTO mensajes (id, titulo, mensaje, nombre, email, tel, fecha_pub) VALUES (2, 'Mi idea', 'The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.', 'vadim', 'example@gmail.com', '123456789', '2025-11-01');
INSERT INTO mensajes (id, titulo, mensaje, nombre, email, tel, fecha_pub) VALUES (3, '¿Como crear ruta?', 'The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.', 'vadim', 'example@gmail.com', '123456789', '2025-11-01');

ALTER TABLE mensajes ALTER COLUMN id RESTART WITH (SELECT COALESCE(MAX(id), 0) + 1 FROM mensajes);


INSERT INTO lineas_objetos (id_ruta, id_objeto) VALUES (1, 1);
INSERT INTO lineas_objetos (id_ruta, id_objeto) VALUES (1, 2);
INSERT INTO lineas_objetos (id_ruta, id_objeto) VALUES (2, 3);
INSERT INTO lineas_objetos (id_ruta, id_objeto) VALUES (3, 4);


INSERT INTO lineas_rutas_fav (id_usuario, id_ruta) VALUES (1, 1);
INSERT INTO lineas_rutas_fav (id_usuario, id_ruta) VALUES (2, 1);
INSERT INTO lineas_rutas_fav (id_usuario, id_ruta) VALUES (1, 2);


INSERT INTO ajustes (id, tema, idioma, foto, recibir_noticias, recibir_notificaciones, id_usuario) VALUES (1, 'dark', 'english', './example.jpg', true, false, 1);
INSERT INTO ajustes (id, tema, idioma, foto, recibir_noticias, recibir_notificaciones, id_usuario) VALUES (2, 'light', 'spanish', './example.jpg', false, false, 2);
INSERT INTO ajustes (id, tema, idioma, foto, recibir_noticias, recibir_notificaciones, id_usuario) VALUES (3, 'dark', 'english', './example.jpg', true, true, 3);
ALTER TABLE ajustes ALTER COLUMN id RESTART WITH (SELECT COALESCE(MAX(id), 0) + 1 FROM ajustes);


INSERT INTO solicitudes (id_usuario, id_ruta, fecha_pub, aprobada) VALUES (1, 1, '1991-01-01', null);
INSERT INTO solicitudes (id_usuario, id_ruta, fecha_pub, aprobada) VALUES (1, 2, '1991-01-01', false);
INSERT INTO solicitudes (id_usuario, id_ruta, fecha_pub, aprobada) VALUES (1, 3, '1991-01-01', null);