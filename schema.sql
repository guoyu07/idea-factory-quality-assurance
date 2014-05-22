-- Schema: public

-- DROP SCHEMA public;

CREATE SCHEMA public
  AUTHORIZATION postgres;

GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO public;
COMMENT ON SCHEMA public
  IS 'standard public schema';

CREATE TABLE public.dictionary (
  key character varying PRIMARY KEY NOT NULL,
  value character varying NOT NULL
);
CREATE UNIQUE INDEX unique_key ON dictionary USING BTREE (key);