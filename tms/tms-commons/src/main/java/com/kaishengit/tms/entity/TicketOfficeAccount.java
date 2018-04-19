package com.kaishengit.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ticket_office_account
 * @author 
 */
public class TicketOfficeAccount implements Serializable {
    /**
     * 售票点帐号主键
     */
    private Integer id;

    private String ticketOfficeAccountName;

    private String ticketOfficeAccountPassword;

    /**
     * 创建时间
     */
    private Date createTime;

    private Date updateTime;

    /**
     * 帐号状态
     */
    private String status;

    private Integer ticketOfficeInfermationId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTicketOfficeAccountName() {
        return ticketOfficeAccountName;
    }

    public void setTicketOfficeAccountName(String ticketOfficeAccountName) {
        this.ticketOfficeAccountName = ticketOfficeAccountName;
    }

    public String getTicketOfficeAccountPassword() {
        return ticketOfficeAccountPassword;
    }

    public void setTicketOfficeAccountPassword(String ticketOfficeAccountPassword) {
        this.ticketOfficeAccountPassword = ticketOfficeAccountPassword;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTicketOfficeInfermationId() {
        return ticketOfficeInfermationId;
    }

    public void setTicketOfficeInfermationId(Integer ticketOfficeInfermationId) {
        this.ticketOfficeInfermationId = ticketOfficeInfermationId;
    }

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
        TicketOfficeAccount other = (TicketOfficeAccount) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTicketOfficeAccountName() == null ? other.getTicketOfficeAccountName() == null : this.getTicketOfficeAccountName().equals(other.getTicketOfficeAccountName()))
            && (this.getTicketOfficeAccountPassword() == null ? other.getTicketOfficeAccountPassword() == null : this.getTicketOfficeAccountPassword().equals(other.getTicketOfficeAccountPassword()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTicketOfficeInfermationId() == null ? other.getTicketOfficeInfermationId() == null : this.getTicketOfficeInfermationId().equals(other.getTicketOfficeInfermationId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTicketOfficeAccountName() == null) ? 0 : getTicketOfficeAccountName().hashCode());
        result = prime * result + ((getTicketOfficeAccountPassword() == null) ? 0 : getTicketOfficeAccountPassword().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTicketOfficeInfermationId() == null) ? 0 : getTicketOfficeInfermationId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ticketOfficeAccountName=").append(ticketOfficeAccountName);
        sb.append(", ticketOfficeAccountPassword=").append(ticketOfficeAccountPassword);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", ticketOfficeInfermationId=").append(ticketOfficeInfermationId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}