CREATE TABLE public.materials_types
(
    id          character(26),
    description character varying(90) NOT NULL,
    enabled     boolean                  DEFAULT true,
    created_at  timestamp with time zone DEFAULT current_timestamp,
    updated_at  timestamp with time zone DEFAULT current_timestamp,
    PRIMARY KEY (id)
);

CREATE TABLE public.materials
(
    id               character(26),
    description      character varying(90) NOT NULL,
    material_type_id character(26)         NOT NULL,
    amount           double precision         DEFAULT 0,
    minimum_quantity double precision         DEFAULT 0,
    cost             double precision         DEFAULT 0,
    ignore_stock     boolean                  DEFAULT false,
    is_perishable    boolean                  default true,
    enabled          boolean                  DEFAULT true,
    created_at       time with time zone      DEFAULT current_timestamp,
    updated_at       timestamp with time zone DEFAULT current_timestamp,
    PRIMARY KEY (id),
    FOREIGN KEY (material_type_id)
        REFERENCES public.materials_types (id) MATCH SIMPLE
        ON UPDATE RESTRICT
        ON DELETE RESTRICT
);

CREATE TABLE public.materials_allotments
(
    id              character(26),
    material_id     character(26)         NOT NULL,
    allotment       character varying(20) not null,
    entry_quantity  double precision         DEFAULT 0,
    cost            double precision         DEFAULT 0,
    expiration_date date                  not null,
    enabled         boolean                  DEFAULT true,
    created_at      timestamp with time zone DEFAULT current_timestamp,
    updated_at      time with time zone      DEFAULT current_timestamp,
    PRIMARY KEY (id),
    FOREIGN KEY (material_id)
        REFERENCES public.materials (id) MATCH SIMPLE
        ON UPDATE RESTRICT
        ON DELETE RESTRICT
);