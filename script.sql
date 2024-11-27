select * from goodCombination;
commit;
CREATE TABLE `productInfo` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`productImage`	VARCHAR(1000)	NULL,
	`CompanyName`	VARCHAR(500)	NULL,
	`productName`	VARCHAR(500)	NOT NULL,
	`ReportNo`	VARCHAR(500)	NOT NULL,
	`registrationDate`	TIMESTAMP	NOT NULL,
	`expirationDate`	VARCHAR(500)	NULL,
	`medicationType`	VARCHAR(1000)	NULL,
	`ingestionMethod`	VARCHAR(1000)	NULL,
	`packagingMaterial`	VARCHAR(1000)	NULL,
	`packagingMethod`	VARCHAR(1000)	NULL,
	`preservation`	VARCHAR(1000)	NULL,
	`precautionsForIngestion`	VARCHAR(2000)	NULL,
	`functionalContent`	TEXT 	NULL,
	`standardsAndSpecifications`	TEXT 	NULL
);

CREATE TABLE `member` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`username`	VARCHAR(100)	NOT NULL,
	`email`	VARCHAR(100)	NOT NULL,
	`password`	VARCHAR(300)	NOT NULL,
	`name`	VARCHAR(100)	NOT NULL,
	`nickname`	VARCHAR(50)	NOT NULL,
	`dob`	TIMESTAMP	NOT NULL,
	`gender`	CHAR(1)	NOT NULL,
	`telephone`	VARCHAR(20)	NOT NULL,
	`address`	VARCHAR(300)	NULL,
	`status`	INT	NOT NULL	DEFAULT 1,
	`createTime`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`updateTime`	TIMESTAMP	NULL	DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (username)
);

CREATE TABLE `review` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`member_seq`	INT	NOT NULL,
	`title`	VARCHAR(300)	NOT NULL,
   	`category`	VARCHAR(100)	NOT NULL,
    	`name`	VARCHAR(300)	NOT NULL,
	`content`	VARCHAR(1000)	NOT NULL,
	`regDate`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (member_seq) REFERENCES member(seq)  
);

CREATE TABLE `reviewComment` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`review_seq`	INT	NOT NULL,
	`member_seq`	INT	NOT NULL,
	`content`	VARCHAR(500)	NOT NULL,
	`regDate`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (review_seq) REFERENCES review(seq),
    FOREIGN KEY (member_seq) REFERENCES member(seq)
);

CREATE TABLE `reviewImage` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`review_seq`	INT	NOT NULL,
	`image`	VARCHAR(300)	NULL,
    FOREIGN KEY (review_seq) REFERENCES review(seq)
);

CREATE TABLE `productMedication` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`member_seq`	INT	NOT NULL,
	`productInfo_seq`	INT	NOT NULL,
    FOREIGN KEY (member_seq) REFERENCES member(seq),
    FOREIGN KEY (productInfo_seq) REFERENCES productInfo(seq)
);


CREATE TABLE `medicationRecord` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`medicationList_seq`	INT	NOT NULL,
	`startDate`	TIMESTAMP	NOT NULL,
	`duration`	INT	NOT NULL,
	`alertTime`	TIME	NOT NULL,
	`status`	VARCHAR(1)	NULL	DEFAULT 1,
    FOREIGN KEY (medicationList_seq) REFERENCES productMedication(seq)
);

-----------------------------------
CREATE TABLE `admin` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`id`	VARCHAR(50)	NOT NULL,
	`pw`	VARCHAR(100)	NOT NULL,
	`name`	VARCHAR(50)	NOT NULL,
	`birthDate`	TIMESTAMP	NOT NULL,
	`email`	VARCHAR(100)	NOT NULL
);


CREATE TABLE `noticePost` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`admin_seq`	INT	NOT NULL,
	`title`	VARCHAR(50)	NOT NULL,
	`content`	VARCHAR(1000)	NOT NULL,
	`regDate`	TIMESTAMP	NOT NULL,
    FOREIGN KEY (admin_seq) REFERENCES admin(seq)
);

CREATE TABLE `faqPost` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`admin_seq`	INT	NOT NULL,
	`title`	VARCHAR(50)	NOT NULL,
	`content`	VARCHAR(1000)	NOT NULL,
	`regDate`	TIMESTAMP	NOT NULL,
    FOREIGN KEY (admin_seq) REFERENCES admin(seq)
    
);

