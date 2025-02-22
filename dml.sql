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

commit;


-------------------------------------------------------

-- 장보화
INSERT INTO goodCombination (ingredient_seq, good, reason, link) VALUES
((SELECT seq FROM ingredient WHERE name = '비타민E'), (SELECT seq FROM ingredient WHERE name = '오메가3'), '비타민 E가 항산화 작용으로 오메가3지방산 산패를 막아줍니다.', 'https://blog.naver.com/centum_surgery/221505150758'),
((SELECT seq FROM ingredient WHERE name = '칼슘'), (SELECT seq FROM ingredient WHERE name = '비타민D'), '비타민 D는 장에서 칼슘 흡수를 돕습니다.', 'https://blog.naver.com/centum_surgery/221505150758'),
((SELECT seq FROM ingredient WHERE name = '칼슘'), (SELECT seq FROM ingredient WHERE name = '비타민K'), '비타민 K는 골다공증 개선 효과가 있습니다.', 'https://blog.naver.com/centum_surgery/221505150758'),
((SELECT seq FROM ingredient WHERE name = '비타민E'), (SELECT seq FROM ingredient WHERE name = '비타민C'), '비타민C는 비타민E의 흡수율을 높여줍니다. 또한 비타민C는 세포 밖에서, 비타민E는 세포막에서 항산화 작용을 하므로 함께 복용하면 효과가 높습니다.', 'https://blog.naver.com/centum_surgery/221505150758'),
((SELECT seq FROM ingredient WHERE name = '비타민A'), (SELECT seq FROM ingredient WHERE name = '아연'), '아연은 비타민A의 혈중 농도를 유지하면서 비타민A가 필요한 조직으로 가는 것을 돕고, 항산화 효과도 배가시킵니다.', 'https://blog.naver.com/centum_surgery/221505150758'),
((SELECT seq FROM ingredient WHERE name = '칼슘'), (SELECT seq FROM ingredient WHERE name = '마그네슘'), '마그네슘은 칼슘 흡수를 돕습니다.', 'https://m.blog.naver.com/ftc_news/222712166901'),
((SELECT seq FROM ingredient WHERE name = '콜라겐'), (SELECT seq FROM ingredient WHERE name = '비타민C'), '콜라겐은 단백질의 한 종류로 체내에서 아미노산 단위로 분해된 후 다시 합성할 때 비타미 C가 필요합니다. ', 'https://m.blog.naver.com/ftc_news/222712166901'),
((SELECT seq FROM ingredient WHERE name = '철분'), (SELECT seq FROM ingredient WHERE name = '비타민C'), '철분은 산성 성질의 영양소와 복용하면 체내 흡수율을 높일 수 있습니다. ', 'https://www.mkhealth.co.kr/news/articleView.html?idxno=68047'),
((SELECT seq FROM ingredient WHERE name = '오메가3'), (SELECT seq FROM ingredient WHERE name = '비타민E'), '오메가3 지방산은 기름 성분으로, 빛이나 공기, 열 등에 의해 산화되는 등 산패되기 쉽다. 하지만, 비타민E가 이러한 산패 작용을 막아준다.', 'https://news.hidoc.co.kr/news/articleView.html?idxno=25148');
select * from goodCombination;

INSERT INTO badCombination (ingredient_seq, bad, reason, link) VALUES
((SELECT seq FROM ingredient WHERE name = '철분'), (SELECT seq FROM ingredient WHERE name = '칼슘'), '둘은 같은 통로로 흡수되어서 같이 먹으면 흡수율이 떨어질 수 있으므로 , 칼슘은 식사 후에 섭취하는 것이 좋습니다.', 'https://blog.naver.com/centum_surgery/221505150758'),
((SELECT seq FROM ingredient WHERE name = '칼슘'), (SELECT seq FROM ingredient WHERE name = '철분'), '둘은 같은 통로로 흡수되어서 같이 먹으면 흡수율이 떨어질 수 있으므로 철분은 식사 전 섭취하는 것이 좋습니다.', 'https://blog.naver.com/centum_surgery/221505150758'),
((SELECT seq FROM ingredient WHERE name = '마그네슘'), (SELECT seq FROM ingredient WHERE name = '철분'), '둘은 같은 통로로 흡수되어서 같이 먹으면 흡수율이 떨어질 수 있습니다.', 'https://m.blog.naver.com/ftc_news/222712166901'),
((SELECT seq FROM ingredient WHERE name = '철분'), (SELECT seq FROM ingredient WHERE name = '마그네슘'), '둘은 같은 통로로 흡수되어서 같이 먹으면 흡수율이 떨어질 수 있습니다.', 'https://m.blog.naver.com/ftc_news/222712166901'),
((SELECT seq FROM ingredient WHERE name = '유산균'), (SELECT seq FROM ingredient WHERE name = '비타민C'), '유산균은 산에 약하다. 그렇기 때문에 산성이 강한 비타민 C와 함께 먹게 되면 유산균의 생존율이 떨어질 수 있다. ', 'https://www.stcarollo.or.kr/0401/5678'),
((SELECT seq FROM ingredient WHERE name = '아연'), (SELECT seq FROM ingredient WHERE name = '철분'), '두 성분은 서로의 흡수를 저해하는 특징이 있다.', 'https://news.hidoc.co.kr/news/articleView.html?idxno=25148'),
((SELECT seq FROM ingredient WHERE name = '철분'), (SELECT seq FROM ingredient WHERE name = '아연'), '두 성분은 서로의 흡수를 저해하는 특징이 있다.', 'https://news.hidoc.co.kr/news/articleView.html?idxno=25148'),
((SELECT seq FROM ingredient WHERE name = '칼슘'), (SELECT seq FROM ingredient WHERE name = '마그네슘'), '칼슘과 마그네슘은 모두 골다공증을 예방하는 데 도움이 되지만 동시에 먹으면 흡수율이 떨어진다.', 'https://www.gqkorea.co.kr/2023/09/19/%ED%95%A8%EA%BB%98%ED%95%98%EB%A9%B4-%EB%8F%85%EC%9D%B4-%EB%90%98%EB%8A%94-%EC%98%81%EC%96%91%EC%A0%9C/'),
((SELECT seq FROM ingredient WHERE name = '마그네슘'), (SELECT seq FROM ingredient WHERE name = '칼슘'), '칼슘과 마그네슘은 모두 골다공증을 예방하는 데 도움이 되지만 동시에 먹으면 흡수율이 떨어진다.', 'https://www.gqkorea.co.kr/2023/09/19/%ED%95%A8%EA%BB%98%ED%95%98%EB%A9%B4-%EB%8F%85%EC%9D%B4-%EB%90%98%EB%8A%94-%EC%98%81%EC%96%91%EC%A0%9C/');
select * from badCombination;

commit;

CREATE or replace VIEW vwGoodCombination AS
SELECT g.seq, 
       g.ingredient_seq, 
       i.name AS ingredientName, 
       g.good, 
       i2.name AS name, 
       g.reason, 
       g.link,
       c.functionalContent
FROM goodCombination g 
LEFT JOIN ingredient i ON g.ingredient_seq = i.seq
LEFT JOIN ingredient i2 ON g.good = i2.seq
LEFT JOIN ingredientContent c ON g.ingredient_seq = c.ingredient_seq;



CREATE VIEW vwBadCombination AS
SELECT g.seq, 
       g.ingredient_seq, 
       i.name AS ingredientName, 
       g.bad, 
       i2.name AS name, 
       g.reason, 
       g.link,
       c.functionalContent
FROM badCombination g 
LEFT JOIN ingredient i ON g.ingredient_seq = i.seq
LEFT JOIN ingredient i2 ON g.bad = i2.seq
LEFT JOIN ingredientContent c ON g.ingredient_seq = c.ingredient_seq;


