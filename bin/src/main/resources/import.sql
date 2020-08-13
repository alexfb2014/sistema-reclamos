INSERT INTO clientes(id,nombre,apellido,numdoc,email,telefono,direccion) VALUES(1,'Alex','Fernandez','9522452','alexafb_12@hotmail.com','967187791','Piura');
INSERT INTO clientes(id,nombre,apellido,numdoc,email,telefono,direccion) VALUES(2,'Danika','Martinez','9466652','Danika@hotmail.com','967187791','Piura');
INSERT INTO clientes(id,nombre,apellido,numdoc,email,telefono,direccion) VALUES(3,'Jon Jairo','Arias','56555585','alexafb_12@hotmail.com','967187791','Piura');
INSERT INTO clientes(id,nombre,apellido,numdoc,email,telefono,direccion) VALUES(4,'John Jairo','Velasquez','9522452' ,'Velasquez@hotmail.com','967187791','Piura');
INSERT INTO clientes(id,nombre,apellido,numdoc,email,telefono,direccion) VALUES(5,'David','Rodriguez','9848452' ,'Rodriguez@hotmail.com','967187791','Piura');
INSERT INTO clientes(id,nombre,apellido,numdoc,email,telefono,direccion) VALUES(6,'Hugo','Martinez','945454' ,'Martinez@hotmail.com','967187791','Piura');
INSERT INTO clientes(id,nombre,apellido,numdoc,email,telefono,direccion) VALUES(7,'Hugo','Aguilar','9845454' ,'Aguilar@hotmail.com','967187791','Piura');
INSERT INTO clientes(id,nombre,apellido,numdoc,email,telefono,direccion) VALUES(8,'Jose','Serrano','9555556' ,'Serrano@hotmail.com','967187791','Piura');

INSERT INTO productos(id, detalle) VALUES(1, 'Tarjeta Debito');
INSERT INTO productos(id, detalle) VALUES(2, 'Cuenta CTS');
INSERT INTO productos(id, detalle) VALUES(3, 'Cuenta Plazo Fijo');
INSERT INTO productos(id, detalle) VALUES(4, 'Cajeros Automaticos');
INSERT INTO productos(id, detalle) VALUES(5, 'Transacciones Via internet');


INSERT INTO motivos(id, detalle) VALUES(1, 'Inadecuada atencio al usuario');
INSERT INTO motivos(id, detalle) VALUES(2, 'Reporte indebido en la central de riesgo');
INSERT INTO motivos(id, detalle) VALUES(3, 'Entrega de billetes falsos');
INSERT INTO motivos(id, detalle) VALUES(4, 'Publicidad engañosa');


/* Users */
INSERT INTO `users` (`username`,`password`,`enabled`,`id_cliente`) VALUES ('admin','$2a$10$3I1a0AigsRw3TD0q5icTJ.wd18A1pCvbFaOOXv1Hsae95/Y.Y7bz6',1,1);
INSERT INTO `users` (`username`,`password`,`enabled`,`id_cliente`) VALUES ('alex','$2a$10$AGy7F8JulVSP6LYJfvH94OcbgzCxCq8HQ5ohNXmvUZlRprrbaj7HO',1,2);


INSERT INTO authorities (user_id,authority) VALUES(1,'ROLE_USER');
INSERT INTO authorities (user_id,authority) VALUES(1,'ROLE_ADMIN');
INSERT INTO authorities (user_id,authority) VALUES(2,'ROLE_USER');