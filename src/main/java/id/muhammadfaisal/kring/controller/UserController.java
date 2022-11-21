package id.muhammadfaisal.kring.controller;

import id.muhammadfaisal.kring.entity.UserEntity;
import id.muhammadfaisal.kring.helper.Messages;
import id.muhammadfaisal.kring.model.request.user.ChangePinRequest;
import id.muhammadfaisal.kring.model.request.user.GeneratePinRequest;
import id.muhammadfaisal.kring.model.request.user.RegisterRequest;
import id.muhammadfaisal.kring.model.request.user.VerifyPinRequest;
import id.muhammadfaisal.kring.model.response.BaseResponse;
import id.muhammadfaisal.kring.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<BaseResponse> register(@Validated @RequestBody RegisterRequest registerRequest) {
        BaseResponse baseResponse = new BaseResponse();

        UserEntity userEntity = new UserEntity();
        userEntity.setName(registerRequest.getName());
        userEntity.setAddress(registerRequest.getAddress());
        userEntity.setPhone(registerRequest.getPhone());
        userEntity.setCityId(registerRequest.getCityId());
        userEntity.setCreateBy("SYSTEM");
        userEntity.setCreateDate(String.valueOf(LocalDateTime.now()));

        try {
            this.userRepository.save(userEntity);

            baseResponse.setCode(200);
            baseResponse.setMessage(Messages.MESSAGE_OK);
            baseResponse.setData(registerRequest);
        } catch (Exception e) {
            e.printStackTrace();

            baseResponse.setCode(500);
            baseResponse.setMessage(Messages.Error.BASE_ERROR);

            if (e.getMessage().contains("ConstraintViolationException")) {
                baseResponse.setMessage(Messages.Error.ALREADY_REGISTERED);
            }
        }


        return ResponseEntity.ok().body(baseResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> findUserById(@PathVariable(value = "id") long id) {

        Optional<UserEntity> userEntity = null;
        BaseResponse baseResponse = new BaseResponse();

        try {
            userEntity = this.userRepository.findById(id);
            baseResponse.setCode(200);
            baseResponse.setMessage(Messages.MESSAGE_OK);
            baseResponse.setData(userEntity.get());
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setCode(500);
            baseResponse.setMessage(Messages.Error.BASE_ERROR);
        }


        return ResponseEntity.ok().body(baseResponse);
    }

    @PostMapping("/create-pin")
    public ResponseEntity<BaseResponse> createPin(@Validated @RequestBody GeneratePinRequest generatePinRequest) {
        BaseResponse baseResponse = BaseResponse.success();

        try {
           if (!generatePinRequest.getPin().equals(generatePinRequest.getPinConfirmed())) {
               baseResponse.setCode(400);
               baseResponse.setMessage(Messages.Error.PIN_NOT_EQUAL);
           }

           Optional<UserEntity> optionalUserEntity = this.userRepository.findById(generatePinRequest.getUserId());

           if (optionalUserEntity.isPresent()) {
               UserEntity userEntity = optionalUserEntity.get();

               userEntity.setPin(generatePinRequest.getPin());
               userEntity.setModifiedBy("SYSTEM");
               userEntity.setModifiedBy(String.valueOf(LocalDateTime.now()));
               this.userRepository.save(userEntity);
           } else {
               baseResponse.setCode(401);
               baseResponse.setMessage(Messages.Error.BASE_ERROR);
           }

        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setCode(500);
            baseResponse.setMessage(Messages.Error.BASE_ERROR);
        }

        return ResponseEntity.ok().body(baseResponse);
    }

    @PostMapping("/update-pin")
    public ResponseEntity<BaseResponse> changePin(@Validated @RequestBody ChangePinRequest changePinRequest) {
        BaseResponse baseResponse = BaseResponse.success();

        try {
            Optional<UserEntity> optionalUserEntity = this.userRepository.findById(changePinRequest.getUserId());

            if (optionalUserEntity.isPresent()) {
                UserEntity userEntity = optionalUserEntity.get();

                if (!changePinRequest.getOldPin().equals(changePinRequest.getPin())) {
                    baseResponse.setCode(401);
                    baseResponse.setMessage(Messages.Error.OLD_PIN_WRONG);
                }

                if (!changePinRequest.getPin().equals(changePinRequest.getPinConfirmed())) {
                    baseResponse.setCode(400);
                    baseResponse.setMessage("Pin yang dikonfirmasi tidak sama.");
                }

                userEntity.setPin(changePinRequest.getPin());
                userEntity.setModifiedBy("SYSTEM");
                userEntity.setModifiedBy(String.valueOf(LocalDateTime.now()));

                this.userRepository.save(userEntity);
            } else {
                baseResponse.setCode(401);
                baseResponse.setMessage(Messages.Error.BASE_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setCode(500);
            baseResponse.setMessage(Messages.Error.BASE_ERROR);
        }

        return ResponseEntity.ok().body(baseResponse);
    }

    @PostMapping("/verify-pin")
    public ResponseEntity<BaseResponse> verifyPin(@Validated @RequestBody VerifyPinRequest verifyPinRequest) {

        BaseResponse baseResponse = BaseResponse.success();

        try {
            BigInteger isSuccess = userRepository.verifyPin(verifyPinRequest.getPin(), verifyPinRequest.getUserId());

            //isSuccess will be return null if pin is incorrect.
            if (isSuccess == null) {
                baseResponse.setCode(401);
                baseResponse.setMessage(Messages.Error.WRONG_PIN);
            }

        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setMessage(Messages.Error.BASE_ERROR);
            baseResponse.setCode(500);
        }

        return ResponseEntity.ok().body(baseResponse);
    }
}
