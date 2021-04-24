package com.seenow.service;
import com.seenow.pojo.User;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author: https://blog.csdn.net/pkxwyf
 * @Description:User业务层接口
 *****/
public interface UserService {

    /***
     * 多条件分页查询User表数据
     * @param user
     * @param page
     * @param size
     * @return
     */
    PageInfo<User> findPage(User user, int page, int size);

    /***
     * 分页查询User表数据
     * @param page
     * @param size
     * @return
     */
    PageInfo<User> findPage(int page, int size);

    /***
     * 多条件搜索User表数据
     * @param user
     * @return
     */
    List<User> findList(User user);

    /***
     * 根据id删除User表数据
     * @param id
     */
    void delete(Integer id);

    /***
     * 根据条件修改User表数据
     * @param user
     */
    void update(User user);

    /***
     * 新增User表数据
     * @param user
     */
    void add(User user);

    /**
     * 根据ID查询User表数据
     * @param id
     * @return
     */
     User findById(Integer id);

    /***
     * 查询所有User表数据
     * @return
     */
    List<User> findAll();
}
