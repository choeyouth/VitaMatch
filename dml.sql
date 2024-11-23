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