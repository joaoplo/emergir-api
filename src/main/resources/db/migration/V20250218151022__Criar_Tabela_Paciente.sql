CREATE SEQUENCE "EMERGIR_DIGITAL".SEQ_PACIENTES
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE "EMERGIR_DIGITAL".PACIENTES
(
    IDT_PACIENTES   BIGINT       NOT NULL DEFAULT nextval('"EMERGIR_DIGITAL".SEQ_PACIENTES'::regclass),
    CPF             VARCHAR(11)  NOT NULL,
    NOME            VARCHAR(100) NOT NULL,
    DT_NASCIMENTO   DATE         NOT NULL,
    DT_INICIO       DATE         NOT NULL,
    DT_TERMINO      DATE,
    ATENDIMENTO     VARCHAR(20)  NOT NULL,
    PLANO           VARCHAR(20)  NOT NULL,
    SITUACAO        VARCHAR(20)  NOT NULL,
    CONSTRAINT PK_PACIENTES PRIMARY KEY (IDT_PACIENTES)
);