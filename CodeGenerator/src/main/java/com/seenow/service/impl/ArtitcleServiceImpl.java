package com.seenow.service.impl;
import com.seenow.dao.ArtitcleMapper;
import com.seenow.pojo.Artitcle;
import com.seenow.service.ArtitcleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author: PKXING
 * @Description:Artitcle业务层接口实现类
 *****/
@Service
public class ArtitcleServiceImpl implements ArtitcleService {

    // 注入持久层对象
    @Autowired
    private ArtitcleMapper artitcleMapper;


    /**
     * 条件+分页查询Artitcle表数据
     * @param artitcle 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Artitcle> findPage(Artitcle artitcle, int page, int size){
        // 分页
        PageHelper.startPage(page,size);
        // 搜索条件构建
        Example example = createExample(artitcle);
        // 执行搜索
        return new PageInfo<Artitcle>(artitcleMapper.selectByExample(example));
    }

    /**
     * 分页查询Artitcle表数据
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Artitcle> findPage(int page, int size){
        // 静态分页
        PageHelper.startPage(page,size);
        // 分页查询
        return new PageInfo<Artitcle>(artitcleMapper.selectAll());
    }

    /**
     * 条件查询Artitcle表数据
     * @param artitcle
     * @return
     */
    @Override
    public List<Artitcle> findList(Artitcle artitcle){
        // 构建查询条件
        Example example = createExample(artitcle);
        // 根据构建的条件查询数据
        return artitcleMapper.selectByExample(example);
    }


    /**
     * Artitcle构建查询对象
     * @param artitcle
     * @return
     */
    public Example createExample(Artitcle artitcle){
        Example example=new Example(Artitcle.class);
        Example.Criteria criteria = example.createCriteria();
        if(artitcle!=null){
            //  
            if(!StringUtils.isEmpty(artitcle.getId())){
                    criteria.andEqualTo("id",artitcle.getId());
            }
            //  
            if(!StringUtils.isEmpty(artitcle.getBody())){
                    criteria.andEqualTo("body",artitcle.getBody());
            }
            //  
            if(!StringUtils.isEmpty(artitcle.getTitle())){
                    criteria.andLike("title","%"+artitcle.getTitle()+"%");
            }
        }
        return example;
    }

    /**
     * 根据id删除Artitcle表数据
     * @param id
     */
    @Override
    public void delete(Long id){
        artitcleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Artitcle表数据
     * @param artitcle
     */
    @Override
    public void update(Artitcle artitcle){
        artitcleMapper.updateByPrimaryKey(artitcle);
    }

    /**
     * 增加Artitcle表数据
     * @param artitcle
     */
    @Override
    public void add(Artitcle artitcle){
        artitcleMapper.insert(artitcle);
    }

    /**
     * 根据ID查询Artitcle表数据
     * @param id
     * @return
     */
    @Override
    public Artitcle findById(Long id){
        return  artitcleMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Artitcle表全部数据
     * @return
     */
    @Override
    public List<Artitcle> findAll() {
        return artitcleMapper.selectAll();
    }
}
