-- 최재권

-- health 데이터 삽입
INSERT INTO health (health) VALUES ('피로감');
INSERT INTO health (health) VALUES ('눈 건강');
INSERT INTO health (health) VALUES ('피부 건강');
INSERT INTO health (health) VALUES ('혈관_혈액순환');
INSERT INTO health (health) VALUES ('간 건강');

INSERT INTO health (health) VALUES ('장 건강');
INSERT INTO health (health) VALUES ('스트레스_수면');
INSERT INTO health (health) VALUES ('콜레스테롤');
INSERT INTO health (health) VALUES ('뼈 건강');
INSERT INTO health (health) VALUES ('소화_위식도 건강');

INSERT INTO health (health) VALUES ('혈압');
INSERT INTO health (health) VALUES ('운동 능력_근육량');
INSERT INTO health (health) VALUES ('혈당');
INSERT INTO health (health) VALUES ('치아_잇몸');
INSERT INTO health (health) VALUES ('면역 기능');

select * from health;

-- ingredient 데이터 삽입
INSERT INTO ingredient (name, category) VALUES
('비타민A', 1),
('비타민B', 1),
('비타민C', 1),
('비타민D', 1),
('비타민B6', 1),
('비타민K', 1),
('비타민E', 1),
('비타민B3', 1),
('비타민B2', 1),
('비타민B12', 1),
('오메가3', 1),
('아연', 1),
('마그네슘', 1),
('엽산', 1),
('아르기닌', 1),
('철분', 1),
('루테인', 1),
('칼슘', 1),
('유산균', 1),
('홍삼', 1),
('밀크씨슬', 1),
('칼륨', 1),
('콜라겐', 1),
('단백질', 1),
('효소', 1),
('코엔자임Q10', 0),
('크레아틴', 0),
('프로폴리스', 0);

select * from ingredient;
-- healthIngredient 데이터 삽입
INSERT INTO healthIngredient (health_seq, ingredient_seq) VALUES
(1, (SELECT seq FROM ingredient WHERE name = '비타민B12')),
(1, (SELECT seq FROM ingredient WHERE name = '마그네슘')),
(2, (SELECT seq FROM ingredient WHERE name = '비타민A')),
(2, (SELECT seq FROM ingredient WHERE name = '루테인')),
(2, (SELECT seq FROM ingredient WHERE name = '오메가3')),
(3, (SELECT seq FROM ingredient WHERE name = '비타민B')),
(3, (SELECT seq FROM ingredient WHERE name = '콜라겐')),
(3, (SELECT seq FROM ingredient WHERE name = '비타민C')),
(4, (SELECT seq FROM ingredient WHERE name = '오메가3')),
(4, (SELECT seq FROM ingredient WHERE name = '마그네슘')),
(4, (SELECT seq FROM ingredient WHERE name = '비타민B')),
(5, (SELECT seq FROM ingredient WHERE name = '밀크씨슬')),
(6, (SELECT seq FROM ingredient WHERE name = '유산균')),
(7, (SELECT seq FROM ingredient WHERE name = '비타민B6')),
(7, (SELECT seq FROM ingredient WHERE name = '오메가3')),
(7, (SELECT seq FROM ingredient WHERE name = '비타민B3')),
(8, (SELECT seq FROM ingredient WHERE name = '밀크씨슬')),
(8, (SELECT seq FROM ingredient WHERE name = '비타민B')),
(8, (SELECT seq FROM ingredient WHERE name = '오메가3')),
(9, (SELECT seq FROM ingredient WHERE name = '마그네슘')),
(9, (SELECT seq FROM ingredient WHERE name = '비타민D')),
(9, (SELECT seq FROM ingredient WHERE name = '칼슘')),
(10, (SELECT seq FROM ingredient WHERE name = '효소')),
(11, (SELECT seq FROM ingredient WHERE name = '코엔자임Q10')),
(11, (SELECT seq FROM ingredient WHERE name = '비타민C')),
(12, (SELECT seq FROM ingredient WHERE name = '크레아틴')),
(12, (SELECT seq FROM ingredient WHERE name = '단백질')),
(13, (SELECT seq FROM ingredient WHERE name = '비타민B')),
(13, (SELECT seq FROM ingredient WHERE name = '마그네슘')),
(13, (SELECT seq FROM ingredient WHERE name = '비타민D')),
(13, (SELECT seq FROM ingredient WHERE name = '코엔자임Q10')),
(13, (SELECT seq FROM ingredient WHERE name = '비타민C')),
(14, (SELECT seq FROM ingredient WHERE name = '아연')),
(14, (SELECT seq FROM ingredient WHERE name = '비타민D')),
(14, (SELECT seq FROM ingredient WHERE name = '프로폴리스')),
(14, (SELECT seq FROM ingredient WHERE name = '칼슘')),
(15, (SELECT seq FROM ingredient WHERE name = '비타민C')),
(15, (SELECT seq FROM ingredient WHERE name = '비타민D'));
select * from healthIngredient;

