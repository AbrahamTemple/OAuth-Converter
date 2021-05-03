package com.spring.vongbase.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
public class VPermission implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 父权限
     */
    private Long prarentId;

    /**
     * 权限名
     */
    private String name;

    /**
     * 权限应用名
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
