package com.plane.sincer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @TableName pd_record
 */
@TableName(value = "pd_record")
@Data
public class ProductRecord implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date pdDate;

    /**
     *
     */
    private String pdId;

    /**
     *
     */
    private Integer planOp;

    /**
     *
     */
    private Integer planTime;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone ="GMT+8")
    private Date startTime;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone ="GMT+8")
    private Date endTime;

    /**
     *
     */
    private Integer restTime;

    /**
     *
     */
    private Integer useTime;

    /**
     *
     */
    private String className;

    /**
     *
     */
    private Integer saveCount;

    /**
     *
     */
    private Integer ruinCount;

    /**
     *
     */
    private Integer halfRuinCount;

    /**
     *
     */
    private Integer refuseCount;

    /**
     *
     */
    private String pdStaff;

    /**
     * 班会消耗的分钟数
     */
    private Integer bfClassMt;

    /**
     * 点检消耗的时间
     */
    private Integer bfStart;

    /**
     * 品质确认消耗的时间
     */
    private Integer qcTime;

    /**
     *
     */
    private Integer threeS;

    /**
     * 设备保养消耗的时间
     */
    private Integer dvTime;

    /**
     * 新品调试
     */
    private Integer newCmTime;

    /**
     *
     */
    private Integer custmCm;

    /**
     *
     */
    private Integer planStop;

    /**
     *
     */
    private Integer dvBroken;

    /**
     * 单品缺料
     */
    private Integer lackTime;

    /**
     *
     */
    private Integer dlWait;

    /**
     * 品质异常
     */
    private Integer anQa;

    /**
     *
     */
    private Integer remark;

    @TableField(exist = false)
    private ProductRecordResult result;

    @TableField(exist = false)
    private ProductList productList;

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
        ProductRecord other = (ProductRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getPdDate() == null ? other.getPdDate() == null : this.getPdDate().equals(other.getPdDate()))
                && (this.getPdId() == null ? other.getPdId() == null : this.getPdId().equals(other.getPdId()))
                && (this.getPlanOp() == null ? other.getPlanOp() == null : this.getPlanOp().equals(other.getPlanOp()))
                && (this.getPlanTime() == null ? other.getPlanTime() == null : this.getPlanTime().equals(other.getPlanTime()))
                && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
                && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
                && (this.getRestTime() == null ? other.getRestTime() == null : this.getRestTime().equals(other.getRestTime()))
                && (this.getUseTime() == null ? other.getUseTime() == null : this.getUseTime().equals(other.getUseTime()))
                && (this.getClassName() == null ? other.getClassName() == null : this.getClassName().equals(other.getClassName()))
                && (this.getSaveCount() == null ? other.getSaveCount() == null : this.getSaveCount().equals(other.getSaveCount()))
                && (this.getRuinCount() == null ? other.getRuinCount() == null : this.getRuinCount().equals(other.getRuinCount()))
                && (this.getHalfRuinCount() == null ? other.getHalfRuinCount() == null : this.getHalfRuinCount().equals(other.getHalfRuinCount()))
                && (this.getRefuseCount() == null ? other.getRefuseCount() == null : this.getRefuseCount().equals(other.getRefuseCount()))
                && (this.getPdStaff() == null ? other.getPdStaff() == null : this.getPdStaff().equals(other.getPdStaff()))
                && (this.getBfClassMt() == null ? other.getBfClassMt() == null : this.getBfClassMt().equals(other.getBfClassMt()))
                && (this.getBfStart() == null ? other.getBfStart() == null : this.getBfStart().equals(other.getBfStart()))
                && (this.getQcTime() == null ? other.getQcTime() == null : this.getQcTime().equals(other.getQcTime()))
                && (this.getThreeS() == null ? other.getThreeS() == null : this.getThreeS().equals(other.getThreeS()))
                && (this.getDvTime() == null ? other.getDvTime() == null : this.getDvTime().equals(other.getDvTime()))
                && (this.getNewCmTime() == null ? other.getNewCmTime() == null : this.getNewCmTime().equals(other.getNewCmTime()))
                && (this.getCustmCm() == null ? other.getCustmCm() == null : this.getCustmCm().equals(other.getCustmCm()))
                && (this.getPlanStop() == null ? other.getPlanStop() == null : this.getPlanStop().equals(other.getPlanStop()))
                && (this.getDvBroken() == null ? other.getDvBroken() == null : this.getDvBroken().equals(other.getDvBroken()))
                && (this.getLackTime() == null ? other.getLackTime() == null : this.getLackTime().equals(other.getLackTime()))
                && (this.getDlWait() == null ? other.getDlWait() == null : this.getDlWait().equals(other.getDlWait()))
                && (this.getAnQa() == null ? other.getAnQa() == null : this.getAnQa().equals(other.getAnQa()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPdDate() == null) ? 0 : getPdDate().hashCode());
        result = prime * result + ((getPdId() == null) ? 0 : getPdId().hashCode());
        result = prime * result + ((getPlanOp() == null) ? 0 : getPlanOp().hashCode());
        result = prime * result + ((getPlanTime() == null) ? 0 : getPlanTime().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getRestTime() == null) ? 0 : getRestTime().hashCode());
        result = prime * result + ((getUseTime() == null) ? 0 : getUseTime().hashCode());
        result = prime * result + ((getClassName() == null) ? 0 : getClassName().hashCode());
        result = prime * result + ((getSaveCount() == null) ? 0 : getSaveCount().hashCode());
        result = prime * result + ((getRuinCount() == null) ? 0 : getRuinCount().hashCode());
        result = prime * result + ((getHalfRuinCount() == null) ? 0 : getHalfRuinCount().hashCode());
        result = prime * result + ((getRefuseCount() == null) ? 0 : getRefuseCount().hashCode());
        result = prime * result + ((getPdStaff() == null) ? 0 : getPdStaff().hashCode());
        result = prime * result + ((getBfClassMt() == null) ? 0 : getBfClassMt().hashCode());
        result = prime * result + ((getBfStart() == null) ? 0 : getBfStart().hashCode());
        result = prime * result + ((getQcTime() == null) ? 0 : getQcTime().hashCode());
        result = prime * result + ((getThreeS() == null) ? 0 : getThreeS().hashCode());
        result = prime * result + ((getDvTime() == null) ? 0 : getDvTime().hashCode());
        result = prime * result + ((getNewCmTime() == null) ? 0 : getNewCmTime().hashCode());
        result = prime * result + ((getCustmCm() == null) ? 0 : getCustmCm().hashCode());
        result = prime * result + ((getPlanStop() == null) ? 0 : getPlanStop().hashCode());
        result = prime * result + ((getDvBroken() == null) ? 0 : getDvBroken().hashCode());
        result = prime * result + ((getLackTime() == null) ? 0 : getLackTime().hashCode());
        result = prime * result + ((getDlWait() == null) ? 0 : getDlWait().hashCode());
        result = prime * result + ((getAnQa() == null) ? 0 : getAnQa().hashCode());
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
        sb.append(", pdDate=").append(pdDate);
        sb.append(", pdId=").append(pdId);
        sb.append(", planOp=").append(planOp);
        sb.append(", planTime=").append(planTime);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", restTime=").append(restTime);
        sb.append(", useTime=").append(useTime);
        sb.append(", className=").append(className);
        sb.append(", saveCount=").append(saveCount);
        sb.append(", ruinCount=").append(ruinCount);
        sb.append(", halfRuinCount=").append(halfRuinCount);
        sb.append(", refuseCount=").append(refuseCount);
        sb.append(", pdStaff=").append(pdStaff);
        sb.append(", bfClassMt=").append(bfClassMt);
        sb.append(", bfStart=").append(bfStart);
        sb.append(", qcTime=").append(qcTime);
        sb.append(", threeS=").append(threeS);
        sb.append(", dvTime=").append(dvTime);
        sb.append(", newCmTime=").append(newCmTime);
        sb.append(", custmCm=").append(custmCm);
        sb.append(", planStop=").append(planStop);
        sb.append(", dvBroken=").append(dvBroken);
        sb.append(", lackTime=").append(lackTime);
        sb.append(", dlWait=").append(dlWait);
        sb.append(", anQa=").append(anQa);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}