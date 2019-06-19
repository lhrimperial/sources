package com.github.sources.docker.compose.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hairen.long
 * @date 2019-04-25
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDO {
    private Integer id;
    private String userName;
    private String password;
    private Integer age;
}
