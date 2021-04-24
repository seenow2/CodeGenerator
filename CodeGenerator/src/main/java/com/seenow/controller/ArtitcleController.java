package com.seenow.controller;
import com.seenow.pojo.Artitcle;
import com.seenow.service.ArtitcleService;
import com.github.pagehelper.PageInfo;
import com.seenow.result.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/****
 * @Author: https://blog.csdn.net/pkxwyf
 *****/
@Api(value = "ArtitcleController")
@RestController
@RequestMapping("/artitcle")
@CrossOrigin
public class ArtitcleController {

    // 注入业务层对象
    @Autowired
    private ArtitcleService artitcleService;

    /***
     * 分页+条件搜索Artitcle表数据
     * @param artitcle
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Artitcle条件分页查询",notes = "分页条件查询Artitcle方法详情",tags = {"ArtitcleController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Artitcle对象",value = "传入JSON数据",required = false) Artitcle artitcle, @PathVariable  int page, @PathVariable  int size){
        //调用ArtitcleService实现分页条件查询Artitcle
        PageInfo<Artitcle> pageInfo = artitcleService.findPage(artitcle, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 分页搜索Artitcle表数据
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Artitcle分页查询",notes = "分页查询Artitcle方法详情",tags = {"ArtitcleController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        // 调用ArtitcleService实现分页查询Artitcle
        PageInfo<Artitcle> pageInfo = artitcleService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索Artitcle表数据
     * @param artitcle
     * @return
     */
    @ApiOperation(value = "Artitcle条件查询",notes = "条件查询Artitcle方法详情",tags = {"ArtitcleController"})
    @PostMapping(value = "/search" )
    public Result<List<Artitcle>> findList(@RequestBody(required = false) @ApiParam(name = "Artitcle对象",value = "传入JSON数据",required = false) Artitcle artitcle){
        //调用ArtitcleService实现条件查询Artitcle
        List<Artitcle> list = artitcleService.findList(artitcle);
        return new Result<List<Artitcle>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除Artitcle表数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Artitcle根据ID删除",notes = "根据ID删除Artitcle方法详情",tags = {"ArtitcleController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用ArtitcleService实现根据主键删除
        artitcleService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Artitcle表数据
     * @param artitcle
     * @param id
     * @return
     */
    @ApiOperation(value = "Artitcle根据ID修改",notes = "根据ID修改Artitcle方法详情",tags = {"ArtitcleController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Artitcle对象",value = "传入JSON数据",required = false) Artitcle artitcle,@PathVariable Long id){
        //设置主键值
        artitcle.setId(id);
        //调用ArtitcleService实现修改Artitcle
        artitcleService.update(artitcle);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Artitcle表数据
     * @param artitcle
     * @return
     */
    @ApiOperation(value = "Artitcle添加",notes = "添加Artitcle方法详情",tags = {"ArtitcleController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Artitcle对象",value = "传入JSON数据",required = true) Artitcle artitcle){
        //调用ArtitcleService实现添加Artitcle
        artitcleService.add(artitcle);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Artitcle表数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Artitcle根据ID查询",notes = "根据ID查询Artitcle方法详情",tags = {"ArtitcleController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<Artitcle> findById(@PathVariable Long id){
        //调用ArtitcleService实现根据主键查询Artitcle
        Artitcle artitcle = artitcleService.findById(id);
        return new Result<Artitcle>(true,StatusCode.OK,"查询成功",artitcle);
    }

    /***
     * 查询Artitcle表全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Artitcle",notes = "查询Artitcle方法详情",tags = {"ArtitcleController"})
    @GetMapping
    public Result<List<Artitcle>> findAll(){
        // 调用ArtitcleService实现查询所有Artitcle
        List<Artitcle> list = artitcleService.findAll();
        return new Result<List<Artitcle>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
