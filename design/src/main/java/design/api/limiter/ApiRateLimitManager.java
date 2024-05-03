package design.api.limiter;

import java.util.concurrent.ConcurrentHashMap;

public class ApiRateLimitManager {

    private ConcurrentHashMap<String, ApiRateLimiter> keyToApiRateLimiter;
    private Configuration configuration;
    private Configuration.ApiLimitAlgorithmType algorithmType;

    public ApiRateLimitManager(Configuration configuration, Configuration.ApiLimitAlgorithmType algorithmType) {
        this.keyToApiRateLimiter = new ConcurrentHashMap<>();
        this.configuration = configuration;
        this.algorithmType = algorithmType;
    }

    void setConfiguration(String key, Configuration configuration) {
        ApiRateLimiter apiRateLimiter = keyToApiRateLimiter.get(key);
        apiRateLimiter.setConfiguration(configuration);
    }

    boolean execute(String key) {
        keyToApiRateLimiter.computeIfAbsent(key, k -> ApiRateLimitExecutor.get(configuration, algorithmType));
        return keyToApiRateLimiter.get(key).execute();
    }
}
