package design.api.limiter;

import design.api.limiter.algorithms.LeakingBucket;
import design.api.limiter.algorithms.TokenBucket;

public class ApiRateLimitExecutor {

    public static ApiRateLimiter get(Configuration configuration, Configuration.ApiLimitAlgorithmType type) {
        if(type.equals(Configuration.ApiLimitAlgorithmType.TOKEN_BUCKET))
            return new TokenBucket(configuration);
        else
            return new LeakingBucket(configuration);
    }
}
