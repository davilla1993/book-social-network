package com.follygbossou.booksocial.feedback;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeedbackResponse {

    private Double note;

    private String comment;

    private boolean ownFeedback;
}
