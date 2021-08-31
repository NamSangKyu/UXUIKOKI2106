--게시판 DB
--회원, 게시글, 댓글
--게시글 : 글번호, 제목, 작성자, 작성일, 좋아요, 싫어요, 내용, 조회수
--위에 컬럼을 기반으로 BOARD 테이블 작성
DROP TABLE BOARD;
DROP TABLE BOARD_COMMENT;
CREATE TABLE BOARD(
	BNO NUMBER PRIMARY KEY,
	TITLE VARCHAR2(60 BYTE),
	WRITER VARCHAR2(20 BYTE),
	BDATE DATE,
	BLIKE NUMBER,
	BHATE NUMBER,
	CONTENT VARCHAR2(1000 BYTE),
	BCOUNT NUMBER
);

--제약조건
ALTER TABLE BOARD ADD CONSTRAINT FK_WRITER FOREIGN KEY(WRITER)
REFERENCES MEMBER(ID) ON DELETE CASCADE;

--시퀸스 : 1~
CREATE SEQUENCE BOARD_NO START WITH 1;

insert into board(bno, title, content, writer, bdate, blike, bhate,bcount)
values(board_no.nextval,'제목','내용','작성자',sysdate,0,0,0);




