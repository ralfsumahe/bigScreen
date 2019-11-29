package com.funo.vo;
/**
 * 仪表盘
 * 描述
 * @author linkun
 * @created 2019年8月19日 下午9:36:15
 */
public class BaseYBP {
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getNormal() {
        return normal;
    }

    public void setNormal(Integer normal) {
        this.normal = normal;
    }

    private Integer total;
	private Integer normal;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 数值
	 */
	private Double value;
	
	private BaseYBP() {
		super();
	}

	public BaseYBP(String title, Double value) {
		super();
		this.title = title;
		this.value = value;
	}

	public BaseYBP(String title, Double value, Integer normal, Integer total) {
		super();
		this.title = title;
		this.value = value;
		this.normal = normal;
		this.total = total;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	
	
	
}
