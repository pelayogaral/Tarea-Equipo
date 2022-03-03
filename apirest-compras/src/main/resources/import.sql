INSERT INTO articulos (nombre,descripcion,precio_unidad,unidades_stock,stock_seguridad,imagen) values('Camiseta','Blanca',1,10,5,'imagen');
INSERT INTO articulos (nombre,descripcion,precio_unidad,unidades_stock,stock_seguridad,imagen) values('Balon','Roterio 2002',7,70,1,'imagen');
INSERT INTO articulos (nombre,descripcion,precio_unidad,unidades_stock,stock_seguridad,imagen) values('Manta','Calentita',4,26,2,'imagen');
INSERT INTO articulos (nombre,descripcion,precio_unidad,unidades_stock,stock_seguridad,imagen) values('Television','Samsung T500',8,32,3,'imagen');
INSERT INTO articulos (nombre,descripcion,precio_unidad,unidades_stock,stock_seguridad,imagen) values('Armario','Madera de roble',3,17,4,'imagen');

INSERT INTO clientes (nombre,apellidos,empresa,puesto,cp,provincia,telefono,fecha_nacimiento) values('Pablo','Saiergo Alonso','Capgemini','Electricista',33041,'Asturias',6666666,'1995-03-14');
INSERT INTO clientes (nombre,apellidos,empresa,puesto,cp,provincia,telefono,fecha_nacimiento) values('Pelayo','Garcia Alvarez','Capgemini','Camionero',33321,'Asturias',7777777,'1995-03-10');
INSERT INTO clientes (nombre,apellidos,empresa,puesto,cp,provincia,telefono,fecha_nacimiento) values('Mateusz Michal','Malasiewicz','Capgemini','Fontanero',33423,'Asturias',3333333,'1995-03-16');
INSERT INTO clientes (nombre,apellidos,empresa,puesto,cp,provincia,telefono,fecha_nacimiento) values('Jairo','Gonzalez Fernandez','Capgemini','Soldador',33231,'Asturias',9999999,'1995-03-15');

INSERT INTO compras (cliente_id, articulo_id, fecha, unidades) values (4, 3, '2022-03-02', 5)
INSERT INTO compras (cliente_id, articulo_id, fecha, unidades) values (3, 4, '2022-03-01', 6)
INSERT INTO compras (cliente_id, articulo_id, fecha, unidades) values (5, 3, '2022-03-04', 2)
