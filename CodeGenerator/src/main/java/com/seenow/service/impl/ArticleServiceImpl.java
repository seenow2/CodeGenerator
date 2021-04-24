package com.seenow.service.impl;
import com.seenow.dao.ArticleMapper;
import com.seenow.pojo.Article;
import com.seenow.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author: PKXING
 * @Description:Article业务层接口实现类
 *****/
@Service
public class ArticleServiceImpl implements ArticleService {

    // 注入持久层对象
    @Autowired
    private ArticleMapper articleMapper;


    /**
     * 条件+分页查询Article表数据
     * @param article 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Article> findPage(Article article, int page, int size){
        // 分页
        PageHelper.startPage(page,size);
        // 搜索条件构建
        Example example = createExample(article);
        // 执行搜索
        return new PageInfo<Article>(articleMapper.selectByExample(example));
    }

    /**
     * 分页查询Article表数据
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Article> findPage(int page, int size){
        // 静态分页
        PageHelper.startPage(page,size);
        // 分页查询
        return new PageInfo<Article>(articleMapper.selectAll());
    }

    /**
     * 条件查询Article表数据
     * @param article
     * @return
     */
    @Override
    public List<Article> findList(Article article){
        // 构建查询条件
        Example example = createExample(article);
        // 根据构建的条件查询数据
        return articleMapper.selectByExample(example);
    }


    /**
     * Article构建查询对象
     * @param article
     * @return
     */
    public Example createExample(Article article){
        Example example=new Example(Article.class);
        Example.Criteria criteria = example.createCriteria();
        if(article!=null){
            //  
            if(!StringUtils.isEmpty(article.getId())){
                    criteria.andEqualTo("id",article.getId());
            }
            //  
            if(!StringUtils.isEmpty(article.getAvailable())){
                    criteria.andEqualTo("available",article.getAvailable());
            }
            //  
            if(!StringUtils.isEmpty(article.getBody())){
                    criteria.andEqualTo("body",article.getBody());
            }
            //  
            if(!StringUtils.isEmpty(article.getDescription())){
                    criteria.andEqualTo("description",article.getDescription());
            }
            //  
            if(!StringUtils.isEmpty(article.getKeyword())){
                    criteria.andEqualTo("keyword",article.getKeyword());
            }
            //  
            if(!StringUtils.isEmpty(article.getTitle())){
                    criteria.andLike("title","%"+article.getTitle()+"%");
            }
            //  
            if(!StringUtils.isEmpty(article.getType())){
                    criteria.andEqualTo("type",article.getType());
            }
            //  
            if(!StringUtils.isEmpty(article.getCreateBy())){
                    criteria.andEqualTo("createBy",article.getCreateBy());
            }
            //  
            if(!StringUtils.isEmpty(article.getCreateTime())){
                    criteria.andEqualTo("createTime",article.getCreateTime());
            }
            //  
            if(!StringUtils.isEmpty(article.getLastmodifiedBy())){
                    criteria.andEqualTo("lastmodifiedBy",article.getLastmodifiedBy());
            }
            //  
            if(!StringUtils.isEmpty(article.getUpdateTime())){
                    criteria.andEqualTo("updateTime",article.getUpdateTime());
            }
        }
        return example;
    }

    /**
     * 根据id删除Article表数据
     * @param id
     */
    @Override
    public void delete(Long id){
        articleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Article表数据
     * @param article
     */
    @Override
    public void update(Article article){
        articleMapper.updateByPrimaryKey(article);
    }

    /**
     * 增加Article表数据
     * @param article
     */
    @Override
    public void add(Article article){
        articleMapper.insert(article);
    }

    /**
     * 根据ID查询Article表数据
     * @param id
     * @return
     */
    @Override
    public Article findById(Long id){
        return  articleMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Article表全部数据
     * @return
     */
    @Override
    public List<Article> findAll() {
        return articleMapper.selectAll();
    }
}
