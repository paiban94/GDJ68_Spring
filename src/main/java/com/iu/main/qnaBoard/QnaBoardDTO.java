package com.iu.main.qnaBoard;

import java.sql.Date;

public class QnaBoardDTO {

	private Long qnaNum;
	private String qnaName;
	private String qnaSubject;
	private String qnaContents;
	private Date qnaDate;
	private Long qnaHit;
	private Long ref;
	private Long step;
	private Long depth;

	
	public Long getQnaNum() {
	return qnaNum;
	}
	public void setQnaNum(Long qnaNum) {
		this.qnaNum = qnaNum;
	}
	public String getQnaName() {
		return qnaName;
	}
	public void setQnaName(String qnaName) {
		this.qnaName = qnaName;
	}
	public String getQnaSubject() {
		return qnaSubject;
	}
	public void setQnaSubject(String qnaSubject) {
		this.qnaSubject = qnaSubject;
	}
	public String getQnaContents() {
		return qnaContents;
	}
	public void setQnaContents(String qnaContents) {
		this.qnaContents = qnaContents;
	}
	public Date getQnaDate() {
		return qnaDate;
	}
	public void setQnaDate(Date qnaDate) {
		this.qnaDate = qnaDate;
	}
	public Long getQnaHit() {
		return qnaHit;
	}
	public void setQnaHit(Long qnaHit) {
		this.qnaHit = qnaHit;
	}
	public Long getRef() {
		return ref;
	}
	public void setRef(Long ref) {
		this.ref = ref;
	}
	public Long getStep() {
		return step;
	}
	public void setStep(Long step) {
		this.step = step;
	}
	public Long getDepth() {
		return depth;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
}
