drop table question;
drop table answer;

CREATE TABLE question (
    seq INT AUTO_INCREMENT PRIMARY KEY,  	       -- 질문 ID
    member_seq INT NOT NULL,                       -- 작성한 회원 ID
    title VARCHAR(255) NOT NULL,                   -- 질문 제목
    content TEXT NOT NULL,                         -- 질문 내용
    isSolved BOOLEAN DEFAULT FALSE,                -- 해결 여부
    regDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,   -- 등록일
    modDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 수정일
    FOREIGN KEY (member_seq) REFERENCES member(seq)  -- 외래 키로 회원과 연결
);


CREATE TABLE answer (
    seq INT AUTO_INCREMENT PRIMARY KEY,             -- 답변 ID
    member_seq INT NOT NULL,                        -- 작성한 회원 ID
    question_seq INT NOT NULL,                      -- 연결된 질문 ID
    content TEXT NOT NULL,                          -- 답변 내용
    regDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,   -- 답변 등록일
    modDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 수정일
    FOREIGN KEY (question_seq) REFERENCES question(seq), -- 외래 키로 질문과 연결
    FOREIGN KEY (member_seq) REFERENCES member(seq)  -- 외래 키로 회원과 연결
);

-- 질문 추가
INSERT INTO question (member_seq, title, content)
VALUES (1, '어떤 영양제가 좋나요?', '간에 좋은 영양제를 추천해주세요.');

-- 답변 추가
INSERT INTO answer (member_seq, question_seq, content)
VALUES (2, 2, '밀크씨슬이 좋습니다. 도움이 됩니다.');
INSERT INTO answer (member_seq, question_seq, content) 
VALUES (1, 1, '오메가-3도 좋습니다. 뇌 건강에 도움이 됩니다.');


-- 질문 해결
UPDATE question
SET isSolved = TRUE
WHERE seq = 1;  -- 질문 ID가 1번인 질문을 해결됨으로 표시


-- 질문과 답변을 조회
SELECT q.seq AS question_seq, q.title, q.content AS question_content, isSolved, 
       a.seq AS answer_seq, a.content AS answer_content
FROM question q
LEFT JOIN answer a ON q.seq = a.question_seq;

SELECT * FROM question;
SELECT * FROM answer;

COMMIT;
