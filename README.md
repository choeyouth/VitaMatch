# VitaMatch 개인 맞춤형 영양제 추천 서비스
**VitaMatch**는 **Spring Boot**를 활용한 개인 맞춤형 영양제 추천 서비스입니다. 사용자의 성별, 연령, 건강 상태를 기반으로 설문을 통해 최적의 영양제를 추천하며, GPS를 이용해 가까운 약국 정보를 제공합니다. 주요 기능으로는 **개인화된 추천**, **영양제 상세 정보 제공**, **약국 검색 및 지도 서비스**, **영양제 Q&A 및 리뷰 시스템** 등이 포함되어 있습니다.

<br> 

## 목표

1. 사용자의 성별, 연령대, 건강 상태 등을 고려하여 개인 맞춤형 영양제 성분을 추천
2. REST API를 통해 설문 응답 데이터를 수집하고, 추천 엔진에 실시간으로 반영하여 바쁜 사용자에게 효율적인 서비스를 제공
3. JSON 데이터를 기반으로 사용자가 선택한 영양제 성분의 상세 정보(효능, 부작용, 권장 복용량 등)를 동적 페이지로 렌더링
4. 사용자에게 효과적인 영양제 조합을 제시해 올바른 영양 관리를 지원
5. Kakao Maps API와 GPS API를 사용하여 사용자의 현재 위치를 중심으로 약국 및 영양제 판매점을 지도에 시각적으로 표시
<br>

## 핵심 기능

- **사용자 설문에 따른 맞춤형 영양제 추천**
- **Kakao Maps API 기반 약국 검색 및 상세 보기**
- **Naver Search API 기반 실시간 영양제 관련 뉴스 보기**
- **영양제 성분 및 상세 정보 제공**
- **영양제 Q&A 및 리뷰 작성 기능**
<br>

## 개발 환경

-   **운영체제**: Windows 10/11, maxOS, Linux(Ubuntu)
-   **서버**: Apache Tomcat, AWS EC2
-   **데이터베이스**: MySQL 8
-   **개발 툴**: STS 4, Visual Studio Code, SQL Developer
-   **협업 툴**: GitHub, Notion, Discord, ERD Cloud, Draw.io, Figma, Google Drive
<br>

## 사용 기술

-   **프로그래밍 언어**: Java 21, HTML5, CSS, JavaScript, SQL
-   **프레임워크 및 라이브러리**:
    -   Spring Boot, Gradle, Spring Web, Spring Boot Security, Spring MVC, Spring Boot Devtools, Lombok, HikariCP, JPA, Query DSL, Thymeleaf, Jackson
    -   jQuery, Ajax, Bootstrap, RESTful API, HttpURLConnection
    -   Kakao Maps API, 전국 약국 조회 API, Naver Search API, OpenAI API



