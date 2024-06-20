CREATE TABLE public.payment_types
(
    id            character(26),
    name          character varying(50) NOT NULL,
    slug          character varying(8)  NOT NULL,
    in_cash       boolean               NOT NULL DEFAULT true,
    deadline      integer                        DEFAULT 1,
    addition      double precision               DEFAULT 0,
    discount      double precision               DEFAULT 0,
    taxes         double precision               DEFAULT 0,
    tax_type      character varying(10)          DEFAULT 'PERCENTAGE',
    addition_type character varying(10)          DEFAULT 'PERCENTAGE',
    discount_type character varying(10)          DEFAULT 'PERCENTAGE',
    created_at    timestamp with time zone       DEFAULT current_timestamp,
    updated_at    timestamp with time zone       DEFAULT current_timestamp,
    PRIMARY KEY (id),
    UNIQUE (slug)
);

CREATE TABLE public.account_category
(
    id                    character(26),
    description           character varying(100) NOT NULL,
    account_category_type character(1)             DEFAULT 'E',
    created_at            timestamp with time zone DEFAULT current_timestamp,
    updated_at            timestamp with time zone DEFAULT current_timestamp,
    PRIMARY KEY (id)
);

CREATE TABLE public.accounts_payable
(
    id                  character(26),
    account_category_id character(26)    NOT NULL,
    supplier_id         character(26)    NOT NULL,
    total_value         double precision NOT NULL,
    issue_date          date,
    due_date            date             NOT NULL,
    portion             integer                  DEFAULT 1,
    installments        integer                  DEFAULT 1,
    payment_date        date,
    payment_status      character varying(20)    DEFAULT 'UNPAID',
    description         character varying(200),
    good_entry_id       character(26),
    created_at          timestamp with time zone DEFAULT current_timestamp,
    updated_at          timestamp with time zone DEFAULT current_timestamp,
    created_by          character(26)    NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (account_category_id)
        REFERENCES public.account_category (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    FOREIGN KEY (supplier_id)
        REFERENCES public.suppliers (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    FOREIGN KEY (good_entry_id)
        REFERENCES public.goods_entry (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    FOREIGN KEY (created_by)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
CREATE TABLE public.financial_movements
(
    id                    character(26),
    reference_id          character(26),
    reference_type        character varying(100),
    person_reference_id   character(26),
    person_reference_type character varying(100),
    movement_value        double precision         NOT NULL,
    movement_date         timestamp with time zone NOT NULL,
    movement_type         character varying(20),
    created_by            character(26)            NOT NULL,
    description           character varying(250)   NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (created_by)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE public.stock_movements
(
    id             character(26),
    item_id        character(26),
    item_type      character varying(100),
    reference_id   character(26),
    reference_type character varying(100),
    movement_value double precision         NOT NULL,
    movement_date  timestamp with time zone NOT NULL,
    movement_type  character varying(20),
    created_by     character(26)            NOT NULL,
    description    character varying(250)   NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (created_by)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);