select * from vwGoodCombination;
select * from vwBadCombination;
----------------------------------------
-- 남황현
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(1,'가) 어두운 곳에서 시각 적응을 위해 필요<br/>(나) 피부와 점막을 형성하고 기능을 유지하는데 필요<br/>(다) 상피세포의 성장과 발달에 필요','210～1,000 μg RE(699.93∼3,333 IU)',' ',1);
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(2,'탄수화물과 에너지 대사에 필요','0.36～100 mg','이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것',2);
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(3,'(가) 결합조직 형성과 기능유지에 필요<br/>(나) 철의 흡수에 필요<br/>(다) 항산화 작용을 하여 유해산소로부터 세포를 보호하는데 필요','30～1,000 mg',' ',3);
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(4,'(가) 칼슘과 인이 흡수되고 이용되는데 필요<br/>(나) 뼈의 형성과 유지에 필요<br/>(다) 골다공증발생 위험 감소에 도움을 줌','3～10 μg(120∼400 IU)','(가) 고칼슘혈증이 있거나 의약품 복용 시 전문가와 상담할 것<br/>(나) 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것',4);
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(5,'(가) 단백질 및 아미노산 이용에 필요<br/>(나) 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요','0.45～67 mg',' ',5);
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(6,'(가) 정상적인 혈액응고에 필요<br/>(나) 뼈의 구성에 필요','21～1,000 μg','(가) 항응고제 등 복용 시 전문가와 상담할 것<br/>(나) 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것',6);
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(7,'항산화 작용을 하여 유해산소로부터 세포를 보호하는데 필요','3.3～400 mg α-TE(4.917～596 IU)',' ',7);
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(8,'준비중','준비중','준비중',8);
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(9,'체내 에너지 생성에 필요','','이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것',9);
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(10,'정상적인 엽산 대사에 필요','0.72～2,000 μg','이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것',10);
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(11,'혈중 중성지질 개선·혈행 개선·기억력 개선·건조한 눈을 개선하여 눈 건강에 도움을 줄 수 있음','(가) 혈중 중성지질 개선·혈행 개선에 도움을 줄 수 있음 : EPA와 DHA의 합으로서 0.5～2 g<br/>(나) 기억력 개선에 도움을 줄 수 있음 : EPA와 DHA의 합으로서 0.9～2 g<br/>(다) 건조한 눈을 개선하여 눈 건강에 도움을 줄 수 있음 : EPA와 DHA의 합으로서 0.6～1 g','(가) 의약품(항응고제, 항혈소판제, 혈압강하제 등) 복용 시 전문가와 상담할 것<br/>(나) 개인에 따라 피부 관련 이상반응이 발생할 수 있음<br/>(다) 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것',11);
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(12,'(가) 정상적인 면역기능에 필요<br/>(나) 정상적인 세포분열에 필요','2.55～12 mg',' ',12);
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(13,'(가) 에너지 이용에 필요<br/>(나) 신경과 근육 기능 유지에 필요','94.5～250 mg',' ',13);
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(14,'(가) 세포와 혈액생성에 필요<br/>(나) 태아 신경관의 정상 발달에 필요<br/>(다) 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요','120～400 μg',' ',14);
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(15,'혈관이완을 통해 혈행 개선에 도움을 줄 수 있음','L-아르기닌으로서 6 g/일','- 임산부 및 수유부는 섭취에 주의<br/>- 저단백질 식사를 하고 있을 경우 또는 천식, 심장계 질환이 있을 경우 의사와 상의하여 섭취할 것을 권장',15);
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(16,'(가) 체내 산소운반과 혈액생성에 필요<br/>(나) 에너지 생성에 필요','3.6～15 mg','특히 6세 이하는 과량섭취하지 않도록 주의',16);
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(17,'노화로 인해 감소될 수 있는 황반색소밀도를 유지하여 눈 건강에 도움을 줄 수 있음','루테인과 총지아잔틴의 합으로서 12 mg/일','-  영·유아, 어린이, 임산부 및 수유부는 섭취를 피할 것<br/>-  과다 섭취 시 일시적으로 피부가 황색으로 변할 수 있음<br/>-  특정질환(알레르기 체질 등)이 있는 분은 섭취에 주의할 것<br/>-  이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것<br/>-  흡연자는 섭취 시 전문가와 상담할 것',17);
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(18,'(가) 뼈와 치아 형성에 필요<br/>(나) 신경과 근육 기능 유지에 필요<br/>(다) 정상적인 혈액응고에 필요<br/>(라) 골다공증발생 위험 감소에 도움을 줌','210～800 mg',' ',18);
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(19,'혈중 콜레스테롤 개선에 도움을 줄 수 있음','유산균복합물(AB-LIFEⓇ)로서 1.2 x 109 CFU/일','- 질환이 있거나 의약품 복용 시 전문가와 상담할 것<br/>- 특정질환(알레르기 체질, 단장증후군 등)이 있는 분은 섭취에 주의할 것<br/>- 영·유아, 어린이, 임산부 및 수유부는 섭취에 주의할 것<br/>- 어린이가 함부로 섭취하지 않도록 일일섭취량 방법을 지도할 것<br/>- 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것<br/>- 과다섭취에 주의할 것',19);
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(20,'면역력 증진·피로개선·혈소판 응집억제를 통한 혈액 흐름·기억력 개선·항산화·갱년기 여성의 건강에 도움을 줄 수 있음','(가) 면역력 증진·피로개선에 도움을 줄 수 있음 : 진세노사이드 Rg1, Rb1 및 Rg3의 합계로서 3∼80 mg<br/>(나) 혈소판 응집억제를 통한 혈액흐름·기억력 개선·항산화에 도움을 줄 수 있음 : 진세노사이드 Rg1, Rb1 및 Rg3의 합계로서 2.4∼80 mg<br/>(다) 갱년기 여성의 건강에 도움을 줄 수 있음 : 진세노사이드 Rg1, Rb1 및 Rg3의 합계로서 25∼80 mg','의약품(당뇨치료제, 혈액항응고제) 복용 시 섭취에 주의',20);
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(21,'간 건강에 도움을 줄 수 있음','실리마린으로서 130 mg','설사, 위통, 복부팽만 등의 위장관계 장애가 나타나는 경우에는 섭취에 주의',21);
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(22,'체내 물과 전해질 균형에 필요','1.05～3.7 g','(가) 신장질환, 위장관질환 등 있는 경우 섭취 전 전문가와 상담할 것<br/>(나) 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것',22);
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(23,'-  피부 보습에 도움을 줄 수 있음<br/>-  자외선에 의한 피부손상으로부터 피부건강을 유지하는데 도움을 줄 수 있음','저분자콜라겐펩타이드로서 1∼3 g/일','-  영‧유아, 어린이, 임산부 및 수유부는 섭취를 피할 것<br/>-  특정질환(알레르기 체질 등)이 있는 분은 섭취에 주의할 것<br/>-  이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것',23);
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(24,'(가) 근육, 결합조직 등 신체조직의 구성성분<br/>(나) 효소, 호르몬, 항체의 구성에 필요<br/>(다) 체내 필수 영양성분이나 활성물질의 운반과 저장에 필요<br/>(라) 체액, 산-염기의 균형 유지에 필요<br/>(마) 에너지, 포도당, 지질의 합성에 필요','단백질로서 12.0 g 이상','특정 단백질에 알레르기를 나타내는 경우에는 섭취 주의',24);
insert into ingredientContent (seq,functionalContent,dailyIntake,precautionsForIngestion,ingredient_seq) VALUES(25,'준비중','준비중','준비중',25);

select * from ingredientContent;

commit;

select * from member;
INSERT INTO member (username,email,password,name,nickname, dob, gender, telephone, status) 
VALUES ('hong', 'hong@test.com','1111','hong','hong','2000-01-01','m','01012345678',1);
INSERT INTO member (username,email,password,name,nickname, dob, gender, telephone, status) 
VALUES ('dog', 'dog@test.com','1111','dog','dog','2000-01-01','m','01012345678',1);
INSERT INTO member (username,email,password,name,nickname, dob, gender, telephone, status, address) 
VALUES ('test', 'test@test.com','1111','test','test','2000-01-01','m','01012345678',1, '여기저기');


select * from vwDailyRecommend;
select * from ingredientDaily;

select * from admin;
select * from adminAuth;
select * from adminAuthList;

-- admin 
INSERT INTO admin (seq, id, pw, name, birthDate, email) 
VALUES (1, 'hong', '1111','hong', '2000-01-01', 'hong@test.com');

INSERT INTO adminAuth (seq, role) 
VALUES (1, 'admin');

INSERT INTO adminAuthList (admin_seq, adminAuth_seq) 
VALUES (1, 1);

UPDATE admin SET pw = '$2a$10$MD6NGN6LcVQcthSf3o.oV.f47Bn6K2MDnoRtIFyKeuZ0pVlDGiGje' where seq = 1;
select * from admin;

