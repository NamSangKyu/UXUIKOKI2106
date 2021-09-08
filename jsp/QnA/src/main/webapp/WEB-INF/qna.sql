--QnA
create table QNA(
	qno number primary key,
	qcode char(1),
	qcontent varchar2(500),
	qdate date,
	qwriter varchar2(50),
	status char(1),
	acontent varchar2(500),
	awriter varchar2(50),
	adate date
);
update qna set status = '0';
--시퀸스
create sequence qna_no_seq start with 1; 
--파일 테이블
create table QNA_FILE_LIST(
	fno number primary key,
	qno number,
	writer varchar2(50),
	file_url varchar2(300),
	fdate date
);
create sequence file_no_seq start with 1; 
alter table QNA_FILE_LIST 
add constraint fk_qno foreign key(qno) 
references qna(qno);

select * from QNA;
select * from QNA_FILE_LIST;

