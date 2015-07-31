package at.bestsolution.tasktracker.emapping.webservice.dto;

public class DTOSourceRepository {
	/*
	 * Meta data
	 */
	private String metaClassname = "SourceRepository";
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

	public static DTOSourceRepository newProxy(long id) {
		DTOSourceRepository dto = new DTOSourceRepository();
		dto.setSid(id);
		dto.setMetaProxy(true);
		return dto;
	}

	/*
	 * Attributes
	 */
	private long sid;
	private java.lang.String sourceUrl;
	private java.lang.String webUrl;
	private at.bestsolution.tasktracker.model.tasktracker.SourceRepositoryType type;

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
	public java.lang.String getSourceUrl() {
		return this.sourceUrl;
	}

	public void setSourceUrl(java.lang.String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}
	public java.lang.String getWebUrl() {
		return this.webUrl;
	}

	public void setWebUrl(java.lang.String webUrl) {
		this.webUrl = webUrl;
	}
	public at.bestsolution.tasktracker.model.tasktracker.SourceRepositoryType getType() {
		return this.type;
	}

	public void setType(at.bestsolution.tasktracker.model.tasktracker.SourceRepositoryType type) {
		this.type = type;
	}

	public DTOTaskRepository getRepository() {
		return this.repository;
	}

	public void setRepository(DTOTaskRepository repository) {
		this.repository = repository;
	}

}
