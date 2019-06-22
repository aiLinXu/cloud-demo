package cn.itcast.user.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author xualin
 * @version v1.0
 * @date 2019/4/2 11:45
 * @description
 **/
    @Table(name = "ta_users")
    @Data
    public class User {

        @Id
        @KeySql(useGeneratedKeys = true)
        private Long id;

        private String userName; // 用户名

        private String password; // 密码

        private String name;// 姓名

        private Integer age;// 年龄

        private Integer sex;// 性别，1男性，2女性

        private Date birthday;// 出生日期

        private Date created;// 创建时间

        private Date updated;// 更新时间

        private String note;// 备注


}
