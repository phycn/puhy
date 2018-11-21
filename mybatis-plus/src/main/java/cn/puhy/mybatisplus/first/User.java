package cn.puhy.mybatisplus.first;

import lombok.Data;

/**
 * @author PUHY
 * 2018-11-20 22:32
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
