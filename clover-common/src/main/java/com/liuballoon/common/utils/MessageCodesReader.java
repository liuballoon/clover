/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/21 13:27
 */
package com.liuballoon.common.utils;

import com.liuballoon.common.configuration.PropertySourceFactory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "clover")
@PropertySource(value = "classpath:message-codes.yml", factory = PropertySourceFactory.class)
public class MessageCodesReader {
    private Map<Integer, String> codes = new HashMap<>();

    public String read(int code) {
        return this.codes.get(code);
    }
}
