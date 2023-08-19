package co.istad.mobilebanking.api.accounttype;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class AccountTypeProvider {
    private final String tableName = "account_types";

    public String buildSelectAllAccountTypesSql() {
       return new SQL(){{
          SELECT("*");
          FROM(tableName);
       }}.toString();
    }

//    SelectById
    public String buildSelectByIdSql(){
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
            WHERE("id = #{id}");
        }}.toString();
    }
//    deleteById
    public String buildDeleteById(){
        return new SQL(){{
            DELETE_FROM(tableName);
            WHERE("id = #{id}");
        }}.toString();
    }
//    updateById
    public String buildUpdateById(@Param("act") AccountTypes accountTypes){
        return new SQL(){{
            UPDATE(tableName);
            SET("name = #{act.name}");
            WHERE("id = #{act.id}");
        }}.toString();
    }

//    insert
    public String buildInsertSql(@Param("act") AccountTypes accountTypes){
        return new SQL(){{
            INSERT_INTO(tableName);
            VALUES("name", "#{act.name}");
        }}.toString();
    }
}
