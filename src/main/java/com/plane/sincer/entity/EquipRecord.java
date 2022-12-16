package com.plane.sincer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * 
 * @TableName equip_record
 */
@TableName(value ="equip_record")
@Data
public class EquipRecord implements Serializable {
    /**
     * 序号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 设备名称
     */
    private Integer equipId;

    /**
     * 生产日期
     */
    private Date pdDate;

    /**
     * 总生产数
     */
    private Integer totalOp;

    /**
     * 总良品率
     */
    private Integer totalPassOp;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 备注
     */
    private String remark;

    @TableField(exist = false)
    private List<EquipPdRecord> equipPdRecordList;

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
        EquipRecord other = (EquipRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEquipId() == null ? other.getEquipId() == null : this.getEquipId().equals(other.getEquipId()))
            && (this.getPdDate() == null ? other.getPdDate() == null : this.getPdDate().equals(other.getPdDate()))
            && (this.getTotalOp() == null ? other.getTotalOp() == null : this.getTotalOp().equals(other.getTotalOp()))
            && (this.getTotalPassOp() == null ? other.getTotalPassOp() == null : this.getTotalPassOp().equals(other.getTotalPassOp()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEquipId() == null) ? 0 : getEquipId().hashCode());
        result = prime * result + ((getPdDate() == null) ? 0 : getPdDate().hashCode());
        result = prime * result + ((getTotalOp() == null) ? 0 : getTotalOp().hashCode());
        result = prime * result + ((getTotalPassOp() == null) ? 0 : getTotalPassOp().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
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
        sb.append(", equipId=").append(equipId);
        sb.append(", pdDate=").append(pdDate);
        sb.append(", totalOp=").append(totalOp);
        sb.append(", totalPassOp=").append(totalPassOp);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}