INSERT INTO member (username,email,password,name,nickname,dob,gender,telephone,status,address) 
VALUES
('user01', 'user01@test.com', '1111', 'User One', 'uone', '1995-03-15', 'm', '01010123456', 1, '서울시 강남구'),
('user02', 'user02@test.com', '1111', 'User Two', 'utwo', '1996-06-18', 'f', '01020234567', 1, '서울시 송파구'),
('user03', 'user03@test.com', '1111', 'User Three', 'uthree', '1997-02-22', 'm', '01030345678', 1, '경기도 수원시'),
('user04', 'user04@test.com', '1111', 'User Four', 'ufour', '1998-08-11', 'f', '01040456789', 1, '서울시 강서구'),
('user05', 'user05@test.com', '1111', 'User Five', 'ufive', '1999-05-25', 'm', '01050567890', 1, '경기도 성남시'),
('user06', 'user06@test.com', '1111', 'User Six', 'usix', '2000-04-12', 'f', '01060678901', 1, '서울시 도봉구'),
('user07', 'user07@test.com', '1111', 'User Seven', 'useven', '2001-12-01', 'm', '01070789012', 1, '경기도 용인시'),
('user08', 'user08@test.com', '1111', 'User Eight', 'ueight', '2002-11-30', 'f', '01080890123', 1, '서울시 마포구'),
('user09', 'user09@test.com', '1111', 'User Nine', 'unine', '2003-07-21', 'm', '01090901234', 1, '경기도 고양시'),
('user10', 'user10@test.com', '1111', 'User Ten', 'uten', '2004-01-10', 'f', '01010112345', 1, '서울시 강북구'),
('user11', 'user11@test.com', '1111', 'User Eleven', 'ueleven', '1995-03-15', 'm', '01011123456', 1, '서울시 관악구'),
('user12', 'user12@test.com', '1111', 'User Twelve', 'utwelve', '1996-06-18', 'f', '01012234567', 1, '경기도 안양시'),
('user13', 'user13@test.com', '1111', 'User Thirteen', 'uthirteen', '1997-02-22', 'm', '01013345678', 1, '서울시 동대문구'),
('user14', 'user14@test.com', '1111', 'User Fourteen', 'ufourteen', '1998-08-11', 'f', '01014456789', 1, '경기도 평택시'),
('user15', 'user15@test.com', '1111', 'User Fifteen', 'ufifteen', '1999-05-25', 'm', '01015567890', 1, '서울시 은평구'),
('user16', 'user16@test.com', '1111', 'User Sixteen', 'usixteen', '2000-04-12', 'f', '01016678901', 1, '경기도 화성시'),
('user17', 'user17@test.com', '1111', 'User Seventeen', 'useventeen', '2001-12-01', 'm', '01017789012', 1, '서울시 성동구'),
('user18', 'user18@test.com', '1111', 'User Eighteen', 'ueighteen', '2002-11-30', 'f', '01018890123', 1, '경기도 부천시'),
('user19', 'user19@test.com', '1111', 'User Nineteen', 'unineteen', '2003-07-21', 'm', '01019901234', 1, '서울시 송파구'),
('user20', 'user20@test.com', '1111', 'User Twenty', 'utwenty', '2004-01-10', 'f', '01020112345', 1, '경기도 하남시'),
('user21', 'user21@test.com', '1111', 'User Twenty One', 'utwentyone', '1995-04-25', 'm', '01021123456', 1, '서울시 용산구'),
('user22', 'user22@test.com', '1111', 'User Twenty Two', 'utwotwo', '1996-07-18', 'f', '01022234567', 1, '서울시 구로구'),
('user23', 'user23@test.com', '1111', 'User Twenty Three', 'utwothree', '1997-01-22', 'm', '01023345678', 1, '경기도 김포시'),
('user24', 'user24@test.com', '1111', 'User Twenty Four', 'utwotfour', '1998-09-15', 'f', '01024456789', 1, '서울시 서대문구'),
('user25', 'user25@test.com', '1111', 'User Twenty Five', 'utwotfive', '1999-03-12', 'm', '01025567890', 1, '경기도 안산시'),
('user26', 'user26@test.com', '1111', 'User Twenty Six', 'utwotsix', '2000-02-10', 'f', '01026678901', 1, '서울시 성북구'),
('user27', 'user27@test.com', '1111', 'User Twenty Seven', 'utwoseven', '2001-06-30', 'm', '01027789012', 1, '경기도 광명시'),
('user28', 'user28@test.com', '1111', 'User Twenty Eight', 'utwoteight', '2002-05-20', 'f', '01028890123', 1, '서울시 동작구'),
('user29', 'user29@test.com', '1111', 'User Twenty Nine', 'utwonine', '2003-04-12', 'm', '01029901234', 1, '경기도 평택시'),
('user30', 'user30@test.com', '1111', 'User Thirty', 'uthirty', '2004-08-01', 'f', '01030112345', 1, '서울시 영등포구'),
('user31', 'user31@test.com', '1111', 'User Thirty One', 'uthirtyone', '1995-05-05', 'm', '01031123456', 1, '서울시 마포구'),
('user32', 'user32@test.com', '1111', 'User Thirty Two', 'uthirtytwo', '1996-09-09', 'f', '01032234567', 1, '서울시 강북구'),
('user33', 'user33@test.com', '1111', 'User Thirty Three', 'uthirtythree', '1997-10-14', 'm', '01033345678', 1, '경기도 시흥시'),
('user34', 'user34@test.com', '1111', 'User Thirty Four', 'uthirtyfour', '1998-11-19', 'f', '01034456789', 1, '서울시 성동구'),
('user35', 'user35@test.com', '1111', 'User Thirty Five', 'uthirtyfive', '1999-01-22', 'm', '01035567890', 1, '경기도 의정부시'),
('user36', 'user36@test.com', '1111', 'User Thirty Six', 'uthirtysix', '2000-03-01', 'f', '01036678901', 1, '서울시 강동구'),
('user37', 'user37@test.com', '1111', 'User Thirty Seven', 'uthirtyseven', '2001-07-05', 'm', '01037789012', 1, '경기도 이천시'),
('user38', 'user38@test.com', '1111', 'User Thirty Eight', 'uthirtyeight', '2002-10-18', 'f', '01038890123', 1, '서울시 서초구'),
('user39', 'user39@test.com', '1111', 'User Thirty Nine', 'uthirtynine', '2003-12-25', 'm', '01039901234', 1, '경기도 광주'),
('user40', 'user40@test.com', '1111', 'User Forty', 'uforty', '2004-07-07', 'f', '01040112345', 1, '서울시 종로구'),
('user41', 'user41@test.com', '1111', 'User Forty One', 'ufortyone', '1995-08-14', 'm', '01041123456', 1, '서울시 강남구'),
('user42', 'user42@test.com', '1111', 'User Forty Two', 'ufortytwo', '1996-12-11', 'f', '01042234567', 1, '서울시 중구'),
('user43', 'user43@test.com', '1111', 'User Forty Three', 'ufortythree', '1997-02-08', 'm', '01043345678', 1, '경기도 남양주시'),
('user44', 'user44@test.com', '1111', 'User Forty Four', 'ufortyfour', '1998-07-30', 'f', '01044456789', 1, '서울시 용산구'),
('user45', 'user45@test.com', '1111', 'User Forty Five', 'ufortyfive', '1999-11-15', 'm', '01045567890', 1, '경기도 고양시'),
('user46', 'user46@test.com', '1111', 'User Forty Six', 'ufortysix', '2000-12-25', 'f', '01046678901', 1, '서울시 구로구'),
('user47', 'user47@test.com', '1111', 'User Forty Seven', 'ufortyseven', '2001-09-18', 'm', '01047789012', 1, '경기도 용인시'),
('user48', 'user48@test.com', '1111', 'User Forty Eight', 'ufortyeight', '2002-05-21', 'f', '01048890123', 1, '서울시 마포구'),
('user49', 'user49@test.com', '1111', 'User Forty Nine', 'ufortynine', '2003-08-06', 'm', '01049901234', 1, '경기도 수원시'),
('user50', 'user50@test.com', '1111', 'User Fifty', 'ufifty', '2004-01-12', 'f', '01050112345', 1, '서울시 강서구')
;

select * from question;
select * from answer;

update question set isSolved = true where seq between 21 and 34;

-- 질문 1
INSERT INTO question (member_seq, title, content)
VALUES (1, '어떤 영양제가 좋나요?', '간에 좋은 영양제를 추천해주세요.');

-- 질문 2
INSERT INTO question (member_seq, title, content)
VALUES (2, '피부에 좋은 영양제는 무엇인가요?', '피부 건강을 위한 영양제를 추천해주세요.');

