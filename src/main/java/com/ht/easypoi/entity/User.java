package com.ht.easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ht
 * @create 2019-12-13 13:58
 */
@ApiModel("用户信息")
@Data
public class User implements Serializable{

    @Excel(name = "用户ID")
    @ApiModelProperty("用户ID")
    private Integer userId;

    @Excel(name = "用户昵称")
    @ApiModelProperty("用户昵称")
    private String nickName;

    @Excel(name = "用户电话")
    @ApiModelProperty("用户电话")
    private String mobile;

    @ApiModelProperty("微信名")
    @Excel(name = "微信名")
    private String wxName;

    @ApiModelProperty("创建时间")
    @Excel(name = "创建时间")
    private Date createTime;

    @Excel(name = "修改时间")
    @ApiModelProperty("修改时间")
    private Date updateTime;

    @Excel(name = "是否修改")
    @ApiModelProperty("是否修改")
    private Integer status;

    @Excel(name = "品牌")
    @ApiModelProperty("品牌")
    private Long brandId;

    @Excel(name = "车系")
    @ApiModelProperty("车系")
    private Long serialId;


}
