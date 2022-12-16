package com.plane.sincer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName equip_mould
 */
@TableName(value ="equip_mould")
@Data
public class EquipMould implements Serializable {
    /**
     * 序号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 模具编号
     */
    private String mouldNo;

    /**
     * 模具名称
     */
    private String mouldName;

    /**
     * 端子旧编号
     */
    private String terminalOld;

    /**
     * 端子新编号
     */
    private String terminalNew;

    /**
     * 现有库存
     */
    private String currQuantity;

    /**
     * 0:不存在,1:存在
     */
    private Integer isExist;

    /**
     * 模具地址
     */
    private String address;

    /**
     * 状态（0:不可用,1:可用）
     */
    private Integer status;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 使用生产的次数
     */
    private Integer useCount;

    /**
     * 出库时间
     */
    private Date outStoreTime;

    /**
     * 入库时间
     */
    private Date inStoreTime;

    /**
     * 最近操作人员
     */
    private Integer lastOperaId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 备注
     */
    private String remark;

    @TableField(exist = false)
    private User operator;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        EquipMould other = (EquipMould) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMouldNo() == null ? other.getMouldNo() == null : this.getMouldNo().equals(other.getMouldNo()))
            && (this.getMouldName() == null ? other.getMouldName() == null : this.getMouldName().equals(other.getMouldName()))
            && (this.getTerminalOld() == null ? other.getTerminalOld() == null : this.getTerminalOld().equals(other.getTerminalOld()))
            && (this.getTerminalNew() == null ? other.getTerminalNew() == null : this.getTerminalNew().equals(other.getTerminalNew()))
            && (this.getCurrQuantity() == null ? other.getCurrQuantity() == null : this.getCurrQuantity().equals(other.getCurrQuantity()))
            && (this.getIsExist() == null ? other.getIsExist() == null : this.getIsExist().equals(other.getIsExist()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getBrand() == null ? other.getBrand() == null : this.getBrand().equals(other.getBrand()))
            && (this.getUseCount() == null ? other.getUseCount() == null : this.getUseCount().equals(other.getUseCount()))
            && (this.getOutStoreTime() == null ? other.getOutStoreTime() == null : this.getOutStoreTime().equals(other.getOutStoreTime()))
            && (this.getInStoreTime() == null ? other.getInStoreTime() == null : this.getInStoreTime().equals(other.getInStoreTime()))
            && (this.getLastOperaId() == null ? other.getLastOperaId() == null : this.getLastOperaId().equals(other.getLastOperaId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMouldNo() == null) ? 0 : getMouldNo().hashCode());
        result = prime * result + ((getMouldName() == null) ? 0 : getMouldName().hashCode());
        result = prime * result + ((getTerminalOld() == null) ? 0 : getTerminalOld().hashCode());
        result = prime * result + ((getTerminalNew() == null) ? 0 : getTerminalNew().hashCode());
        result = prime * result + ((getCurrQuantity() == null) ? 0 : getCurrQuantity().hashCode());
        result = prime * result + ((getIsExist() == null) ? 0 : getIsExist().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBrand() == null) ? 0 : getBrand().hashCode());
        result = prime * result + ((getUseCount() == null) ? 0 : getUseCount().hashCode());
        result = prime * result + ((getOutStoreTime() == null) ? 0 : getOutStoreTime().hashCode());
        result = prime * result + ((getInStoreTime() == null) ? 0 : getInStoreTime().hashCode());
        result = prime * result + ((getLastOperaId() == null) ? 0 : getLastOperaId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mouldNo=").append(mouldNo);
        sb.append(", mouldName=").append(mouldName);
        sb.append(", terminalOld=").append(terminalOld);
        sb.append(", terminalNew=").append(terminalNew);
        sb.append(", currQuantity=").append(currQuantity);
        sb.append(", isExist=").append(isExist);
        sb.append(", address=").append(address);
        sb.append(", status=").append(status);
        sb.append(", brand=").append(brand);
        sb.append(", useCount=").append(useCount);
        sb.append(", outStoreTime=").append(outStoreTime);
        sb.append(", inStoreTime=").append(inStoreTime);
        sb.append(", lastOperaId=").append(lastOperaId);
        sb.append(", createTime=").append(createTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}