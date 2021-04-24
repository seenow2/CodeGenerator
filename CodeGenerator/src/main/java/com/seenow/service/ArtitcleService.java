package com.seenow.service;
import com.seenow.pojo.Artitcle;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author: https://blog.csdn.net/pkxwyf
 * @Description:Artitcle业务层接口
 *****/
public interface ArtitcleService {

    /***
     * 多条件分页查询Artitcle表数据
     * @param artitcle
     * @param page
     * @param size
     * @return
     */
    PageInfo<Artitcle> findPage(Artitcle artitcle, int page, int size);

    /***
     * 分页查询Artitcle表数据
     * @param page
     * @param size
     * @return
     */
    PageInfo<Artitcle> findPage(int page, int size);

    /***
     * 多条件搜索Artitcle表数据
     * @param artitcle
     * @return
     */
    List<Artitcle> findList(Artitcle artitcle);

    /***
     * 根据id删除Artitcle表数据
     * @param id
     */
    void delete(Long id);

    /***
     * 根据条件修改Artitcle表数据
     * @param artitcle
     */
    void update(Artitcle artitcle);

    /***
     * 新增Artitcle表数据
     * @param artitcle
     */
    void add(Artitcle artitcle);

    /**
     * 根据ID查询Artitcle表数据
     * @param id
     * @return
     */
     Artitcle findById(Long id);

    /***
     * 查询所有Artitcle表数据
     * @return
     */
    List<Artitcle> findAll();
}
