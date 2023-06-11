package id.muhammadfaisal.kring.entity;

import javax.persistence.*;

@Entity
@Table(name = "m_store")
public class StoreEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "bio")
    private String bio;

    @Column(name = "avatar_img")
    private String avatarImage;

    @Column(name = "cover_img")
    private String coverImage;

    @Column(name = "seller_id")
    private long sellerId;

    @Column(name = "minimum_order")
    private int minimumOrder;

    @Column(name = "city_id")
    private int cityId;

    @Column(name = "address")
    private String address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(String avatarImage) {
        this.avatarImage = avatarImage;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public int getMinimumOrder() {
        return minimumOrder;
    }

    public void setMinimumOrder(int minimumOrder) {
        this.minimumOrder = minimumOrder;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
