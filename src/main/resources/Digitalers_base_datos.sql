drop database if exists digitalers_practica_base_datos;

create database if not exists digitalers_practica_base_datos;

use digitalers_practica_base_datos;

-- TABLA CIUDADES

drop table if exists ciudades;

create table if not exists ciudades(
	id_ciudad int(30) auto_increment,
	ciudad varchar(100) not null,
	provincia varchar(100),
	primary key(id_ciudad),
	key(ciudad)
)engine=InnoDB;

insert into ciudades(ciudad,provincia) values("Flores","CABA");
insert into ciudades(ciudad,provincia) values("Caballito","CABA");
insert into ciudades(ciudad,provincia) values("Villa Devoto","CABA");
insert into ciudades(ciudad,provincia) values("Recoleta","CABA");
insert into ciudades(ciudad,provincia) values("Belgrano","CABA");
insert into ciudades(ciudad,provincia) values("La Plata","Buenos Aires");
insert into ciudades(ciudad,provincia) values("San Isidro","Buenos Aires");
insert into ciudades(ciudad,provincia) values("San Justo","Buenos Aires");
insert into ciudades(ciudad,provincia) values("Tigre","Buenos Aires");
insert into ciudades(ciudad,provincia) values("Mar del Plata","Buenos Aires");
insert into ciudades(ciudad,provincia) values("Bahia Blanca","Buenos Aires");
insert into ciudades(ciudad,provincia) values("Lujan","Buenos Aires");
insert into ciudades(ciudad,provincia) values("Gualeguaychu","Entre Rios");
insert into ciudades(ciudad,provincia) values("Ciudad de Cordoba","Cordoba");
insert into ciudades(ciudad,provincia) values("Rosario","Santa Fe");
insert into ciudades(ciudad,provincia) values("Ciudad de Mendoza","Mendoza");
insert into ciudades(ciudad,provincia) values("Posadas","Misiones");
insert into ciudades(ciudad,provincia) values("La Quiaca","Jujuy");
insert into ciudades(ciudad,provincia) values("Ushuaia","Tierra del Fuego");

-- TABLA SUCURSALES

drop table if exists sucursales;

create table if not exists sucursales(
	nombre_sucursal varchar(100) not null,
	ciudad varchar(100) not null,
	primary key(nombre_sucursal),
	constraint fk_ciudad foreign key (ciudad) references ciudades(ciudad) on delete no action on update no action
)engine=InnoDB;

insert into sucursales(nombre_sucursal,ciudad) values("SUC1-FLORES","Flores");
insert into sucursales(nombre_sucursal,ciudad) values("SUC2-CABALLITO","Caballito");
insert into sucursales(nombre_sucursal,ciudad) values("SUC3-DEVOTO","Villa Devoto");
insert into sucursales(nombre_sucursal,ciudad) values("SUC4-RECOLETA","Recoleta");
insert into sucursales(nombre_sucursal,ciudad) values("SUC5-BELGRANO","Belgrano");
insert into sucursales(nombre_sucursal,ciudad) values("SUC6-LA PLATA","La Plata");
insert into sucursales(nombre_sucursal,ciudad) values("SUC7-SAN ISIDRO","San Isidro");
insert into sucursales(nombre_sucursal,ciudad) values("SUC8-SAN JUSTO","San Justo");
insert into sucursales(nombre_sucursal,ciudad) values("SUC9-TIGRE","Tigre");
insert into sucursales(nombre_sucursal,ciudad) values("SUC10-MAR DEL PLATA","Mar del Plata");
insert into sucursales(nombre_sucursal,ciudad) values("SUC11-BAHIA BLANCA","Bahia Blanca");
insert into sucursales(nombre_sucursal,ciudad) values("SUC12-LUJAN","Lujan");
insert into sucursales(nombre_sucursal,ciudad) values("SUC13-GUALEGUAYCHU","Gualeguaychu");
insert into sucursales(nombre_sucursal,ciudad) values("SUC14-CIUDAD CORDOBA","Ciudad de Cordoba");
insert into sucursales(nombre_sucursal,ciudad) values("SUC15-ROSARIO","Rosario");
insert into sucursales(nombre_sucursal,ciudad) values("SUC16-MENDOZA","Ciudad de Mendoza");
insert into sucursales(nombre_sucursal,ciudad) values("SUC17-POSADAS","Posadas");
insert into sucursales(nombre_sucursal,ciudad) values("SUC18-LA QUIACA","La Quiaca");
insert into sucursales(nombre_sucursal,ciudad) values("SUC19-USHUAIA","Ushuaia");

