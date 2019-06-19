package com.github.sources.rabbitmq.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hairen.long
 * @date 2019-05-13
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Config {
    private String userName;
    private String password;
    private String host;
    private String port;
    private String vhost;
    private String queueName;
}
