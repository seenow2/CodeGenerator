package com.seenow.service.impl;
import com.seenow.dao.UserMapper;
import com.seenow.pojo.User;
import com.seenow.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author: PKXING
 * @Description:User业务层接口实现类
 *****/
@Service
public class UserServiceImpl implements UserService {

    // 注入持久层对象
    @Autowired
    private UserMapper userMapper;


    /**
     * 条件+分页查询User表数据
     * @param user 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<User> findPage(User user, int page, int size){
        // 分页
        PageHelper.startPage(page,size);
        // 搜索条件构建
        Example example = createExample(user);
        // 执行搜索
        return new PageInfo<User>(userMapper.selectByExample(example));
    }

    /**
     * 分页查询User表数据
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<User> findPage(int page, int size){
        // 静态分页
        PageHelper.startPage(page,size);
        // 分页查询
        return new PageInfo<User>(userMapper.selectAll());
    }

    /**
     * 条件查询User表数据
     * @param user
     * @return
     */
    @Override
    public List<User> findList(User user){
        // 构建查询条件
        Example example = createExample(user);
        // 根据构建的条件查询数据
        return userMapper.selectByExample(example);
    }


    /**
     * User构建查询对象
     * @param user
     * @return
     */
    public Example createExample(User user){
        Example example=new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if(user!=null){
            //  
            if(!StringUtils.isEmpty(user.getId())){
                    criteria.andEqualTo("id",user.getId());
            }
            //  
            if(!StringUtils.isEmpty(user.getUsername())){
                    criteria.andLike("username","%"+user.getUsername()+"%");
            }
            //  
            if(!StringUtils.isEmpty(user.getPassword())){
                    criteria.andEqualTo("password",user.getPassword());
            }
        }
        return example;
    }

    /**
     * 根据id删除User表数据
     * @param id
     */
    @Override
    public void delete(Integer id){
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改User表数据
     * @param user
     */
    @Override
    public void update(User user){
        userMapper.updateByPrimaryKey(user);
    }

    /**
     * 增加User表数据
     * @param user
     */
    @Override
    public void add(User user){
        userMapper.insert(user);
    }

    /**
     * 根据ID查询User表数据
     * @param id
     * @return
     */
    @Override
    public User findById(Integer id){
        return  userMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询User表全部数据
     * @return
     */
    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }
}
