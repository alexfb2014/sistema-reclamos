/* Productos */
INSERT INTO productos(id, detalle) VALUES(1, 'Tarjeta Debito');
INSERT INTO productos(id, detalle) VALUES(2, 'Cuenta CTS');
INSERT INTO productos(id, detalle) VALUES(3, 'Cuenta Plazo Fijo');
INSERT INTO productos(id, detalle) VALUES(4, 'Cajeros Automaticos');
INSERT INTO productos(id, detalle) VALUES(5, 'Transacciones Via internet');
INSERT INTO productos(id, detalle) VALUES(6, 'Otras Operaciones, Servicios y/o Productos');

INSERT INTO motivos(id, detalle) VALUES(1, 'Inadecuada atención al usuario');
INSERT INTO motivos(id, detalle) VALUES(2, 'Reporte indebido en la central de riesgo');
INSERT INTO motivos(id, detalle) VALUES(3, 'Entrega de billetes falsos');
INSERT INTO motivos(id, detalle) VALUES(4, 'Publicidad engañosa');
INSERT INTO motivos(id, detalle) VALUES(5, 'Cancelación de cuenta');
INSERT INTO motivos(id, detalle) VALUES(6, 'Otros Motivos');

INSERT INTO tipossolicitud(id, descripcion) VALUES(1, 'Reclamo');
INSERT INTO tipossolicitud(id, descripcion) VALUES(2, 'Queja');
INSERT INTO tipossolicitud(id, descripcion) VALUES(3, 'Sugerencia');

INSERT INTO tipodocumento(id, descripcion,longitud) VALUES(1, 'DNI',8);
INSERT INTO tipodocumento(id, descripcion,longitud) VALUES(2, 'CE',8);
INSERT INTO tipodocumento(id, descripcion,longitud) VALUES(3, 'RUC',11);

INSERT INTO estados(id, descripcion,detalle,rol) VALUES(1, 'Registrado','Indica que la solicitud ha sido registrada por el cliente','cliente y entidad');
INSERT INTO estados(id, descripcion,detalle,rol) VALUES(2, 'Evaluacion','Indica que la solicitud ha sido leida por Atencion al usuario y sera evaluada dentro de la entidad','cliente');
INSERT INTO estados(id, descripcion,detalle,rol) VALUES(3, 'Finalizado','Indica que la entidad ha finalizado la solicitud y que se ha dado una respuesta','cliente y entidad');
INSERT INTO estados(id, descripcion,detalle,rol) VALUES(4, 'Enviado','Indica que atencion al usuario envio la solicitud a un area competente para que dè su opinion','entidad');
INSERT INTO estados(id, descripcion,detalle,rol) VALUES(5, 'Devuelto','Indica que area competente devuelve la solicitud a Atencion al usuario con su opinion','entidad');