-- TABLA EMPLEADOS

drop table if exists empleados;

create table if not exists empleados(
	id_empleado int(20) auto_increment,
	nombre varchar(100) not null,
	telefono varchar(30) default null,
	id_empleado_jefe int(20) default null,
	fecha_incorporacion date not null default current_date(),
	primary key (id_empleado)
)engine=InnoDB;

insert into empleados(nombre,telefono,fecha_incorporacion) values("Juan Ignacio Garcia","1134567899","2022-01-13");
insert into empleados(nombre,telefono) values("Maria Ana Sanchez","23457766");
insert into empleados(nombre,telefono) values("Susana Martinez","44880011");
insert into empleados(nombre,telefono,fecha_incorporacion) values("Mariela Suarez","46470890","1990-08-16");
insert into empleados(nombre,telefono,fecha_incorporacion) values("Matias Ramos","34521122","2018-09-23");
insert into empleados(nombre,telefono) values("Sofia Loria","1122334455");
insert into empleados(nombre,telefono,fecha_incorporacion) values("Roberto Marcelo Torres","1134563445","1987-06-21");
insert into empleados(nombre,telefono,fecha_incorporacion) values("Analia Beatriz Gomez","56478933","1992-05-26");
insert into empleados(nombre,telefono,fecha_incorporacion) values("Romina Barone","351 23421223","2009-11-12");
insert into empleados(nombre,telefono,fecha_incorporacion) values("Javier Mauro Nuncio","351 67389920","2011-02-14");
insert into empleados(nombre,telefono,fecha_incorporacion) values("Yamila Camila Soria","221 3456788","2021-04-01");
insert into empleados(nombre,telefono,fecha_incorporacion) values("Tobias Leonel Rodriguez","221 7788997","2014-12-03");
insert into empleados(nombre,telefono,fecha_incorporacion) values("Monica Cristoferssen","3446 9008875","1985-05-18");
insert into empleados(nombre,telefono,fecha_incorporacion) values("Dario Yamil Santoro","1122337788","1999-07-19");
insert into empleados(nombre,telefono,fecha_incorporacion) values("Isabel Rosa Meijide","1134567389","1979-08-15");
insert into empleados(nombre,telefono,fecha_incorporacion) values("Rocio Belen Fernandez","112289045","2022-10-09");
insert into empleados(nombre,telefono) values("Agustin Riveros","229 45679499");
insert into empleados(nombre,telefono,fecha_incorporacion) values("Teresa Gomez Fraccia","229 67584004","1993-01-23");
insert into empleados(nombre,telefono,fecha_incorporacion) values("Juana Roxana Serrano","229 86574889","2005-08-20");
insert into empleados(nombre,telefono) values("Martin Roux","1134565366");
insert into empleados(nombre,telefono) values("Ezequiel Gonzalez","367 89872738");
insert into empleados(nombre,telefono,fecha_incorporacion) values("Rogelio Oscar Montoya","367 54683848","1988-11-05");
insert into empleados(nombre,telefono,fecha_incorporacion) values("Martina Lujan Terramus","266 4567485","2000-01-15");
insert into empleados(nombre,telefono,fecha_incorporacion) values("Raquel Estela Garcia","266 45374839","1989-07-11");
insert into empleados(nombre,telefono) values("Dominique Sour","113423453");

