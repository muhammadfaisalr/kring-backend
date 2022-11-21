package id.muhammadfaisal.kring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

public class BaseEntity {
    @Column(name = "create_date")
    private String createDate;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "modified_date")
    private String modifiedDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
