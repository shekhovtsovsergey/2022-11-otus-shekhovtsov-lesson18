INSERT INTO AUTHORS (NAME) VALUES('Lean Nielsen');
INSERT INTO AUTHORS (NAME) VALUES('Klaus Rifbjerg');
INSERT INTO AUTHORS (NAME) VALUES('Thorkild Bjørnvig');
INSERT INTO AUTHORS (NAME) VALUES('Cecil Bødker');
INSERT INTO AUTHORS (NAME) VALUES('Grete Stenbæk');

insert into GENRES (name) values('Documental');
insert into GENRES (name) values('History');

INSERT INTO BOOKS (NAME, AUTHOR_ID,GENRE_ID) VALUES ('Ned ad trappen, ud på gaden (Danish Edition)',1,1);
INSERT INTO BOOKS (NAME, AUTHOR_ID,GENRE_ID) VALUES ('Kesses krig (Unge læsere) (Danish Edition)',1,1);
INSERT INTO BOOKS (NAME, AUTHOR_ID,GENRE_ID) VALUES ('Hjørnestuen og månehavet: Erindringer 1934-1938 (Danish Edition)',2,2);
INSERT INTO BOOKS (NAME, AUTHOR_ID,GENRE_ID) VALUES ('Vandgården: Roman (Danish Edition)',2,2);
INSERT INTO BOOKS (NAME, AUTHOR_ID,GENRE_ID) VALUES ('Thea (Danish Edition)',1,1);

INSERT INTO COMMENTS (BOOK_ID, AUTHOR_NAME,COMMENT) VALUES (1,DEFAULT,'Скукота');
INSERT INTO COMMENTS (BOOK_ID, AUTHOR_NAME,COMMENT) VALUES (1,DEFAULT,'Скукота');
INSERT INTO COMMENTS (BOOK_ID, AUTHOR_NAME,COMMENT) VALUES (1,DEFAULT,'Скукота');
INSERT INTO COMMENTS (BOOK_ID, AUTHOR_NAME,COMMENT) VALUES (1,DEFAULT,'Скукота');
INSERT INTO COMMENTS (BOOK_ID, AUTHOR_NAME,COMMENT) VALUES (1,DEFAULT,'Скукота');