update empleados set id_empleado_jefe = 15 where id_empleado = 1;
update empleados set id_empleado_jefe = 15 where id_empleado = 2;
update empleados set id_empleado_jefe = 15 where id_empleado = 3;
update empleados set id_empleado_jefe = 15 where id_empleado = 4;
update empleados set id_empleado_jefe = 15 where id_empleado = 5;
update empleados set id_empleado_jefe = 15 where id_empleado = 6;
update empleados set id_empleado_jefe = 7 where id_empleado = 9;
update empleados set id_empleado_jefe = 7 where id_empleado = 10;
update empleados set id_empleado_jefe = 7 where id_empleado = 11;
update empleados set id_empleado_jefe = 7 where id_empleado = 12;
update empleados set id_empleado_jefe = 22 where id_empleado = 21;
update empleados set id_empleado_jefe = 22 where id_empleado = 23;
update empleados set id_empleado_jefe = 22 where id_empleado = 24;
update empleados set id_empleado_jefe = 13 where id_empleado = 14;
update empleados set id_empleado_jefe = 13 where id_empleado = 16;
update empleados set id_empleado_jefe = 13 where id_empleado = 17;
update empleados set id_empleado_jefe = 13 where id_empleado = 18;
update empleados set id_empleado_jefe = 24 where id_empleado = 25;
update empleados set id_empleado_jefe = 24 where id_empleado = 20;
update empleados set id_empleado_jefe = 24 where id_empleado = 22;
update empleados set id_empleado_jefe = 24 where id_empleado = 13;

-- TABLA CLIENTES

drop table if exists clientes;

create table if not exists clientes(
	id_cliente int(20) auto_increment,
	nombre varchar(100) not null,
	calle varchar(100) default null,
	ciudad varchar(100) not null,
	id_empleado int(20) default null,
	primary key (id_cliente),
	constraint fk_ciudad_cliente foreign key(ciudad) references sucursales(ciudad) on delete no action on update no action,
	constraint fk_empleado foreign key (id_empleado) references empleados(id_empleado) on delete no action on update no action
)engine=InnoDB;

insert into clientes(nombre,calle,ciudad,id_empleado) values("Dario Romero","Avenida Rivadavia 7200","Flores",12);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Estela Fernandez","Avenida Carabobo 100","Flores",13);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Emiliano Lucci","Yerbal 123","Flores",12);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Juana Molina","Avenida Santa Fe 1560","Recoleta",18);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Belen Garcia","Avenida Cordoba 1589","Recoleta",18);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Ana Maria Treffi","Avenida Cabildo 980","Belgrano",9);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Marcos Andres Tracio","Avenida Juan Domingo Peron 560","San Justo",10);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Nancy Rivera","Avenida Juan Domingo Peron 560","San Justo",10);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Esther Stein","Ignacio Arieta 345","San Justo",10);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Joaquin Gabriel Nuñez","Balcarce 95","Mar del Plata",20);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Juan Pablo Yturre","Libertad 456","Mar del Plata",20);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Elsa Ines Gutierrez","25 de Mayo 1789","Mar del Plata",20);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Ramon Teodoro Falcon","Avenida San Martin 928","Bahia Blanca",19);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Felisindo Samuel Goyte","El Alamo 2345","Bahia Blanca",19);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Rosario Paz Suarez","Terrazas 765","Lujan",14);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Merida Marcia Tonnell","Calle 28","Lujan",14);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Sabrina Estebanez","Calle Villareal 1678","Lujan",14);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Stephanie Moretz","Avenida de los santos 525","Posadas",16);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Alberto Jose Sendon","Esperanza 1980","Posadas",16);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Juan Mauricio Belloso","Belgrano 56","Posadas",16);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Susana Fernanda Cardoso","Moreno 155","Ciudad de Cordoba",7);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Micalea Camila Pedraza","Avenida 9 de septiembre 1567","Ciudad de Cordoba",7);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Tadeo Garcia","Avenida Libertador 1890","Ciudad de Cordoba",7);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Alma Isidor","Viento de las Nieves 345","Ushuaia",25);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Mariela Portre","Cañaveral 7658","Ciudad de Mendoza",5);
insert into clientes(nombre,calle,ciudad,id_empleado) values("Elvira Rosa Padilla","Avenida Juarez 456","Ciudad de Mendoza",5);

