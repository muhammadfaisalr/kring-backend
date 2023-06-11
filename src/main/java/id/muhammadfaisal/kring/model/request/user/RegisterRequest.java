package id.muhammadfaisal.kring.model.request.user;

public class RegisterRequest {
    private String name;
    private long phone;
    private String password;
    private String email;

    private String fSeller;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfSeller() {
        return fSeller;
    }

    public void setfSeller(String fSeller) {
        this.fSeller = fSeller;
    }
}
