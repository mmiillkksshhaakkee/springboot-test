package org.example;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final String sharedKey = "SHARED_KEY";

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";

    private static final int CODE_SUCCESS = 100;
    private static final int AUTHENTICATION_FAILURE = 102;

    @GetMapping
    public BaseResponse showStatus(){
        return new BaseResponse(SUCCESS_STATUS, 1);
    }

    @PostMapping
    public BaseResponse pay(@RequestParam(value = "key") String key, @RequestBody PaymentRequest req){
        final BaseResponse response;

        if(sharedKey.equalsIgnoreCase(key)){
            int userId = req.getUserId();
            String itemId = req.getItemId();
            double discount = req.getDiscount();

            //TODO: process the request
            // ...
            // Return success response to the client
            response = new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS);
        } else {
            response = new BaseResponse(ERROR_STATUS, AUTHENTICATION_FAILURE);
        }
        return response;
    }
}
