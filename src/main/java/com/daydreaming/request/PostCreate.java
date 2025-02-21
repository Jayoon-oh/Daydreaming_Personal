package com.daydreaming.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter

public class PostCreate {

    @NotBlank(message="타이틀을 입력해주세요.")
    private String title;

    @NotBlank(message="컨텐츠를 입력해주세요.")
    private String content;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PostCreate{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
