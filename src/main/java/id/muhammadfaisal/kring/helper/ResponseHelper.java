package id.muhammadfaisal.kring.helper;

import id.muhammadfaisal.kring.model.response.BaseResponse;

public class ResponseHelper {
    public static BaseResponse responseOk(BaseResponse baseResponse) {
        baseResponse.setCode(200);
        baseResponse.setMessage("Sukses");
        return baseResponse;
    }

    public static BaseResponse responseError(BaseResponse baseResponse, int code, String message) {
        baseResponse.setCode(code);
        baseResponse.setMessage(message);

        return baseResponse;
    }
}