-- 질문 3
INSERT INTO question (member_seq, title, content)
VALUES (3, '어떤 영양제가 눈에 좋나요?', '눈 건강을 위한 영양제를 추천해주세요.');

-- 질문 4
INSERT INTO question (member_seq, title, content)
VALUES (4, '어떤 영양제가 체중 감소에 도움이 되나요?', '체중 감소를 돕는 영양제를 추천해주세요.');

-- 질문 5
INSERT INTO question (member_seq, title, content)
VALUES (5, '어떤 영양제가 혈액순환에 좋나요?', '혈액순환을 돕는 영양제를 추천해주세요.');

-- 질문 6
INSERT INTO question (member_seq, title, content)
VALUES (6, '어떤 영양제가 면역력에 좋나요?', '면역력 강화를 위한 영양제를 추천해주세요.');

-- 질문 7
INSERT INTO question (member_seq, title, content)
VALUES (7, '어떤 영양제가 뼈 건강에 좋나요?', '뼈 건강을 위한 영양제를 추천해주세요.');

-- 질문 8
INSERT INTO question (member_seq, title, content)
VALUES (8, '어떤 영양제가 스트레스 해소에 좋나요?', '스트레스 해소에 좋은 영양제를 추천해주세요.');

-- 질문 9
INSERT INTO question (member_seq, title, content)
VALUES (9, '어떤 영양제가 혈압 조절에 좋나요?', '혈압을 조절하는 영양제를 추천해주세요.');

-- 질문 10
INSERT INTO question (member_seq, title, content)
VALUES (10, '어떤 영양제가 혈당 조절에 좋나요?', '혈당 조절에 좋은 영양제를 추천해주세요.');

-- 질문 11
INSERT INTO question (member_seq, title, content)
VALUES (11, '어떤 영양제가 심장 건강에 좋나요?', '심장 건강을 위한 영양제를 추천해주세요.');

-- 질문 12
INSERT INTO question (member_seq, title, content)
VALUES (12, '어떤 영양제가 위장 건강에 좋나요?', '위장 건강을 위한 영양제를 추천해주세요.');

-- 질문 13
INSERT INTO question (member_seq, title, content)
VALUES (13, '어떤 영양제가 두뇌 건강에 좋나요?', '두뇌 건강을 위한 영양제를 추천해주세요.');

-- 질문 14
INSERT INTO question (member_seq, title, content)
VALUES (14, '어떤 영양제가 소화에 도움이 되나요?', '소화를 돕는 영양제를 추천해주세요.');

-- 질문 15
INSERT INTO question (member_seq, title, content)
VALUES (15, '어떤 영양제가 숙면에 도움이 되나요?', '숙면을 돕는 영양제를 추천해주세요.');

-- 질문 16
INSERT INTO question (member_seq, title, content)
VALUES (16, '어떤 영양제가 체내 해독에 좋나요?', '체내 해독을 위한 영양제를 추천해주세요.');

-- 질문 17
INSERT INTO question (member_seq, title, content)
VALUES (17, '어떤 영양제가 당뇨 예방에 좋나요?', '당뇨 예방을 위한 영양제를 추천해주세요.');

-- 질문 18
INSERT INTO question (member_seq, title, content)
VALUES (18, '어떤 영양제가 피부 미백에 좋나요?', '피부 미백을 위한 영양제를 추천해주세요.');
 
-- 질문 19
INSERT INTO question (member_seq, title, content)
VALUES (19, '어떤 영양제가 노화 방지에 좋나요?', '노화 방지를 위한 영양제를 추천해주세요.');

-- 질문 20
INSERT INTO question (member_seq, title, content)
VALUES (20, '어떤 영양제가 체내 염증을 줄이는데 좋나요?', '체내 염증을 줄이는 영양제를 추천해주세요.');

-- 질문 21
INSERT INTO question (member_seq, title, content)
VALUES (21, '어떤 영양제가 근육 강화에 좋나요?', '근육 강화를 위한 영양제를 추천해주세요.');

-- 질문 22
INSERT INTO question (member_seq, title, content)
VALUES (22, '어떤 영양제가 심리적 안정에 좋나요?', '심리적 안정을 위한 영양제를 추천해주세요.');

-- 질문 23
INSERT INTO question (member_seq, title, content)
VALUES (23, '어떤 영양제가 피로 회복에 좋나요?', '피로 회복을 위한 영양제를 추천해주세요.');

-- 질문 24
INSERT INTO question (member_seq, title, content)
VALUES (24, '어떤 영양제가 장 건강에 좋나요?', '장 건강을 위한 영양제를 추천해주세요.');

-- 질문 25
INSERT INTO question (member_seq, title, content)
VALUES (25, '어떤 영양제가 피부 탄력에 좋나요?', '피부 탄력을 위한 영양제를 추천해주세요.');

-- 질문 26
INSERT INTO question (member_seq, title, content)
VALUES (26, '어떤 영양제가 고혈압에 좋나요?', '고혈압을 조절하는 영양제를 추천해주세요.');

-- 질문 27
INSERT INTO question (member_seq, title, content)
VALUES (27, '어떤 영양제가 자외선 차단에 좋나요?', '자외선 차단에 도움이 되는 영양제를 추천해주세요.');

-- 질문 28
INSERT INTO question (member_seq, title, content)
VALUES (28, '어떤 영양제가 신진대사에 좋나요?', '신진대사를 촉진하는 영양제를 추천해주세요.');

-- 질문 29
INSERT INTO question (member_seq, title, content)
VALUES (29, '어떤 영양제가 관절 건강에 좋나요?', '관절 건강을 위한 영양제를 추천해주세요.');

-- 질문 30
INSERT INTO question (member_seq, title, content)
VALUES (30, '어떤 영양제가 콜레스테롤 수치를 낮추는데 좋나요?', '콜레스테롤 수치를 낮추는 영양제를 추천해주세요.');

-- 질문 31
INSERT INTO question (member_seq, title, content)
VALUES (31, '어떤 영양제가 항산화 작용에 좋나요?', '항산화 작용을 돕는 영양제를 추천해주세요.');

-- 질문 32
INSERT INTO question (member_seq, title, content)
VALUES (32, '어떤 영양제가 간 기능에 좋나요?', '간 기능을 돕는 영양제를 추천해주세요.');

-- 질문 33
INSERT INTO question (member_seq, title, content)
VALUES (33, '어떤 영양제가 혈액 건강에 좋나요?', '혈액 건강을 위한 영양제를 추천해주세요.');

-- 질문 34
INSERT INTO question (member_seq, title, content)
VALUES (34, '어떤 영양제가 대사 증후군 예방에 좋나요?', '대사 증후군 예방을 위한 영양제를 추천해주세요.');

-- 질문 35
INSERT INTO question (member_seq, title, content)
VALUES (35, '어떤 영양제가 비타민 C가 많이 들어있나요?', '비타민 C가 많이 들어 있는 영양제를 추천해주세요.');

-- 질문 36
INSERT INTO question (member_seq, title, content)
VALUES (36, '어떤 영양제가 칼슘 흡수에 좋나요?', '칼슘 흡수를 돕는 영양제를 추천해주세요.');

-- 질문 37
INSERT INTO question (member_seq, title, content)
VALUES (37, '어떤 영양제가 체내 산성화 완화에 좋나요?', '체내 산성화 완화를 위한 영양제를 추천해주세요.');

-- 질문 38
INSERT INTO question (member_seq, title, content)
VALUES (38, '어떤 영양제가 체중 증가에 좋나요?', '체중 증가를 돕는 영양제를 추천해주세요.');

-- 질문 39
INSERT INTO question (member_seq, title, content)
VALUES (39, '어떤 영양제가 불면증에 좋나요?', '불면증을 치료하는 영양제를 추천해주세요.');

-- 질문 40
INSERT INTO question (member_seq, title, content)
VALUES (40, '어떤 영양제가 정자 건강에 좋나요?', '정자 건강을 위한 영양제를 추천해주세요.');

-- 질문 41
INSERT INTO question (member_seq, title, content)
VALUES (41, '어떤 영양제가 장기 건강에 좋나요?', '장기 건강을 위한 영양제를 추천해주세요.');

-- 질문 42
INSERT INTO question (member_seq, title, content)
VALUES (42, '어떤 영양제가 눈 건강을 개선하나요?', '눈 건강을 개선하는 영양제를 추천해주세요.');

-- 질문 43
INSERT INTO question (member_seq, title, content)
VALUES (43, '어떤 영양제가 호흡기 건강에 좋나요?', '호흡기 건강을 위한 영양제를 추천해주세요.');

