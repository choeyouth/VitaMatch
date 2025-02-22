CREATE VIEW vwReview AS
SELECT 
    r.seq, 
    nickname,
    regDate as createDate,
    title,
    category,
    r.name, 
    content,
    image    
FROM review r
INNER JOIN member m ON r.member_seq = m.seq
INNER JOIN reviewImage ri ON ri.review_seq = r.seq;

drop view vwReview;

select * from vwReview; 
select * from review;
select * from reviewImage;
select * from reviewComment;
select * from member;

INSERT INTO reviewImage (seq, review_seq, image) VALUES (1, 1, 'test.img');

commit;
