package com.seenow.feign;

import com.seenow.result.*;
import com.seenow.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.pagehelper.PageInfo;
import java.util.List;

/****
 * @Author: https://blog.csdn.net/pkxwyf
 *****/
@FeignClient(name="seenow")
@RequestMapping("/user")
public interface UserFeign {

    /***
     * 分页+条件搜索User表数据
     * @param user
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) User user, @PathVariable  int page, @PathVariable  int size);

    /***
     * 分页搜索User表数据
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索User表数据
     * @param user
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<User>> findList(@RequestBody(required = false) User user);

    /***
     * 根据ID删除User表数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改User表数据
     * @param user
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody User user,@PathVariable Integer id);

    /***
     * 新增User表数据
     * @param user
     * @return
     */
    @PostMapping
    Result add(@RequestBody User user);

    /***
     * 根据ID查询User表数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<User> findById(@PathVariable Integer id);

    /***
     * 查询User表全部数据
     * @return
     */
    @GetMapping
    Result<List<User>> findAll();
}