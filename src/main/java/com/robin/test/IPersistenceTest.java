package com.robin.test;

import com.robin.dao.IUserDao;
import com.robin.io.Resources;
import com.robin.pojo.User;
import com.robin.sqlSession.SqlSession;
import com.robin.sqlSession.SqlSessionFactory;
import com.robin.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.beans.IntrospectionException;
import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class IPersistenceTest {

    @Test
    public void test() throws PropertyVetoException, DocumentException, SQLException, IllegalAccessException, IntrospectionException, InstantiationException, NoSuchFieldException, InvocationTargetException, ClassNotFoundException {
        InputStream sourceAsStream = Resources.getSourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(sourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(1);
        user.setUsername("Robin");
//        User user1 = sqlSession.selectOne("user.selectOne", user);
//        System.out.println(user1.getId() + " | " + user1.getUsername());
//        List<User> users = sqlSession.selectList("user.selectList");
//        for (User user1 : users) {
//            System.out.println(user1.getId() + " | " + user1.getUsername());
//        }
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
//        User user2 = userDao.findByCondition(user);
//        System.out.println(user2.getId() + " | " + user2.getUsername());
        List<User> user2 = userDao.findAll();
        for (User user1 : user2) {
            System.out.println(user1.getId() + " | " + user1.getUsername());
        }

    }
}
