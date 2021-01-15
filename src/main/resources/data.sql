insert into articulo (idarticulo, codigoarticulo, descripcion, estado, precio)values(1,1,'Primer artículo', 1, 6.3);
insert into articulo (idarticulo, codigoarticulo, descripcion, estado, precio)values(2,2,'Segundo artículo', 1, 1.3);
insert into articulo (idarticulo, codigoarticulo, descripcion, estado, precio)values(3,3,'Tercer artículo', 1, 6.3);
insert into articulo (idarticulo, codigoarticulo, descripcion, estado, precio)values(4,4,'Cuarto artículo', 1, 9.3);
insert into articulo (idarticulo, codigoarticulo, descripcion, estado, precio)values(5,5,'Quinto artículo', 2, 9.3);

insert into usuario (idusuario, nombreusuario, contraseña, tipo)values(1,'belen', 'belen', 'usuario');
insert into usuario (idusuario, nombreusuario, contraseña, tipo)values(2,'admin', 'admin', 'admin');

insert into reduccion (idreduccion, usuario_id, creacion, inicio, fin, articulo_id)values(1,1, PARSEDATETIME(20211501133321, 'yyyyMMddHHmmss'), PARSEDATETIME(20211501133321, 'yyyyMMddHHmmss'), PARSEDATETIME(20213101133321, 'yyyyMMddHHmmss'),1);
insert into reduccion (idreduccion, usuario_id, creacion, inicio, fin, articulo_id)values(2,1, PARSEDATETIME(20211501133321, 'yyyyMMddHHmmss'), PARSEDATETIME(20211501133321, 'yyyyMMddHHmmss'), PARSEDATETIME(20213101133321, 'yyyyMMddHHmmss'),1);
