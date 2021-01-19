insert into articulo (idarticulo, codigoarticulo, descripcion, estado, precio)values(1,1,'Primer artículo', 1, 6.3);
insert into articulo (idarticulo, codigoarticulo, descripcion, estado, precio)values(2,2,'Segundo artículo', 1, 1.3);
insert into articulo (idarticulo, codigoarticulo, descripcion, estado, precio)values(3,3,'Tercer artículo', 1, 6.3);
insert into articulo (idarticulo, codigoarticulo, descripcion, estado, precio)values(4,4,'Cuarto artículo', 1, 9.3);
insert into articulo (idarticulo, codigoarticulo, descripcion, estado, precio)values(5,5,'Quinto artículo', 2, 9.3);

insert into usuario (idusuario, nombreusuario, contraseña, tipo)values(1,'belen', '$2y$12$dFRK.uWhIxE4MFLSgl1fHe9MqQjN10fQugKEunICFus0sCrpc.Vp.', 'usuario');
insert into usuario (idusuario, nombreusuario, contraseña, tipo)values(2,'admin', '$2y$12$CtmSx0T7ZcV2tcEWi0uWNurObg7cORQQ2DT6i3xNFz44ZxndZfYEm', 'admin');

insert into proveedor (idproveedor, nombre, pais)values(1,'Muebles Norte', 'España');
insert into proveedor (idproveedor, nombre, pais)values(2,'Ikea Suecia', 'Suecia');
insert into proveedor (idproveedor, nombre, pais)values(3,'La Quinta Puerta', 'España');

insert into articulo_proveedor (proveedor_id, articulo_id)values(1,1);
insert into articulo_proveedor (proveedor_id, articulo_id)values(2,2);
insert into articulo_proveedor (proveedor_id, articulo_id)values(3,3);

insert into reduccion (idreduccion, usuario_id, creacion, inicio, fin, articulo_id)values(1,1, PARSEDATETIME(20211501133321, 'yyyyMMddHHmmss'), PARSEDATETIME(20211501133321, 'yyyyMMddHHmmss'), PARSEDATETIME(20213101133321, 'yyyyMMddHHmmss'),1);
insert into reduccion (idreduccion, usuario_id, creacion, inicio, fin, articulo_id)values(2,1, PARSEDATETIME(20211501133321, 'yyyyMMddHHmmss'), PARSEDATETIME(20211501133321, 'yyyyMMddHHmmss'), PARSEDATETIME(20213101133321, 'yyyyMMddHHmmss'),1);
