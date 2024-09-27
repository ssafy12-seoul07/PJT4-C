# PJT4-C
정우 재현 혜민

---

### **프로젝트 구조 및 구현 사항**

---

#### 1. **프로젝트 구조**
- **Dynamic Web Project**로 설정
- **메모리 기반 데이터 관리** (이전 자바 관통과 동일한 방식)

---

#### 2. **디렉토리 구조 및 각 파일별 메서드 구현 사항**

---

##### 2.1. **src/main/java**

---

**Controller Layer**

1. **MainController.java**
    - **service(HttpServletRequest req, HttpServletResponse res)**
      - 경로에 따라 라우팅 처리:
        - `switch(path)`
          - `case "video"`:
            - `dovideo(req, res)` : 게시판 관리로 포워드
          - **URL**: `/video` → `videoController`로 매핑
          - `case "comment"`:
            - `doComment(req, res)` : 댓글 관리로 포워드
          - **URL**: `/comment` → `CommentController`로 매핑

2. **VideoController.java** (매핑 경로: `/video`)
    - **doDetail(HttpServletRequest req, HttpServletResponse res)**: 선택된 영상 게시판의 상세 정보 표시
    - **doSortByViewCnt(HttpServletRequest req, HttpServletResponse res)**: 조회수 기준으로 영상 정렬
    - **doFilter(HttpServletRequest req, HttpServletResponse res)**: 카테고리/운동 부위에 따른 영상 필터링

3. **CommentController.java** (매핑 경로: `/comment`)
    - **doList(HttpServletRequest req, HttpServletResponse res)**: 해당 영상의 모든 댓글 목록 표시
    - **doAdd(HttpServletRequest req, HttpServletResponse res)**: 새로운 댓글 추가
    - **doUpdate(HttpServletRequest req, HttpServletResponse res)**: 기존 댓글 수정
    - **doDelete(HttpServletRequest req, HttpServletResponse res)**: 댓글 삭제

---

**Service Layer**

1. **videoService.java** (인터페이스)
    - `List<video> getAllvideos();`
    - `video getvideoById(int id);`
    - `List<video> getvideosSortedByViewCount();`
    - `List<video> filtervideosByCategory(String category);`

2. **videoServiceImpl.java**: `videoService`의 메서드를 구현

3. **CommentService.java** (인터페이스)
    - `List<Comment> getAllComments();`
    - `Comment getCommentById(int id);`
    - `void addComment(Comment comment);`
    - `void updateComment(Comment comment);`
    - `void deleteComment(int id);`

4. **CommentServiceImpl.java**: `CommentService`의 메서드를 구현

---

**Repository Layer**

1. **videoRepository.java**
    - `List<video> findAll();`
    - `video findById(int id);`

2. **CommentRepository.java**
    - `List<Comment> findAll();`
    - `Comment findById(int id);`
    - `void save(Comment comment);`
    - `void update(Comment comment);`
    - `void deleteById(int id);`

---

**Model Layer**

1. **Video.java**
    - `private int id;`
    - `private String title;`
    - `private String description;`
    - `private int viewCount;`
    - `private String category;`

2. **Comment.java**
    - `private int id;`
    - `private int videoId;`
    - `private String content;`
    - `private String author;`

---

##### 2.2. **src/main/webapp**

---

**/video**
1. **videoDetail.jsp**
    - 선택된 영상의 세부 정보 표시 (영상 제목, 설명, 조회수, 카테고리 등)
    - 댓글 섹션으로 연결하는 앵커 태그 포함
2. **videoList.jsp**
    - 모든 영상 목록을 ID 순으로 나열
    - 조회수 순 정렬 버튼 및 카테고리별 필터링 버튼 포함

**/comment**
1. **commentList.jsp**
    - 선택된 영상의 모든 댓글 목록 표시
    - 댓글 추가, 수정, 삭제 기능 포함
2. **addComment.jsp**
    - 새로운 댓글을 추가하기 위한 폼
3. **updateComment.jsp**
    - 기존 댓글을 수정하기 위한 폼

**index.jsp**
1. 모든 영상 목록을 ID 순으로 정렬하여 표시
2. 조회수 순 정렬 및 카테고리별 필터링 버튼 포함

---
