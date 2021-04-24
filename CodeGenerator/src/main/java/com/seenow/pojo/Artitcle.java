package com.seenow.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
/****
 * @Author: https://blog.csdn.net/pkxwyf
 * @Description:Artitcle构建
 *****/
@ApiModel(description = "Artitcle",value = "Artitcle")
@Table(name="artitcle")
public class Artitcle implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "body")
	private String body;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "title")
	private String title;//



	//get方法
	public Long getId() {
		return id;
	}

	//set方法
	public void setId(Long id) {
		this.id = id;
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
	public String getTitle() {
		return title;
	}

	//set方法
	public void setTitle(String title) {
		this.title = title;
	}


}
