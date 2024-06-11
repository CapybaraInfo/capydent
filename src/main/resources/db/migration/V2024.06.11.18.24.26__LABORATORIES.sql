CREATE TABLE public.laboratories
(
    id character(26),
    name character varying(100) NOT NULL,
    created_at timestamp with time zone DEFAULT current_timestamp,
    updated_at timestamp with time zone DEFAULT current_timestamp,
    enabled boolean DEFAULT true,
    PRIMARY KEY (id)
);