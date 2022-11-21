package id.muhammadfaisal.kring.model.request.user;

public class VerifyPinRequest {
    private int userId;
    private String pin;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
