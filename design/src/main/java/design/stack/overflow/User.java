package design.stack.overflow;

import javax.xml.stream.events.Comment;
import java.util.List;

public class User extends Person {
    private String userId;
    private String username;
    private List<String> emails;
    private Address address;
    private Badge badge;

    public void post(Question question) {

    }

    public void addAnswer(String questionId, Answer answer) {

    }

    public void flag(String id) {

    }

    public void upvote(String id) {

    }

    public void downVote(String id) {

    }

    public void addComment(String id, Comment comment) {

    }

    public void voteToDelete(String id) {

    }

    public void voteToClose(String id) {

    }
}
