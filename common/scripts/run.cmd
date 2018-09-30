@ECHO OFF

SET "CURRENT_DIR=%cd%"
SET "LIB=%CURRENT_DIR%\lib"
call java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -jar %LIB%\party-lab-aggregator.jar