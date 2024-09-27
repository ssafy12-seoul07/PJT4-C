package com.ssafit.comment.model.repository;

import com.ssafit.comment.model.dto.Comment;
import com.ssafit.video.model.repository.VideoRepositoryImpl;  // VideoRepositoryImpl import

import java.util.ArrayList;
import java.util.Map;

public class CommentRepositoryImpl implements CommentRepository {
    
	private static CommentRepository commentRepository = new CommentRepositoryImpl();
	
	private Map<String, Integer> videoMap;  // videoMap: <videoId, videoListIndex>
    
	private ArrayList<ArrayList<Comment>> commentList;  // 이중 ArrayList<Comment>로 댓글 관리
    
	private int nextCommentId;  // 댓글 ID 자동 증가 변수

	public static CommentRepository getInstance() {
		return commentRepository;
	}
   
    public CommentRepositoryImpl() {
        // VideoRepositoryImpl의 싱글턴 인스턴스에서 videoMap을 가져옴
        this.videoMap = VideoRepositoryImpl.getInstance().getVideoMap();
        this.commentList = new ArrayList<>();
        this.nextCommentId = 1;  // ID 시작 값

        // commentList 초기화: videoList와 크기 동기화
        for (int i = 0; i < videoMap.size(); i++) {
            commentList.add(new ArrayList<>());
        }

        // 초기 댓글 데이터 추가
        initializeComments();
    }

    @Override
    public ArrayList<Comment> findAllByVideoId(String videoId) {
        // videoMap에서 videoId로부터 인덱스 가져오기
        Integer videoIndex = videoMap.get(videoId);
        if (videoIndex != null) {
            return commentList.get(videoIndex);
        }
        return new ArrayList<>();  // 비어 있는 리스트 반환
    }

    @Override
    public void save(Comment comment) {
        // videoMap에서 comment의 videoId로 인덱스 값 가져오기
        Integer videoIndex = videoMap.get(comment.getVideoId());

        if (videoIndex != null) {
            comment.setCommentId(nextCommentId++);  // commentId 자동 할당
            commentList.get(videoIndex).add(comment);  // 해당 인덱스에 댓글 추가
        }
    }

    @Override
    public void deleteById(int commentId, String videoId) {
        // videoMap에서 videoId로부터 인덱스 가져오기
        Integer videoIndex = videoMap.get(videoId);
        if (videoIndex != null) {
            ArrayList<Comment> comments = commentList.get(videoIndex);
            comments.removeIf(c -> c.getCommentId() == commentId);  // commentId로 삭제
        }
    }

