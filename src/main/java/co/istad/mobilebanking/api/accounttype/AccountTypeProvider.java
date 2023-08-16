package co.istad.mobilebanking.api.accounttype;


import org.apache.ibatis.jdbc.SQL;

public class AccountTypeProvider {

    public String buildSelectAllAccountTypesSql() {
       return new SQL(){{
          SELECT("*");
          FROM("account_types");
       }}.toString();
    }

}