-- 질문 44
INSERT INTO question (member_seq, title, content)
VALUES (44, '어떤 영양제가 갑상선 건강에 좋나요?', '갑상선 건강을 위한 영양제를 추천해주세요.');

-- 질문 45
INSERT INTO question (member_seq, title, content)
VALUES (45, '어떤 영양제가 탈모에 좋나요?', '탈모 예방을 위한 영양제를 추천해주세요.');

-- 질문 46
INSERT INTO question (member_seq, title, content)
VALUES (46, '어떤 영양제가 고콜레스테롤에 좋나요?', '고콜레스테롤을 낮추는 영양제를 추천해주세요.');

-- 질문 47
INSERT INTO question (member_seq, title, content)
VALUES (47, '어떤 영양제가 기억력 향상에 좋나요?', '기억력 향상을 위한 영양제를 추천해주세요.');

-- 질문 48
INSERT INTO question (member_seq, title, content)
VALUES (48, '어떤 영양제가 여성 건강에 좋나요?', '여성 건강을 위한 영양제를 추천해주세요.');

-- 질문 49
INSERT INTO question (member_seq, title, content)
VALUES (49, '어떤 영양제가 남성 건강에 좋나요?', '남성 건강을 위한 영양제를 추천해주세요.');

-- 질문 50
INSERT INTO question (member_seq, title, content)
VALUES (50, '어떤 영양제가 심리적 웰빙에 좋나요?', '심리적 웰빙을 위한 영양제를 추천해주세요.');

-- 질문 51
INSERT INTO question (member_seq, title, content)
VALUES (1, '어떤 영양제가 간에 좋나요?', '간 건강을 위한 영양제를 추천해주세요.');

-- 질문 52
INSERT INTO question (member_seq, title, content)
VALUES (2, '어떤 영양제가 피부 건강에 좋나요?', '피부 건강을 위한 영양제를 추천해주세요.');

-- 질문 53
INSERT INTO question (member_seq, title, content)
VALUES (3, '어떤 영양제가 눈 피로에 좋나요?', '눈 피로를 완화하는 영양제를 추천해주세요.');

-- 질문 54
INSERT INTO question (member_seq, title, content)
VALUES (4, '어떤 영양제가 체중 감량에 좋나요?', '체중 감량을 돕는 영양제를 추천해주세요.');

-- 질문 55
INSERT INTO question (member_seq, title, content)
VALUES (5, '어떤 영양제가 혈액순환에 도움이 되나요?', '혈액순환을 돕는 영양제를 추천해주세요.');

-- 질문 56
INSERT INTO question (member_seq, title, content)
VALUES (6, '어떤 영양제가 면역력을 높여주나요?', '면역력 강화를 위한 영양제를 추천해주세요.');

-- 질문 57
INSERT INTO question (member_seq, title, content)
VALUES (7, '어떤 영양제가 뼈 건강에 도움이 되나요?', '뼈 건강을 위한 영양제를 추천해주세요.');

-- 질문 58
INSERT INTO question (member_seq, title, content)
VALUES (8, '어떤 영양제가 스트레스 관리에 좋나요?', '스트레스 관리를 돕는 영양제를 추천해주세요.');

-- 질문 59
INSERT INTO question (member_seq, title, content)
VALUES (9, '어떤 영양제가 혈압 조절에 효과적인가요?', '혈압을 조절하는 영양제를 추천해주세요.');

-- 질문 60
INSERT INTO question (member_seq, title, content)
VALUES (10, '어떤 영양제가 혈당을 조절하는 데 좋나요?', '혈당 조절에 좋은 영양제를 추천해주세요.');

-- 질문 61
INSERT INTO question (member_seq, title, content)
VALUES (11, '어떤 영양제가 심장 건강에 도움이 되나요?', '심장 건강을 위한 영양제를 추천해주세요.');

-- 질문 62
INSERT INTO question (member_seq, title, content)
VALUES (12, '어떤 영양제가 위 건강에 좋나요?', '위 건강을 위한 영양제를 추천해주세요.');

-- 질문 63
INSERT INTO question (member_seq, title, content)
VALUES (13, '어떤 영양제가 뇌 건강에 좋나요?', '뇌 건강을 위한 영양제를 추천해주세요.');

-- 질문 64
INSERT INTO question (member_seq, title, content)
VALUES (14, '어떤 영양제가 소화 건강에 좋나요?', '소화 건강을 위한 영양제를 추천해주세요.');

-- 질문 65
INSERT INTO question (member_seq, title, content)
VALUES (15, '어떤 영양제가 숙면에 도움이 되나요?', '숙면을 돕는 영양제를 추천해주세요.');

-- 질문 66
INSERT INTO question (member_seq, title, content)
VALUES (16, '어떤 영양제가 해독에 좋은가요?', '체내 해독을 위한 영양제를 추천해주세요.');

-- 질문 67
INSERT INTO question (member_seq, title, content)
VALUES (17, '어떤 영양제가 당뇨 예방에 좋나요?', '당뇨 예방을 위한 영양제를 추천해주세요.');

-- 질문 68
INSERT INTO question (member_seq, title, content)
VALUES (18, '어떤 영양제가 피부 미백에 좋나요?', '피부 미백을 위한 영양제를 추천해주세요.');

-- 질문 69
INSERT INTO question (member_seq, title, content)
VALUES (19, '어떤 영양제가 노화 방지에 좋나요?', '노화 방지를 위한 영양제를 추천해주세요.');

-- 질문 70
INSERT INTO question (member_seq, title, content)
VALUES (20, '어떤 영양제가 염증을 줄여줄까요?', '체내 염증을 줄이는 영양제를 추천해주세요.');

-- 질문 71
INSERT INTO question (member_seq, title, content)
VALUES (1, '체중 감소에 도움이 되는 영양제는?', '체중 감소에 도움이 되는 영양제를 추천해주세요.');

-- 질문 72
INSERT INTO question (member_seq, title, content)
VALUES (2, '피부 건강을 위한 영양제는?', '피부 건강에 좋은 영양제를 추천해주세요.');

-- 질문 73
INSERT INTO question (member_seq, title, content)
VALUES (3, '눈 건강을 위한 영양제는?', '눈 건강에 좋은 영양제를 추천해주세요.');

-- 질문 74
INSERT INTO question (member_seq, title, content)
VALUES (4, '혈액순환에 좋은 영양제는?', '혈액순환에 도움이 되는 영양제를 추천해주세요.');

-- 질문 75
INSERT INTO question (member_seq, title, content)
VALUES (5, '면역력 강화에 좋은 영양제는?', '면역력 강화를 위한 영양제를 추천해주세요.');

-- 질문 76
INSERT INTO question (member_seq, title, content)
VALUES (6, '뼈 건강을 위한 영양제는?', '뼈 건강에 좋은 영양제를 추천해주세요.');

-- 질문 77
INSERT INTO question (member_seq, title, content)
VALUES (7, '스트레스 해소에 좋은 영양제는?', '스트레스 해소에 도움이 되는 영양제를 추천해주세요.');

-- 질문 78
INSERT INTO question (member_seq, title, content)
VALUES (8, '체중 감소에 도움이 되는 비타민은?', '체중 감소에 도움이 되는 비타민을 추천해주세요.');

-- 질문 79
INSERT INTO question (member_seq, title, content)
VALUES (9, '피부 탄력에 좋은 영양제는?', '피부 탄력을 돕는 영양제를 추천해주세요.');

-- 질문 80
INSERT INTO question (member_seq, title, content)
VALUES (10, '뼈와 관절 건강에 좋은 영양제는?', '뼈와 관절 건강을 위한 영양제를 추천해주세요.');

-- 질문 81
INSERT INTO question (member_seq, title, content)
VALUES (11, '소화에 좋은 영양제는?', '소화를 돕는 영양제를 추천해주세요.');

-- 질문 82
INSERT INTO question (member_seq, title, content)
VALUES (12, '피로 회복에 좋은 영양제는?', '피로 회복에 도움이 되는 영양제를 추천해주세요.');

-- 질문 83
INSERT INTO question (member_seq, title, content)
VALUES (13, '눈 건강을 위한 비타민은?', '눈 건강에 좋은 비타민을 추천해주세요.');

-- 질문 84
INSERT INTO question (member_seq, title, content)
VALUES (14, '다이어트를 위한 영양제는?', '다이어트에 도움이 되는 영양제를 추천해주세요.');

