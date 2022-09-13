drop database if exists digitalers_practica_base_datos;

create database if not exists digitalers_practica_base_datos;

use digitalers_practica_base_datos;

drop table if exists sucursales;

create table if not exists sucursales(
	nombre_sucursal varchar(100) not null,
	ciudad varchar(100) not null,
	primary key(nombre_sucursal),
	key(ciudad)
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


drop table if exists clientes;

create table if not exists clientes(
	id_cliente int(20) auto_increment,
	nombre varchar(100) not null,
	calle varchar(100) default null,
	ciudad varchar(100) not null,
	prestamo boolean default false,
	id_empleado int(20) default null,
	primary key (id_cliente),
	constraint fk_ciudad foreign key(ciudad) references sucursales(ciudad) on delete no action on update no action,
	constraint fk_empleado foreign key (id_empleado) references empleados(id_empleado) on delete no action on update no action
)engine=InnoDB;

insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Dario Romero","Avenida Rivadavia 7200","Flores",0,12);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Estela Fernandez","Avenida Carabobo 100","Flores",0,13);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Emiliano Lucci","Yerbal 123","Flores",0,12);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Juana Molina","Avenida Santa Fe 1560","Recoleta",0,18);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Belen Garcia","Avenida Cordoba 1589","Recoleta",1,18);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Ana Maria Treffi","Avenida Cabildo 980","Belgrano",1,9);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Marcos Andres Tracio","Avenida Juan Domingo Peron 560","San Justo",1,10);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Nancy Rivera","Avenida Juan Domingo Peron 560","San Justo",0,10);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Esther Stein","Ignacio Arieta 345","San Justo",0,10);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Joaquin Gabriel Nuñez","Balcarce 95","Mar del Plata",0,20);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Juan Pablo Yturre","Libertad 456","Mar del Plata",1,20);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Elsa Ines Gutierrez","25 de Mayo 1789","Mar del Plata",0,20);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Ramon Teodoro Falcon","Avenida San Martin 928","Bahia Blanca",1,19);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Felisindo Samuel Goyte","El Alamo 2345","Bahia Blanca",0,19);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Rosario Paz Suarez","Terrazas 765","Lujan",1,14);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Merida Marcia Tonnell","Calle 28","Lujan",0,14);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Sabrina Estebanez","Calle Villareal 1678","Lujan",0,14);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Stephanie Moretz","Avenida de los santos 525","Posadas",0,16);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Alberto Jose Sendon","Esperanza 1980","Posadas",0,16);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Juan Mauricio Belloso","Belgrano 56","Posadas",1,16);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Susana Fernanda Cardoso","Moreno 155","Ciudad de Cordoba",0,7);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Micalea Camila Pedraza","Avenida 9 de septiembre 1567","Ciudad de Cordoba",0,7);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Tadeo Garcia","Avenida Libertador 1890","Ciudad de Cordoba",0,7);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Alma Isidor","Viento de las Nieves 345","Ushuaia",0,25);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Mariela Portre","Cañaveral 7658","Ciudad de Mendoza",1,5);
insert into clientes(nombre,calle,ciudad,prestamo,id_empleado) values("Elvira Rosa Padilla","Avenida Juarez 456","Ciudad de Mendoza",1,5);

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
	primary key(nro_cuenta),
	constraint fk_tipo_cuenta foreign key(tipo_cuenta) references tipos_cuentas(descripcion) on delete no action on update no action
)engine=InnoDB;

alter table cuentas auto_increment=1000;

insert into cuentas(tipo_cuenta) values("Cuenta Corriente");
insert into cuentas(tipo_cuenta) values("Cuenta Corriente");
insert into cuentas(tipo_cuenta) values("Cuenta Corriente");
insert into cuentas(tipo_cuenta) values("Cuenta Corriente");
insert into cuentas(tipo_cuenta) values("Cuenta Corriente");
insert into cuentas(tipo_cuenta) values("Caja de Ahorro");
insert into cuentas(tipo_cuenta) values("Caja de Ahorro");
insert into cuentas(tipo_cuenta) values("Cuenta Corriente");
insert into cuentas(tipo_cuenta) values("Cuenta Corriente");
insert into cuentas(tipo_cuenta) values("Caja de Ahorro");
insert into cuentas(tipo_cuenta) values("Caja de Ahorro");
insert into cuentas(tipo_cuenta) values("Caja de Ahorro");
insert into cuentas(tipo_cuenta) values("Caja de Ahorro");
insert into cuentas(tipo_cuenta) values("Caja de Ahorro");
insert into cuentas(tipo_cuenta) values("Cuenta Corriente");
insert into cuentas(tipo_cuenta) values("Cuenta Corriente");
insert into cuentas(tipo_cuenta) values("Caja de Ahorro");
insert into cuentas(tipo_cuenta) values("Cuenta Corriente");
insert into cuentas(tipo_cuenta) values("Cuenta Corriente");
insert into cuentas(tipo_cuenta) values("Cuenta Corriente");
insert into cuentas(tipo_cuenta) values("Caja de Ahorro");
insert into cuentas(tipo_cuenta) values("Caja de Ahorro");
insert into cuentas(tipo_cuenta) values("Cuenta Corriente");
insert into cuentas(tipo_cuenta) values("Cuenta Corriente");
insert into cuentas(tipo_cuenta) values("Cuenta Corriente");
insert into cuentas(tipo_cuenta) values("Cuenta Corriente");
insert into cuentas(tipo_cuenta) values("Caja de Ahorro");
insert into cuentas(tipo_cuenta) values("Cuenta Corriente");
insert into cuentas(tipo_cuenta) values("Caja de Ahorro");
insert into cuentas(tipo_cuenta) values("Cuenta Corriente");


drop table if exists cuentas_clientes;

create table if not exists cuentas_clientes(
	nro_cuenta int(30),
	id_cliente int(20),
	key (nro_cuenta,id_cliente),
	constraint fk_nro_cuenta foreign key(nro_cuenta) references cuentas(nro_cuenta) on delete cascade on update cascade,
	constraint fk_id_cliente foreign key(id_cliente) references clientes(id_cliente) on delete cascade on update cascade
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
