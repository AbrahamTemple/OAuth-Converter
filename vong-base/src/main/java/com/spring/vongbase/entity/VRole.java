package com.spring.vongbase.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Abraham
 * @since 2021-05-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class VRole implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 父角色
     */
    private Long parentId;

    /**
     * 角色名
     */
    @TableField("NAME")
    private String name;

    /**
     * 角色应用名
     */
    private String enableName;

    /**
     * 授权路径
     */
    private String url;

    /**
     * 描述
     */
    private String description;

    private LocalDateTime created;

    private LocalDateTime updated;


}
