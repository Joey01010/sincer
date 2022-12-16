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
 * 设备产品记录表
 * @TableName equip_pd_record
 */
@TableName(value ="equip_pd_record")
@Data
public class EquipPdRecord implements Serializable {
    /**
     * 序号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 端子编号
     */
    private String terminalId;

    /**
     * 设备id
     */
    private Integer equipRecordId;

    /**
     * 记录人员id
     */
    private Integer operaId;

    /**
     * 计划产量
     */
    private Integer planOp;

    /**
     * 实际产量
     */
    private Integer realOp;

    /**
     * 良品数
     */
    private Integer passOp;

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
    private User operator;

    @TableField(exist = false)
    private List<EquipPdStatus> equipPdStatuses;

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
        EquipPdRecord other = (EquipPdRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTerminalId() == null ? other.getTerminalId() == null : this.getTerminalId().equals(other.getTerminalId()))
            && (this.getEquipRecordId() == null ? other.getEquipRecordId() == null : this.getEquipRecordId().equals(other.getEquipRecordId()))
            && (this.getOperaId() == null ? other.getOperaId() == null : this.getOperaId().equals(other.getOperaId()))
            && (this.getPlanOp() == null ? other.getPlanOp() == null : this.getPlanOp().equals(other.getPlanOp()))
            && (this.getRealOp() == null ? other.getRealOp() == null : this.getRealOp().equals(other.getRealOp()))
            && (this.getPassOp() == null ? other.getPassOp() == null : this.getPassOp().equals(other.getPassOp()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTerminalId() == null) ? 0 : getTerminalId().hashCode());
        result = prime * result + ((getEquipRecordId() == null) ? 0 : getEquipRecordId().hashCode());
        result = prime * result + ((getOperaId() == null) ? 0 : getOperaId().hashCode());
        result = prime * result + ((getPlanOp() == null) ? 0 : getPlanOp().hashCode());
        result = prime * result + ((getRealOp() == null) ? 0 : getRealOp().hashCode());
        result = prime * result + ((getPassOp() == null) ? 0 : getPassOp().hashCode());
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
        sb.append(", terminalId=").append(terminalId);
        sb.append(", equipRecordId=").append(equipRecordId);
        sb.append(", operaId=").append(operaId);
        sb.append(", planOp=").append(planOp);
        sb.append(", realOp=").append(realOp);
        sb.append(", passOp=").append(passOp);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}