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
 * @TableName equip
 */
@TableName(value ="equip")
@Data
public class Equip implements Serializable {
    /**
     * 序号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 设备生产产品编号
     */
    private String pdCode;

    /**
     * 模具id
     */
    private Integer mouldId;

    /**
     * 计划生产数量
     */
    private Integer planOp;

    /**
     * 实际生产数量
     */
    private Integer realOp;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 质检时间
     */
    private Date qcTime;

    /**
     * 设备状态id
     */
    private Integer statusId;

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
        Equip other = (Equip) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPdCode() == null ? other.getPdCode() == null : this.getPdCode().equals(other.getPdCode()))
            && (this.getMouldId() == null ? other.getMouldId() == null : this.getMouldId().equals(other.getMouldId()))
            && (this.getPlanOp() == null ? other.getPlanOp() == null : this.getPlanOp().equals(other.getPlanOp()))
            && (this.getRealOp() == null ? other.getRealOp() == null : this.getRealOp().equals(other.getRealOp()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getQcTime() == null ? other.getQcTime() == null : this.getQcTime().equals(other.getQcTime()))
            && (this.getStatusId() == null ? other.getStatusId() == null : this.getStatusId().equals(other.getStatusId()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPdCode() == null) ? 0 : getPdCode().hashCode());
        result = prime * result + ((getMouldId() == null) ? 0 : getMouldId().hashCode());
        result = prime * result + ((getPlanOp() == null) ? 0 : getPlanOp().hashCode());
        result = prime * result + ((getRealOp() == null) ? 0 : getRealOp().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getQcTime() == null) ? 0 : getQcTime().hashCode());
        result = prime * result + ((getStatusId() == null) ? 0 : getStatusId().hashCode());
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
        sb.append(", pdCode=").append(pdCode);
        sb.append(", mouldId=").append(mouldId);
        sb.append(", planOp=").append(planOp);
        sb.append(", realOp=").append(realOp);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", qcTime=").append(qcTime);
        sb.append(", statusId=").append(statusId);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}