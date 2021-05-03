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
public class VMusic implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 歌曲名
     */
    private String name;

    /**
     * 歌手
     */
    private String artist;

    /**
     * 专辑图片
     */
    private String cover;

    /**
     * 文件资源
     */
    private String source;

    /**
     * 源官网
     */
    private String url;

    private LocalDateTime created;

    private LocalDateTime updated;


}
