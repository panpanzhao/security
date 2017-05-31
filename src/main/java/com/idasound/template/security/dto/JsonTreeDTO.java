package com.idasound.template.security.dto;

import java.util.List;

/**
 * 树 json model 数据
 * @author glq
 *
 */
public class JsonTreeDTO {
 
    public String id;       //json id
    public String pid;      //父节点
    public String text;     //json 显示文本
    public String state;    //json 'open','closed'
    public String checkbox; //是否被选中
    public String iconCls;  //显示图标
    public Attributes attributes;
    public List<JsonTreeDTO> children;//子属性
    
	public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public List<JsonTreeDTO> getChildren() {
        return children;
    }
    public void setChildren(List<JsonTreeDTO> children) {
        this.children = children;
    }
    public String getPid() {
        return pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }
    public String getCheckbox() {
		return checkbox;
	}
	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public Attributes getAttributes() {
		return attributes;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	public static class Attributes{
    	private String url;
    	

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
    	
    }
}