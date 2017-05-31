package com.idasound.template.security.model;


import org.springframework.format.annotation.DateTimeFormat;

import com.idasound.template.common.utils.PaginatedHelper;


public class TbsUser extends PaginatedHelper implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//构造函数
	public TbsUser(){
	}
	
	//属性
	
	 /**
     * 用户主键       db_column: ID 
     */
	private java.lang.String id;

	
    /**
     * 渠道信息       db_column: CHANNEL_ID 
     */	
	private java.lang.String channelId;
	
    /**
     * 详细地址       db_column: ADDRESS 
     */	
	private java.lang.String address;
	
    /**
     * 出生日期       db_column: BIRTHDAY 
     */	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date birthday;
	
    /**
     * 证件号码       db_column: CERTIFICATE_NO 
     */	
	private java.lang.String certificateNo;
	
    /**
     * 证件类型       db_column: CERTIFICATE_TYPE 
     */	
	private java.lang.String certificateType;
	
    /**
     * 市       db_column: CITY 
     */	
	private java.lang.String city;
	
    /**
     * 公司名称       db_column: COMPANY_NAME 
     */	
	private java.lang.String companyName;
	
    /**
     * 县       db_column: COUNTY 
     */	
	private java.lang.String county;
	
    /**
     * 邮件       db_column: EMAIL 
     */	
	private java.lang.String email;
	
    /**
     * 过期时间       db_column: INVALIDATE_DATE 
     */	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date invalidateDate;
	
    /**
     * 密码       db_column: PASSPWORD 
     */	
	private java.lang.String passpword;
	
    /**
     * 省       db_column: PROVINCE 
     */	
	private java.lang.String province;
	
    /**
     * 真实姓名       db_column: REAL_NAME 
     */	
	private java.lang.String realName;
	
    /**
     * 备注信息       db_column: REMARK 
     */	
	private java.lang.String remark;
	
    /**
     * 性别       db_column: SEX 
     */	
	private java.lang.String sex;
	
    /**
     * 状态       db_column: STATUS 
     */	
	private java.lang.String status;
	
    /**
     * 电话       db_column: TELEPHONE 
     */	
	private java.lang.String telephone;
	
    /**
     * 用户名       db_column: USER_NAME 
     */	
	private java.lang.String userName;
	
    /**
     * 审核时间       db_column: VALIDATE_DATE 
     */	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date validateDate;
	
    /**
     * 渠道名称       db_column: name 
     */	
	private java.lang.String channelName;
	
	//getter setter方法
	
	public java.lang.String getId() {
		return this.id;
	}
	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getChannelId() {
		return this.channelId;
	}
	public void setChannelId(java.lang.String value) {
		this.channelId = value;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	
	public java.util.Date getBirthday() {
		return this.birthday;
	}
	public void setBirthday(java.util.Date value) {
		this.birthday = value;
	}
	
	public java.lang.String getCertificateNo() {
		return this.certificateNo;
	}
	public void setCertificateNo(java.lang.String value) {
		this.certificateNo = value;
	}
	
	public java.lang.String getCertificateType() {
		return this.certificateType;
	}
	public void setCertificateType(java.lang.String value) {
		this.certificateType = value;
	}
	
	public java.lang.String getCity() {
		return this.city;
	}
	public void setCity(java.lang.String value) {
		this.city = value;
	}
	
	public java.lang.String getCompanyName() {
		return this.companyName;
	}
	public void setCompanyName(java.lang.String value) {
		this.companyName = value;
	}
	
	public java.lang.String getCounty() {
		return this.county;
	}
	public void setCounty(java.lang.String value) {
		this.county = value;
	}
	
	public java.lang.String getEmail() {
		return this.email;
	}
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	
	public java.util.Date getInvalidateDate() {
		return this.invalidateDate;
	}
	public void setInvalidateDate(java.util.Date value) {
		this.invalidateDate = value;
	}
	
	public java.lang.String getPasspword() {
		return this.passpword;
	}
	public void setPasspword(java.lang.String value) {
		this.passpword = value;
	}
	
	public java.lang.String getProvince() {
		return this.province;
	}
	public void setProvince(java.lang.String value) {
		this.province = value;
	}
	
	public java.lang.String getRealName() {
		return this.realName;
	}
	public void setRealName(java.lang.String value) {
		this.realName = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getSex() {
		return this.sex;
	}
	public void setSex(java.lang.String value) {
		this.sex = value;
	}
	
	public java.lang.String getStatus() {
		return this.status;
	}
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	
	public java.lang.String getTelephone() {
		return this.telephone;
	}
	public void setTelephone(java.lang.String value) {
		this.telephone = value;
	}
	
	public java.lang.String getUserName() {
		return this.userName;
	}
	public void setUserName(java.lang.String value) {
		this.userName = value;
	}
	
	public java.util.Date getValidateDate() {
		return this.validateDate;
	}
	public void setValidateDate(java.util.Date value) {
		this.validateDate = value;
	}
	
	public java.lang.String getChannelName() {
		return this.channelName;
	}
	public void setChannelName(java.lang.String value) {
		this.channelName = value;
	}
		
}