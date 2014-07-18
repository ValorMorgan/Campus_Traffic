@rem     ************************************************
@rem     this script starts the Derby database server
@rem     ************************************************

@rem     change the following line to 'echo on' for debugging
@echo off

setlocal

@rem     call dbSetenv.cmd script to set up the Derby environment
call dbSetenv

title Stop Derby Server

@rem     stop the Derby database server
"C:\Program Files (x86)\Java\jre1.6.0_24\bin\java" org.apache.derby.drda.NetworkServerControl shutdown

echo Derby server stopped.
pause

endlocal