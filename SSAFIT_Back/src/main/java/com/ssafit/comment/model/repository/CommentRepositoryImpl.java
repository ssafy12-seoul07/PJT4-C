package com.ssafit.comment.model.repository;

import com.ssafit.comment.model.dto.Comment;
import java.util.ArrayList;
import java.util.HashMap;

public class CommentRepositoryImpl implements CommentRepository {
    private HashMap<String, ArrayList<Comment>> videoCommentsMap;
    private int nextCommentId;  // 댓글 ID 자동 증가 변수

    public CommentRepositoryImpl() {
        this.videoCommentsMap = new HashMap<>();
        this.nextCommentId = 1;  // ID 시작 값

        // 초기 댓글 데이터 추가
        initializeComments();
    }

    @Override
    public ArrayList<Comment> findAllByVideoId(String videoId) {
        return videoCommentsMap.getOrDefault(videoId, new ArrayList<>());
    }

    @Override
    public void save(Comment comment) {
        comment.setCommentId(nextCommentId++);  // commentId 자동 할당
        videoCommentsMap.putIfAbsent(comment.getVideoId(), new ArrayList<>());
        videoCommentsMap.get(comment.getVideoId()).add(comment);
    }

    @Override
    public void deleteById(int commentId, String videoId) {
        ArrayList<Comment> comments = videoCommentsMap.get(videoId);
        if (comments != null) {
            comments.removeIf(c -> c.getCommentId() == commentId);
        }
    }

