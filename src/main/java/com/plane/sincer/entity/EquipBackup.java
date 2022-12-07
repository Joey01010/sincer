package com.plane.sincer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName equip_backup
 */
@TableName(value ="equip_backup")
@Data
public class EquipBackup implements Serializable {
    /**
     * 序号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 备品编号
     */
    private String code;

    /**
     * 备品名称
     */
    private String name;

    /**
     * 规格
     */
    private String spec;

    /**
     * 地址
     */
    private String address;

    /**
     * 最大库存
     */
    private Integer maxQuantity;

    /**
     * 最小库存
     */
    private Integer minQuantity;

    /**
     * 现有库存
     */
    private Integer currQuantity;

    /**
     * 单位
     */
    private String unit;

    /**
     * 设备类型
     */
    private String type;

    /**
     * 品牌
     */
    private String brand;

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
        EquipBackup other = (EquipBackup) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSpec() == null ? other.getSpec() == null : this.getSpec().equals(other.getSpec()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getMaxQuantity() == null ? other.getMaxQuantity() == null : this.getMaxQuantity().equals(other.getMaxQuantity()))
            && (this.getMinQuantity() == null ? other.getMinQuantity() == null : this.getMinQuantity().equals(other.getMinQuantity()))
            && (this.getCurrQuantity() == null ? other.getCurrQuantity() == null : this.getCurrQuantity().equals(other.getCurrQuantity()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getBrand() == null ? other.getBrand() == null : this.getBrand().equals(other.getBrand()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSpec() == null) ? 0 : getSpec().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getMaxQuantity() == null) ? 0 : getMaxQuantity().hashCode());
        result = prime * result + ((getMinQuantity() == null) ? 0 : getMinQuantity().hashCode());
        result = prime * result + ((getCurrQuantity() == null) ? 0 : getCurrQuantity().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getBrand() == null) ? 0 : getBrand().hashCode());
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
        sb.append(", spec=").append(spec);
        sb.append(", address=").append(address);
        sb.append(", maxQuantity=").append(maxQuantity);
        sb.append(", minQuantity=").append(minQuantity);
        sb.append(", currQuantity=").append(currQuantity);
        sb.append(", unit=").append(unit);
        sb.append(", type=").append(type);
        sb.append(", brand=").append(brand);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}