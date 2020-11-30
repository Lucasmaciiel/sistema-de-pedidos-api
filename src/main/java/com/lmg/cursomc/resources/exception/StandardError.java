package com.lmg.cursomc.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer status;
	private String msn;
	private Long timeStamp;

	public StandardError(Integer status, String msn, Long timeStamp) {
		super();
		this.status = status;
		this.msn = msn;
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
