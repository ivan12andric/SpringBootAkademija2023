create table test
(
    id          int primary key auto_increment,
    name        varchar(100),
    description varchar(255)
);

insert into test(name, description) values ('Petar' , 'Sjedi pored Sonje');


create table pretrage_letova
(
    id int primary key auto_increment,
    sifra_polazista char(3),
    sifra_odredista char(3),
    datum_odlaska date,
    datum_povratka date,
    broj_odraslih int,

    datum_kreiranja date,
    korisnik_kreiranja varchar(50),
    datum_azuriranja date,
    korisnik_azuriranja varchar(50)

);


create table rezultati_pretrage
(
    id int primary key auto_increment,

    polazak_sifra_aerodroma_polazak varchar(3),
    polazak_sifra_aerodroma_odrediste varchar(3),
    polazak_datum_polaska varchar(25),
    polazak_datum_dolaska varchar(25),

    povratak_sifra_aerodroma_polazak varchar(3),
    povratak_sifra_aerodroma_odrediste varchar(3),
    povratak_datum_polaska varchar(25),
    povratak_datum_dolaska varchar(25),

    prijevoznik varchar(50),
    cijena varchar(10),

    id_pretrage int,

    datum_kreiranja date,
    korisnik_kreiranja varchar(50),
    datum_azuriranja date,
    korisnik_azuriranja varchar(50)

);

alter table rezultati_pretrage add foreign key (id_pretrage) references pretrage_letova (id);

create table korisnici
(
    id number primary key auto_increment,
    korisnicko_ime varchar(50),
    lozinka varchar (50),
    rola varchar (10),
    aktivan boolean,

    datum_kreiranja date,
    korisnik_kreiranja varchar(50),
    datum_azuriranja date,
    korisnik_azuriranja varchar(50)

);

insert into korisnici (korisnicko_ime, lozinka, rola, aktivan)
values ('user', 'user', 'ROLE_USER', true);

insert into korisnici (korisnicko_ime, lozinka, rola, aktivan)
values ('test', 'test', 'ROLE_TEST', true);

insert into korisnici (korisnicko_ime, lozinka, rola, aktivan)
values ('admin', 'admin', 'ROLE_ADMIN', true);

