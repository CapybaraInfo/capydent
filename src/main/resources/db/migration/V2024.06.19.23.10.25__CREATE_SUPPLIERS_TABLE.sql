create table if not exists suppliers
(
    id                  character(26),
    full_name           character varying(190) not null,
    nickname            character varying(90),
    person_type         character varying(30)  not null,
    tax_id              character varying(30)  not null,
    registration_number character varying(30)  not null,
    date_of_birth       date                   not null,
    email               character varying(100),
    address_line_one    character varying(180) not null,
    address_line_two    character varying(120),
    neighbourhood       character varying(180) not null,
    city                character varying(180) not null,
    federation_unit     character varying(40)  not null,
    country             character varying(120) not null,
    zip_code            character varying(30)  not null,
    phone               character varying(18),
    enabled             boolean                not null,
    created_at          timestamp with time zone default current_timestamp,
    updated_at          timestamp with time zone default current_timestamp,
    constraint suppliers_pkey primary key (id)
);


CREATE TABLE IF NOT EXISTS goods_entry
(
    id                  character(26) NOT NULL,
    supplier_id         character(26) NOT NULL,
    has_fiscal          boolean       NOT NULL,
    fiscal_document_key character varying(120),
    total_tax           double precision         DEFAULT 0,
    portage             double precision         DEFAULT 0,
    other_costs         double precision         DEFAULT 0,
    subtotals           double precision         DEFAULT 0,
    total               double precision         DEFAULT 0,
    created_at          timestamp with time zone default current_timestamp,
    updated_at          timestamp with time zone default current_timestamp,
    created_by          character(26) NOT NULL,
    CONSTRAINT goods_entry_pkey PRIMARY KEY (id),
    CONSTRAINT goods_entry_supplier_id_fkey FOREIGN KEY (supplier_id)
        REFERENCES suppliers (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT goods_entry_created_by_fkey FOREIGN KEY (created_by)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE goods_entry_materials
(
    id              character(26),
    goods_entry_id  character(26),
    material_id     character(26) NOT NULL,
    cost            double precision DEFAULT 0,
    taxes           double precision default 0,
    discount        double precision DEFAULT 0,
    quantity        double precision DEFAULT 0,
    subtotal        double precision DEFAULT 0,
    total           double precision DEFAULT 0,
    allotment       character varying(20),
    expiration_date date,
    PRIMARY KEY (id),
    FOREIGN KEY (goods_entry_id)
        REFERENCES goods_entry (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    FOREIGN KEY (material_id)
        REFERENCES materials (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE goods_entry_medicines
(
    id              character(26),
    goods_entry_id  character(26),
    medicine_id     character(26) NOT NULL,
    cost            double precision DEFAULT 0,
    taxes           double precision default 0,
    discount        double precision DEFAULT 0,
    quantity        double precision DEFAULT 0,
    subtotal        double precision DEFAULT 0,
    total           double precision DEFAULT 0,
    allotment       character varying(20),
    expiration_date date,
    PRIMARY KEY (id),
    FOREIGN KEY (goods_entry_id)
        REFERENCES goods_entry (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    FOREIGN KEY (medicine_id)
        REFERENCES medicines (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);