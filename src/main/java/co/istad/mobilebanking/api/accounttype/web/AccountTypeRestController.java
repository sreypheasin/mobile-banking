package co.istad.mobilebanking.api.accounttype.web;

import co.istad.mobilebanking.api.accounttype.AccountTypeServices;
import co.istad.mobilebanking.base.BaseRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/account-types")
public class AccountTypeRestController {
    private final AccountTypeServices accountTypeServices;

    @GetMapping
    public BaseRest<?> findAll() {
        var accountTypeDtoList  = accountTypeServices.findAll();
       return BaseRest.builder()
               .status(true)
               .code(HttpStatus.OK.value())
               .message("Success")
               .timestamp(LocalDateTime.now())
               .data(accountTypeDtoList)
               .build();
    }
}
