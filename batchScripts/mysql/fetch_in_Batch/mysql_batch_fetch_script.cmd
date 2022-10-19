@echo off

set MASTER_DB_USER=root
set MASTER_DB_PASSWD=password
set MASTER_DB_PORT=3306
set MASTER_DB_HOST=localhost
set MASTER_DB_NAME=world

setlocal enabledelayedexpansion

set /A offset=0
set /A batchSize=2
set /A lastRow=11
set /A loopCount=1

:while
if !offset! leq !lastRow! (
   
   set SQL_Query="select * from people limit !offset!,!batchSize!"

   echo !SQl_QUERY!

   set result=
   set /A count=1
   set /A one=1

   FOR /F "tokens=*" %%x in ('MYSQL -u%MASTER_DB_USER% -p%MASTER_DB_PASSWD% -h%MASTER_DB_HOST% -P%MASTER_DB_PORT%  -D%MASTER_DB_NAME% -e !SQL_Query!') DO (
	echo !loopCount!
      
      if !count! GTR !one! (
         set result=%%x 
         echo !result! >> output.txt
      ) 
      if !loopCount! EQU !one! if !count! EQU !one! (
         set result=%%x 
         echo !result! >> output.txt
      )
      
      set /A count=!count!+!one!

   )
   set /A loopCount=!loopCount!+!one!

   echo !ERRORLEVEL!
   set /A offset=!offset!+!batchSize!

   goto :while
)
set  offset=

echo "End of script"