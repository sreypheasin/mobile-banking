package co.istad.mobilebanking.api.accounttype;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

// repository
@Mapper
public interface AccountTypeMapper {
    @SelectProvider(type = AccountTypeProvider.class, method = "buildSelectAllAccountTypesSql")
//    @Results(
//            id = "accountTypeResult",
//            value = {
//                    @Result(property = "name", column = "name")
//            }
//    )
    List<AccountTypes> selectAllAccountTypes();
}
