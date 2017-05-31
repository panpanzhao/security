package com.idasound.template.security.model;


import com.idasound.template.common.utils.PaginatedHelper;


public class TbsMenu extends PaginatedHelper implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//构造函数
	public TbsMenu(){
	}
	
	//属性
	
	 /**
     * 权限主键       db_column: ID 
     */
	private java.lang.String id;

	
    /**
     * 菜单排序       db_column: MENU_SORT 
     */	
	private java.lang.Integer menuSort;
	
    /**
     * 菜单显示状态       db_column: DISPLAY_FLAG 
     */	
	private java.lang.String displayFlag;
	
    /**
     * 菜单描述       db_column: MENU_DESC 
     */	
	private java.lang.String menuDesc;
	
    /**
     * 菜单名称       db_column: MENU_NAME 
     */	
	private java.lang.String menuName;
	
    /**
     * 权限链接       db_column: MENU_URL 
     */	
	private java.lang.String menuUrl;
	
    /**
     * 父节点       db_column: PARENT_ID 
     */	
	private java.lang.String parentId;
	
    /**
     * 备注       db_column: REMARK 
     */	
	private java.lang.String remark;
	
    /**
     * 状态       db_column: STATUS 
     */	
	private java.lang.String status;
	
    /**
     * 父菜单名称       db_column: MENU_NAME 
     */	
	private java.lang.String parentMenuName;
	
	//getter setter方法
	
	public java.lang.String getId() {
		return this.id;
	}
	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.Integer getMenuSort() {
		return this.menuSort;
	}
	public void setMenuSort(java.lang.Integer value) {
		this.menuSort = value;
	}
	
	public java.lang.String getDisplayFlag() {
		return this.displayFlag;
	}
	public void setDisplayFlag(java.lang.String value) {
		this.displayFlag = value;
	}
	
	public java.lang.String getMenuDesc() {
		return this.menuDesc;
	}
	public void setMenuDesc(java.lang.String value) {
		this.menuDesc = value;
	}
	
	public java.lang.String getMenuName() {
		return this.menuName;
	}
	public void setMenuName(java.lang.String value) {
		this.menuName = value;
	}
	
	public java.lang.String getMenuUrl() {
		return this.menuUrl;
	}
	public void setMenuUrl(java.lang.String value) {
		this.menuUrl = value;
	}
	
	public java.lang.String getParentId() {
		return this.parentId;
	}
	public void setParentId(java.lang.String value) {
		this.parentId = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getStatus() {
		return this.status;
	}
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	
	public java.lang.String getParentMenuName() {
		return this.parentMenuName;
	}
	public void setParentMenuName(java.lang.String value) {
		this.parentMenuName = value;
	}
		
}