CREATE TABLE public.units
(
    id          character(26),
    description character varying(90) NOT NULL,
    enabled     boolean             DEFAULT true,
    created_at  time with time zone DEFAULT current_timestamp,
    updated_at  time with time zone DEFAULT current_timestamp,
    PRIMARY KEY (id)
);
CREATE TABLE public.pharmaceutical_forms
(
    id          character(26),
    description character varying(50) NOT NULL,
    enabled     boolean             DEFAULT true,
    created_at  time with time zone DEFAULT current_timestamp,
    updated_at  time with time zone DEFAULT current_timestamp,
    PRIMARY KEY (id)
);

CREATE TABLE public.medicines
(
    id                     character(26),
    description            character varying(90)  NOT NULL,
    chemical_name          character varying(110) NOT NULL,
    laboratory_id          character(26)          NOT NULL,
    unit_id                character(26)          NOT NULL,
    pharmaceutical_form_id character(26)          NOT NULL,
    presentation_unity     character varying(5)   NOT NULL,
    presentation           character varying(8)   NOT NULL,
    minimum_quantity       double precision         DEFAULT 0,
    amount                 double precision         DEFAULT 0,
    cost                   double precision         DEFAULT 0,
    antibiotic             boolean                  DEFAULT false,
    additional_data        character varying(500),
    ignore_stock           boolean                  DEFAULT false,
    enabled                boolean                  DEFAULT true,
    created_at             timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at             time with time zone      DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT medicines_pkey PRIMARY KEY (id),
    CONSTRAINT medicines_laboratory_id_fkey FOREIGN KEY (laboratory_id)
        REFERENCES public.laboratories (id) MATCH SIMPLE
        ON UPDATE RESTRICT
        ON DELETE RESTRICT,
    CONSTRAINT medicines_pharmaceutical_form_id_fkey FOREIGN KEY (pharmaceutical_form_id)
        REFERENCES public.pharmaceutical_forms (id) MATCH SIMPLE
        ON UPDATE RESTRICT
        ON DELETE RESTRICT,
    CONSTRAINT medicines_unit_id_fkey FOREIGN KEY (unit_id)
        REFERENCES public.units (id) MATCH SIMPLE
        ON UPDATE RESTRICT
        ON DELETE RESTRICT
);

CREATE TABLE public.allotments
(
    id              character(26),
    medicine_id     character(26) NOT NULL,
    ammount         double precision         DEFAULT 0,
    entry_quantity  double precision         DEFAULT 0,
    cost            double precision         DEFAULT 0,
    expiration_date date          not null,
    enabled         boolean                  DEFAULT true,
    created_at      timestamp with time zone DEFAULT current_timestamp,
    updated_at      time with time zone      DEFAULT current_timestamp,
    PRIMARY KEY (id),
    FOREIGN KEY (medicine_id)
        REFERENCES public.medicines (id) MATCH SIMPLE
        ON UPDATE RESTRICT
        ON DELETE RESTRICT
);
