package co.istad.mobilebanking.api.accounttype;

import co.istad.mobilebanking.api.accounttype.web.AccountTypeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountTypeServiceIpm implements AccountTypeServices{

    private final AccountTypeMapper  accountTypeMapper;
    private final AccountTypeMapStruct accountTypeMapStruct;
    @Override
    public List<AccountTypeDto> findAll() {
        List <AccountTypes> accountTypes = accountTypeMapper.selectAllAccountTypes();
        return accountTypeMapStruct.ModelToDto(accountTypes);
    }
}

