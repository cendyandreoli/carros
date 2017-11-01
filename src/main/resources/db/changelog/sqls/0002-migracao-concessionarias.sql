CREATE TABLE concessionaria
(
  id uuid NOT NULL,
  nome character varying(100) NOT NULL,
  endereco character varying(100) NOT NULL,
  carro_pertencente uuid,
  ano date,
  CONSTRAINT concessionaria_pk PRIMARY KEY (id),
  CONSTRAINT concessionaria_carro_pertencente_fkey FOREIGN KEY (carro_pertencente)
      REFERENCES carro (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
