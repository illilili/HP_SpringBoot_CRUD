INSERT INTO article(title, content) VALUES('가가가가', '1111');
INSERT INTO article(title, content) VALUES('나나나나', '2222');
INSERT INTO article(title, content) VALUES('다다다다', '3333');

INSERT INTO article(id, title, content) VALUES(4,'당신의 인생 영화는?', '댓글ㄱ');
INSERT INTO article(id, title, content) VALUES(5,'당신의 소울 푸드는?', '댓글ㄱㄱ');
INSERT INTO article(id, title, content) VALUES(6,'당신의 취미는?', '댓글ㄱㄱㄱ');

INSERT INTO comment(id, article_id, nickname, body) VALUES(1, 4, 'Park', '굳 윌 헌팅');
INSERT INTO comment(id, article_id, nickname, body) VALUES(2, 4, 'Kim', '아이엠 샘');
INSERT INTO comment(id, article_id, nickname, body) VALUES(3, 4, 'Choi', '쇼생크의 탈출');

INSERT INTO comment(id, article_id, nickname, body) VALUES(4, 5, 'Park', '치킨');
INSERT INTO comment(id, article_id, nickname, body) VALUES(5, 5, 'Kim', '샤브샤브');
INSERT INTO comment(id, article_id, nickname, body) VALUES(6, 5, 'Choi', '초밥');

INSERT INTO comment(id, article_id, nickname, body) VALUES(7, 6, 'Park', '조깅');
INSERT INTO comment(id, article_id, nickname, body) VALUES(8, 6, 'Kim', '유튜브');
INSERT INTO comment(id, article_id, nickname, body) VALUES(9, 6, 'Choi', '독서');