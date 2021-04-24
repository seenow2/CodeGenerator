package com.seenow.feign;

import com.seenow.result.*;
import com.seenow.pojo.Artitcle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.pagehelper.PageInfo;
import java.util.List;

/****
 * @Author: https://blog.csdn.net/pkxwyf
 *****/
@FeignClient(name="seenow")
@RequestMapping("/artitcle")
public interface ArtitcleFeign {

    /***
     * 分页+条件搜索Artitcle表数据
     * @param artitcle
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Artitcle artitcle, @PathVariable  int page, @PathVariable  int size);

    /***
     * 分页搜索Artitcle表数据
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索Artitcle表数据
     * @param artitcle
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Artitcle>> findList(@RequestBody(required = false) Artitcle artitcle);

    /***
     * 根据ID删除Artitcle表数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改Artitcle表数据
     * @param artitcle
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Artitcle artitcle,@PathVariable Long id);

    /***
     * 新增Artitcle表数据
     * @param artitcle
     * @return
     */
    @PostMapping
    Result add(@RequestBody Artitcle artitcle);

    /***
     * 根据ID查询Artitcle表数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Artitcle> findById(@PathVariable Long id);

    /***
     * 查询Artitcle表全部数据
     * @return
     */
    @GetMapping
    Result<List<Artitcle>> findAll();
}