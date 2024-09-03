create database filtroJava;
use filtroJava;

create table ninja (
id int primary key auto_increment not null,
nombre varchar(60) not null,
rango int not null,
aldea varchar(30)
);

create table mision (
id int primary key auto_increment not null,
descripcion varchar(60) not null,
rango int not null,
recompensa int not null
);

create table habilidades(
id int primary key auto_increment not null,
id_ninja int,
foreign key (id_ninja) references ninja(id),
nombre varchar(60) not null,
descripcion varchar(60) not null
);

create table misionNinja(
id_ninja int,
foreign key (id_ninja) references ninja(id),
id_mision int,
foreign key (id_mision) references mision(id),
fechaInicio date,
fechafin date
);