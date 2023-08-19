package co.istad.mobilebanking.api.accounttype;

import co.istad.mobilebanking.api.accounttype.web.AccountTypeDto;
import co.istad.mobilebanking.api.users.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountTypeServiceIpm implements AccountTypeServices{

    private final AccountTypeMapper  accountTypeMapper;
    private final AccountTypeMapStruct accountTypeMapStruct;
    @Override
    public List<AccountTypeDto> findAllUsers() {
        List <AccountTypes> accountTypes = accountTypeMapper.selectAllAccountTypes();
        return accountTypeMapStruct.ModelToDto(accountTypes);
    }

//    findById
    @Override
    public AccountTypeDto findById(Integer id) {
        AccountTypes accountType= accountTypeMapper.selectById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("User with id %d is not found",id)));
        return accountTypeMapStruct.accountTypeToAccountTypeDto(accountType);
    }

//   TODO: deleteById
    @Override
    public Integer deleteById(Integer id) {
        boolean isFound = accountTypeMapper.isExisted(id);
        if(isFound){
            accountTypeMapper.deleteById(id);
            return id;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Account type with id %d not found",id));
    }

//    TODO: updateById
    @Override
    public AccountTypeDto updateById(Integer id,AccountTypeDto accountTypeDto) {
        boolean isFound = accountTypeMapper.isExisted(id);
        if(isFound){
            AccountTypes accountTypes = accountTypeMapStruct.accountTypeDtoToAccountType(accountTypeDto);
            accountTypes.setId(id);
            accountTypeMapper.updateById(accountTypes);
            return this.findById(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Account Type with id %d not found!",id));
    }

//    TODO: addNewAccountType
    @Override
    public AccountTypeDto addNewAccountType(AccountTypeDto accountTypeDto) {
        AccountTypes accountTypes = accountTypeMapStruct.accountTypeDtoToAccountType(accountTypeDto);
        accountTypeMapper.insert(accountTypes);
//        accountTypes.setName(accountTypes.getName());
        log.info("account type= {}", accountTypes.getName());
        return this.findById(accountTypes.getId());
    }
}

