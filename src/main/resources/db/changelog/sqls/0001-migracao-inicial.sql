create table veiculo
(
  id uuid not null,
  placa character varying(100) not null,
  modelo character varying(100) not null,
  marca character varying(100) not null,
  motor INTEGER,
  ano DATE,
  concessionaria_id UUID,
  constraint carro_pk primary key (id)
)