    // 초기 댓글 데이터를 설정하는 메서드
    private void initializeComments() {
        // 예시로, videoMap에서 특정 videoId에 해당하는 인덱스에 맞춰 댓글을 추가하는 방식
        Integer videoIndex0 = videoMap.get("50WCSpZtdmA");  // videoId 50WCSpZtdmA의 인덱스를 가져옴
        if (videoIndex0 != null) {
            commentList.get(videoIndex0).add(new Comment(nextCommentId++, "50WCSpZtdmA", "매일 아침 상쾌한 시작!", "매일 아침 이 스트레칭을 하니까 몸이 훨씬 가벼워졌어요. 하루를 상쾌하게 시작할 수 있어요. 정말 강추!", "user1234"));
            commentList.get(videoIndex0).add(new Comment(nextCommentId++, "50WCSpZtdmA", "짧고 효과적인 전신 스트레칭", "이 10분 스트레칭을 꾸준히 하면 하루 종일 활력이 넘쳐요. 전신 스트레칭으로 정말 좋아요.", "fitfan567"));
            commentList.get(videoIndex0).add(new Comment(nextCommentId++, "50WCSpZtdmA", "바쁜 아침에도 딱 맞는 운동", "시간이 짧아서 바쁜 아침에도 하기 좋아요. 특히 전신이 풀리는 느낌이 정말 좋습니다.", "wellness_guru88"));
            commentList.get(videoIndex0).add(new Comment(nextCommentId++, "50WCSpZtdmA", "짧지만 알찬 스트레칭", "짧지만 알찬 스트레칭이에요. 매일 하면 몸이 가벼워지는 걸 느낄 수 있습니다.", "daily_health_90"));
            commentList.get(videoIndex0).add(new Comment(nextCommentId++, "50WCSpZtdmA", "아침 스트레칭으로 완벽", "아침 스트레칭으로 딱이에요! 10분 동안 전신이 풀려서 하루가 한결 가벼워집니다.", "stretchlover21"));
        }

        Integer videoIndex1 = videoMap.get("Kk7TQGqQ3nA");  // videoId Kk7TQGqQ3nA의 인덱스를 가져옴
        if (videoIndex1 != null) {
            commentList.get(videoIndex1).add(new Comment(nextCommentId++, "Kk7TQGqQ3nA", "피로 회복에 탁월!", "이 스트레칭은 피로 회복에 정말 좋습니다. 하루 두 번 하면 피로가 확 풀리는 느낌이에요.", "yogi_master"));
            commentList.get(videoIndex1).add(new Comment(nextCommentId++, "Kk7TQGqQ3nA", "20분의 마법 같은 시간", "20분 투자로 온몸이 시원해지고 피로가 가시는 기분이 들어요. 적극 추천합니다.", "mindful_stretches"));
            commentList.get(videoIndex1).add(new Comment(nextCommentId++, "Kk7TQGqQ3nA", "전신 순환에 최고!", "전신 순환이 잘 되는 느낌이라 운동 후에 하면 정말 좋습니다. 특히 피로회복에 최고!", "detox_daily"));
            commentList.get(videoIndex1).add(new Comment(nextCommentId++, "Kk7TQGqQ3nA", "심신 안정에도 좋아요", "심신 안정에도 좋고, 피로도 확 풀립니다. 하루 두 번 꼭 하고 있어요.", "peaceful_mind"));
            commentList.get(videoIndex1).add(new Comment(nextCommentId++, "Kk7TQGqQ3nA", "디톡스 효과 굿!", "디톡스와 혈액순환 효과까지 있어서 요즘 매일 하고 있어요. 전신 스트레칭으로 강추!", "cleanse_yourbody"));
        }

        Integer videoIndex2 = videoMap.get("MTU4iCDntjs");  // videoId MTU4iCDntjs의 인덱스를 가져옴
        if (videoIndex2 != null) {
            commentList.get(videoIndex2).add(new Comment(nextCommentId++, "MTU4iCDntjs", "사무실에서 간단히!", "사무실에서 간단히 할 수 있는 스트레칭이라 너무 좋아요. 4분만 투자하면 몸이 한결 가벼워집니다.", "office_fitness"));
            commentList.get(videoIndex2).add(new Comment(nextCommentId++, "MTU4iCDntjs", "책상 앞에서도 가능!", "책상 앞에서 오랜 시간 앉아있을 때 꼭 필요한 스트레칭입니다. 짧고 간단해서 실천하기 좋네요.", "quick_moves"));
            commentList.get(videoIndex2).add(new Comment(nextCommentId++, "MTU4iCDntjs", "짧은 시간에 효과적", "짧은 시간에 전신을 풀 수 있어서 업무 중간중간에 자주 하고 있어요. 강추합니다!", "stretchworklife"));
            commentList.get(videoIndex2).add(new Comment(nextCommentId++, "MTU4iCDntjs", "피로가 싹 가시는 느낌", "이 4분 스트레칭 덕분에 하루 종일 앉아있어도 피로가 덜 느껴져요. 간편하고 효과적입니다.", "desk_yoga_fan"));
            commentList.get(videoIndex2).add(new Comment(nextCommentId++, "MTU4iCDntjs", "사무실 스트레칭 추천", "사무실 스트레칭으로 딱 좋아요. 전신이 쫙 풀려서 피로가 싹 가십니다.", "healthyhabits"));
        }

        Integer videoIndex3 = videoMap.get("D3yExRi7EME");  // videoId D3yExRi7EME의 인덱스를 가져옴
        if (videoIndex3 != null) {
            commentList.get(videoIndex3).add(new Comment(nextCommentId++, "D3yExRi7EME", "어깨와 골반에 효과 만점", "어깨와 골반이 자주 뭉치는 편인데, 이 요가로 많이 풀렸어요. 정말 효과적이에요!", "yogalover202"));
            commentList.get(videoIndex3).add(new Comment(nextCommentId++, "D3yExRi7EME", "간편하게 따라할 수 있어요", "앉아서 쉽게 따라 할 수 있어서 좋습니다. 어깨랑 골반이 훨씬 유연해졌어요.", "easy_yoga_flow"));
            commentList.get(videoIndex3).add(new Comment(nextCommentId++, "D3yExRi7EME", "긴장된 근육 풀기 좋아요", "긴장된 어깨와 골반을 풀어주는 데 이만한 요가가 없어요. 적극 추천합니다.", "body_relaxation"));
            commentList.get(videoIndex3).add(new Comment(nextCommentId++, "D3yExRi7EME", "사무실에서도 가능!", "사무실에서도 간단히 할 수 있는 요가 스트레칭이라 너무 좋네요. 효과도 바로 느껴집니다.", "yogaworkday"));
            commentList.get(videoIndex3).add(new Comment(nextCommentId++, "D3yExRi7EME", "유연해지는 어깨와 골반", "매일 이 요가를 하면서 어깨랑 골반이 많이 유연해졌어요. 꼭 해보세요!", "daily_yoga_moves"));
        }

        Integer videoIndex4 = videoMap.get("02K-k6daPb4");  // videoId 02K-k6daPb4의 인덱스를 가져옴
        if (videoIndex4 != null) {
            commentList.get(videoIndex4).add(new Comment(nextCommentId++, "02K-k6daPb4", "짧고 강력한 다이어트 운동", "짧은 시간 안에 땀이 쫙 나면서 칼로리를 태울 수 있는 운동이에요. 다이어트에 강추합니다!", "burncalories123"));
            commentList.get(videoIndex4).add(new Comment(nextCommentId++, "02K-k6daPb4", "서서 하는 유산소 운동", "15분 동안 서서 하는 유산소 운동이라 장소 구애 없이 할 수 있어서 너무 좋아요.", "cardioqueen"));
            commentList.get(videoIndex4).add(new Comment(nextCommentId++, "02K-k6daPb4", "매일 해도 좋은 운동", "강도가 적당해서 매일 따라 하고 있어요. 전신운동으로 아주 좋습니다.", "fitforlife777"));
            commentList.get(videoIndex4).add(new Comment(nextCommentId++, "02K-k6daPb4", "효과 만점 전신 운동", "이 운동 덕분에 전신이 개운해지고 다이어트 효과도 톡톡히 보고 있어요.", "daily_cardio"));
            commentList.get(videoIndex4).add(new Comment(nextCommentId++, "02K-k6daPb4", "장소 구애 없는 운동", "서서 하는 운동이라 공간 제약 없이 어디서든 할 수 있어서 좋아요. 정말 효과적입니다.", "anywhere_fitness"));
        }
    }
}
