--------------------------------------------------------
--  ������ ������ - ������-8��-25-2021   
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
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('I6970J','1234','������',3,'1',64800,'VVIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('G9554J','1234','�赿��',23,'1',88580,'VVIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('U1191V','1234','��÷�',58,'0',24760,'Gold');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('W7266H','1234','������',26,'0',49560,'VIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('V9882P','1234','������',34,'1',106320,'VVIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('W4395F','1234','�ڹο�',16,'0',1040,'Bronze');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('J3021F','1234','�����',41,'1',260,'Bronze');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('J7982N','1234','�̵���',34,'0',7760,'Bronze');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('I2752U','1234','�����',18,'1',32030,'DIAMOND');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('P9316X','1234','��ȣ��',17,'0',23780,'Gold');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('U1687M','1234','�ӵ���',15,'0',20000,'Silver');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('S5778H','1234','��α�',6,'1',116000,'VVIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('F9483G','1234','������',50,'0',3160,'Bronze');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('Q1251U','1234','���ؼ�',43,'1',400,'Bronze');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('W7432X','1234','���μ�',24,'1',0,'Bronze');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('U6879W','1234','�ڼ���',6,'1',102880,'VVIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('F3035R','1234','������',16,'1',44930,'VIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('X5494N','1234','������',36,'0',419400,'VVIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('P2994I','1234','�̱Լ�',30,'1',142100,'VVIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('D5485O','1234','������',56,'1',7120,'Bronze');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('O3335O','1234','�����',14,'1',28220,'Gold');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('Z2639R','1234','������',34,'0',38690,'DIAMOND');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('U3054H','1234','���־�',57,'1',60780,'VVIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('Q2421F','1234','�ּ���',42,'1',32500,'DIAMOND');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('B7176F','1234','�����',47,'1',145000,'VVIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('F3947Q','1234','���ֿ�',1,'0',36900,'DIAMOND');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('Y2585E','1234','������',16,'0',91140,'VVIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('G4006C','1234','�̻��',7,'1',58800,'VVIP');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('A4828I','1234','������',19,'1',300,'Bronze');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('H7938B','1234','�̱Լ�',33,'1',260,'Bronze');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('G3782Q','1234','�ּ���',57,'0',2700,'Bronze');
Insert into MEMBER (ID,PASSWD,NAME,AGE,GENDER,POINT,GRADE) values ('R7062L','1234','����ö',16,'1',10680,'Silver');
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
