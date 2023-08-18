package co.istad.mobilebanking.api.users;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

@RequiredArgsConstructor
public class UserProvider {
    private final String tableName = "users";
//    TODO: select all users
    public String buildSelectAllUsersSql() {
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
            WHERE("is_deleted = FALSE");
            ORDER_BY("id DESC");
        }}.toString();
    }

//    TODO: Select By ID
    public String buildFindUserByIdSql(@Param("id") Integer id){
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
            WHERE("id = #{id}", "is_deleted = FALSE");
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

//    TODO: Delete user by id
    public String buildDeleteByIdSql(@Param("id") Integer id){

        return new SQL(){{
            DELETE_FROM(tableName);
            WHERE("id = #{id}");
        }}.toString();
    }
//    TODO: Update is deleted status
    public String buildUpdateIsDeletedSql(@Param("id") Integer id, @Param("status") boolean status){
        return new SQL(){{
            UPDATE(tableName);
            SET("is_deleted = #{status}");
            WHERE("id = #{id}");
        }}.toString();
    }

//    TODO: Update user by Id
    public String buildUpdateById(){
        return new SQL(){{
            UPDATE(tableName);
            SET("name = #{u.name}" );
            SET("gender = #{u.gender}");
            WHERE("id = #{u.id}");
        }}.toString();
    }
}
