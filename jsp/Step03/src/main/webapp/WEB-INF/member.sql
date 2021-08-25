--------------------------------------------------------
--  파일이 생성됨 - 수요일-8월-25-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MEMBER
--------------------------------------------------------

  CREATE TABLE "MEMBER" 
   (	"ID" VARCHAR2(20 BYTE), 
	"PASSWD" VARCHAR2(40 BYTE), 
	"NAME" VARCHAR2(15 BYTE), 
	"AGE" NUMBER(3,0) DEFAULT 0, 
	"GENDER" CHAR(1 BYTE), 
	"POINT" NUMBER DEFAULT 0, 
	"GRADE" VARCHAR2(10 BYTE) DEFAULT 'Bronze'
   ) ;
REM INSERTING into MEMBER
SET DEFINE OFF;
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('I6970J','1234','강바일',3,'1',64800,'VVIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('G9554J','1234','김동량',23,'1',88580,'VVIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('U1191V','1234','김시래',58,'0',24760,'Gold');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('W7266H','1234','김진영',26,'0',49560,'VIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('V9882P','1234','김현수',34,'1',106320,'VVIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('W4395F','1234','박민우',16,'0',1040,'Bronze');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('J3021F','1234','배수용',41,'1',260,'Bronze');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('J7982N','1234','이동엽',34,'0',7760,'Bronze');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('I2752U','1234','이재우',18,'1',32030,'DIAMOND');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('P9316X','1234','이호현',17,'0',23780,'Gold');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('U1687M','1234','임동섭',15,'0',20000,'Silver');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('S5778H','1234','장민국',6,'1',116000,'VVIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('F9483G','1234','전형준',50,'0',3160,'Bronze');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('Q1251U','1234','정준수',43,'1',400,'Bronze');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('W7432X','1234','차민석',24,'1',0,'Bronze');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('U6879W','1234','박수미',6,'1',102880,'VVIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('F3035R','1234','정유민',16,'1',44930,'VIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('X5494N','1234','김진아',36,'0',419400,'VVIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('P2994I','1234','이규섭',30,'1',142100,'VVIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('D5485O','1234','유주흔',56,'1',7120,'Bronze');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('O3335O','1234','양수진',14,'1',28220,'Gold');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('Z2639R','1234','김정연',34,'0',38690,'DIAMOND');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('U3054H','1234','이주아',57,'1',60780,'VVIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('Q2421F','1234','최선미',42,'1',32500,'DIAMOND');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('B7176F','1234','김다인',47,'1',145000,'VVIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('F3947Q','1234','김주연',1,'0',36900,'DIAMOND');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('Y2585E','1234','윤영서',16,'0',91140,'VVIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('G4006C','1234','이상민',7,'1',58800,'VVIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('A4828I','1234','양은성',19,'1',300,'Bronze');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('H7938B','1234','이규섭',33,'1',260,'Bronze');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('G3782Q','1234','최수현',57,'0',2700,'Bronze');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('R7062L','1234','김형철',16,'1',10680,'Silver');
--------------------------------------------------------
--  DDL for Index SYS_C007003
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007003" ON "MEMBER" ("ID") 
  ;

--------------------------------------------------------
--  Constraints for Table MEMBER
--------------------------------------------------------

  ALTER TABLE "MEMBER" ADD PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "MEMBER" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "MEMBER" MODIFY ("PASSWD" NOT NULL ENABLE);
