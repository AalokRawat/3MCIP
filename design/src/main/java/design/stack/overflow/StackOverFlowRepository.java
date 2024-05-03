package design.stack.overflow;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StackOverFlowRepository {
    Map<String, Question> questionMap = new ConcurrentHashMap<>();

}
