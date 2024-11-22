CREATE TABLE `productInfo` (
	`seq`	INT	NOT NULL,
	`productImage`	VARCHAR(1000)	NULL,
	`CompanyName`	VARCHAR(500)	NULL,
	`productName`	VARCHAR(500)	NOT NULL,
	`ReportNo`	VARCHAR(500)	NOT NULL,
	`registrationTIMESTAMP`	TIMESTAMP	NOT NULL,
	`expirationTIMESTAMP`	VARCHAR(500)	NULL,
	`medicationType`	VARCHAR(1000)	NULL,
	`ingestionMethod`	VARCHAR(1000)	NULL,
	`packagingMaterial`	VARCHAR(1000)	NULL,
	`packagingMethod`	VARCHAR(1000)	NULL,
	`preservation`	VARCHAR(1000)	NULL,
	`precautionsForIngestion`	VARCHAR(2000)	NULL,
	`functionalContent`	VARCHAR(4000)	NULL,
	`standardsAndSpecifications`	VARCHAR(4000)	NULL
);

CREATE TABLE `member` (
	`seq`	INT	NOT NULL,
	`username`	VARCHAR(100)	NOT NULL	COMMENT 'UNIQUE',
	`email`	VARCHAR(100)	NOT NULL,
	`password`	VARCHAR(300)	NOT NULL,
	`name`	VARCHAR(100)	NOT NULL,
	`nickname`	VARCHAR(50)	NOT NULL,
	`dob`	TIMESTAMP	NOT NULL,
	`gender`	CHAR(1)	NOT NULL,
	`telephone`	VARCHAR(20)	NOT NULL,
	`address`	VARCHAR(300)	NULL	COMMENT '테스트를 위해서 일 단 NULL',
	`status`	INT	NOT NULL	DEFAULT 1	COMMENT '계정 상태',
	`createTime`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`upTIMESTAMPTime`	TIMESTAMP	NULL	DEFAULT CURRENT_TIMESTAMP
);
DESCRIBE `goodCombination`;
CREATE TABLE `goodCombination` (
	`seq`	INT	NOT NULL,
	`good`	VARCHAR(50)	NOT NULL,
	`reason`	VARCHAR(1500)	NOT NULL,
	`link`	VARCHAR(1000)	NOT NULL
);

CREATE TABLE `badCombination` (
	`seq`	INT	NOT NULL,
	`bad`	VARCHAR(50)	NOT NULL,
	`reason`	VARCHAR(1500)	NOT NULL,
	`link`	VARCHAR(1000)	NOT NULL
);

CREATE TABLE `review` (
	`seq`	INT	NOT NULL,
	`member_seq`	INT	NOT NULL	COMMENT '유저  닉네임을 작성자로 사용',
	`productInfo_seq`	INT	NOT NULL,
	`title`	VARCHAR(300)	NOT NULL,
	`content`	VARCHAR(1000)	NOT NULL,
	`regTIMESTAMP`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`rating`	INT	NULL
);

