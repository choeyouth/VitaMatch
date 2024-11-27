-- 성별/나이대별 insert
INSERT INTO surveyGenderAge (gender, age) VALUES
('f', 10),
('f', 20),
('f', 30),
('f', 40),
('f', 50),
('f', 60),
('m', 10),
('m', 20),
('m', 30),
('m', 40),
('m', 50),
('m', 60);

select * from surveyGenderAge;

-- 성별/나이대별 + 성분 연관 테이블
INSERT INTO ingredientGenderAge (genderAge_seq, ingredient_seq) VALUES
(1,1),
(1,12),
(1,18),
(2,4),
(2,13),
(2,18),
(3,13),
(3,18),
(3,21),
(4,11),
(4,13),
(4,18),
(5,4),
(5,10),
(5,22),
(6,11),
(6,18),
(6,22),
(7,1),
(7,12),
(7,18),
(8,2),
(8,11),
(8,21),
(9,3),
(9,11),
(9,14),
(10,4),
(10,17),
(10,26),
(11,11),
(11,13),
(11,18),
(12,11),
(12,13),
(12,18);

select * from ingredientGenderAge;

INSERT INTO surveyHealth (name) VALUES
('간 건강'),
('피로감'),
('혈관 및 혈액 순환'),
('콜레스테롤'),
('혈당 관리'),
('혈압 관리');

select * from surveyHealth;

INSERT INTO ingredientHealth (health_seq, ingredient_seq) VALUES
(1,2),
(1,15),
(1,21),
(2,10),
(2,13),
(2,16),
(3,2),
(3,11),
(3,13),
(3,3),
(4,8),
(4,11),
(4,21),
(5,3),
(5,4),
(5,13),
(6,3),
(6,11),
(6,13);

select * from ingredientHealth;

INSERT INTO surveyOrgan (name) VALUES
('눈 건강'),
('뼈 건강'),
('장 건강');

select * from surveyOrgan;

INSERT INTO ingredientOrgan (organ_seq, ingredient_seq) VALUES
(1,1),
(1,11),
(1,17),
(2,4),
(2,13),
(2,18),
(3,19);

select * from ingredientOrgan;

INSERT INTO surveyDaily (name) VALUES
('운동 능력 및 근육량'),
('면역 기능'),
('소화 및 위식도 건강'),
('스트레스 및 수면'),
('치아 및 잇몸'),
('피부 건강');

select * from surveyDaily;

INSERT INTO ingredientDaily (daily_seq, ingredient_seq) VALUES
(1,13),
(1,15),
(1,24),
(2,3),
(2,4),
(2,12),
(3,5),
(3,19),
(3,25),
(4,5),
(4,8),
(4,11),
(5,4),
(5,12),
(5,18),
(6,2),
(6,3),
(6,23);

select * from ingredientDaily;

commit;

-- 성별 나이대별 영양제 성분 및 내용 뷰
CREATE OR REPLACE VIEW vwGenderAgeRecommend AS
SELECT 
    iga.seq,
    ga.gender as gender,
    ga.age as age,
    iga.genderAge_seq as genderAgeSeq,
    iga.ingredient_seq as ingredientSeq,
    i.name as ingredientName,
    ic.functionalContent
FROM surveyGenderAge ga
INNER JOIN ingredientGenderAge iga ON ga.seq = iga.genderAge_seq
INNER JOIN ingredient i ON iga.ingredient_seq = i.seq
INNER JOIN ingredientContent ic ON i.seq = ic.ingredient_seq;

select * from vwGenderAgeRecommend;

drop view vwGenderAgeRecommend;

-- 건강검진 영양제 성분 및 내용 뷰
CREATE VIEW vwHealthRecommend AS
SELECT ih.seq, 
       h.name,
       ih.health_seq as healthSeq,
       ih.ingredient_seq as ingredientSeq,
       i.name as ingredientName,
       ic.functionalContent
FROM surveyHealth h
INNER JOIN ingredientHealth ih ON h.seq = ih.health_seq
INNER JOIN ingredient i ON ih.ingredient_seq = i.seq
INNER JOIN ingredientContent ic ON i.seq = ic.ingredient_seq;

select * from vwHealthRecommend;

drop view vwHealthRecommend;

-- 주요 장기 영양제 성분 및 내용 뷰
CREATE VIEW vwOrganRecommend AS
SELECT io.seq, 
       o.name,
       io.organ_seq as organSeq,
       io.ingredient_seq as ingredientSeq,
       i.name as ingredientName,
       ic.functionalContent
FROM surveyOrgan o
INNER JOIN ingredientOrgan io ON o.seq = io.organ_seq
INNER JOIN ingredient i ON io.ingredient_seq = i.seq
INNER JOIN ingredientContent ic ON i.seq = ic.ingredient_seq;

select * from vwOrganRecommend;

drop view vwOrganRecommend;

-- 일상생활 영양제 성분 및 내용 뷰
CREATE VIEW vwDailyRecommend AS
SELECT id.seq, 
       d.name,
       id.daily_seq as dailySeq,
       id.ingredient_seq as ingredientSeq,
       i.name as ingredientName,
       ic.functionalContent
FROM surveyDaily d
INNER JOIN ingredientDaily id ON d.seq = id.daily_seq
INNER JOIN ingredient i ON id.ingredient_seq = i.seq
INNER JOIN ingredientContent ic ON i.seq = ic.ingredient_seq;

select * from vwDailyRecommend;

drop view vwDailyRecommend;

commit;
