insert into usuario (idusuario, nombreusuario, contraseña, rol, nombre, apellidos, ciudad, telefono)values(1,'belen', '$2y$12$dFRK.uWhIxE4MFLSgl1fHe9MqQjN10fQugKEunICFus0sCrpc.Vp.', 'USER', 'Belen', 'Pulido Rivero', 'Santa María de Guía', '77889922');
insert into usuario (idusuario, nombreusuario, contraseña, rol, nombre, apellidos, ciudad, telefono)values(2,'belen2', '$2y$12$Y6pu12WAAx4ySAx1wl2CX.3aQ.q.2BcdmlNI9vQOB9TDto82IVN1C', 'USER', 'Belen', 'Pulido Rivero', 'Santa María de Guía', '77889922');
insert into usuario (idusuario, nombreusuario, contraseña, rol, nombre, apellidos, ciudad, telefono)values(3,'admin', '$2y$12$CtmSx0T7ZcV2tcEWi0uWNurObg7cORQQ2DT6i3xNFz44ZxndZfYEm', 'ADMIN', 'Belen', 'Pulido Rivero', 'Santa María de Guía', '77889922');

insert into articulo (codigoarticulo, descripcion, estado, precio, usuario_id)values(1000,'Herramientas multiusos para extracción de radios de coche', 1, 15.3,1);
insert into articulo (codigoarticulo, descripcion, estado, precio,usuario_id)values(1001,'Plancha para el pelo portátil, ideal para viajes', 1, 45.3,2);
insert into articulo (codigoarticulo, descripcion, estado, precio, usuario_id)values(1002, 'Herramientas de teclado para PC sobremesa con luces led', 1, 25.4,2);
insert into articulo (codigoarticulo, descripcion, estado, precio, usuario_id)values(1003,'Mochila para portátil con cargador USB incluído', 1, 45.2,2);
insert into articulo (codigoarticulo, descripcion, estado, precio, usuario_id)values(1004,'Ratón especial para el descanso de las muñecas', 2,60.3,1);
insert into articulo (codigoarticulo, descripcion, estado, precio, usuario_id)values(1005,'Fundas para asiento de coche universal', 2, 6.3,1);
insert into articulo (codigoarticulo, descripcion, estado, precio, usuario_id)values(1006,'Libreta con cargador USB para smartphone universal', 2, 10.3,1);
insert into articulo (codigoarticulo, descripcion, estado, precio, usuario_id)values(1007,'Almohadilla eléctrica portátil', 1, 19.3,1);
insert into articulo (codigoarticulo, descripcion, estado, precio, usuario_id)values(1008,'Televisión LG 50 pulgadas SMART TV', 1, 504.3,1);
insert into articulo (codigoarticulo, descripcion, estado, precio, usuario_id)values(1009,'Huaweii P30 Pro (Reacondicionado)', 1, 587.3,1);
insert into articulo (codigoarticulo, descripcion, estado, precio, usuario_id)values(1010,'Mueble TV', 1, 192.3,1);
insert into articulo (codigoarticulo, descripcion, estado, precio,usuario_id)values(1011,'Television SmartTV Samsung 32 pulgadas', 1, 201.3,2);
insert into articulo (codigoarticulo, descripcion, estado, precio, usuario_id)values(1012, 'Silla profesional de oficina', 1, 102.4,2);
insert into articulo (codigoarticulo, descripcion, estado, precio, usuario_id)values(1013,'Estantería Blanca', 1, 45.2,2);
insert into articulo (codigoarticulo, descripcion, estado, precio, usuario_id)values(1014,'Monitor LG 28 pulgadas', 2,102.3,1);
insert into articulo (codigoarticulo, descripcion, estado, precio, usuario_id)values(1015,'Router Xiaomi 5G', 2, 23.3,1);
insert into articulo (codigoarticulo, descripcion, estado, precio, usuario_id)values(1016,'Samsung galaxy s21+ (Reacondicionadi)', 2, 604.3,1);
insert into articulo (codigoarticulo, descripcion, estado, precio, usuario_id)values(1017,'Maquina de masajes', 1, 53.3,1);
insert into articulo (codigoarticulo, descripcion, estado, precio, usuario_id)values(1018,'Televisión LG 50 pulgadas SMART TV', 1, 504.3,1);
insert into articulo (codigoarticulo, descripcion, estado, precio, usuario_id)values(1019,'Huaweii P30 Pro (Reacondicionado)', 1, 587.3,1);

insert into proveedor (idproveedor, nombre, pais)values(1,'Muebles Norte', 'España');
insert into proveedor (idproveedor, nombre, pais)values(2,'Ikea Suecia', 'Suecia');
insert into proveedor (idproveedor, nombre, pais)values(3,'La Quinta Puerta', 'España');

insert into articulo_proveedor (proveedor_id, articulo_id)values(1,1);
insert into articulo_proveedor (proveedor_id, articulo_id)values(1,2);
insert into articulo_proveedor (proveedor_id, articulo_id)values(2,2);
insert into articulo_proveedor (proveedor_id, articulo_id)values(2,3);
insert into articulo_proveedor (proveedor_id, articulo_id)values(2,4);
insert into articulo_proveedor (proveedor_id, articulo_id)values(3,3);

--insert into reduccion (idreduccion, codigoreduccion, creacion, inicio, fin, articulo_id, cantidad, activo)values(1, 1000*1,  PARSEDATETIME(20211501133321, 'yyyyMMddHHmmss'), PARSEDATETIME(20211501133321, 'yyyyMMddHHmmss'), PARSEDATETIME(20213101133321, 'yyyyMMddHHmmss'),1, 0.5, false);
--insert into reduccion (idreduccion, codigoreduccion, creacion, inicio, fin, articulo_id,cantidad, activo)values(2, 2000*1,PARSEDATETIME(20211501133321, 'yyyyMMddHHmmss'), PARSEDATETIME(20211501133321, 'yyyyMMddHHmmss'), PARSEDATETIME(20213101133321, 'yyyyMMddHHmmss'),2, 0.1, false);
