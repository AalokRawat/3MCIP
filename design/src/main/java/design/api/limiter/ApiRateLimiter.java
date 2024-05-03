package design.api.limiter;

public interface ApiRateLimiter {

    boolean execute();

    void setConfiguration(Configuration configuration);
}
