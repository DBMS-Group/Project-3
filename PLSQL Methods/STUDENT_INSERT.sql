/*
Inserts a student into the table, setting their level based on the number of 
credits they've taken given as a parameter to the procedure.
*/
CREATE OR REPLACE PROCEDURE STUDENT_INSERT 
(
  SNUM IN NUMBER 
, SNAME IN VARCHAR2 
, MAJOR IN VARCHAR2 
, CREDITS IN NUMBER 
, AGE IN NUMBER 
) 
AS 
  V_LEVEL VARCHAR2(255);
BEGIN
  IF CREDITS < 30 THEN 
    V_LEVEL := 'FR';
  ELSIF CREDITS < 60 THEN
    V_LEVEL := 'SF';
  ELSIF CREDITS < 90 THEN
    V_LEVEL := 'JR';
  ELSE
    V_LEVEL := 'SR';
  END IF;
  INSERT INTO STUDENT VALUES (SNUM, SNAME, MAJOR, V_LEVEL, AGE);
END STUDENT_INSERT;