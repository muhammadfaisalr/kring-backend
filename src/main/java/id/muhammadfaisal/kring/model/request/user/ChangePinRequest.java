package id.muhammadfaisal.kring.model.request.user;

public class ChangePinRequest {
    private long userId;
    private String oldPin;
    private String pin;
    private String pinConfirmed;

    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getOldPin() {
        return oldPin;
    }

    public void setOldPin(String oldPin) {
        this.oldPin = oldPin;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPinConfirmed() {
        return pinConfirmed;
    }

    public void setPinConfirmed(String pinConfirmed) {
        this.pinConfirmed = pinConfirmed;
    }
}
