CREATE TABLE Transfers(
    id bigint NOT NULL DEFAULT nextval('transfer_id_seq'::regclass),
    amount double precision,
    source_id bigint,
    target_id bigint,
    transfer_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT transfer_pkey PRIMARY KEY (id)
);