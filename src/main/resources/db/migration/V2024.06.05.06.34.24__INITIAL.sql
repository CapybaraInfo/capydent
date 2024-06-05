CREATE TABLE IF NOT EXISTS public.occupations
(
    id character(26) COLLATE pg_catalog."default" NOT NULL,
    description character varying(150) COLLATE pg_catalog."default" NOT NULL,
    enabled boolean DEFAULT true,
    created_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT occupations_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.user_occupations
(
    user_id character(26) COLLATE pg_catalog."default" NOT NULL,
    occupation_id character(26) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT user_occupations_user_id_occupation_id_key UNIQUE (user_id, occupation_id)
);

CREATE TABLE IF NOT EXISTS public.users
(
    id character(26) COLLATE pg_catalog."default" NOT NULL,
    full_name character varying(190) COLLATE pg_catalog."default" NOT NULL,
    username character varying(50) COLLATE pg_catalog."default" NOT NULL,
    encoded_pass character varying(72) COLLATE pg_catalog."default" NOT NULL,
    person_type character varying(30) COLLATE pg_catalog."default" NOT NULL,
    brazilian_id character varying(30) COLLATE pg_catalog."default" NOT NULL,
    tax_id character varying(30) COLLATE pg_catalog."default" NOT NULL,
    registration_number character varying(30) COLLATE pg_catalog."default",
    gender character varying(30) COLLATE pg_catalog."default" NOT NULL,
    date_of_birth date NOT NULL,
    email character varying(100) COLLATE pg_catalog."default",
    address_line_one character varying(180) COLLATE pg_catalog."default" NOT NULL,
    address_line_two character varying(120) COLLATE pg_catalog."default",
    neighbourhood character varying(180) COLLATE pg_catalog."default" NOT NULL,
    city character varying(180) COLLATE pg_catalog."default" NOT NULL,
    federation_unit character varying(40) COLLATE pg_catalog."default" NOT NULL,
    country character varying(120) COLLATE pg_catalog."default" NOT NULL,
    zip_code character varying(30) COLLATE pg_catalog."default" NOT NULL,
    commission double precision NOT NULL,
    mobile_phone character varying(18) COLLATE pg_catalog."default",
    phone character varying(18) COLLATE pg_catalog."default",
    enabled boolean NOT NULL,
    hiring_date date NOT NULL,
    termination_date date,
    authority character varying(30) COLLATE pg_catalog."default" NOT NULL,
    updated_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    created_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.user_occupations
    ADD CONSTRAINT user_occupations_occupation_id_fkey FOREIGN KEY (occupation_id)
    REFERENCES public.occupations (id) MATCH SIMPLE
    ON UPDATE NO ACTION
       ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.user_occupations
    ADD CONSTRAINT user_occupations_user_id_fkey FOREIGN KEY (user_id)
    REFERENCES public.users (id) MATCH SIMPLE
    ON UPDATE NO ACTION
       ON DELETE NO ACTION
    NOT VALID;
