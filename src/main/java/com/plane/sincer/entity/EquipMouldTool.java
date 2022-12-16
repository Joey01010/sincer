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
    @TableId
    private Integer id;

    /**
     * 端子旧编号
     */
    private String terminalOld;

    /**
     * 端子新编号
     */
    private String terminalNew;

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
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 备注
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
            && (this.getTerminalOld() == null ? other.getTerminalOld() == null : this.getTerminalOld().equals(other.getTerminalOld()))
            && (this.getTerminalNew() == null ? other.getTerminalNew() == null : this.getTerminalNew().equals(other.getTerminalNew()))
            && (this.getLineUp() == null ? other.getLineUp() == null : this.getLineUp().equals(other.getLineUp()))
            && (this.getLineDown() == null ? other.getLineDown() == null : this.getLineDown().equals(other.getLineDown()))
            && (this.getIsolateUp() == null ? other.getIsolateUp() == null : this.getIsolateUp().equals(other.getIsolateUp()))
            && (this.getIsolateDown() == null ? other.getIsolateDown() == null : this.getIsolateDown().equals(other.getIsolateDown()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTerminalOld() == null) ? 0 : getTerminalOld().hashCode());
        result = prime * result + ((getTerminalNew() == null) ? 0 : getTerminalNew().hashCode());
        result = prime * result + ((getLineUp() == null) ? 0 : getLineUp().hashCode());
        result = prime * result + ((getLineDown() == null) ? 0 : getLineDown().hashCode());
        result = prime * result + ((getIsolateUp() == null) ? 0 : getIsolateUp().hashCode());
        result = prime * result + ((getIsolateDown() == null) ? 0 : getIsolateDown().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
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
        sb.append(", terminalOld=").append(terminalOld);
        sb.append(", terminalNew=").append(terminalNew);
        sb.append(", lineUp=").append(lineUp);
        sb.append(", lineDown=").append(lineDown);
        sb.append(", isolateUp=").append(isolateUp);
        sb.append(", isolateDown=").append(isolateDown);
        sb.append(", address=").append(address);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}