@rem     ************************************************
@rem     this script starts the Derby database server
@rem     ************************************************

@rem     change the following line to 'echo on' for debugging
@echo off

setlocal

@rem     call dbSetenv.cmd script to set up the Derby environment
call dbSetenv

@rem     start the Derby database server
start "Derby Server" "C:\Program Files (x86)\Java\jre1.6.0_24\bin\java" org.apache.derby.drda.NetworkServerControl start

endlocal