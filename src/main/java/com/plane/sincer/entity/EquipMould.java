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
    private String code;

    /**
     * 模具名称
     */
    private String name;

    /**
     * 端子旧编码
     */
    private String teminalOld;

    /**
     * 端子新编码
     */
    private String teminalNew;

    /**
     * 现有库存
     */
    private Integer currQuanlity;

    /**
     * O：不存在，1：存在
     */
    private Integer isExist;

    /**
     * 地址
     */
    private String address;

    /**
     * 0：不可用状态，1：可用状态
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
     * 操作人员id
     */
    private String operaId;

    /**
     * 备注补充
     */
    private String remark;

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
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTeminalOld() == null ? other.getTeminalOld() == null : this.getTeminalOld().equals(other.getTeminalOld()))
            && (this.getTeminalNew() == null ? other.getTeminalNew() == null : this.getTeminalNew().equals(other.getTeminalNew()))
            && (this.getCurrQuanlity() == null ? other.getCurrQuanlity() == null : this.getCurrQuanlity().equals(other.getCurrQuanlity()))
            && (this.getIsExist() == null ? other.getIsExist() == null : this.getIsExist().equals(other.getIsExist()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getBrand() == null ? other.getBrand() == null : this.getBrand().equals(other.getBrand()))
            && (this.getUseCount() == null ? other.getUseCount() == null : this.getUseCount().equals(other.getUseCount()))
            && (this.getOutStoreTime() == null ? other.getOutStoreTime() == null : this.getOutStoreTime().equals(other.getOutStoreTime()))
            && (this.getInStoreTime() == null ? other.getInStoreTime() == null : this.getInStoreTime().equals(other.getInStoreTime()))
            && (this.getOperaId() == null ? other.getOperaId() == null : this.getOperaId().equals(other.getOperaId()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTeminalOld() == null) ? 0 : getTeminalOld().hashCode());
        result = prime * result + ((getTeminalNew() == null) ? 0 : getTeminalNew().hashCode());
        result = prime * result + ((getCurrQuanlity() == null) ? 0 : getCurrQuanlity().hashCode());
        result = prime * result + ((getIsExist() == null) ? 0 : getIsExist().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBrand() == null) ? 0 : getBrand().hashCode());
        result = prime * result + ((getUseCount() == null) ? 0 : getUseCount().hashCode());
        result = prime * result + ((getOutStoreTime() == null) ? 0 : getOutStoreTime().hashCode());
        result = prime * result + ((getInStoreTime() == null) ? 0 : getInStoreTime().hashCode());
        result = prime * result + ((getOperaId() == null) ? 0 : getOperaId().hashCode());
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
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", teminalOld=").append(teminalOld);
        sb.append(", teminalNew=").append(teminalNew);
        sb.append(", currQuanlity=").append(currQuanlity);
        sb.append(", isExist=").append(isExist);
        sb.append(", address=").append(address);
        sb.append(", status=").append(status);
        sb.append(", brand=").append(brand);
        sb.append(", useCount=").append(useCount);
        sb.append(", outStoreTime=").append(outStoreTime);
        sb.append(", inStoreTime=").append(inStoreTime);
        sb.append(", operaId=").append(operaId);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}