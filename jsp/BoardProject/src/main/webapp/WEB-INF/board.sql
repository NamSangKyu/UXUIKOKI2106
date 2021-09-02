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
	CONTENT VARCHAR2(1000 BYTE),
	BCOUNT NUMBER
);
--컬럼 삭제
alter table board drop column blike;
alter table board drop column bhate;
select b.*, 
(select count(*) from BOARD_LIKE bl where b.bno = bl.bno) as blike, 
(select count(*) from BOARD_hate bh where b.bno = bh.bno) as bhate
from board b order by bno desc;
--제약조건
ALTER TABLE BOARD ADD CONSTRAINT FK_WRITER FOREIGN KEY(WRITER)
REFERENCES MEMBER(ID) ON DELETE CASCADE;

--시퀸스 : 1~
CREATE SEQUENCE BOARD_NO START WITH 1;

insert into board(bno, title, content, writer, bdate, bcount)
values(board_no.nextval,'제목25','내용','A0001',sysdate,0);
insert into board(bno, title, content, writer, bdate, bcount)
values(board_no.nextval,'제목26','내용','A0001',sysdate,0);
insert into board(bno, title, content, writer, bdate, bcount)
values(board_no.nextval,'제목27','내용','A0001',sysdate,0);
insert into board(bno, title, content, writer, bdate, bcount)
values(board_no.nextval,'제목28','내용','A0001',sysdate,0);
insert into board(bno, title, content, writer, bdate, bcount)
values(board_no.nextval,'제목29','내용','A0001',sysdate,0);
insert into board(bno, title, content, writer, bdate, bcount)
values(board_no.nextval,'제목30','내용','A0001',sysdate,0);

select * from member;

--좋아요 테이블
--글번호, 회원아이디
create table board_like(
	bno number,
	id varchar2(20 BYTE),
	constraint board_like_pk primary key(bno,id)
);
ALTER TABLE board_like ADD CONSTRAINT board_like_bno_fk FOREIGN KEY(bno)
REFERENCES board(bno) ON DELETE CASCADE;

ALTER TABLE board_like ADD CONSTRAINT board_like_id_fk FOREIGN KEY(id)
REFERENCES MEMBER(ID) ON DELETE CASCADE;

insert into BOARD_LIKE values(1,'A0001');

--싫어요 테이블
--글번호, 회원아이디
create table board_hate(
	bno number,
	id varchar2(20 BYTE),
	constraint board_hate_pk primary key(bno,id)
);
ALTER TABLE board_hate ADD CONSTRAINT board_hate_bno_fk FOREIGN KEY(bno)
REFERENCES board(bno) ON DELETE CASCADE;

ALTER TABLE board_hate ADD CONSTRAINT board_hate_id_fk FOREIGN KEY(id)
REFERENCES MEMBER(ID) ON DELETE CASCADE;

insert into board_hate values(1,'A0001');

--해당 게시글의 페이지 번호를 조회, 한페이지당 게시글은 5개가 조회
create or replace view board_list
as
select b.*, 
(select count(*) from BOARD_LIKE bl where b.bno = bl.bno) as blike, 
(select count(*) from BOARD_hate bh where b.bno = bh.bno) as bhate
from board b;

select b.*, ceil(rownum / 5) as pageno from
(select * from board_list order by bno desc) b where ceil(rownum / 5) = 1;


--전체 게시글 개수
select count(*) from board_list;













