package co.istad.mobilebanking.api.users;

import co.istad.mobilebanking.api.users.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

//    TODO: Find all users
    @SelectProvider(type = UserProvider.class, method = "buildSelectAllUsersSql")
    @Results(
            id = "userResult",
            value ={
            @Result(property = "name", column = "name"),
                    @Result(property = "gender", column = "gender"),
                    @Result(property = "isStudent", column = "is_student"),
                    @Result(property = "studentCardId", column = "student_card_id"),
    }
    )
    List<User> selectAllUsers();

//    TODO: Insert a user

    @InsertProvider(type = UserProvider.class, method = "buildInsertUserSql")
    @Options(useGeneratedKeys = true, keyColumn = "id",keyProperty = "id")
    void insertUser(@Param("u")  User user);
}
