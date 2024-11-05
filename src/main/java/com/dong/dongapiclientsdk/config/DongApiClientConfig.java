package com.dong.dongapiclientsdk.config;

import com.dong.dongapiclientsdk.client.DongApiClient;
import com.dong.dongapiclientsdk.service.ApiService;
import com.dong.dongapiclientsdk.service.impl.ApiServiceImpl;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("dong.api.client")
@ComponentScan
public class DongApiClientConfig {
    /**
     * 访问密钥
     */
    private String accessKey;

    /**
     * 秘密密钥
     */
    private String secretKey;

    /**
     * 网关
     */
    private String host;

    @Bean
    public DongApiClient dongApiClient() {
        return new DongApiClient(accessKey, secretKey);
    }

    @Bean
    public ApiService apiService() {
        ApiServiceImpl apiService = new ApiServiceImpl();
        apiService.setDongApiClient(new DongApiClient(accessKey, secretKey));
        if (StringUtils.isNotBlank(host)) {
            apiService.setGetewayHost(host);
        }
        return apiService;
    }

}