-- 질문 85
INSERT INTO question (member_seq, title, content)
VALUES (15, '면역력 강화에 효과적인 비타민은?', '면역력 강화를 위한 비타민을 추천해주세요.');

-- 질문 86
INSERT INTO question (member_seq, title, content)
VALUES (16, '피부 노화 방지에 좋은 영양제는?', '피부 노화 방지에 도움이 되는 영양제를 추천해주세요.');

-- 질문 87
INSERT INTO question (member_seq, title, content)
VALUES (17, '혈당 조절에 좋은 영양제는?', '혈당 조절을 돕는 영양제를 추천해주세요.');

-- 질문 88
INSERT INTO question (member_seq, title, content)
VALUES (18, '근육 건강에 좋은 영양제는?', '근육 건강을 위한 영양제를 추천해주세요.');

-- 질문 89
INSERT INTO question (member_seq, title, content)
VALUES (19, '소화 건강에 좋은 비타민은?', '소화에 좋은 비타민을 추천해주세요.');

-- 질문 90
INSERT INTO question (member_seq, title, content)
VALUES (20, '피부 회복에 좋은 영양제는?', '피부 회복을 돕는 영양제를 추천해주세요.');

-- 질문 91
INSERT INTO question (member_seq, title, content)
VALUES (21, '체중 감량에 도움이 되는 식이섬유는?', '체중 감량을 돕는 식이섬유를 추천해주세요.');

-- 질문 92
INSERT INTO question (member_seq, title, content)
VALUES (22, '머리카락 건강을 위한 영양제는?', '머리카락 건강에 좋은 영양제를 추천해주세요.');

-- 질문 93
INSERT INTO question (member_seq, title, content)
VALUES (23, '스트레스 완화에 좋은 비타민은?', '스트레스 완화에 도움이 되는 비타민을 추천해주세요.');

-- 질문 94
INSERT INTO question (member_seq, title, content)
VALUES (24, '혈액순환에 좋은 음식과 영양제는?', '혈액순환을 돕는 음식과 영양제를 추천해주세요.');

-- 질문 95
INSERT INTO question (member_seq, title, content)
VALUES (25, '체중 감량을 위한 운동과 영양제는?', '체중 감량을 돕는 운동과 영양제를 추천해주세요.');

-- 질문 96
INSERT INTO question (member_seq, title, content)
VALUES (26, '눈 건강을 위한 영양소는?', '눈 건강에 좋은 영양소를 추천해주세요.');

-- 질문 97
INSERT INTO question (member_seq, title, content)
VALUES (27, '피부 수분 보충에 좋은 영양제는?', '피부 수분 보충에 도움이 되는 영양제를 추천해주세요.');

-- 질문 98
INSERT INTO question (member_seq, title, content)
VALUES (28, '체중 감소를 위한 식이 보충제는?', '체중 감소를 위한 식이 보충제를 추천해주세요.');

-- 질문 99
INSERT INTO question (member_seq, title, content)
VALUES (29, '근육 강화를 위한 영양제는?', '근육 강화를 위한 영양제를 추천해주세요.');

-- 질문 100
INSERT INTO question (member_seq, title, content)
VALUES (30, '심장 건강에 좋은 영양제는?', '심장 건강을 위한 영양제를 추천해주세요.');

select * from question;

---------------