CREATE TABLE `communityPost` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`member_seq`	INT	NOT NULL,
	`title`	VARCHAR(50)	NOT NULL,
	`content`	VARCHAR(1000)	NOT NULL,
	`regDate`	TIMESTAMP	NOT NULL,
    FOREIGN KEY (member_seq) REFERENCES member(seq)
);

CREATE TABLE `communityComment` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`member_seq`	INT	NOT NULL,
	`communityPost_seq`	INT	NOT NULL,
	`content`	VARCHAR(300)	NOT NULL,
	`regDate`	TIMESTAMP	NOT NULL,
    FOREIGN KEY (member_seq) REFERENCES member(seq),
    FOREIGN KEY (communityPost_seq) REFERENCES communityPost(seq)
    
);

CREATE TABLE `health` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`health`	VARCHAR(150)	NOT NULL
);

-----------------------------------------
CREATE TABLE `sessionType` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`name`	VARCHAR(30)	NOT NULL
);

CREATE TABLE `sessionStatus` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`name`	VARCHAR(50)	NOT NULL
);
CREATE TABLE `logSession` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`member_seq`	INT	NOT NULL,
	`type_seq`	INT	NOT NULL,
	`logTime`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`ip`	VARCHAR(50)	NOT NULL,
	`status_seq`	INT	NOT NULL,
    FOREIGN KEY (member_seq) REFERENCES member(seq),
    FOREIGN KEY (type_seq) REFERENCES sessionType(seq),
    FOREIGN KEY (status_seq) REFERENCES sessionStatus(seq)
);

CREATE TABLE `news` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`title`	VARCHAR(100)	NOT NULL,
	`link`	VARCHAR(300)	NOT NULL,
	`originalLink`	VARCHAR(300)	NOT NULL,
	`description`	VARCHAR(500)	NOT NULL,
	`regDate`	TIMESTAMP	NOT NULL
);


CREATE TABLE `ingredient` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`name`	VARCHAR(500)	NOT NULL,
	`category`	INT	NOT NULL
);
---------------------------------------
CREATE TABLE `ingredientContent` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`functionalContent`	VARCHAR(1000)	NULL,
	`dailyIntake`	VARCHAR(1000)	NULL,
	`precautionsForIngestion`	VARCHAR(1000)	NULL,
	`ingredient_seq`	INT	NOT NULL,
    FOREIGN KEY (ingredient_seq) REFERENCES ingredient(seq)
);

CREATE TABLE `ingredientProduct` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`product_seq`	INT	NOT NULL,
	`ingredient_seq`	INT	NOT NULL,
    FOREIGN KEY (product_seq) REFERENCES productInfo(seq),
    FOREIGN KEY (ingredient_seq) REFERENCES ingredient(seq)
);

CREATE TABLE `goodCombination` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`good`	VARCHAR(50)	NOT NULL,
	`reason`	VARCHAR(1500)	NOT NULL,
	`link`	VARCHAR(1000)	NOT NULL,
	`ingredient_seq`	INT	NOT NULL,
    FOREIGN KEY (ingredient_seq) REFERENCES ingredient(seq)
);

CREATE TABLE `badCombination` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`bad`	VARCHAR(50)	NOT NULL,
	`reason`	VARCHAR(1500)	NOT NULL,
	`link`	VARCHAR(1000)	NOT NULL,
	`ingredient_seq`	INT	NOT NULL,
    FOREIGN KEY (ingredient_seq) REFERENCES ingredient(seq)
);

CREATE TABLE `emailVerification` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`member_seq`	INT	NOT NULL,
	`token`	VARCHAR(255)	NOT NULL,
	`expirationTime`	TIMESTAMP	NOT NULL,
	`requestTime`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`VerificationTime`	TIMESTAMP	NULL,
    FOREIGN KEY (member_seq) REFERENCES member(seq)
);

--------------------------------------
CREATE TABLE `activityType` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`name`	VARCHAR(30)	NOT NULL,
	`message`	VARCHAR(300)	NOT NULL
);

CREATE TABLE `userActivity` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`member_seq`	INT	NOT NULL,
	`type_seq`	INT	NOT NULL,
	`url`	VARCHAR(500)	NOT NULL,
	`startTime`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`endTime`	TIMESTAMP	NULL,
	`status`	VARCHAR(30)	NOT NULL,
    FOREIGN KEY (member_seq) REFERENCES member(seq),
    FOREIGN KEY (type_seq) REFERENCES activityType(seq)
);

