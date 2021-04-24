package com.seenow.feign;

import com.seenow.result.*;
import com.seenow.pojo.Article;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.pagehelper.PageInfo;
import java.util.List;

/****
 * @Author: https://blog.csdn.net/pkxwyf
 *****/
@FeignClient(name="seenow")
@RequestMapping("/article")
public interface ArticleFeign {

    /***
     * 分页+条件搜索Article表数据
     * @param article
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Article article, @PathVariable  int page, @PathVariable  int size);

    /***
     * 分页搜索Article表数据
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索Article表数据
     * @param article
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Article>> findList(@RequestBody(required = false) Article article);

    /***
     * 根据ID删除Article表数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改Article表数据
     * @param article
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Article article,@PathVariable Long id);

    /***
     * 新增Article表数据
     * @param article
     * @return
     */
    @PostMapping
    Result add(@RequestBody Article article);

    /***
     * 根据ID查询Article表数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Article> findById(@PathVariable Long id);

    /***
     * 查询Article表全部数据
     * @return
     */
    @GetMapping
    Result<List<Article>> findAll();
}