-- TABLAS DE CUENTAS

drop table if exists tipos_cuentas;

create table if not exists tipos_cuentas(
	id int(11) auto_increment,
	descripcion varchar(100) not null,
	primary key(id),
	key(descripcion)
)engine=InnoDB;

insert into tipos_cuentas(descripcion) values("Cuenta Corriente");
insert into tipos_cuentas(descripcion) values("Caja de Ahorro");


drop table if exists cuentas;

create table if not exists cuentas(
	nro_cuenta int(30) auto_increment,
	tipo_cuenta varchar(100) not null,
	fecha_creacion date not null default current_date(),
	activa tinyint(1) not null default 1,
	primary key(nro_cuenta),
	constraint fk_tipo_cuenta foreign key(tipo_cuenta) references tipos_cuentas(descripcion) on delete no action on update no action
)engine=InnoDB;

alter table cuentas auto_increment=1000;

insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Cuenta Corriente","1990-07-18",1);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Cuenta Corriente","1990-09-21",1);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Cuenta Corriente","1990-09-10",1);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Cuenta Corriente","1990-04-15",0);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Cuenta Corriente","1991-06-18",0);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Caja de Ahorro","1993-11-12",1);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Caja de Ahorro","1993-01-16",0);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Cuenta Corriente","1993-02-02",1);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Cuenta Corriente","1995-06-18",1);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Caja de Ahorro","1998-04-05",1);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Caja de Ahorro","2000-12-21",1);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Caja de Ahorro","2000-08-14",1);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Caja de Ahorro","2003-09-20",1);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Caja de Ahorro","2003-01-18",1);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Cuenta Corriente","2006-10-23",1);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Cuenta Corriente","2006-03-15",0);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Caja de Ahorro","2009-08-09",0);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Cuenta Corriente","2010-10-10",0);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Cuenta Corriente","2011-03-27",0);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Cuenta Corriente","2011-07-23",1);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Caja de Ahorro","2015-06-12",0);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Caja de Ahorro","2015-09-13",1);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Cuenta Corriente","2016-09-13",1);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Cuenta Corriente","2016-08-10",0);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Cuenta Corriente","2019-08-01",1);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Cuenta Corriente","2019-04-16",1);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Caja de Ahorro","2019-09-12",1);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Cuenta Corriente","2021-03-03",0);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Caja de Ahorro","2021-07-09",1);
insert into cuentas(tipo_cuenta,fecha_creacion,activa) values("Cuenta Corriente","2022-05-18",1);


drop table if exists cuentas_clientes;

create table if not exists cuentas_clientes(
	nro_cuenta int(30),
	id_cliente int(20),
	key (nro_cuenta,id_cliente),
	constraint fk_nro_cuenta foreign key(nro_cuenta) references cuentas(nro_cuenta) on delete cascade on update cascade,
	constraint fk_id_cliente_cuenta foreign key(id_cliente) references clientes(id_cliente) on delete cascade on update cascade
)engine=InnoDB;

insert into cuentas_clientes(nro_cuenta,id_cliente) values(1001,1);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1001,2);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1003,3);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1003,4);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1003,5);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1007,6);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1008,6);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1009,9);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1009,9);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1012,1);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1012,2);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1011,21);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1011,20);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1017,16);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1015,8);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1015,10);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1013,1);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1029,25);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1027,2);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1027,13);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1018,3);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1023,19);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1023,8);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1014,10);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1014,12);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1020,2);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1020,15);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1020,20);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1008,16);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1008,18);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1009,10);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1015,15);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1015,21);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1015,21);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1029,26);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1001,1);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1024,24);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1024,23);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1022,4);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1026,7);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1026,13);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1019,15);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1019,10);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1021,11);
insert into cuentas_clientes(nro_cuenta,id_cliente) values(1021,3);

