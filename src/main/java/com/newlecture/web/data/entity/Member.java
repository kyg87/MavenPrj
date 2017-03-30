package com.newlecture.web.data.entity;

import java.sql.Date;

public class Member {
	private String id;
	private String name;
	private String pwd;
	private String nicName;
	private String photo;
	private String gender;
	private String birthday;
	private int isLunar;
	private String phone;
	private String email;
	private String zipCode;
	private String address;
	private String addressDetail;
	private Date regDate;
	private String regIP;
	private String regEnv;
	private String pwdModifykey;
	private String regAdmin;
	private String guid;
	private boolean disabled;
	private String disabledReason;
	private String lastLoginIp;
	private String lastLoginPlatform;
	private Date lastLoginTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNicName() {
		return nicName;
	}

	public void setNicName(String nicName) {
		this.nicName = nicName;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getIsLunar() {
		return isLunar;
	}

	public void setIsLunar(int isLunar) {
		this.isLunar = isLunar;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getRegIP() {
		return regIP;
	}

	public void setRegIP(String regIP) {
		this.regIP = regIP;
	}

	public String getRegEnv() {
		return regEnv;
	}

	public void setRegEnv(String regEnv) {
		this.regEnv = regEnv;
	}

	public String getPwdModifykey() {
		return pwdModifykey;
	}

	public void setPwdModifykey(String pwdModifykey) {
		this.pwdModifykey = pwdModifykey;
	}

	public String getRegAdmin() {
		return regAdmin;
	}

	public void setRegAdmin(String regAdmin) {
		this.regAdmin = regAdmin;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public String getDisabledReason() {
		return disabledReason;
	}

	public void setDisabledReason(String disabledReason) {
		this.disabledReason = disabledReason;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getLastLoginPlatform() {
		return lastLoginPlatform;
	}

	public void setLastLoginPlatform(String lastLoginPlatform) {
		this.lastLoginPlatform = lastLoginPlatform;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

}
