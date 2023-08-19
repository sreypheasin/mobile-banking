package co.istad.mobilebanking.api.accounttype;

import co.istad.mobilebanking.api.accounttype.web.AccountTypeDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountTypeMapStruct {
//    TODO : convert Model to DTO
 List<AccountTypeDto> ModelToDto(List<AccountTypes> model);
 AccountTypeDto accountTypeToAccountTypeDto (AccountTypes accountTypes);
 AccountTypes accountTypeDtoToAccountType (AccountTypeDto accountTypeDto);
}
