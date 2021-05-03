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
public class VCover implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 封面名
     */
    private String name;

    /**
     * 封面图片
     */
    private String url;

    /**
     * 描述
     */
    private String title;

    /**
     * 动画
     */
    private String animate;

    /**
     * 库总量
     */
    private Integer count;

    /**
     * 上传时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 逻辑删除
     */
    private Integer deleted;

    /**
     * 乐观锁
     */
    private Integer version;


}
