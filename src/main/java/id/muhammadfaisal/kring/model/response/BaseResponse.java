package id.muhammadfaisal.kring.model.response;

import id.muhammadfaisal.kring.helper.Messages;

public class BaseResponse {
    private int code;
    private String message;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static BaseResponse success() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(200);
        baseResponse.setMessage(Messages.MESSAGE_OK);
        return baseResponse;
    }
}
