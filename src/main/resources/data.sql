insert into usuario (idusuario, nombreusuario, contraseña, rol)values(1,'belen', '$2y$12$dFRK.uWhIxE4MFLSgl1fHe9MqQjN10fQugKEunICFus0sCrpc.Vp.', 'USER');
insert into usuario (idusuario, nombreusuario, contraseña, rol)values(2,'admin', '$2y$12$CtmSx0T7ZcV2tcEWi0uWNurObg7cORQQ2DT6i3xNFz44ZxndZfYEm', 'ADMIN');

insert into articulo (codigoarticulo, descripcion, estado, precio, usuario_id)values(1000,'Primer artículo', 1, 6.3,1);
insert into articulo (codigoarticulo, descripcion, estado, precio,usuario_id)values(1001,'Segundo artículo', 1, 1.3,1);
insert into articulo (codigoarticulo, descripcion, estado, precio, usuario_id)values(1002, 'Tercer artículo', 1, 6.3,1);
insert into articulo (codigoarticulo, descripcion, estado, precio, usuario_id)values(1003,'Cuarto artículo', 1, 9.3,1);
insert into articulo (codigoarticulo, descripcion, estado, precio, usuario_id)values(1004,'Quinto artículo', 2, 9.3,1);

insert into proveedor (idproveedor, nombre, pais)values(1,'Muebles Norte', 'España');
insert into proveedor (idproveedor, nombre, pais)values(2,'Ikea Suecia', 'Suecia');
insert into proveedor (idproveedor, nombre, pais)values(3,'La Quinta Puerta', 'España');

insert into articulo_proveedor (proveedor_id, articulo_id)values(1,1);
insert into articulo_proveedor (proveedor_id, articulo_id)values(1,2);
insert into articulo_proveedor (proveedor_id, articulo_id)values(2,2);
insert into articulo_proveedor (proveedor_id, articulo_id)values(3,3);

insert into reduccion (idreduccion, creacion, inicio, fin, articulo_id, cantidad, activo)values(1, PARSEDATETIME(20211501133321, 'yyyyMMddHHmmss'), PARSEDATETIME(20211501133321, 'yyyyMMddHHmmss'), PARSEDATETIME(20213101133321, 'yyyyMMddHHmmss'),1, 0.5, false);
insert into reduccion (idreduccion, creacion, inicio, fin, articulo_id,cantidad, activo)values(2, PARSEDATETIME(20211501133321, 'yyyyMMddHHmmss'), PARSEDATETIME(20211501133321, 'yyyyMMddHHmmss'), PARSEDATETIME(20213101133321, 'yyyyMMddHHmmss'),2, 0.1, false);
