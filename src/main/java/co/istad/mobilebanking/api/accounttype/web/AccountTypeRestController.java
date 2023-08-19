package co.istad.mobilebanking.api.accounttype.web;

import co.istad.mobilebanking.api.accounttype.AccountTypeServices;
import co.istad.mobilebanking.base.BaseRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/account-types")
public class AccountTypeRestController {
    private final AccountTypeServices accountTypeServices;

    @GetMapping
    public BaseRest<?> findAllUsers() {
        var accountTypeDtoList  = accountTypeServices.findAllUsers();
       return BaseRest.builder()
               .status(true)
               .code(HttpStatus.OK.value())
               .message("Account Types have been found")
               .timestamp(LocalDateTime.now())
               .data(accountTypeDtoList)
               .build();
    }

    @GetMapping("/{id}")
    public BaseRest<?> findById(@PathVariable Integer id){
        AccountTypeDto accountType = accountTypeServices.findById(id);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Account Type has been found!")
                .timestamp(LocalDateTime.now())
                .data(accountType)
                .build();
    }
//    TODO: deleteById
    @DeleteMapping("/{id}")
    public BaseRest<?> deleteById(@PathVariable Integer id){
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Account Type has been deleted successfully!!")
                .timestamp(LocalDateTime.now())
                .data(accountTypeServices.deleteById(id))
                .build();
    }
//    TODO: updateByID
    @PutMapping("/{id}")
    public BaseRest<?> updateById (@PathVariable Integer id, @RequestBody AccountTypeDto accountTypeDto){
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Account type has been updated successfully!")
                .timestamp(LocalDateTime.now())
                .data(accountTypeServices.updateById(id,accountTypeDto))
                .build();
    }
//    TODO: addNewAccountType
    @PostMapping
    public BaseRest<?> addNewAccountType(@RequestBody AccountTypeDto accountTypeDto){
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Account type have been create successfully!")
                .timestamp(LocalDateTime.now())
                .data(accountTypeServices.addNewAccountType(accountTypeDto))
                .build();
    }
}
