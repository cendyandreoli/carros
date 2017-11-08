CREATE TABLE concessionaria
(
  id uuid NOT NULL,
  nome character varying(100) NOT NULL,
  endereco character varying(100) NOT NULL,
  ano date,
  CONSTRAINT concessionaria_pk PRIMARY KEY (id)
)
