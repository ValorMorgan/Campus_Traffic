@rem     *****************************************************************************
@rem     this script starts the Derby ij and creates the database
@rem     *****************************************************************************

@rem     change the following line to 'echo on' for debugging
@echo off

setlocal

@rem     call dbSetenv.cmd script to set up the Derby environment
call dbSetenv

title Create %DB_NAME% database

@rem     start ij, and run the the dbCreate.sql script, which connects 
@rem     to the database, as user/password guest/password,
@rem     creates the database if it doesn't exist,
@rem     and creates the schema and database tables
"C:\Program Files (x86)\Java\jre1.6.0_24\bin\java" -Dij.driver=org.apache.derby.jdbc.ClientDriver -Dij.database=%DB_NAME%;create=true -Dij.user=guest -Dij.password=password org.apache.derby.tools.ij dbCreate_ParkingLots.sql
"C:\Program Files (x86)\Java\jre1.6.0_24\bin\java" -Dij.driver=org.apache.derby.jdbc.ClientDriver -Dij.database=%DB_NAME%;create=true -Dij.user=guest -Dij.password=password org.apache.derby.tools.ij dbCreate_Obstructions.sql

echo %DB_NAME% created.
pause

endlocal