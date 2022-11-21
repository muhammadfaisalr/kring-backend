package id.muhammadfaisal.kring.model.request;

public class BaseRequest {
    private String createDate;
    private String createBy;
    private String modifiedBy;
    private String modifiedDate;

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