CREATE TABLE `reviewComment` (
	`seq`	INT	NOT NULL,
	`review_seq`	INT	NOT NULL,
	`member_seq`	INT	NOT NULL	COMMENT '유저  닉네임을 작성자로 사용',
	`content`	VARCHAR(500)	NOT NULL,
	`regTIMESTAMP`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE `reviewImage` (
	`seq`	INT	NOT NULL,
	`review_seq`	INT	NOT NULL,
	`image`	VARCHAR(300)	NULL
);

CREATE TABLE `medicationRecord` (
	`seq`	INT	NOT NULL,
	`medicationList_seq`	INT	NOT NULL,
	`startTIMESTAMP`	TIMESTAMP	NOT NULL,
	`duration`	INT	NOT NULL,
	`alertTime`	TIME	NOT NULL,
	`status`	VARCHAR(1)	NULL	DEFAULT 1	COMMENT '1:복용중, 0: 복용 완료'
);

CREATE TABLE `noticePost` (
	`seq`	INT	NOT NULL,
	`admin_seq`	INT	NOT NULL,
	`title`	VARCHAR(50)	NOT NULL,
	`content`	VARCHAR(1000)	NOT NULL,
	`regTIMESTAMP`	TIMESTAMP	NOT NULL
);

CREATE TABLE `faqPost` (
	`seq`	INT	NOT NULL,
	`admin_seq`	INT	NOT NULL,
	`title`	VARCHAR(50)	NOT NULL,
	`content`	VARCHAR(1000)	NOT NULL,
	`regTIMESTAMP`	TIMESTAMP	NOT NULL
);

CREATE TABLE `communityPost` (
	`seq`	INT	NOT NULL,
	`member_seq`	INT	NOT NULL,
	`title`	VARCHAR(50)	NOT NULL,
	`content`	VARCHAR(1000)	NOT NULL,
	`regTIMESTAMP`	TIMESTAMP	NOT NULL
);

CREATE TABLE `communityComment` (
	`seq`	INT	NOT NULL,
	`member_seq`	INT	NOT NULL,
	`communityPost_seq`	INT	NOT NULL,
	`content`	VARCHAR(300)	NOT NULL,
	`regTIMESTAMP`	TIMESTAMP	NOT NULL
);

CREATE TABLE `health` (
	`seq`	INT	NOT NULL,
	`health`	VARCHAR(150)	NOT NULL
);

CREATE TABLE `logSession` (
	`seq`	INT	NOT NULL,
	`member_seq`	INT	NOT NULL,
	`type_seq`	INT	NOT NULL,
	`logTime`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`ip`	VARCHAR(50)	NOT NULL,
	`status_seq`	INT	NOT NULL
);

CREATE TABLE `news` (
	`seq`	INT	NOT NULL,
	`title`	VARCHAR(100)	NOT NULL	COMMENT '뉴스제목',
	`link`	VARCHAR(300)	NOT NULL	COMMENT '뉴스 기사의 네이버 뉴스 URL',
	`originalLink`	VARCHAR(300)	NOT NULL	COMMENT '뉴스 기사 원문의 URL',
	`description`	VARCHAR(500)	NOT NULL	COMMENT '뉴스 기사의 내용을 요약한 패시지 정보.',
	`regTIMESTAMP`	TIMESTAMP	NOT NULL	COMMENT '뉴스 기사가 네이버에 제공된 시간'
);

CREATE TABLE `admin` (
	`seq`	INT	NOT NULL,
	`id`	VARCHAR(50)	NOT NULL,
	`pw`	VARCHAR(100)	NOT NULL,
	`name`	VARCHAR(50)	NOT NULL,
	`birthTIMESTAMP`	TIMESTAMP	NOT NULL,
	`email`	VARCHAR(100)	NOT NULL
);

CREATE TABLE `productMedication` (
	`seq`	INT	NOT NULL,
	`member_seq`	INT	NOT NULL,
	`productInfo_seq`	INT	NOT NULL
);

CREATE TABLE `ingredient` (
	`seq`	INT	NOT NULL,
	`name`	VARCHAR(500)	NOT NULL,
	`category`	INT	NOT NULL	COMMENT '카테고리 있을시 1 , 없을시 0'
);

CREATE TABLE `ingredientContent` (
	`seq`	INT	NOT NULL,
	`functionalContent`	VARCHAR(1000)	NULL,
	`dailyIntake`	VARCHAR(1000)	NULL,
	`precautionsForIngestion`	VARCHAR(1000)	NULL,
	`ingredient_seq`	VARCHAR(1000)	NOT NULL
);

CREATE TABLE `ingredientProduct` (
	`seq`	INT	NOT NULL,
	`product_seq`	INT	NOT NULL,
	`ingredient_seq`	INT	NOT NULL
);

CREATE TABLE `sessionType` (
	`seq`	INT	NOT NULL,
	`name`	VARCHAR(30)	NOT NULL	COMMENT '로그인, 로그아웃'
);

CREATE TABLE `sessionStatus` (
	`seq`	INT	NOT NULL,
	`name`	VARCHAR(50)	NOT NULL	COMMENT '성공, 실패'
);

CREATE TABLE `emailVerification` (
	`seq`	INT	NOT NULL,
	`member_seq`	INT	NOT NULL,
	`token`	VARCHAR(255)	NOT NULL,
	`expirationTime`	TIMESTAMP	NOT NULL,
	`requestTime`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`VerificationTime`	TIMESTAMP	NULL
);

CREATE TABLE `userActivity` (
	`seq`	INT	NOT NULL,
	`member_seq`	INT	NOT NULL,
	`type_seq`	INT	NOT NULL,
	`url`	VARCHAR(500)	NOT NULL,
	`startTime`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP	COMMENT '사용자가 특정 페이지를 접근한 시각',
	`endTime`	TIMESTAMP	NULL	COMMENT '사용자가 특정 페이지를 나간 시각 또는 세션만료 시각',
	`status`	VARCHAR(30)	NOT NULL	COMMENT 'active, expired, logged_out'
);

CREATE TABLE `logApplication` (
	`seq`	INT	NOT NULL,
	`level_seq`	INT	NOT NULL,
	`message`	VARCHAR(4000)	NOT NULL,
	`logTime`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`source`	VARCHAR(100)	NOT NULL	COMMENT '어디서 로그가 발생했는지 클래스/메서드 명을  기록'
);

CREATE TABLE `logLevel` (
	`seq`	INT	NOT NULL,
	`name`	VARCHAR(30)	NOT NULL,
	`message`	VARCHAR(300)	NOT NULL
);

CREATE TABLE `logError` (
	`seq`	INT	NOT NULL,
	`member_seq`	INT	NOT NULL,
	`code`	VARCHAR(50)	NOT NULL,
	`message`	VARCHAR(4000)	NOT NULL,
	`errorTime`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`ip`	VARCHAR(50)	NOT NULL
);

CREATE TABLE `healthIngredient` (
	`Key`	INT	NOT NULL,
	`health_seq`	INT	NOT NULL,
	`ingredient_seq`	INT	NOT NULL
);

CREATE TABLE `ingredientGoodCombination` (
	`seq`	INT	NOT NULL,
	`ingredient_seq`	INT	NOT NULL,
	`goodCombination_seq`	INT	NOT NULL
);

CREATE TABLE `ingredientBadCombination` (
	`seq`	INT	NOT NULL,
	`ingredient_seq`	INT	NOT NULL,
	`badCombination_seq`	INT	NOT NULL
);

CREATE TABLE `adminAuth` (
	`seq`	INT	NOT NULL,
	`role`	VARCHAR(50)	NOT NULL
);

CREATE TABLE `adminAuthList` (
	`Key`	INT	NOT NULL,
	`admin_seq`	INT	NOT NULL,
	`adminAuth_seq`	INT	NOT NULL
);

CREATE TABLE `activityType` (
	`seq`	INT	NOT NULL,
	`name`	VARCHAR(30)	NOT NULL	COMMENT 'view, recommendation, click, search',
	`message`	VARCHAR(300)	NOT NULL
);

CREATE TABLE `address` (
	`seq`	INT	NOT NULL,
	`addressRoad`	VARCHAR(500)	NULL,
	`addressLot`	VARCHAR(500)	NULL,
	`postalCode`	VARCHAR(20)	NULL,
	`latitude`	VARCHAR(20)	NULL,
	`longitude`	VARCHAR(20)	NULL,
	`createTime`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`upTIMESTAMPTime`	TIMESTAMP	NULL
);

CREATE TABLE `member-address` (
	`seq`	INT	NOT NULL,
	`member_seq`	INT	NOT NULL,
	`address_seq`	INT	NOT NULL
);

CREATE TABLE `surveyGenderAge` (
	`seq`	INT	NOT NULL,
	`gender`	CHAR(1)	NOT NULL,
	`age`	INT	NOT NULL
);

CREATE TABLE `surveyHealth` (
	`seq`	INT	NOT NULL,
	`name`	VARCHAR(100)	NOT NULL
);

CREATE TABLE `surveyOrgan` (
	`seq`	INT	NOT NULL,
	`name`	VARCHAR(100)	NOT NULL
);

CREATE TABLE `surveyDaily` (
	`seq`	INT	NOT NULL,
	`name`	VARCHAR(100)	NOT NULL
);

CREATE TABLE `ingredient-genderAge` (
	`seq`	INT	NOT NULL,
	`genderAge_seq`	INT	NOT NULL,
	`ingredient_seq`	INT	NOT NULL
);

CREATE TABLE `ingredient-organ` (
	`seq`	INT	NOT NULL,
	`organ_seq`	INT	NOT NULL,
	`ingredient_seq`	INT	NOT NULL
);

CREATE TABLE `ingredient-health` (
	`seq`	INT	NOT NULL,
	`health_seq`	INT	NOT NULL,
	`ingredient_seq`	INT	NOT NULL
);

CREATE TABLE `ingredient-daily` (
	`seq`	INT	NOT NULL,
	`daily_seq`	INT	NOT NULL,
	`ingredient_seq`	INT	NOT NULL
);

ALTER TABLE `productInfo` ADD CONSTRAINT `PK_PRODUCTINFO` PRIMARY KEY (
	`seq`
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`seq`
);

ALTER TABLE `goodCombination` ADD CONSTRAINT `PK_GOODCOMBINATION` PRIMARY KEY (
	`seq`
);

ALTER TABLE `badCombination` ADD CONSTRAINT `PK_BADCOMBINATION` PRIMARY KEY (
	`seq`
);

ALTER TABLE `review` ADD CONSTRAINT `PK_REVIEW` PRIMARY KEY (
	`seq`
);

ALTER TABLE `reviewComment` ADD CONSTRAINT `PK_REVIEWCOMMENT` PRIMARY KEY (
	`seq`
);

ALTER TABLE `reviewImage` ADD CONSTRAINT `PK_REVIEWIMAGE` PRIMARY KEY (
	`seq`
);

ALTER TABLE `medicationRecord` ADD CONSTRAINT `PK_MEDICATIONRECORD` PRIMARY KEY (
	`seq`
);

ALTER TABLE `noticePost` ADD CONSTRAINT `PK_NOTICEPOST` PRIMARY KEY (
	`seq`
);

ALTER TABLE `faqPost` ADD CONSTRAINT `PK_FAQPOST` PRIMARY KEY (
	`seq`
);

ALTER TABLE `communityPost` ADD CONSTRAINT `PK_COMMUNITYPOST` PRIMARY KEY (
	`seq`
);

ALTER TABLE `communityComment` ADD CONSTRAINT `PK_COMMUNITYCOMMENT` PRIMARY KEY (
	`seq`
);

ALTER TABLE `health` ADD CONSTRAINT `PK_HEALTH` PRIMARY KEY (
	`seq`
);

ALTER TABLE `logSession` ADD CONSTRAINT `PK_LOGSESSION` PRIMARY KEY (
	`seq`
);

ALTER TABLE `news` ADD CONSTRAINT `PK_NEWS` PRIMARY KEY (
	`seq`
);

ALTER TABLE `admin` ADD CONSTRAINT `PK_ADMIN` PRIMARY KEY (
	`seq`
);

ALTER TABLE `productMedication` ADD CONSTRAINT `PK_PRODUCTMEDICATION` PRIMARY KEY (
	`seq`
);

ALTER TABLE `ingredient` ADD CONSTRAINT `PK_INGREDIENT` PRIMARY KEY (
	`seq`
);

ALTER TABLE `ingredientContent` ADD CONSTRAINT `PK_INGREDIENTCONTENT` PRIMARY KEY (
	`seq`
);

ALTER TABLE `ingredientProduct` ADD CONSTRAINT `PK_INGREDIENTPRODUCT` PRIMARY KEY (
	`seq`
);

ALTER TABLE `sessionType` ADD CONSTRAINT `PK_SESSIONTYPE` PRIMARY KEY (
	`seq`
);

ALTER TABLE `sessionStatus` ADD CONSTRAINT `PK_SESSIONSTATUS` PRIMARY KEY (
	`seq`
);

ALTER TABLE `emailVerification` ADD CONSTRAINT `PK_EMAILVERIFICATION` PRIMARY KEY (
	`seq`
);

ALTER TABLE `userActivity` ADD CONSTRAINT `PK_USERACTIVITY` PRIMARY KEY (
	`seq`
);

ALTER TABLE `logApplication` ADD CONSTRAINT `PK_LOGAPPLICATION` PRIMARY KEY (
	`seq`
);

ALTER TABLE `logLevel` ADD CONSTRAINT `PK_LOGLEVEL` PRIMARY KEY (
	`seq`
);

ALTER TABLE `logError` ADD CONSTRAINT `PK_LOGERROR` PRIMARY KEY (
	`seq`
);

ALTER TABLE `healthIngredient` ADD CONSTRAINT `PK_HEALTHINGREDIENT` PRIMARY KEY (
	`Key`
);

ALTER TABLE `ingredientGoodCombination` ADD CONSTRAINT `PK_INGREDIENTGOODCOMBINATION` PRIMARY KEY (
	`seq`
);

ALTER TABLE `ingredientBadCombination` ADD CONSTRAINT `PK_INGREDIENTBADCOMBINATION` PRIMARY KEY (
	`seq`
);

ALTER TABLE `adminAuth` ADD CONSTRAINT `PK_ADMINAUTH` PRIMARY KEY (
	`seq`
);

ALTER TABLE `adminAuthList` ADD CONSTRAINT `PK_ADMINAUTHLIST` PRIMARY KEY (
	`Key`
);

ALTER TABLE `activityType` ADD CONSTRAINT `PK_ACTIVITYTYPE` PRIMARY KEY (
	`seq`
);

ALTER TABLE `address` ADD CONSTRAINT `PK_ADDRESS` PRIMARY KEY (
	`seq`
);

ALTER TABLE `member-address` ADD CONSTRAINT `PK_MEMBER-ADDRESS` PRIMARY KEY (
	`seq`
);

ALTER TABLE `surveyGenderAge` ADD CONSTRAINT `PK_SURVEYGENDERAGE` PRIMARY KEY (
	`seq`
);

ALTER TABLE `surveyHealth` ADD CONSTRAINT `PK_SURVEYHEALTH` PRIMARY KEY (
	`seq`
);

ALTER TABLE `surveyOrgan` ADD CONSTRAINT `PK_SURVEYORGAN` PRIMARY KEY (
	`seq`
);

ALTER TABLE `surveyDaily` ADD CONSTRAINT `PK_SURVEYDAILY` PRIMARY KEY (
	`seq`
);

ALTER TABLE `ingredient-genderAge` ADD CONSTRAINT `PK_INGREDIENT-GENDERAGE` PRIMARY KEY (
	`seq`
);

ALTER TABLE `ingredient-organ` ADD CONSTRAINT `PK_INGREDIENT-ORGAN` PRIMARY KEY (
	`seq`
);

ALTER TABLE `ingredient-health` ADD CONSTRAINT `PK_INGREDIENT-HEALTH` PRIMARY KEY (
	`seq`
);

ALTER TABLE `ingredient-daily` ADD CONSTRAINT `PK_INGREDIENT-DAILY` PRIMARY KEY (
	`seq`
);


commit;
