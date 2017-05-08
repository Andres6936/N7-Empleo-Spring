@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogotá - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n7_empleo
REM Autor: Milena Vela - 21-abr-2006
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

java -classpath ../lib/empleo.jar;../test/lib/empleoTest.jar;../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.empleo.test.BolsaDeEmpleoTest
java -classpath ../lib/empleo.jar;../test/lib/empleoTest.jar;../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.empleo.test.AspiranteTest
