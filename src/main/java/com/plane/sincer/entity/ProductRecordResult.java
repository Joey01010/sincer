package com.plane.sincer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName pd_rec_result
 */
@TableName(value = "pd_rec_result")
@Data
public class ProductRecordResult implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     *
     */
    private Integer recId;

    /**
     *
     */
    private Integer opTime;

    /**
     *
     */
    private Integer loadTime;

    /**
     *
     */
    private Integer processTime;

    /**
     *
     */
    private Double theoryRate;

    /**
     *
     */
    private Double timeRate;

    /**
     *
     */
    private Double performanceRate;

    /**
     *
     */
    private Integer passPdCount;

    /**
     *
     */
    private Double theoryHigh;

    /**
     *
     */
    private Double passRate;

    /**
     *
     */
    private Double dvUseRate;

    /**
     *
     */
    private Double realCt;

    /**
     *
     */
    private Integer sumPoint;

    /**
     *
     */
    private Double theoryPerTime;

    /**
     *
     */
    private Double dvCompRate;

    /**
     *
     */
    private Double realHigh;

    /**
     *
     */
    private Double overRate;

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
        ProductRecordResult other = (ProductRecordResult) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getRecId() == null ? other.getRecId() == null : this.getRecId().equals(other.getRecId()))
                && (this.getOpTime() == null ? other.getOpTime() == null : this.getOpTime().equals(other.getOpTime()))
                && (this.getLoadTime() == null ? other.getLoadTime() == null : this.getLoadTime().equals(other.getLoadTime()))
                && (this.getProcessTime() == null ? other.getProcessTime() == null : this.getProcessTime().equals(other.getProcessTime()))
                && (this.getTheoryRate() == null ? other.getTheoryRate() == null : this.getTheoryRate().equals(other.getTheoryRate()))
                && (this.getTimeRate() == null ? other.getTimeRate() == null : this.getTimeRate().equals(other.getTimeRate()))
                && (this.getPerformanceRate() == null ? other.getPerformanceRate() == null : this.getPerformanceRate().equals(other.getPerformanceRate()))
                && (this.getPassPdCount() == null ? other.getPassPdCount() == null : this.getPassPdCount().equals(other.getPassPdCount()))
                && (this.getTheoryHigh() == null ? other.getTheoryHigh() == null : this.getTheoryHigh().equals(other.getTheoryHigh()))
                && (this.getPassRate() == null ? other.getPassRate() == null : this.getPassRate().equals(other.getPassRate()))
                && (this.getDvUseRate() == null ? other.getDvUseRate() == null : this.getDvUseRate().equals(other.getDvUseRate()))
                && (this.getRealCt() == null ? other.getRealCt() == null : this.getRealCt().equals(other.getRealCt()))
                && (this.getSumPoint() == null ? other.getSumPoint() == null : this.getSumPoint().equals(other.getSumPoint()))
                && (this.getTheoryPerTime() == null ? other.getTheoryPerTime() == null : this.getTheoryPerTime().equals(other.getTheoryPerTime()))
                && (this.getDvCompRate() == null ? other.getDvCompRate() == null : this.getDvCompRate().equals(other.getDvCompRate()))
                && (this.getRealHigh() == null ? other.getRealHigh() == null : this.getRealHigh().equals(other.getRealHigh()))
                && (this.getOverRate() == null ? other.getOverRate() == null : this.getOverRate().equals(other.getOverRate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRecId() == null) ? 0 : getRecId().hashCode());
        result = prime * result + ((getOpTime() == null) ? 0 : getOpTime().hashCode());
        result = prime * result + ((getLoadTime() == null) ? 0 : getLoadTime().hashCode());
        result = prime * result + ((getProcessTime() == null) ? 0 : getProcessTime().hashCode());
        result = prime * result + ((getTheoryRate() == null) ? 0 : getTheoryRate().hashCode());
        result = prime * result + ((getTimeRate() == null) ? 0 : getTimeRate().hashCode());
        result = prime * result + ((getPerformanceRate() == null) ? 0 : getPerformanceRate().hashCode());
        result = prime * result + ((getPassPdCount() == null) ? 0 : getPassPdCount().hashCode());
        result = prime * result + ((getTheoryHigh() == null) ? 0 : getTheoryHigh().hashCode());
        result = prime * result + ((getPassRate() == null) ? 0 : getPassRate().hashCode());
        result = prime * result + ((getDvUseRate() == null) ? 0 : getDvUseRate().hashCode());
        result = prime * result + ((getRealCt() == null) ? 0 : getRealCt().hashCode());
        result = prime * result + ((getSumPoint() == null) ? 0 : getSumPoint().hashCode());
        result = prime * result + ((getTheoryPerTime() == null) ? 0 : getTheoryPerTime().hashCode());
        result = prime * result + ((getDvCompRate() == null) ? 0 : getDvCompRate().hashCode());
        result = prime * result + ((getRealHigh() == null) ? 0 : getRealHigh().hashCode());
        result = prime * result + ((getOverRate() == null) ? 0 : getOverRate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", recId=").append(recId);
        sb.append(", opTime=").append(opTime);
        sb.append(", loadTime=").append(loadTime);
        sb.append(", processTime=").append(processTime);
        sb.append(", theoryRate=").append(theoryRate);
        sb.append(", timeRate=").append(timeRate);
        sb.append(", performanceRate=").append(performanceRate);
        sb.append(", passPdCount=").append(passPdCount);
        sb.append(", theoryHigh=").append(theoryHigh);
        sb.append(", passRate=").append(passRate);
        sb.append(", dvUseRate=").append(dvUseRate);
        sb.append(", realCt=").append(realCt);
        sb.append(", sumPoint=").append(sumPoint);
        sb.append(", theoryPerTime=").append(theoryPerTime);
        sb.append(", dvCompRate=").append(dvCompRate);
        sb.append(", realHigh=").append(realHigh);
        sb.append(", overRate=").append(overRate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}