    // 초기 댓글 데이터를 설정하는 메서드
    private void initializeComments() {
        ArrayList<Comment> video1Comments = new ArrayList<>();
        video1Comments.add(new Comment(nextCommentId++, "50WCSpZtdmA", "매일 아침 상쾌한 시작!", "매일 아침 이 스트레칭을 하니까 몸이 훨씬 가벼워졌어요. 하루를 상쾌하게 시작할 수 있어요. 정말 강추!", "user1234"));
        video1Comments.add(new Comment(nextCommentId++, "50WCSpZtdmA", "짧고 효과적인 전신 스트레칭", "이 10분 스트레칭을 꾸준히 하면 하루 종일 활력이 넘쳐요. 전신 스트레칭으로 정말 좋아요.", "fitfan567"));
        video1Comments.add(new Comment(nextCommentId++, "50WCSpZtdmA", "바쁜 아침에도 딱 맞는 운동", "시간이 짧아서 바쁜 아침에도 하기 좋아요. 특히 전신이 풀리는 느낌이 정말 좋습니다.", "wellness_guru88"));
        video1Comments.add(new Comment(nextCommentId++, "50WCSpZtdmA", "짧지만 알찬 스트레칭", "짧지만 알찬 스트레칭이에요. 매일 하면 몸이 가벼워지는 걸 느낄 수 있습니다.", "daily_health_90"));
        video1Comments.add(new Comment(nextCommentId++, "50WCSpZtdmA", "아침 스트레칭으로 완벽", "아침 스트레칭으로 딱이에요! 10분 동안 전신이 풀려서 하루가 한결 가벼워집니다.", "stretchlover21"));
        videoCommentsMap.put("50WCSpZtdmA", video1Comments);

        ArrayList<Comment> video2Comments = new ArrayList<>();
        video2Comments.add(new Comment(nextCommentId++, "Kk7TQGqQ3nA", "피로 회복에 탁월!", "이 스트레칭은 피로 회복에 정말 좋습니다. 하루 두 번 하면 피로가 확 풀리는 느낌이에요.", "yogi_master"));
        video2Comments.add(new Comment(nextCommentId++, "Kk7TQGqQ3nA", "20분의 마법 같은 시간", "20분 투자로 온몸이 시원해지고 피로가 가시는 기분이 들어요. 적극 추천합니다.", "mindful_stretches"));
        video2Comments.add(new Comment(nextCommentId++, "Kk7TQGqQ3nA", "전신 순환에 최고!", "전신 순환이 잘 되는 느낌이라 운동 후에 하면 정말 좋습니다. 특히 피로회복에 최고!", "detox_daily"));
        video2Comments.add(new Comment(nextCommentId++, "Kk7TQGqQ3nA", "심신 안정에도 좋아요", "심신 안정에도 좋고, 피로도 확 풀립니다. 하루 두 번 꼭 하고 있어요.", "peaceful_mind"));
        video2Comments.add(new Comment(nextCommentId++, "Kk7TQGqQ3nA", "디톡스 효과 굿!", "디톡스와 혈액순환 효과까지 있어서 요즘 매일 하고 있어요. 전신 스트레칭으로 강추!", "cleanse_yourbody"));
        videoCommentsMap.put("Kk7TQGqQ3nA", video2Comments);

        ArrayList<Comment> video3Comments = new ArrayList<>();
        video3Comments.add(new Comment(nextCommentId++, "MTU4iCDntjs", "사무실에서 간단히!", "사무실에서 간단히 할 수 있는 스트레칭이라 너무 좋아요. 4분만 투자하면 몸이 한결 가벼워집니다.", "office_fitness"));
        video3Comments.add(new Comment(nextCommentId++, "MTU4iCDntjs", "책상 앞에서도 가능!", "책상 앞에서 오랜 시간 앉아있을 때 꼭 필요한 스트레칭입니다. 짧고 간단해서 실천하기 좋네요.", "quick_moves"));
        video3Comments.add(new Comment(nextCommentId++, "MTU4iCDntjs", "짧은 시간에 효과적", "짧은 시간에 전신을 풀 수 있어서 업무 중간중간에 자주 하고 있어요. 강추합니다!", "stretchworklife"));
        video3Comments.add(new Comment(nextCommentId++, "MTU4iCDntjs", "피로가 싹 가시는 느낌", "이 4분 스트레칭 덕분에 하루 종일 앉아있어도 피로가 덜 느껴져요. 간편하고 효과적입니다.", "desk_yoga_fan"));
        video3Comments.add(new Comment(nextCommentId++, "MTU4iCDntjs", "사무실 스트레칭 추천", "사무실 스트레칭으로 딱 좋아요. 전신이 쫙 풀려서 피로가 싹 가십니다.", "healthyhabits"));
        videoCommentsMap.put("MTU4iCDntjs", video3Comments);

        ArrayList<Comment> video4Comments = new ArrayList<>();
        video4Comments.add(new Comment(nextCommentId++, "D3yExRi7EME", "어깨와 골반에 효과 만점", "어깨와 골반이 자주 뭉치는 편인데, 이 요가로 많이 풀렸어요. 정말 효과적이에요!", "yogalover202"));
        video4Comments.add(new Comment(nextCommentId++, "D3yExRi7EME", "간편하게 따라할 수 있어요", "앉아서 쉽게 따라 할 수 있어서 좋습니다. 어깨랑 골반이 훨씬 유연해졌어요.", "easy_yoga_flow"));
        video4Comments.add(new Comment(nextCommentId++, "D3yExRi7EME", "긴장된 근육 풀기 좋아요", "긴장된 어깨와 골반을 풀어주는 데 이만한 요가가 없어요. 적극 추천합니다.", "body_relaxation"));
        video4Comments.add(new Comment(nextCommentId++, "D3yExRi7EME", "사무실에서도 가능!", "사무실에서도 간단히 할 수 있는 요가 스트레칭이라 너무 좋네요. 효과도 바로 느껴집니다.", "yogaworkday"));
        video4Comments.add(new Comment(nextCommentId++, "D3yExRi7EME", "유연해지는 어깨와 골반", "매일 이 요가를 하면서 어깨랑 골반이 많이 유연해졌어요. 꼭 해보세요!", "daily_yoga_moves"));
        videoCommentsMap.put("D3yExRi7EME", video4Comments);

        ArrayList<Comment> video5Comments = new ArrayList<>();
        video5Comments.add(new Comment(nextCommentId++, "02K-k6daPb4", "짧고 강력한 다이어트 운동", "짧은 시간 안에 땀이 쫙 나면서 칼로리를 태울 수 있는 운동이에요. 다이어트에 강추합니다!", "burncalories123"));
        video5Comments.add(new Comment(nextCommentId++, "02K-k6daPb4", "서서 하는 유산소 운동", "15분 동안 서서 하는 유산소 운동이라 장소 구애 없이 할 수 있어서 너무 좋아요.", "cardioqueen"));
        video5Comments.add(new Comment(nextCommentId++, "02K-k6daPb4", "매일 해도 좋은 운동", "강도가 적당해서 매일 따라 하고 있어요. 전신운동으로 아주 좋습니다.", "fitforlife777"));
        video5Comments.add(new Comment(nextCommentId++, "02K-k6daPb4", "효과 만점 전신 운동", "이 운동 덕분에 전신이 개운해지고 다이어트 효과도 톡톡히 보고 있어요.", "daily_cardio"));
        video5Comments.add(new Comment(nextCommentId++, "02K-k6daPb4", "장소 구애 없는 운동", "서서 하는 운동이라 공간 제약 없이 어디서든 할 수 있어서 좋아요. 정말 효과적입니다.", "anywhere_fitness"));
        videoCommentsMap.put("02K-k6daPb4", video5Comments);
    }
}
