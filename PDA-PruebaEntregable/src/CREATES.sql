CREATE TABLE productores (
    id_prod   INTEGER PRIMARY KEY NOT NULL,
    nombre    VARCHAR2(30) NOT NULL,
    telefono  VARCHAR2(30)
)
TABLESPACE "USERS";

CREATE TABLE animales (
    id           INTEGER PRIMARY KEY NOT NULL,
    descripcion  VARCHAR2(20) NOT NULL,
    categoria    VARCHAR2(10),
    id_prod      NUMBER NOT NULL,
    CONSTRAINT id_prod FOREIGN KEY ( id_prod )
        REFERENCES productores ( id_prod )
)
TABLESPACE "USERS";

DELETE FROM PRODUCTORES WHERE ID_PROD = 1;