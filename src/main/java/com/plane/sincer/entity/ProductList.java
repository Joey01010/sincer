package com.plane.sincer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * @TableName pd_list
 */
@TableName(value = "pd_list")
@Data
public class ProductList implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     *
     */
    private String pdId;

    /**
     *
     */
    private String pdLine;

    /**
     *
     */
    private String type;

    /**
     *
     */
    private String pdCode;

    /**
     *
     */
    private String pdName;

    /**
     *
     */
    private String spec;

    /**
     *
     */
    private Double ct;

    /**
     *
     */
    private Integer count;

    /**
     *
     */
    private String processNo;

    /**
     *
     */
    private Integer assist;

    /**
     *
     */
    private String mcCode;

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
        ProductList other = (ProductList) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getPdId() == null ? other.getPdId() == null : this.getPdId().equals(other.getPdId()))
                && (this.getPdLine() == null ? other.getPdLine() == null : this.getPdLine().equals(other.getPdLine()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getPdCode() == null ? other.getPdCode() == null : this.getPdCode().equals(other.getPdCode()))
                && (this.getPdName() == null ? other.getPdName() == null : this.getPdName().equals(other.getPdName()))
                && (this.getSpec() == null ? other.getSpec() == null : this.getSpec().equals(other.getSpec()))
                && (this.getCt() == null ? other.getCt() == null : this.getCt().equals(other.getCt()))
                && (this.getCount() == null ? other.getCount() == null : this.getCount().equals(other.getCount()))
                && (this.getProcessNo() == null ? other.getProcessNo() == null : this.getProcessNo().equals(other.getProcessNo()))
                && (this.getAssist() == null ? other.getAssist() == null : this.getAssist().equals(other.getAssist()))
                && (this.getMcCode() == null ? other.getMcCode() == null : this.getMcCode().equals(other.getMcCode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPdId() == null) ? 0 : getPdId().hashCode());
        result = prime * result + ((getPdLine() == null) ? 0 : getPdLine().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getPdCode() == null) ? 0 : getPdCode().hashCode());
        result = prime * result + ((getPdName() == null) ? 0 : getPdName().hashCode());
        result = prime * result + ((getSpec() == null) ? 0 : getSpec().hashCode());
        result = prime * result + ((getCt() == null) ? 0 : getCt().hashCode());
        result = prime * result + ((getCount() == null) ? 0 : getCount().hashCode());
        result = prime * result + ((getProcessNo() == null) ? 0 : getProcessNo().hashCode());
        result = prime * result + ((getAssist() == null) ? 0 : getAssist().hashCode());
        result = prime * result + ((getMcCode() == null) ? 0 : getMcCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pdId=").append(pdId);
        sb.append(", pdLine=").append(pdLine);
        sb.append(", type=").append(type);
        sb.append(", pdCode=").append(pdCode);
        sb.append(", pdName=").append(pdName);
        sb.append(", spec=").append(spec);
        sb.append(", ct=").append(ct);
        sb.append(", count=").append(count);
        sb.append(", processNo=").append(processNo);
        sb.append(", assist=").append(assist);
        sb.append(", mcCode=").append(mcCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}