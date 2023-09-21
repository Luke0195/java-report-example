package br.com.jasperreportexample.userslist.mapper;

import br.com.jasperreportexample.userslist.entities.User;
import br.com.jasperreportexample.userslist.vo.UserVO;

public class UserMapper {

    public static UserVO parseUsersToDTO(User user){
     return  UserVO.builder().id(user.getId()).brithDate(user.getBrithDate()).email(user.getEmail()).name(user.getName()).salary(user.getSalary()).build();
    }
}
