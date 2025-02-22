# VitaMatch 개인 맞춤형 영양제 추천 서비스
**VitaMatch**는 **Spring Boot**를 활용한 개인 맞춤형 영양제 추천 서비스입니다. 사용자의 성별, 연령, 건강 상태를 기반으로 설문을 통해 최적의 영양제를 추천하며, GPS를 이용해 가까운 약국 정보를 제공합니다. 주요 기능으로는 **개인화된 추천**, **영양제 상세 정보 제공**, **약국 검색 및 지도 서비스**, **영양제 Q&A 및 리뷰 시스템** 등이 포함되어 있습니다.

<br>

## 목표

1. 사용자의 성별, 연령대, 건강 상태 등을 고려하여 개인 맞춤형 영양제 성분을 추천
2. REST API를 통해 설문 응답 데이터를 수집하고, 추천 엔진에 실시간으로 반영하여 바쁜 사용자에게 효율적인 서비스를 제공
3. JSON 데이터를 기반으로 사용자가 선택한 영양제 성분의 상세 정보(효능, 부작용, 권장 복용량 등)를 동적 페이지로 렌더링하여 과다 복용을 방지
4. 사용자에게 효과적인 영양제 조합을 제시해 올바른 영양 관리를 지원
5. Kakao Maps API와 GPS API를 사용하여 사용자의 현재 위치를 중심으로 약국 및 영양제 판매점을 지도에 시각적으로 표시
<br>

## 핵심 기능

- **사용자 설문에 따른 맞춤형 영양제 추천**
- **Kakao Maps API 기반 약국 검색 및 상세 보기**
- **Naver Search API 기반 실시간 영양제 관련 뉴스 보기**
- **영양제 성분 및 상세 정보 제공**
- **리뷰 작성 및 키워드 검색 기능**
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
<br>

## 성과

1. 사용자 설문 데이터를 기반으로 맞춤형 영양제 추천 기능 구현
2. Kakao Maps API를 활용한 GPS 기반 약국 검색 및 상세 정보 제공
3. QueryDSL을 통해 데이터 중복 제거 및 최신 데이터 동기화
4. 동적 페이지 렌더링으로 사용자 친화적인 UI/UX 구현
5. Spring Boot와 REST API로 확장성과 유지보수성을 강화

<br>

## 트러블 슈팅 및 성능 최적화 경험

### 1. N+1 문제 해결 및 성능 최적화 경험

- **QnA 상세 페이지**에서 `Answer`, `Question`, `Member` 연관 조회 시 발생한 N+1 문제를 **QueryDSL**의 `fetchJoin()`을 사용하여 한 번의 쿼리로 해결, 성능을 크게 개선하였습니다.
    - **리팩토링 전**: 평균 실행 시간: 2.71초 (최초 진입 시 8.26초)
    - **리팩토링 후**: 평균 실행 시간: 0.31초, **약 8.7배 향상**
<br>

### 2. 전반적인 데이터 접근 및 페이징 최적화

- 대용량 데이터 처리 시 전체 데이터를 불러오는 방식으로 인해 응답 시간이 점진적으로 증가하는 문제를 페이징 쿼리 최적화 및 불필요한 데이터 조회 제거를 통해, 필요한 데이터만 선별하여 조회하도록 개선하였습니다.
    - 데이터베이스 부하를 최소화하고, 대용량 데이터 처리 시에도 안정적인 응답 속도 유지
    - 전체 데이터 조회 시 183ms에서 페이징 처리 후 23ms로 응답 시간 **약 8배 향상**
<br>
      
### 3. 데이터 개수 조회 성능 개선

- 목록 리스트 출력 시 데이터 개수를 구하는 방식을 `fetch().size()`에서 `count()`로 변경하여 불필요한 데이터 조회를 줄이고, 평균 실행 시간 **74ms → 17ms, 약 4배 향상**.



