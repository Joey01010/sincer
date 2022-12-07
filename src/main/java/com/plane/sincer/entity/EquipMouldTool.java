package com.plane.sincer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName equip_mould_tool
 */
@TableName(value ="equip_mould_tool")
@Data
public class EquipMouldTool implements Serializable {
    /**
     * 序号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 端子旧编码
     */
    private String teminalOld;

    /**
     * 端子新编码
     */
    private String teminalNew;

    /**
     * 线芯上刀
     */
    private Integer lineUp;

    /**
     * 线芯下刀
     */
    private Integer lineDown;

    /**
     * 绝缘上刀
     */
    private Integer isolateUp;

    /**
     * 绝缘下刀
     */
    private Integer isolateDown;

    /**
     * 地址
     */
    private String address;

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
        EquipMouldTool other = (EquipMouldTool) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTeminalOld() == null ? other.getTeminalOld() == null : this.getTeminalOld().equals(other.getTeminalOld()))
            && (this.getTeminalNew() == null ? other.getTeminalNew() == null : this.getTeminalNew().equals(other.getTeminalNew()))
            && (this.getLineUp() == null ? other.getLineUp() == null : this.getLineUp().equals(other.getLineUp()))
            && (this.getLineDown() == null ? other.getLineDown() == null : this.getLineDown().equals(other.getLineDown()))
            && (this.getIsolateUp() == null ? other.getIsolateUp() == null : this.getIsolateUp().equals(other.getIsolateUp()))
            && (this.getIsolateDown() == null ? other.getIsolateDown() == null : this.getIsolateDown().equals(other.getIsolateDown()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTeminalOld() == null) ? 0 : getTeminalOld().hashCode());
        result = prime * result + ((getTeminalNew() == null) ? 0 : getTeminalNew().hashCode());
        result = prime * result + ((getLineUp() == null) ? 0 : getLineUp().hashCode());
        result = prime * result + ((getLineDown() == null) ? 0 : getLineDown().hashCode());
        result = prime * result + ((getIsolateUp() == null) ? 0 : getIsolateUp().hashCode());
        result = prime * result + ((getIsolateDown() == null) ? 0 : getIsolateDown().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
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
        sb.append(", teminalOld=").append(teminalOld);
        sb.append(", teminalNew=").append(teminalNew);
        sb.append(", lineUp=").append(lineUp);
        sb.append(", lineDown=").append(lineDown);
        sb.append(", isolateUp=").append(isolateUp);
        sb.append(", isolateDown=").append(isolateDown);
        sb.append(", address=").append(address);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}