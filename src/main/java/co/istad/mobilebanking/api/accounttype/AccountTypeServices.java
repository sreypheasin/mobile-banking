package co.istad.mobilebanking.api.accounttype;

import co.istad.mobilebanking.api.accounttype.web.AccountTypeDto;

import java.util.List;

public interface AccountTypeServices {
    List<AccountTypeDto> findAll();
}
