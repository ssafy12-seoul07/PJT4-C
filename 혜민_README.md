# 혜민 README

### **PJT4-C 프로젝트 명세서**

---

#### **1. 프로젝트 개요**

**프로젝트명:** SSAFIT_Back
**참여 인원:** 정우, 재현, 혜민  
**프로젝트 유형:** Dynamic Web Project  
**데이터 관리 방식:** 메모리 기반 데이터 관리
**협업 log**

1. 13:00 - 15:00
- Back-End 구조 및 작동 원리 복습
- 명세서 분석을 통해 필요한 Back-End 구조를 결정 
- ChatGPT를 통해 구조 내 필요한 인터페이스, 변수명, 메소드명 통일 및 UML Diagram 제작 
- 공통 작업 부분과 분업 가능 부분을 파악

2. 15:00 - 18:00
- 정우: Controller 및 헬퍼
- 혜민: Video 담당
- 재현: Comment 담당

---
#### 내가 한 일
1. 큰 틀 구조 아이디어 내기
    - **service(HttpServletRequest req, HttpServletResponse res)**
      - 경로에 따라 라우팅 처리:
        - `switch(path)`
          - `case "video"`:
            - `dovideo(req, res)` : 게시판 관리로 포워드
          - **URL**: `/video` → `videoController`로 매핑
          - `case "comment"`:
            - `doComment(req, res)` : 댓글 관리로 포워드
          - **URL**: `/comment` → `CommentController`로 매핑

2. video 관련 servelet, jsp 작성

```
PJT4-C/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── controller/
│   │   │   │   └── VideoController.java
│   │   │   ├── service/
│   │   │   │   ├── VideoService.java
│   │   │   │   └── VideoServiceImpl.java
│   │   │   ├── repository/
│   │   │   │   └── VideoRepository.java
│   │   │   ├── dto/
│   │   │   │   └── Video.java
│   │
│   └── webapp/
│       ├── video/
│       │   ├── videoDetail.jsp
│       │   └── videoList.jsp
│       └── index.jsp
```

1) **VideoController.java** (매핑 경로: `/video`)
    - **`doDetail(HttpServletRequest req, HttpServletResponse res)`**: 선택된 영상 게시판의 상세 정보 표시
    - **`doSortByViewCnt(HttpServletRequest req, HttpServletResponse res)`**: 조회수 기준으로 영상 정렬
    - **`doFilter(HttpServletRequest req, HttpServletResponse res)`**: 카테고리/운동 부위에 따른 영상 필터링


2) **videoService.java** (인터페이스)
    - `List<video> getAllvideos();`
    - `video getvideoById(int id);`
    - `List<video> getvideosSortedByViewCount();`
    - `List<video> filtervideosByCategory(String category);`

3) **videoServiceImpl.java**: `videoService`의 메서드를 구현

4) **videoRepository.java**
    - `List<video> findAll();`
    - `video findById(int id);`

5) **Video.java**
    - `private int id;`
    - `private String title;`
    - `private String description;`
    - `private int viewCount;`
    - `private String category;`

6) **videoDetail.jsp**
    - 선택된 영상의 세부 정보 표시 (영상 제목, 설명, 조회수, 카테고리 등)
    - 댓글 섹션으로 연결하는 앵커 태그 포함
7) **videoList.jsp**
    - 모든 영상 목록을 ID 순으로 나열
    - 조회수 순 정렬 버튼 및 카테고리별 필터링 버튼 포함

8) **index.jsp**
1. 모든 영상 목록을 ID 순으로 정렬하여 표시
2. 조회수 순 정렬 및 카테고리별 필터링 버튼 포함

## 아쉬운 점
* 원하는 기능 구현을 다 하지 못했다는 것
* 원인 분석
    * 내가 원하는 화면을 구성하려면 index를 servlet으로 만들었어야했다.
    * 자료 구조화하는 시간을 충분히 가져야겠다는 것을 알게 되었다.

## 알게된 점
* request.getParameter는 수명이 그 페이지에서만 된다는 것
* uri를 통해 parameter로 전달하면 setAttribute로 저장해두어야한다.