package com.seenow.service;
import com.seenow.pojo.Article;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author: https://blog.csdn.net/pkxwyf
 * @Description:Article业务层接口
 *****/
public interface ArticleService {

    /***
     * 多条件分页查询Article表数据
     * @param article
     * @param page
     * @param size
     * @return
     */
    PageInfo<Article> findPage(Article article, int page, int size);

    /***
     * 分页查询Article表数据
     * @param page
     * @param size
     * @return
     */
    PageInfo<Article> findPage(int page, int size);

    /***
     * 多条件搜索Article表数据
     * @param article
     * @return
     */
    List<Article> findList(Article article);

    /***
     * 根据id删除Article表数据
     * @param id
     */
    void delete(Long id);

    /***
     * 根据条件修改Article表数据
     * @param article
     */
    void update(Article article);

    /***
     * 新增Article表数据
     * @param article
     */
    void add(Article article);

    /**
     * 根据ID查询Article表数据
     * @param id
     * @return
     */
     Article findById(Long id);

    /***
     * 查询所有Article表数据
     * @return
     */
    List<Article> findAll();
}
