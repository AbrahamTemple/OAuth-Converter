package com.cloud.vongoauth.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class vUser {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;
    private String password;
    private String clientId;
    private String phone;
    private String email;

    @TableField(fill = FieldFill.INSERT)
    private Date created;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updated;
}
