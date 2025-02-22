# VitaMatch
스프링 부트 기반 영양제 추천 사이트 입니다.

**프로젝트 소개**

<aside>
<img src="/icons/command-line_lightgray.svg" alt="/icons/command-line_lightgray.svg" width="40px" />

**VitaMatch**는 **Spring Boot**를 활용한 개인 맞춤형 영양제 추천 서비스입니다. 사용자의 성별, 연령, 건강 상태를 기반으로 설문을 통해 최적의 영양제를 추천하며, GPS를 이용해 가까운 약국 정보를 제공합니다. 주요 기능으로는 **개인화된 추천**, **영양제 상세 정보 제공**, **약국 검색 및 지도 서비스**, **리뷰 시스템** 등이 포함되어 있습니다.

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/24897b8e-6e97-4a7e-9a81-89d0dd017f08/735f61c5-a1f4-468a-8049-cf3234fd7823/95612623-be82-4855-8493-8da962c3ce94.png)

![A-6.약국추천-상세정보 (1).png](https://prod-files-secure.s3.us-west-2.amazonaws.com/24897b8e-6e97-4a7e-9a81-89d0dd017f08/9dbc7cf6-f2db-4d88-802a-ca0a32d42423/A-6.%EC%95%BD%EA%B5%AD%EC%B6%94%EC%B2%9C-%EC%83%81%EC%84%B8%EC%A0%95%EB%B3%B4_(1).png)

</aside>

**목표**

<aside>
<img src="/icons/golf_green.svg" alt="/icons/golf_green.svg" width="40px" />

1. 사용자의 성별, 연령대, 건강 상태 등을 고려하여 개인 맞춤형 영양제 성분을 추천
2. REST API를 통해 설문 응답 데이터를 수집하고, 추천 엔진에 실시간으로 반영하여 바쁜 사용자에게  효율적인 서비스를 제공
3. JSON 데이터를 기반으로 사용자가 선택한 영양제 성분의 상세 정보(효능, 부작용, 권장 복용량 등)를 동적 페이지로 렌더링하여 과다 복용을 방지
4. 사용자에게 효과적인 영양제 조합을 제시해 올바른 영양 관리를 지원
5. Kakao Maps API와 GPS API를 사용하여 사용자의 현재 위치를 중심으로 약국 및 영양제 판매점을 지도에 시각적으로 표시
</aside>

**핵심 기능** 

<aside>
<img src="/icons/apron_yellow.svg" alt="/icons/apron_yellow.svg" width="40px" />

1. 사용자 설문에 따른 맞춤형 영양제 추천
2. Kakao Maps API 기반 약국 검색 및 상세 보기
3. Naver Search API 기반 실시간 영양제 관련 뉴스 보기
4. 영양제 성분 및 상세 정보 제공
5. 리뷰 작성 및 키워드 검색 기능
</aside>

**주요 사용 기술**

<aside>
<img src="/icons/battery-charging_blue.svg" alt="/icons/battery-charging_blue.svg" width="40px" />

Spring Boot, JPA, QueryDSL, Thymeleaf, Kakao Maps API, JSTL/EL, AJAX

</aside>

**성과**

<aside>
<img src="/icons/flag-swallowtail_purple.svg" alt="/icons/flag-swallowtail_purple.svg" width="40px" />

1. 사용자 설문 데이터를 기반으로 맞춤형 영양제 추천 기능 구현
2. Kakao Maps API를 활용한 GPS 기반 약국 검색 및 상세 정보 제공
3. QueryDSL을 통해 데이터 중복 제거 및 최신 데이터 동기화
4. 동적 페이지 렌더링으로 사용자 친화적인 UI/UX 구현
5. Spring Boot와 REST API로 확장성과 유지보수성을 강화
</aside>

**트러블 슈팅 및 성능 최적화 경험**

<aside>

1. `getQnaPag` **메서드 성능 개선**

**요약**: 목록 리스트 출력 시 데이터 개수를 구하는 방식을 `fetch().size()`에서 `count()`로 변경하여 불필요한 데이터 조회를 줄이고, 평균 실행 시간 **74ms → 17ms, 약 4배 향상**

1. **N+1 문제 해결 및 성능 최적화 경험**

QnA 상세 페이지에서 `Answer`, `Question`, `Member` 연관 조회 시 발생한 N+1 문제를 **QueryDSL**의

`fetchJoin()`을 사용하여 한 번의 쿼리로 해결, 성능을 크게 개선하였습니다.

- **리팩토링 전:** 평균 실행 시간: 2.71초 (최초 진입 시 8.26초)
- **리팩토링 후:** 평균 실행 시간: 0.31초, **약 8.7배 향상**

1. **전반적인 데이터 접근 및 페이징 최적화**

대용량 데이터 처리 시 전체 데이터를 불러오는 방식으로 인해 응답 시간이 점진적으로 증가하는 문제를 페이징 쿼리 최적화 및 불필요한 데이터 조회 제거를 통해, 필요한 데이터만 선별하여 조회하도록 개선하였습니다. 

- 데이터베이스 부하를 최소화하고, 대용량 데이터 처리 시에도 안정적인 응답 속도 유지
- 전체 데이터 조회 시 183ms에서 페이징 처리 후 23ms로 응답 시간 **약 8배 향상**
</aside>
