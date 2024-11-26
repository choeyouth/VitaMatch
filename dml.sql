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


select * from vwDailyRecommend;
select * from ingredientDaily;
