DRIVER 'org.apache.derby.jdbc.ClientDriver';
connect 'jdbc:derby://localhost:1527/CAMPUS' USER 'guest' PASSWORD 'password';

DROP TABLE Obstructions;

CREATE TABLE Obstructions
(
   ID		 INT		  NOT NULL    GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1),
   Street_Name   VARCHAR(30)      NOT NULL,
   X_Coord       DECIMAL(8,6)     NOT NULL,
   Y_Coord       DECIMAL(8,6)     NOT NULL,
   Description   VARCHAR(80)      DEFAULT 'Obstruction present, please find alternate route.',
   CONSTRAINT    PK_Obstruction   PRIMARY KEY(ID)
);

INSERT INTO Obstructions VALUES
                     (DEFAULT, 'Red Cedar', 42.728904, -84.483225, 'Construction - Road Closed');

INSERT INTO Obstructions VALUES
                     (DEFAULT, 'Farm', 42.725594, -84.477861, DEFAULT);

INSERT INTO Obstructions VALUES
		     (DEFAULT, 'W Circle 1', 42.730860, -84.481351, 'Summer Construction- West Circle Dr.');

INSERT INTO Obstructions VALUES
		     (DEFAULT, 'W Circle 2', 42.732203, -84.479978, 'Summer Construction- West Circle Dr.');

INSERT INTO Obstructions VALUES
		     (DEFAULT, 'W Circle 3', 42.730004, -84.479377, 'Summer Construction- West Circle Dr.');

INSERT INTO Obstructions VALUES
		     (DEFAULT, 'W Circle 4', 42.730004, -84.479645, 'Summer Construction- West Circle Dr.');


COMMIT;