-- 답변 1
INSERT INTO answer (member_seq, question_seq, content)
VALUES (2, 1, '밀크씨슬이 간에 좋습니다. 간 기능을 돕습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (1, 1, '오메가-3도 간에 좋습니다. 염증 감소에 효과적입니다.');

-- 답변 2
INSERT INTO answer (member_seq, question_seq, content)
VALUES (1, 2, '비타민 C가 피부에 좋습니다. 항산화 작용이 뛰어나죠.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (2, 2, '콜라겐이 피부에 좋습니다. 피부 탄력을 도와줍니다.');

-- 답변 3
INSERT INTO answer (member_seq, question_seq, content)
VALUES (1, 3, '루테인이 눈에 좋습니다. 시력 보호에 도움을 줍니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (3, 3, '아스타잔틴도 좋습니다. 눈의 피로를 덜어줍니다.');

-- 답변 4
INSERT INTO answer (member_seq, question_seq, content)
VALUES (4, 4, '녹차 추출물이 체중 감소에 도움이 됩니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (2, 4, 'CLA가 체지방 감소에 좋습니다. 다이어트에 도움이 됩니다.');

-- 답변 5
INSERT INTO answer (member_seq, question_seq, content)
VALUES (1, 5, '홍삼이 혈액순환에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (5, 5, '마그네슘도 혈액순환에 도움이 됩니다.');

-- 답변 6
INSERT INTO answer (member_seq, question_seq, content)
VALUES (3, 6, '비타민 D가 면역력 강화에 효과적입니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (2, 6, '아연도 면역력 증진에 도움이 됩니다.');

-- 답변 7
INSERT INTO answer (member_seq, question_seq, content)
VALUES (1, 7, '칼슘이 뼈 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (7, 7, '비타민 D3가 뼈에 좋습니다.');

-- 답변 8
INSERT INTO answer (member_seq, question_seq, content)
VALUES (9, 8, '마그네슘이 스트레스 해소에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (8, 8, 'L-테아닌이 스트레스 완화에 효과적입니다.');

-- 답변 9
INSERT INTO answer (member_seq, question_seq, content)
VALUES (2, 9, '프로바이오틱스가 소화에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (10, 9, '식이섬유가 소화에 도움을 줍니다.');

-- 답변 10
INSERT INTO answer (member_seq, question_seq, content)
VALUES (5, 10, '계피가 혈당 조절에 도움이 됩니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (10, 10, '알로에가 혈당 관리에 효과적입니다.');

-- 답변 11
INSERT INTO answer (member_seq, question_seq, content)
VALUES (3, 11, '아르기닌이 혈압 조절에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (7, 11, '마그네슘도 혈압 관리에 도움이 됩니다.');

-- 답변 12
INSERT INTO answer (member_seq, question_seq, content)
VALUES (2, 12, '비타민 B군이 피로 회복에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (1, 12, '홍삼이 피로 회복에 효과적입니다.');

-- 답변 13
INSERT INTO answer (member_seq, question_seq, content)
VALUES (4, 13, '프로바이오틱스가 장 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (2, 13, '식이섬유가 장 기능을 돕습니다.');

-- 답변 14
INSERT INTO answer (member_seq, question_seq, content)
VALUES (5, 14, '비타민 E가 피부 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (7, 14, '콜라겐이 피부 재생을 돕습니다.');

-- 답변 15
INSERT INTO answer (member_seq, question_seq, content)
VALUES (1, 15, '마그네슘이 스트레스 해소에 도움이 됩니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (10, 15, 'L-테아닌도 스트레스 감소에 효과적입니다.');

-- 답변 16
INSERT INTO answer (member_seq, question_seq, content)
VALUES (6, 16, '비타민 A가 눈 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (3, 16, '루테인도 눈 건강에 중요한 역할을 합니다.');

-- 답변 17
INSERT INTO answer (member_seq, question_seq, content)
VALUES (4, 17, '아르기닌이 혈액순환에 도움이 됩니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (8, 17, '홍삼도 혈액순환에 효과적입니다.');

-- 답변 18
INSERT INTO answer (member_seq, question_seq, content)
VALUES (2, 18, '비타민 B12가 에너지 증진에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (1, 18, '홍삼이 에너지를 보충해줍니다.');

-- 답변 19
INSERT INTO answer (member_seq, question_seq, content)
VALUES (6, 19, '비타민 D가 면역력에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (10, 19, '아연도 면역력 강화를 돕습니다.');

-- 답변 20
INSERT INTO answer (member_seq, question_seq, content)
VALUES (5, 20, '칼슘이 뼈 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (3, 20, '비타민 D3가 뼈에 중요한 역할을 합니다.');

-- 답변 21
INSERT INTO answer (member_seq, question_seq, content)
VALUES (4, 21, '비타민 C가 피부 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (7, 21, '콜라겐이 피부 탄력에 좋습니다.');

-- 답변 22
INSERT INTO answer (member_seq, question_seq, content)
VALUES (8, 22, '마그네슘이 스트레스 해소에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (9, 22, 'L-테아닌도 스트레스 완화에 효과적입니다.');

-- 답변 23
INSERT INTO answer (member_seq, question_seq, content)
VALUES (2, 23, '홍삼이 면역력 강화에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (6, 23, '비타민 C가 면역력 증진에 효과적입니다.');

-- 답변 24
INSERT INTO answer (member_seq, question_seq, content)
VALUES (1, 24, '루테인이 눈 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (7, 24, '아스타잔틴이 눈 피로 해소에 좋습니다.');

-- 답변 25
INSERT INTO answer (member_seq, question_seq, content)
VALUES (4, 25, '비타민 D가 면역력 강화에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (3, 25, '아연이 면역력 증진에 도움이 됩니다.');

-- 답변 26
INSERT INTO answer (member_seq, question_seq, content)
VALUES (10, 26, '프로바이오틱스가 소화에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (8, 26, '식이섬유가 소화에 도움을 줍니다.');

-- 답변 27
INSERT INTO answer (member_seq, question_seq, content)
VALUES (6, 27, '비타민 E가 피부 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (4, 27, '콜라겐이 피부 재생에 도움을 줍니다.');

-- 답변 28
INSERT INTO answer (member_seq, question_seq, content)
VALUES (5, 28, '홍삼이 에너지 증진에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (2, 28, '비타민 B군이 에너지 증진에 효과적입니다.');

-- 답변 29
INSERT INTO answer (member_seq, question_seq, content)
VALUES (9, 29, '루테인이 눈 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (10, 29, '아스타잔틴이 시력 보호에 좋습니다.');

-- 답변 30
INSERT INTO answer (member_seq, question_seq, content)
VALUES (6, 30, '비타민 C가 피부에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (5, 30, '콜라겐이 피부 탄력을 도와줍니다.');

-- 답변 31
INSERT INTO answer (member_seq, question_seq, content)
VALUES (1, 31, '계피가 혈당 조절에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (2, 31, '알로에가 혈당 관리에 효과적입니다.');

-- 답변 32
INSERT INTO answer (member_seq, question_seq, content)
VALUES (4, 32, '홍삼이 혈액순환에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (7, 32, '마그네슘도 혈액순환에 도움이 됩니다.');

-- 답변 33
INSERT INTO answer (member_seq, question_seq, content)
VALUES (3, 33, '비타민 D가 면역력 강화에 효과적입니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (6, 33, '아연이 면역력 증진에 도움이 됩니다.');

-- 답변 34
INSERT INTO answer (member_seq, question_seq, content)
VALUES (1, 34, '루테인이 눈 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (7, 34, '아스타잔틴이 눈 피로를 덜어줍니다.');

-- 답변 35
INSERT INTO answer (member_seq, question_seq, content)
VALUES (5, 35, '비타민 E가 피부에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (10, 35, '콜라겐이 피부 탄력에 좋습니다.');

-- 답변 36
INSERT INTO answer (member_seq, question_seq, content)
VALUES (2, 36, '홍삼이 피로 회복에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (6, 36, '비타민 B군이 피로 회복에 효과적입니다.');

-- 답변 37
INSERT INTO answer (member_seq, question_seq, content)
VALUES (3, 37, '프로바이오틱스가 소화에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (7, 37, '식이섬유가 소화에 도움을 줍니다.');

-- 답변 38
INSERT INTO answer (member_seq, question_seq, content)
VALUES (4, 38, '비타민 D가 면역력에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (10, 38, '아연이 면역력 증진에 도움이 됩니다.');

-- 답변 39
INSERT INTO answer (member_seq, question_seq, content)
VALUES (1, 39, '칼슘이 뼈 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (7, 39, '비타민 D3가 뼈에 좋습니다.');

-- 답변 40
INSERT INTO answer (member_seq, question_seq, content)
VALUES (2, 40, '마그네슘이 스트레스 해소에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (9, 40, 'L-테아닌이 스트레스 완화에 효과적입니다.');

-- 답변 41
INSERT INTO answer (member_seq, question_seq, content)
VALUES (10, 41, '비타민 C가 피부 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (5, 41, '콜라겐이 피부 탄력을 도와줍니다.');

-- 답변 42
INSERT INTO answer (member_seq, question_seq, content)
VALUES (4, 42, '홍삼이 혈액순환에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (2, 42, '마그네슘도 혈액순환에 효과적입니다.');

-- 답변 43
INSERT INTO answer (member_seq, question_seq, content)
VALUES (9, 43, '프로바이오틱스가 소화에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (7, 43, '식이섬유가 소화에 도움을 줍니다.');

-- 답변 44
INSERT INTO answer (member_seq, question_seq, content)
VALUES (1, 44, '루테인이 눈 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (6, 44, '아스타잔틴이 시력 보호에 좋습니다.');

-- 답변 45
INSERT INTO answer (member_seq, question_seq, content)
VALUES (3, 45, '비타민 D가 면역력 강화에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (4, 45, '아연이 면역력 증진에 도움이 됩니다.');

-- 답변 46
INSERT INTO answer (member_seq, question_seq, content)
VALUES (46, 46, '레시틴이 뇌 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (47, 46, '비타민 B군이 뇌 기능을 향상시킬 수 있습니다.');

-- 답변 47
INSERT INTO answer (member_seq, question_seq, content)
VALUES (48, 47, '비타민 A가 눈에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (49, 47, '베타카로틴이 눈 건강에 도움을 줍니다.');

-- 답변 48
INSERT INTO answer (member_seq, question_seq, content)
VALUES (50, 48, '코엔자임 Q10이 피부에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (1, 48, '비타민 E가 피부에 영양을 줍니다.');

-- 답변 49
INSERT INTO answer (member_seq, question_seq, content)
VALUES (2, 49, '홍삼이 면역력 강화에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (3, 49, '프로폴리스가 면역력을 높이는 데 효과적입니다.');

-- 답변 50
INSERT INTO answer (member_seq, question_seq, content)
VALUES (4, 50, '녹차가 체중 감소에 효과적입니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (5, 50, '커피가 체중 감소를 촉진할 수 있습니다.');

-- 답변 51
INSERT INTO answer (member_seq, question_seq, content)
VALUES (6, 51, '비타민 C가 피부 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (7, 51, '콜라겐이 피부 탄력에 도움을 줍니다.');

-- 답변 52
INSERT INTO answer (member_seq, question_seq, content)
VALUES (8, 52, '칼슘이 뼈 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (9, 52, '비타민 D3가 뼈에 도움이 됩니다.');

-- 답변 53
INSERT INTO answer (member_seq, question_seq, content)
VALUES (10, 53, '마그네슘이 스트레스 완화에 효과적입니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (11, 53, 'L-테아닌이 스트레스를 해소하는 데 도움을 줍니다.');

-- 답변 54
INSERT INTO answer (member_seq, question_seq, content)
VALUES (12, 54, '아스타잔틴이 눈에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (13, 54, '루테인이 눈 건강에 효과적입니다.');

-- 답변 55
INSERT INTO answer (member_seq, question_seq, content)
VALUES (14, 55, '비타민 B12가 체중 감소에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (15, 55, '카르니틴이 체중 감량에 도움이 됩니다.');

-- 답변 56
INSERT INTO answer (member_seq, question_seq, content)
VALUES (16, 56, '홍삼이 피로 회복에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (17, 56, '비타민 C가 피로 회복에 도움이 됩니다.');

-- 답변 57
INSERT INTO answer (member_seq, question_seq, content)
VALUES (18, 57, '비타민 D가 면역력 강화에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (19, 57, '아연이 면역력 증진에 효과적입니다.');

-- 답변 58
INSERT INTO answer (member_seq, question_seq, content)
VALUES (20, 58, '베타-글루칸이 면역력 강화에 도움을 줍니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (21, 58, '비타민 E가 면역력에 좋습니다.');

-- 답변 59
INSERT INTO answer (member_seq, question_seq, content)
VALUES (22, 59, '비타민 D가 뼈 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (23, 59, '칼슘이 뼈 건강에 도움이 됩니다.');

-- 답변 60
INSERT INTO answer (member_seq, question_seq, content)
VALUES (24, 60, '비타민 C가 피부 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (25, 60, '콜라겐이 피부 탄력에 도움을 줍니다.');

-- 답변 61
INSERT INTO answer (member_seq, question_seq, content)
VALUES (26, 61, '프로바이오틱스가 소화에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (27, 61, '식이섬유가 소화에 도움을 줍니다.');

-- 답변 62
INSERT INTO answer (member_seq, question_seq, content)
VALUES (28, 62, '루테인이 눈에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (29, 62, '비타민 A가 눈 건강에 좋습니다.');

-- 답변 63
INSERT INTO answer (member_seq, question_seq, content)
VALUES (30, 63, '아연이 면역력에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (31, 63, '비타민 C가 면역력 증진에 효과적입니다.');

-- 답변 64
INSERT INTO answer (member_seq, question_seq, content)
VALUES (32, 64, '비타민 D가 뼈 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (33, 64, '칼슘이 뼈에 좋습니다.');

-- 답변 65
INSERT INTO answer (member_seq, question_seq, content)
VALUES (34, 65, '홍삼이 피로 회복에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (35, 65, '비타민 B군이 피로 해소에 효과적입니다.');

-- 답변 66
INSERT INTO answer (member_seq, question_seq, content)
VALUES (36, 66, '루테인이 눈 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (37, 66, '비타민 A가 시력 보호에 효과적입니다.');

-- 답변 67
INSERT INTO answer (member_seq, question_seq, content)
VALUES (38, 67, '마그네슘이 스트레스 해소에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (39, 67, 'L-테아닌이 스트레스를 완화합니다.');

-- 답변 68
INSERT INTO answer (member_seq, question_seq, content)
VALUES (40, 68, '베타카로틴이 눈 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (41, 68, '아스타잔틴이 눈에 좋습니다.');

-- 답변 69
INSERT INTO answer (member_seq, question_seq, content)
VALUES (42, 69, 'CLA가 체중 감소에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (43, 69, '녹차가 체중 감소에 도움을 줍니다.');

-- 답변 70
INSERT INTO answer (member_seq, question_seq, content)
VALUES (44, 70, '비타민 D가 면역력 증진에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (45, 70, '아연이 면역력 강화에 도움을 줍니다.');

-- 답변 71
INSERT INTO answer (member_seq, question_seq, content)
VALUES (1, 71, '비타민 A가 눈 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (2, 71, '루테인과 제아잔틴이 시력을 보호하는 데 효과적입니다.');

-- 답변 72
INSERT INTO answer (member_seq, question_seq, content)
VALUES (3, 72, '프로폴리스가 면역력 강화에 도움이 됩니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (4, 72, '홍삼도 면역력에 좋은 효과를 줍니다.');

-- 답변 73
INSERT INTO answer (member_seq, question_seq, content)
VALUES (5, 73, '콜라겐이 피부 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (6, 73, '비타민 C가 피부를 보호하고, 콜라겐 생성을 도와줍니다.');

-- 답변 74
INSERT INTO answer (member_seq, question_seq, content)
VALUES (7, 74, '칼슘과 비타민 D가 뼈 건강에 중요합니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (8, 74, '마그네슘이 뼈를 튼튼하게 만드는 데 도움을 줍니다.');

-- 답변 75
INSERT INTO answer (member_seq, question_seq, content)
VALUES (9, 75, '가르시니아 캄보지아가 체중 관리에 도움이 됩니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (10, 75, 'CLA가 체지방 감소에 효과적입니다.');

-- 답변 76
INSERT INTO answer (member_seq, question_seq, content)
VALUES (11, 76, '비타민 E가 피부와 머리카락 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (12, 76, '비타민 B군이 피부와 머리카락에 도움을 줍니다.');

-- 답변 77
INSERT INTO answer (member_seq, question_seq, content)
VALUES (13, 77, '비타민 C와 E가 항산화 작용을 통해 노화를 늦출 수 있습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (14, 77, '녹차 추출물이 항산화 효과를 가지고 있습니다.');

-- 답변 78
INSERT INTO answer (member_seq, question_seq, content)
VALUES (15, 78, '아스타잔틴이 강력한 항산화제입니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (16, 78, '비타민 A가 피부에 좋습니다.');

-- 답변 79
INSERT INTO answer (member_seq, question_seq, content)
VALUES (17, 79, '아연이 면역력 강화에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (18, 79, '비타민 C와 D가 면역력에 도움을 줍니다.');

-- 답변 80
INSERT INTO answer (member_seq, question_seq, content)
VALUES (19, 80, '칼슘이 뼈를 강하게 만드는 데 중요합니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (20, 80, '비타민 D가 뼈의 흡수를 도와줍니다.');

-- 답변 81
INSERT INTO answer (member_seq, question_seq, content)
VALUES (21, 81, '홍삼이 체중 관리에 도움이 됩니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (22, 81, '가르시니아가 체지방 감소에 효과적입니다.');

-- 답변 82
INSERT INTO answer (member_seq, question_seq, content)
VALUES (23, 82, '비타민 D가 면역력 증진에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (24, 82, '아연이 면역력에 중요한 역할을 합니다.');

-- 답변 83
INSERT INTO answer (member_seq, question_seq, content)
VALUES (25, 83, '오메가-3가 피부 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (26, 83, '비타민 E가 피부에 효과적입니다.');

-- 답변 84
INSERT INTO answer (member_seq, question_seq, content)
VALUES (27, 84, '칼슘과 비타민 D3가 뼈에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (28, 84, '마그네슘이 뼈의 밀도를 유지하는 데 중요합니다.');

-- 답변 85
INSERT INTO answer (member_seq, question_seq, content)
VALUES (29, 85, '비타민 B군이 체중 감소에 도움이 됩니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (30, 85, 'CLA가 체지방 감소에 효과적입니다.');

-- 답변 86
INSERT INTO answer (member_seq, question_seq, content)
VALUES (31, 86, '녹차 추출물이 다이어트에 효과적입니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (32, 86, '가르시니아가 체중 감소에 도움이 됩니다.');

-- 답변 87
INSERT INTO answer (member_seq, question_seq, content)
VALUES (33, 87, '비타민 D가 뼈와 관절 건강에 중요합니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (34, 87, '칼슘이 뼈를 튼튼하게 만듭니다.');

-- 답변 88
INSERT INTO answer (member_seq, question_seq, content)
VALUES (35, 88, '프로바이오틱스가 장 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (36, 88, '식이섬유가 장 운동을 도와줍니다.');

-- 답변 89
INSERT INTO answer (member_seq, question_seq, content)
VALUES (37, 89, '비타민 C가 피부를 보호합니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (38, 89, '콜라겐이 피부 탄력을 증진시킵니다.');

-- 답변 90
INSERT INTO answer (member_seq, question_seq, content)
VALUES (39, 90, '비타민 A가 피부 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (40, 90, '콜라겐이 피부의 탄력을 돕습니다.');

-- 답변 91
INSERT INTO answer (member_seq, question_seq, content)
VALUES (41, 91, '가르시니아가 체중 감소에 효과적입니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (42, 91, '녹차 추출물이 체지방 감소에 좋습니다.');

-- 답변 92
INSERT INTO answer (member_seq, question_seq, content)
VALUES (43, 92, '비타민 D가 면역력 강화에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (44, 92, '아연이 면역력 증진에 도움이 됩니다.');

-- 답변 93
INSERT INTO answer (member_seq, question_seq, content)
VALUES (45, 93, '칼슘이 뼈를 튼튼하게 합니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (46, 93, '비타민 D가 뼈 건강에 좋습니다.');

-- 답변 94
INSERT INTO answer (member_seq, question_seq, content)
VALUES (47, 94, '비타민 C가 피부에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (48, 94, '콜라겐이 피부 탄력을 돕습니다.');

-- 답변 95
INSERT INTO answer (member_seq, question_seq, content)
VALUES (49, 95, '비타민 B군이 체중 관리에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (50, 95, '가르시니아가 체지방 감소에 도움이 됩니다.');

-- 답변 96
INSERT INTO answer (member_seq, question_seq, content)
VALUES (1, 96, '비타민 D가 면역력에 중요합니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (2, 96, '비타민 C가 면역력 강화에 좋습니다.');

-- 답변 97
INSERT INTO answer (member_seq, question_seq, content)
VALUES (3, 97, '홍삼이 체중 감소에 도움이 됩니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (4, 97, '녹차 추출물이 체지방 감소에 효과적입니다.');

-- 답변 98
INSERT INTO answer (member_seq, question_seq, content)
VALUES (5, 98, '아스타잔틴이 항산화 작용을 합니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (6, 98, '비타민 E가 피부 건강에 좋습니다.');

-- 답변 99
INSERT INTO answer (member_seq, question_seq, content)
VALUES (7, 99, '비타민 A가 눈 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (8, 99, '루테인과 제아잔틴이 시력 보호에 효과적입니다.');

-- 답변 100
INSERT INTO answer (member_seq, question_seq, content)
VALUES (9, 100, '비타민 C가 피부 건강에 좋습니다.');
INSERT INTO answer (member_seq, question_seq, content)
VALUES (10, 100, '콜라겐이 피부의 탄력을 증진시킵니다.');


commit;

