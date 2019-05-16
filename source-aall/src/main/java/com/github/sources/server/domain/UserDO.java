package com.github.sources.server.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hairen.long
 * @date 2019-05-08
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDO {
    private Integer id;
    private String userName;
    private String password;
}
