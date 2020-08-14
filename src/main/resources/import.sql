
INSERT INTO productos(id, detalle) VALUES(1, 'Tarjeta Debito');
INSERT INTO productos(id, detalle) VALUES(2, 'Cuenta CTS');
INSERT INTO productos(id, detalle) VALUES(3, 'Cuenta Plazo Fijo');
INSERT INTO productos(id, detalle) VALUES(4, 'Cajeros Automaticos');
INSERT INTO productos(id, detalle) VALUES(5, 'Transacciones Via internet');


INSERT INTO motivos(id, detalle) VALUES(1, 'Inadecuada atencio al usuario');
INSERT INTO motivos(id, detalle) VALUES(2, 'Reporte indebido en la central de riesgo');
INSERT INTO motivos(id, detalle) VALUES(3, 'Entrega de billetes falsos');
INSERT INTO motivos(id, detalle) VALUES(4, 'Publicidad engañosa');


INSERT INTO tipodocumento(id, descripcion,longitud) VALUES(1, 'DNI',8);
INSERT INTO tipodocumento(id, descripcion,longitud) VALUES(2, 'CE',8);
INSERT INTO tipodocumento(id, descripcion,longitud) VALUES(3, 'RUC',11);

INSERT INTO estados(id, descripcion,detalle,rol) VALUES(1, 'registrado','Indica que la solicitud ha sido registrada por el cliente','cliente y entidad');
INSERT INTO estados(id, descripcion,detalle,rol) VALUES(2, 'evaluacion','Indica que la solicitud ha sido leida por Atencion al usuario y sera evaluada dentro de la entidad','cliente');
INSERT INTO estados(id, descripcion,detalle,rol) VALUES(3, 'finalizado','Indica que la entidad ha finalizado la solicitud y que se ha dado una respuesta','cliente y entidad');
INSERT INTO estados(id, descripcion,detalle,rol) VALUES(4, 'enviado','Indica que atencion al usuario envio la solicitud a un area competente para que dè su opinion','entidad');
INSERT INTO estados(id, descripcion,detalle,rol) VALUES(5, 'devuelto','Indica que area competente devuelve la solicitud a Atencion al usuario con su opinion','entidad');




INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(1,'Alex','Fernandez',1,'9522452','alexafb_12@hotmail.com','967187791','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(2,'Danika','Martinez',1,'9466652','Danika@hotmail.com','967187791','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(3,'Jon Jairo','Arias',1,'56555585','alexafb_12@hotmail.com','967187791','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(4,'John Jairo','Velasquez',1,'9522452' ,'Velasquez@hotmail.com','967187791','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(5,'David','Rodriguez',1,'9848452' ,'Rodriguez@hotmail.com','967187791','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(6,'Hugo','Martinez',1,'945454' ,'Martinez@hotmail.com','967187791','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(7,'Hugo','Aguilar',1,'9845454' ,'Aguilar@hotmail.com','967187791','Piura');
INSERT INTO clientes(id,nombre,apellido,id_tipodocumento,numdoc,email,telefono,direccion) VALUES(8,'Jose','Serrano',1,'9555556' ,'Serrano@hotmail.com','967187791','Piura');




/* Users */
INSERT INTO `users` (`username`,`password`,`enabled`,`id_cliente`) VALUES ('admin','$2a$10$3I1a0AigsRw3TD0q5icTJ.wd18A1pCvbFaOOXv1Hsae95/Y.Y7bz6',1,1);
INSERT INTO `users` (`username`,`password`,`enabled`,`id_cliente`) VALUES ('alex','$2a$10$AGy7F8JulVSP6LYJfvH94OcbgzCxCq8HQ5ohNXmvUZlRprrbaj7HO',1,2);


INSERT INTO authorities (user_id,authority) VALUES(1,'ROLE_USER');
INSERT INTO authorities (user_id,authority) VALUES(1,'ROLE_ADMIN');
INSERT INTO authorities (user_id,authority) VALUES(2,'ROLE_USER');