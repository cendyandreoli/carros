create table carro
(
  id uuid not null,
  placa character varying(100) not null,
  modelo character varying(100) not null,
  marca character varying(100) not null,
  motor INTEGER,
  ano DATE,
  constraint carro_pk primary key (id)
);
