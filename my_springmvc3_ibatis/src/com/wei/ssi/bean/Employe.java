package com.wei.ssi.bean;


public class Employe extends BaseBean {
	
		private Long id;//   主键id	private String name;//   姓名	private String name2;//   姓名	private Integer sex;//   性别 0=保密，1=男，2=女	private Integer age;//   年龄	private String remark;//   备注	public Long getId() {	    return this.id;	}	public void setId(Long id) {	    this.id=id;	}	public String getName() {	    return this.name;	}	public void setName(String name) {	    this.name=name;	}	public Integer getSex() {	    return this.sex;	}	public void setSex(Integer sex) {	    this.sex=sex;	}	public Integer getAge() {	    return this.age;	}	public void setAge(Integer age) {	    this.age=age;	}	public String getRemark() {	    return this.remark;	}	public void setRemark(String remark) {	    this.remark=remark;	}
    public String getName2() {
        return name2;
    }
    public void setName2(String name2) {
        this.name2 = name2;
    }
}
