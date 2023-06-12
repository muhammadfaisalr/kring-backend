package id.muhammadfaisal.kring.model.request.user;

public class CreateStoreRequest {
    private String name;
    private String bio;
    private String avatarImg;
    private String coverImg;
    private Integer minimumOrder;
    private Integer cityId;
    private String address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatarImg() {
        return avatarImg;
    }

    public void setAvatarImg(String avatarImg) {
        this.avatarImg = avatarImg;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Integer getMinimumOrder() {
        return minimumOrder;
    }

    public void setMinimumOrder(Integer minimumOrder) {
        this.minimumOrder = minimumOrder;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
