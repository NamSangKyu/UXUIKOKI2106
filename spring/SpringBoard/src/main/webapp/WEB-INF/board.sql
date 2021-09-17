--------------------------------------------------------
--  파일이 생성됨 - 금요일-9월-17-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BOARD
--------------------------------------------------------

  CREATE TABLE "BOARD" 
   (	"BNO" NUMBER, 
	"TITLE" VARCHAR2(60), 
	"WRITER" VARCHAR2(20), 
	"BDATE" DATE, 
	"CONTENT" VARCHAR2(1000), 
	"BCOUNT" NUMBER
   ) ;
--------------------------------------------------------
--  DDL for Table BOARD_COMMENT
--------------------------------------------------------

  CREATE TABLE "BOARD_COMMENT" 
   (	"CNO" NUMBER, 
	"CONTENT" VARCHAR2(500), 
	"CDATE" DATE DEFAULT sysdate, 
	"BNO" NUMBER, 
	"WRITER" VARCHAR2(20)
   ) ;
--------------------------------------------------------
--  DDL for Table BOARD_COMMENT_HATE
--------------------------------------------------------

  CREATE TABLE "BOARD_COMMENT_HATE" 
   (	"CNO" NUMBER, 
	"ID" VARCHAR2(20)
   ) ;
--------------------------------------------------------
--  DDL for Table BOARD_COMMENT_LIKE
--------------------------------------------------------

  CREATE TABLE "BOARD_COMMENT_LIKE" 
   (	"CNO" NUMBER, 
	"ID" VARCHAR2(20)
   ) ;
--------------------------------------------------------
--  DDL for Table BOARD_FILE_LIST
--------------------------------------------------------

  CREATE TABLE "BOARD_FILE_LIST" 
   (	"FNO" NUMBER, 
	"BNO" NUMBER, 
	"WRITER" VARCHAR2(50), 
	"PATH" VARCHAR2(300), 
	"FDATE" DATE DEFAULT SYSDATE, 
	"ORIGINFILENAME" VARCHAR2(100)
   ) ;
--------------------------------------------------------
--  DDL for Index SYS_C007375
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007375" ON "BOARD" ("BNO") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C007383
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007383" ON "BOARD_COMMENT" ("CNO") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C007464
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007464" ON "BOARD_FILE_LIST" ("FNO") 
  ;
--------------------------------------------------------
--  Constraints for Table BOARD
--------------------------------------------------------

  ALTER TABLE "BOARD" ADD PRIMARY KEY ("BNO") ENABLE;
--------------------------------------------------------
--  Constraints for Table BOARD_COMMENT
--------------------------------------------------------

  ALTER TABLE "BOARD_COMMENT" ADD PRIMARY KEY ("CNO") ENABLE;
--------------------------------------------------------
--  Constraints for Table BOARD_FILE_LIST
--------------------------------------------------------

  ALTER TABLE "BOARD_FILE_LIST" ADD PRIMARY KEY ("FNO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BOARD
--------------------------------------------------------

  ALTER TABLE "BOARD" ADD CONSTRAINT "FK_WRITER" FOREIGN KEY ("WRITER")
	  REFERENCES "MEMBER" ("ID") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BOARD_COMMENT
--------------------------------------------------------

  ALTER TABLE "BOARD_COMMENT" ADD CONSTRAINT "BC_BNO_FK" FOREIGN KEY ("BNO")
	  REFERENCES "BOARD" ("BNO") ON DELETE CASCADE ENABLE;
  ALTER TABLE "BOARD_COMMENT" ADD CONSTRAINT "BC_WRITER_FK" FOREIGN KEY ("WRITER")
	  REFERENCES "MEMBER" ("ID") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BOARD_COMMENT_HATE
--------------------------------------------------------

  ALTER TABLE "BOARD_COMMENT_HATE" ADD CONSTRAINT "HATE_CNO_FK" FOREIGN KEY ("CNO")
	  REFERENCES "BOARD_COMMENT" ("CNO") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BOARD_COMMENT_LIKE
--------------------------------------------------------

  ALTER TABLE "BOARD_COMMENT_LIKE" ADD CONSTRAINT "LIKE_CNO_FK" FOREIGN KEY ("CNO")
	  REFERENCES "BOARD_COMMENT" ("CNO") ON DELETE CASCADE ENABLE;
