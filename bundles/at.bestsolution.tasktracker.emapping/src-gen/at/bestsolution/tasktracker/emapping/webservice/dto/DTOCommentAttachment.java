package at.bestsolution.tasktracker.emapping.webservice.dto;

public class DTOCommentAttachment {
	/*
	 * Meta data
	 */
	private String metaClassname = "CommentAttachment";
	private boolean metaProxy;

	public void setMetaProxy(boolean metaProxy) {
		this.metaProxy = metaProxy;
	}

	public boolean isMetaProxy() {
		return metaProxy;
	}

	public void setMetaClassname(String metaClassname) {
		this.metaClassname = metaClassname;
	}

	public String getMetaClassname() {
		return metaClassname;
	}

	public static DTOCommentAttachment newProxy(long id) {
		DTOCommentAttachment dto = new DTOCommentAttachment();
		dto.setSid(id);
		dto.setMetaProxy(true);
		return dto;
	}

	/*
	 * Attributes
	 */
	private long sid;
	private java.lang.String title;
	private java.lang.String mimetype;
	private java.lang.String description;

	/*
	 * References
	 */
	private DTOComment comment;

	public long getSid() {
		return this.sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}
	public java.lang.String getTitle() {
		return this.title;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}
	public java.lang.String getMimetype() {
		return this.mimetype;
	}

	public void setMimetype(java.lang.String mimetype) {
		this.mimetype = mimetype;
	}
	public java.lang.String getDescription() {
		return this.description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	public DTOComment getComment() {
		return this.comment;
	}

	public void setComment(DTOComment comment) {
		this.comment = comment;
	}

}
