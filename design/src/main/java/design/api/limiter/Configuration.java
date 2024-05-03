package design.api.limiter;

import java.util.concurrent.TimeUnit;

public class Configuration {
    int nRequests;
    int rateLimit;
    TimeUnit timeUnit;

    public Configuration(int nRequests, int rateLimit, TimeUnit timeUnit) {
        this.nRequests = nRequests;
        this.rateLimit = rateLimit;
        this.timeUnit = timeUnit;
    }

    public int getNRequests() {
        return nRequests;
    }

    public int getRateLimit() {
        return rateLimit;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public enum ApiLimitAlgorithmType {
        LEAKING_BUCKET,
        TOKEN_BUCKET
    }
}