-----------------------------------
CREATE TABLE `logLevel` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`name`	VARCHAR(30)	NOT NULL,
	`message`	VARCHAR(300)	NOT NULL
);


CREATE TABLE `logApplication` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`level_seq`	INT	NOT NULL,
	`message`	VARCHAR(4000)	NOT NULL,
	`logTime`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`source`	VARCHAR(100)	NOT NULL,
    FOREIGN KEY (level_seq) REFERENCES logLevel(seq)
);


CREATE TABLE `logError` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`member_seq`	INT	NOT NULL,
	`code`	VARCHAR(50)	NOT NULL,
	`message`	VARCHAR(4000)	NOT NULL,
	`errorTime`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`ip`	VARCHAR(50)	NOT NULL,
    FOREIGN KEY (member_seq) REFERENCES member(seq)
);

CREATE TABLE `healthIngredient` (
	`Key`	INT	AUTO_INCREMENT PRIMARY KEY,
	`health_seq`	INT	NOT NULL,
	`ingredient_seq`	INT	NOT NULL,
    FOREIGN KEY (health_seq) REFERENCES health(seq),
    FOREIGN KEY (ingredient_seq) REFERENCES ingredient(seq)
);


CREATE TABLE `adminAuth` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`role`	VARCHAR(50)	NOT NULL
);

------여기서부터 시작 > adminAuthList
CREATE TABLE `adminAuthList` (
	`Key`	INT	AUTO_INCREMENT PRIMARY KEY,
	`admin_seq`	INT	NOT NULL,
	`adminAuth_seq`	INT	NOT NULL,
    FOREIGN KEY (admin_seq) REFERENCES admin(seq),
    FOREIGN KEY (adminAuth_seq) REFERENCES adminAuth(seq)
);



CREATE TABLE `address` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`addressRoad`	VARCHAR(500)	NULL,
	`addressLot`	VARCHAR(500)	NULL,
	`postalCode`	VARCHAR(20)	NULL,
	`latitude`	VARCHAR(20)	NULL,
	`longitude`	VARCHAR(20)	NULL,
	`createTime`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`updateTime`	TIMESTAMP	NULL
);

CREATE TABLE `memberAddress` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`member_seq`	INT	NOT NULL,
	`address_seq`	INT	NOT NULL,
    FOREIGN KEY (member_seq) REFERENCES member(seq),
    FOREIGN KEY (address_seq) REFERENCES address(seq)
);

CREATE TABLE `surveyGenderAge` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`gender`	CHAR(1)	NOT NULL,
	`age`	INT	NOT NULL
);

CREATE TABLE `surveyHealth` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`name`	VARCHAR(100)	NOT NULL
);

CREATE TABLE `surveyOrgan` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`name`	VARCHAR(100)	NOT NULL
);

CREATE TABLE `surveyDaily` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`name`	VARCHAR(100)	NOT NULL
);

CREATE TABLE `ingredientGenderAge` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`genderAge_seq`	INT	NOT NULL,
	`ingredient_seq`	INT	NOT NULL,
    FOREIGN KEY (genderAge_seq) REFERENCES surveyGenderAge(seq),
    FOREIGN KEY (ingredient_seq) REFERENCES ingredient(seq)
);

CREATE TABLE `ingredientOrgan` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`organ_seq`	INT	NOT NULL,
	`ingredient_seq`	INT	NOT NULL,
    FOREIGN KEY (organ_seq) REFERENCES surveyOrgan(seq),
    FOREIGN KEY (ingredient_seq) REFERENCES ingredient(seq)
);

CREATE TABLE `ingredientHealth` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`health_seq`	INT	NOT NULL,
	`ingredient_seq`	INT	NOT NULL,
    FOREIGN KEY (health_seq) REFERENCES surveyHealth(seq),
    FOREIGN KEY (ingredient_seq) REFERENCES ingredient(seq)
);

CREATE TABLE `ingredientDaily` (
	`seq`	INT	AUTO_INCREMENT PRIMARY KEY,
	`daily_seq`	INT	NOT NULL,
	`ingredient_seq`	INT	NOT NULL,
    FOREIGN KEY (daily_seq) REFERENCES surveyDaily(seq),
    FOREIGN KEY (ingredient_seq) REFERENCES ingredient(seq)
);

commit;
