package co.istad.mobilebanking.api.accounttype;

import co.istad.mobilebanking.api.accounttype.web.AccountTypeDto;

import java.util.List;

public interface AccountTypeServices {
    List<AccountTypeDto> findAllUsers();
    AccountTypeDto findById(Integer id);
    Integer deleteById(Integer id);
    AccountTypeDto updateById(Integer id,AccountTypeDto accountTypeDto);
    AccountTypeDto addNewAccountType (AccountTypeDto accountTypeDto);
}
