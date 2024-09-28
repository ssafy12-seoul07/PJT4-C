# SSAFIT_Back_정우

## 1. 프로젝트 개요

**프로젝트 유형:** Dynamic Web Project  
**데이터 관리 방식:** 메모리 기반 데이터 관리

1. 13:00 - 15:00
- Back-End 구조 및 작동 원리 복습
- 명세서 분석을 통해 필요한 Back-End 구조를 결정 
- ChatGPT를 통해 구조 내 필요한 인터페이스, 변수명, 메소드명 통일 및 UML Diagram 제작 
- 공통 작업 부분과 분업 가능 부분을 파악

1. 15:00 - 18:00
- 정우: Controller 및 헬퍼
- 혜민: Video 담당
- 재현: Comment 담당

---

#### **2. 디렉토리 구조 및 UML Diagram**

```
PJT4-C/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── controller/
│   │   │   │   ├── MainController.java
│   │   │   │   ├── VideoController.java
│   │   │   │   └── CommentController.java
│   │   │   ├── service/
│   │   │   │   ├── VideoService.java
│   │   │   │   ├── VideoServiceImpl.java
│   │   │   │   ├── CommentService.java
│   │   │   │   └── CommentServiceImpl.java
│   │   │   ├── repository/
│   │   │   │   ├── VideoRepository.java
│   │   │   │   └── CommentRepository.java
│   │   │   ├── dto/
│   │   │   │   ├── Video.java
│   │   │   │   └── Comment.java
│   │
│   └── webapp/
│       ├── video/
│       │   ├── videoDetail.jsp
│       │   └── videoList.jsp
│       ├── comment/
│       │   ├── commentList.jsp
│       │   ├── addComment.jsp
│       │   └── updateComment.jsp
│       └── index.jsp
```
![UML Diagram](https://github.com/user-attachments/assets/8e4d83db-7f00-4c49-bd24-6dcd48a43664)

---

## 3. 역할

---

1. **MainController.java** 구현

- **service(HttpServletRequest req, HttpServletResponse res)**
    - 경로에 따라 라우팅 처리:
    - `switch(path)`
        - `case "video"`:
        - `dovideo(req, res)` : 게시판 관리로 포워드
        - **URL**: `/video` → `videoController`로 매핑
        - `case "comment"`:
        - `doComment(req, res)` : 댓글 관리로 포워드
        - **URL**: `/comment` → `CommentController`로 매핑


2.  **VideoController.java** 특정 기능 구현 

* **`doDetail(HttpServletRequest req, HttpServletResponse res)`**: 선택된 영상 게시판의 상세 정보 표시


3.  **videoService.java** (인터페이스) 구현
- `List<video> getAllvideos();`
- `video getvideoById(int id);`
- `List<video> getvideosSortedByViewCount();`
- `List<video> filtervideosByCategory(String category);`


4. 프로젝트 운영 및 Git 운영 프로세스 관리
* 독립적인 branch에서 작업 후 pull request를 보냈을 때, merge & 충돌 관리
* 16:10, 17:30 두 차례 중간점검을 통한 진행상황 공유


### 4. 배운 점
* MVC 패턴에 대한 이해
    * Service와 DB 사이에 Repository의 필요성에 대해 이해하게 되었음
    * Dao와 Dto에 대한 이해하고, 개념을 활용하여 프로젝트를 진행할 수 있었음
* Back의 구조에 대한 구체적인 이해
    * 명세서를 확인하고 직접 Back-End 구조를 설계해보는 과정을 통해 Back 구조에 대한 이해를 높일 수 있었음
* Servlet, jsp 코드 및 메서드 이해
    * getRequestDispatcher와 Forward
    * getAttribute, setAttribute
    * 라이브 코드를 듣고 복습하며 Back에서 작성하는 코드에 대한 이해도를 높일 수 있었음
* branch명을 각자 진행하는 `업무명`으로 작성해서 진행
    * 단순히 각자의 이름으로 branch를 만들어 작성하는 것보다 branch명을 통해 프로젝트 이해도를 높일 수 있도록 함.

### 5. 아쉬웠던 점 및 개선점
* Back의 개념이 자리잡히지 않은 상태에서 프로젝트를 진행해 시간이 오래걸린 점
    * PJT 전 복습의 필요성을 느낌
* 원하는 기능을 다 구현하지 못한 점
    * 주어진 시간 내의 목표, 역할 등을 적절히 분배하여 다음 프로젝트에서는 시간 내 프로젝트를 완성할 수 있도록 도전해보고자 함.