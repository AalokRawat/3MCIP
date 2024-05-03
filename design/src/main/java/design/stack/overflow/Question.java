package design.stack.overflow;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String questionId;
    private String summary;
    private String description;
    private Tag tag;
    private Bounty bounty;
    private List<Answer> answers = new ArrayList<>();

    public void addBounty(Bounty bounty) {
        this.bounty = bounty;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }
}
