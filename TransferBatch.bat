@echo off
rem Script para executar o projeto Java

rem Caminho para o JAR gerado
set JAR_PATH=C:\Users\kaio\Documents\Projects\calc-commission\target\calc-commission-1.0-SNAPSHOT.jar

rem Comando para executar o JAR
java -jar %JAR_PATH% %*
