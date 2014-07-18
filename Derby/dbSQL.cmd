@rem     ******************************************
@rem     this script starts the ij tool
@rem     ******************************************

@rem     change the following line to 'echo on' for debugging
@echo off

setlocal

@rem     call dbSetenv.cmd script to set up the Derby environment
call dbSetenv

title ij

@rem     start ij, connecting as username/password: guest/password
"C:\Program Files (x86)\Java\jre1.6.0_24\bin\java" -Dij.driver=org.apache.derby.jdbc.ClientDriver -Dij.database=%DB_NAME% -Dij.user=guest -Dij.password=password org.apache.derby.tools.ij

endlocal