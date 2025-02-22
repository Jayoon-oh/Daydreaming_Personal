package com.daydreaming.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class PostCreate {

    @NotBlank(message="타이틀을 입력해주세요.")
    private String title;

    @NotBlank(message="컨텐츠를 입력해주세요.")
    private String content;

    @Builder // 타입 순서관리를 위함.
    public PostCreate(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // 빌더의 장점
    // - 가독성에 좋음. (값 생성에 대한 유연함)
    // - 필요한 값만 받을 수 있다. // -> 오버로딩 가능한 조건 찾아보기.
    // - 객체의 불변성
}
