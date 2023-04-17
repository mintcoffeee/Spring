CREATE TABLE USERIMAGE(
    seq number primary key,
    imagename varchar2(50) not null,
    imagecontent varchar2(4000),
    image1 varchar2(200)
);

create SEQUENCE seq_userimage nocycle nocache;