/* clientes */
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(1,'Alex','Fernandez',1,'9522452','alexafb_12@hotmail.com','969687991','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(2,'Danika','Martinez',1,'9466652','Danika@hotmail.com','967187791','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(3,'Jorge Alberto','Cumpa Loyaga',3,'10164121611','jcumpalo@gmail.com','967187991','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(4,'Karoline Andreina','Chavez Zapata',1,'73676192' ,'karolinevirgo@hotmail.com','970287809','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(5,'David','Fernandez Vazquez',3,'10276626367' ,'davidfer21@hotmail.com','976456890','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(6,'Jorge Enrique','Marin Gonzales',1,'42388604' ,'jmaringoza@gmail.com','996127856','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(7,'Tadeo','Requejo Carrero',1,'33562458' ,'tadeo_requejoc@hotmail.com','997887221','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(8,'Juan Carlos','Marquez Lopez',1,'46967914' ,'juanmarquez@hotmail.com','912367221','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(9,'Kiara Mariel','Huaman Diaz',1,'72859897' ,'kiara2210@hotmail.com','998765823','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(10,'Julia Luisa','Sanchez Galdos',1,'09444172' ,'juliagaldos@gmail.com','969609864','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(11,'Vannesa Maria','Diaz Oveido',1,'41763832' ,'vanessa1992ez@hotmail.com','987756243','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(12,'Jose Tomas','Terrores Arteaga',1,'17859853' ,'jose653torres@hotmail.com','987349234','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(13,'Luis Alberto','Huerto Santolalla',1,'42189197' ,'luishuerto@gmail.com','989977622','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(14,'Jhon Anthony','Carrasc Cuzco',1,'41261812' ,'carrasco8761@hotmail.com','992267721','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(15,'Esteven Antonio','Avila Merino',1,'46788632' ,'estevenam@gmail.com','986345987','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(16,'Jorge Luis','Valencia Santos',1,'41379060' ,'valenciajorge@hotmail.com','999778123','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(17,'Kassandra','LLamo Torres',1,'73423734' ,'kassandra9822@gmail.com','970287890','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(18,'Evelyn Dayais','Nunura Castillo',1,'45671031' ,'evelyn_1888@hotmail.com','986123098','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(19,'Anthony Emilio','Vega Roman',1,'70340861' ,'emilio1992_08@hotmail.com','989987543','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(20,'Eduardo','Tassara Alva',1,'10548800' ,'tassaraeduardo@hotmail.com','998822908','Piura');



/* Users */
INSERT INTO `users` (`username`,`password`,`enabled`,`id_cliente`) VALUES ('admin','$2a$10$3I1a0AigsRw3TD0q5icTJ.wd18A1pCvbFaOOXv1Hsae95/Y.Y7bz6',1,1);
INSERT INTO `users` (`username`,`password`,`enabled`,`id_cliente`) VALUES ('cliente','$2a$10$AGy7F8JulVSP6LYJfvH94OcbgzCxCq8HQ5ohNXmvUZlRprrbaj7HO',1,2);
INSERT INTO `users` (`username`,`password`,`enabled`,`id_cliente`) VALUES ('area','$2a$10$3rvDH3cseD3WEndm1yWgoeJ1v1pCbCVcIrkySf6tqEnr7hMaIhDwK',1,3);
INSERT INTO `users` (`username`,`password`,`enabled`,`id_cliente`) VALUES ('atencion','$2a$10$8Y6ejtWH0tpup7.YCTc8XuB28/nWntMdK6nCi.QYukjoWTnfkIOLq',1,4);


INSERT INTO authorities (user_id,authority) VALUES(1,'ROLE_CLIENTE');
INSERT INTO authorities (user_id,authority) VALUES(1,'ROLE_ADMIN');
INSERT INTO authorities (user_id,authority) VALUES(2,'ROLE_CLIENTE');
INSERT INTO authorities (user_id,authority) VALUES(3,'ROLE_AREA');
INSERT INTO authorities (user_id,authority) VALUES(4,'ROLE_ATENCION');


/* solicitudes y detalle*/
INSERT INTO solicitudes(id,fecha_registro,fecha_respuesta,notificacion,id_cliente,id_estado,id_estado_evalu,id_motivo,id_producto,id_tipo) VALUES(1,'2020-08-04',null,'telefono',2,1,1,4,5,1);
INSERT INTO detalle(id,archivo,detalle,opinion_area,pedido,respuesta,id_solicitud) VALUES(1,'','Las  transacciones via internet no se estan completando, pero pese a ello se esta descontando en mi cuenta','','se devuleva mi dinero a mi cuenta','',1);
INSERT INTO solicitudes(id,fecha_registro,fecha_respuesta,notificacion,id_cliente,id_estado,id_estado_evalu,id_motivo,id_producto,id_tipo) VALUES(2,'2020-08-12',null,'correo',2,1,1,5,3,2);
INSERT INTO detalle(id,archivo,detalle,opinion_area,pedido,respuesta,id_solicitud) VALUES(2,'','la cancelación de mi cuenta aun no se realiza ya ha pasado 2 semanas de la solicitud de cancelación, exijo que se realiza la cancelación','','exijo que se realiza la cancelación','',2);
INSERT INTO solicitudes(id,fecha_registro,fecha_respuesta,notificacion,id_cliente,id_estado,id_estado_evalu,id_motivo,id_producto,id_tipo) VALUES(3,'2020-08-06',null,'correo',1,2,4,2,3,1);
INSERT INTO detalle(id,archivo,detalle,opinion_area,pedido,respuesta,id_solicitud) VALUES(3,'','Solicitud una cuenta plazo fijo, me evaluan pero la central de riesgos dicen que aprueban, luego me indican que no y no dan una respuesta correcta, tal ves se han equivocado en su tasa y no lo admiten','Abrir cuenta de plazo fijo al cliente','exijo que se aperture mi cuenta de plazo fijo, o se han equivocado en la tasa que ofrecen','',3);
INSERT INTO solicitudes(id,fecha_registro,fecha_respuesta,notificacion,id_cliente,id_estado,id_estado_evalu,id_motivo,id_producto,id_tipo) VALUES(4,'2020-08-11',null,'correo',5,2,5,4,3,1);
INSERT INTO detalle(id,archivo,detalle,opinion_area,pedido,respuesta,id_solicitud) VALUES(4,'','solicito una apertura de cuenta a plazo fijo con la tasa de 4%, realizan la apertura pero al cabo de un mes me indican que esa no es la tasa que es de 3.7%, por lo que mi interes disminuye','Cliente firmo documentos en el que se la indico que la tasa es de 3.7%.','exijo que se realiza la tasa de mi cuenta cambie','',4);