-- TABLAS DE PRESTAMOS

drop table if exists tipos_prestamos;

create table if not exists tipos_prestamos(
	id int(11) auto_increment,
	descripcion varchar(100) not null,
	primary key(id),
	key(descripcion)
)engine=InnoDB;

insert into tipos_prestamos(descripcion) values("Prestamo personal");
insert into tipos_prestamos(descripcion) values("Prestamo al consumo");
insert into tipos_prestamos(descripcion) values("Prestamo educativo");
insert into tipos_prestamos(descripcion) values("Prestamo hipotecario");
insert into tipos_prestamos(descripcion) values("Prestamo para empresas");

drop table if exists prestamos;

create table if not exists prestamos(
	nro_prestamo int(30) auto_increment,
	tipo_prestamo varchar(100) not null,
	fecha_expedicion date not null default current_date(),
	cant_cuotas int(30) not null default 3,
	cancelado tinyint(1),
	primary key(nro_prestamo),
	constraint fk_tipo_prestamo foreign key(tipo_prestamo) references tipos_prestamos(descripcion) on delete no action on update no action
)engine=InnoDB;

alter table prestamos auto_increment=1000;

insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo personal","1999-01-01",3,1);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo personal","2000-04-15",12,1);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo hipotecario","2001-09-09",24,1);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo para empresas","2001-09-15",12,1);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo para empresas","2001-09-16",24,0);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo para empresas","2001-09-24",36,0);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo educativo","2001-10-09",36,1);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo educativo","2001-10-10",48,1);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo personal","2001-10-23",24,1);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo educativo","2001-11-03",12,0);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo hipotecario","2002-02-10",96,1);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo hipotecario","2003-04-15",144,0);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo hipotecario","2003-05-16",144,1);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo personal","2003-05-19",24,1);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo personal","2003-09-12",6,0);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo al consumo","2006-12-09",18,1);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo al consumo","2008-12-12",36,1);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo al consumo","2010-08-16",96,1);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo educativo","2012-04-15",96,0);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo para empresas","2012-10-03",12,0);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo personal","2018-07-13",12,1);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo hipotecario","2019-06-01",156,0);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo personal","2019-11-05",12,0);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo para empresas","2019-11-20",48,0);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo al consumo","2020-05-09",6,1);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo personal","2020-06-07",18,1);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo personal","2020-09-09",12,1);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo educativo","2021-10-10",24,0);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo educativo","2021-11-15",24,0);
insert into prestamos(tipo_prestamo,fecha_expedicion,cant_cuotas,cancelado) values("Prestamo personal","2022-05-15",12,1);

drop table if exists prestamos_clientes;

create table if not exists prestamos_clientes(
	nro_prestamo int(30),
	id_cliente int(20),
	key (nro_prestamo,id_cliente),
	constraint fk_nro_prestamo foreign key(nro_prestamo) references prestamos(nro_prestamo) on delete cascade on update cascade,
	constraint fk_id_cliente_prestamo foreign key(id_cliente) references clientes(id_cliente) on delete cascade on update cascade
)engine=InnoDB;

insert into prestamos_clientes(nro_prestamo,id_cliente) values(1001,1);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1001,2);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1003,3);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1003,4);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1003,5);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1007,6);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1008,6);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1009,9);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1009,9);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1012,1);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1012,2);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1011,21);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1011,20);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1017,16);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1015,8);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1015,10);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1013,1);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1029,25);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1027,2);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1027,13);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1018,3);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1023,19);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1023,8);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1014,10);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1014,12);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1020,2);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1020,15);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1020,20);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1008,16);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1008,18);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1009,10);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1015,15);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1015,21);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1015,21);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1029,26);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1001,1);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1024,24);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1024,23);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1022,4);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1026,7);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1026,13);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1019,15);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1019,10);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1021,11);
insert into prestamos_clientes(nro_prestamo,id_cliente) values(1021,3);



