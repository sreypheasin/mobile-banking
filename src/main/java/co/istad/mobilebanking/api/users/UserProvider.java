package co.istad.mobilebanking.api.users;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class UserProvider {
    private final String tableName = "users";
//    TODO: select all users
    public String buildSelectAllUsersSql() {
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
        }}.toString();
    }
//    TODO: Insert a user
    public String buildInsertUserSql(@Param("u") User user){
        return new SQL(){{
            INSERT_INTO(tableName);
            VALUES("name", "#{u.name}");
            VALUES("gender", "#{u.gender}");
            VALUES("one_signal_id", "#{u.oneSignalId}");
            VALUES("is_deleted", "FALSE");
            VALUES("is_student", "#{u.isStudent}");
            if(!user.getStudentCardId().isBlank()){
                VALUES("student_card_id", "#{u.studentCardId}");
            }
        }}.toString();
    }
}
