package id.muhammadfaisal.kring.controller;

import id.muhammadfaisal.kring.entity.StoreEntity;
import id.muhammadfaisal.kring.entity.UserEntity;
import id.muhammadfaisal.kring.helper.ResponseHelper;
import id.muhammadfaisal.kring.model.request.store.StoresRequest;
import id.muhammadfaisal.kring.model.response.BaseResponse;
import id.muhammadfaisal.kring.repo.StoreRepository;
import id.muhammadfaisal.kring.repo.UserRepository;
import id.muhammadfaisal.kring.util.KeyCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/store")
public class StoreController {

    @Autowired
    public StoreRepository storeRepository;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public Environment environment;

    @PostMapping("/all")
    public ResponseEntity<BaseResponse> getStores(@Validated @RequestBody StoresRequest request) {
        BaseResponse baseResponse = BaseResponse.success();

        try {
            UserEntity userEntity = this.validateSession(request.getSession());

            if (userEntity == null) {
                //If Session Get Null or Not Found
                ResponseHelper.responseError(baseResponse, KeyCodes.ErrorCode.SESSION_NOT_FOUND, KeyCodes.ErrorMessage.ERR_400);
            } else {
                List<StoreEntity> entity = this.storeRepository.stores();
                baseResponse.setData(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ResponseHelper.responseError(baseResponse, KeyCodes.ErrorCode.INTERNAL_SERVER_ERROR, KeyCodes.ErrorMessage.ERR_500);
        }

        return ResponseEntity.ok(baseResponse);
    }

    private UserEntity validateSession(String session) {
        return this.userRepository.findBySession(session);
    }
}
