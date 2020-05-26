package com.example.springbootshiroproject.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "",description = "用户实体类")
public class User {

    private int id;
    @ApiModelProperty("用户名")
    private String name;
    @ApiModelProperty("密码")
    private String pwd;
    private String Perms;
}
