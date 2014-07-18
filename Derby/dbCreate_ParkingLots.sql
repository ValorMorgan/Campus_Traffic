DRIVER 'org.apache.derby.jdbc.ClientDriver';
connect 'jdbc:derby://localhost:1527/CAMPUS' USER 'guest' PASSWORD 'password';

DROP TABLE ParkingLots;

CREATE TABLE ParkingLots
(
   Lot_Name   VARCHAR(10)      NOT NULL,
   X_Coord    DECIMAL(8,6)     NOT NULL,
   Y_Coord    DECIMAL(8,6)     NOT NULL,
   Capacity   INTEGER,
   Vehicles   INTEGER,
   Lot_Open   SMALLINT         NOT NULL,
   CONSTRAINT PK_ParkingLots   PRIMARY KEY(Lot_Name)
);

INSERT INTO ParkingLots VALUES
		     ('89', 42.713648, -84.481228, 40, 21, 1);

INSERT INTO ParkingLots VALUES
		     ('83', 42.718792, -84.488275, 40, 0, 0);

INSERT INTO ParkingLots VALUES
                     ('79', 42.726636, -84.484728, 30, 18, 1);

INSERT INTO ParkingLots VALUES
                     ('79e', 42.726784, -84.483502, 50, 42, 1);

INSERT INTO ParkingLots VALUES
                     ('75', 42.728579, -84.495837, 50, 42, 1);

INSERT INTO ParkingLots VALUES
		     ('62w', 42.729975, -84.486680, 60, 12, 1);

INSERT INTO ParkingLots VALUES
                     ('57', 42.723898, -84.483508, 54, 21, 1);

INSERT INTO ParkingLots VALUES
                     ('56', 42.725159, -84.483248, 10, 0, 0);

INSERT INTO ParkingLots VALUES
                     ('55', 42.727870, -84.483040, 28, 28, 1);

INSERT INTO ParkingLots VALUES
		     ('54', 42.721085, -84.472546, 56, 16, 1);

INSERT INTO ParkingLots VALUES
                     ('43', 42.724093, -84.479017, 35, 35, 1);

INSERT INTO ParkingLots VALUES
                     ('41', 42.725599, -84.477155, 147, 47, 0);

INSERT INTO ParkingLots VALUES
                     ('40', 42.725623, -84.478934, 74, 2, 0);

INSERT INTO ParkingLots VALUES
                     ('39', 42.725654, -84.481095, 120, 53, 1);

INSERT INTO ParkingLots VALUES
                     ('38', 42.726513, -84.478379, 67, 43, 1);

INSERT INTO ParkingLots VALUES
                     ('20', 42.725798, -84.465271, 64, 0, 0);

INSERT INTO ParkingLots VALUES
                     ('10', 42.728612, -84.479044, 50, 21, 1);

INSERT INTO ParkingLots VALUES
                     ('4', 42.734082, -84.481280, 123, 23, 1);

INSERT INTO ParkingLots VALUES
                     ('2', 42.731055, -84.473594, 34, 12, 1);



COMMIT;
