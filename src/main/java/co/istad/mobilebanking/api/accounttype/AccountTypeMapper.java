package co.istad.mobilebanking.api.accounttype;

import co.istad.mobilebanking.api.accounttype.web.AccountTypeDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

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

//    TODO: SelectById
    @SelectProvider(type = AccountTypeProvider.class, method = "buildSelectByIdSql")
    Optional<AccountTypes> selectById(@Param("id") Integer id);

//    TODO: deleteById
    @Select("SELECT EXISTS(SELECT * FROM account_types WHERE id = #{id})")
    boolean isExisted(@Param("id") Integer id);
    @DeleteProvider(type = AccountTypeProvider.class, method = "buildDeleteById")
    void deleteById (@Param("id") Integer id);

//    TODO: updateById
    @UpdateProvider(type = AccountTypeProvider.class, method = "buildUpdateById")
    void updateById(@Param("act") AccountTypes accountTypes);

//    insertAccountType

    @InsertProvider(type = AccountTypeProvider.class, method = "buildInsertSql")
    @Options(useGeneratedKeys = true, keyColumn = "id",keyProperty = "id")
    void insert(@Param("act") AccountTypes accountTypes);


}
