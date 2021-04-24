package com.seenow.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
/****
 * @Author: https://blog.csdn.net/pkxwyf
 * @Description:Article构建
 *****/
@ApiModel(description = "Article",value = "Article")
@Table(name="article")
public class Article implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "available")
	private String available;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "body")
	private String body;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "description")
	private String description;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "keyword")
	private String keyword;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "title")
	private String title;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "type")
	private String type;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "create_by")
	private Long createBy;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "create_time")
	private Long createTime;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "lastmodified_by")
	private String lastmodifiedBy;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "update_time")
	private Long updateTime;//



	//get方法
	public Long getId() {
		return id;
	}

	//set方法
	public void setId(Long id) {
		this.id = id;
	}
	//get方法
	public String getAvailable() {
		return available;
	}

	//set方法
	public void setAvailable(String available) {
		this.available = available;
	}
	//get方法
	public String getBody() {
		return body;
	}

	//set方法
	public void setBody(String body) {
		this.body = body;
	}
	//get方法
	public String getDescription() {
		return description;
	}

	//set方法
	public void setDescription(String description) {
		this.description = description;
	}
	//get方法
	public String getKeyword() {
		return keyword;
	}

	//set方法
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	//get方法
	public String getTitle() {
		return title;
	}

	//set方法
	public void setTitle(String title) {
		this.title = title;
	}
	//get方法
	public String getType() {
		return type;
	}

	//set方法
	public void setType(String type) {
		this.type = type;
	}
	//get方法
	public Long getCreateBy() {
		return createBy;
	}

	//set方法
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	//get方法
	public Long getCreateTime() {
		return createTime;
	}

	//set方法
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	//get方法
	public String getLastmodifiedBy() {
		return lastmodifiedBy;
	}

	//set方法
	public void setLastmodifiedBy(String lastmodifiedBy) {
		this.lastmodifiedBy = lastmodifiedBy;
	}
	//get方法
	public Long getUpdateTime() {
		return updateTime;
	}

	//set方法
	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}


}
