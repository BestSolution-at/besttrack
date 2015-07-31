package at.bestsolution.tasktracker.emapping.webservice.dto;

public class DTOPerson {
	/*
	 * Meta data
	 */
	private String metaClassname = "Person";
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

	public static DTOPerson newProxy(long id) {
		DTOPerson dto = new DTOPerson();
		dto.setSid(id);
		dto.setMetaProxy(true);
		return dto;
	}

	/*
	 * Attributes
	 */
	private long sid;
	private java.lang.String firstname;
	private java.lang.String lastname;

	/*
	 * References
	 */
	private java.util.List<DTORepositoryPerson> repositoryList;

	public long getSid() {
		return this.sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}
	public java.lang.String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(java.lang.String firstname) {
		this.firstname = firstname;
	}
	public java.lang.String getLastname() {
		return this.lastname;
	}

	public void setLastname(java.lang.String lastname) {
		this.lastname = lastname;
	}

	public java.util.List<DTORepositoryPerson> getRepositoryList() {
		return this.repositoryList;
	}

	public void setRepositoryList(java.util.List<DTORepositoryPerson> repositoryList) {
		this.repositoryList = repositoryList;
	}

}
