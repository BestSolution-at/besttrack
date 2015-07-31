package at.bestsolution.tasktracker.emapping.webservice.dto;

public class DTOVersion {
	/*
	 * Meta data
	 */
	private String metaClassname = "Version";
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

	public static DTOVersion newProxy(long id) {
		DTOVersion dto = new DTOVersion();
		dto.setSid(id);
		dto.setMetaProxy(true);
		return dto;
	}

	/*
	 * Attributes
	 */
	private long sid;
	private java.lang.String value;
	private java.util.Date date;
	private java.lang.String codename;

	/*
	 * References
	 */
	private DTOTaskRepository repository;

	public long getSid() {
		return this.sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}
	public java.lang.String getValue() {
		return this.value;
	}

	public void setValue(java.lang.String value) {
		this.value = value;
	}
	public java.util.Date getDate() {
		return this.date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public java.lang.String getCodename() {
		return this.codename;
	}

	public void setCodename(java.lang.String codename) {
		this.codename = codename;
	}

	public DTOTaskRepository getRepository() {
		return this.repository;
	}

	public void setRepository(DTOTaskRepository repository) {
		this.repository = repository;
	}

}
