package at.bestsolution.tasktracker.emapping.webservice.dto;

public class DTORepositoryPerson {
	/*
	 * Meta data
	 */
	private String metaClassname = "RepositoryPerson";
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

	public static DTORepositoryPerson newProxy(long id) {
		DTORepositoryPerson dto = new DTORepositoryPerson();
		dto.setSid(id);
		dto.setMetaProxy(true);
		return dto;
	}

	/*
	 * Attributes
	 */
	private long sid;
	private long privilegeMask;

	/*
	 * References
	 */
	private DTOPerson person;
	private DTOTaskRepository repository;

	public long getSid() {
		return this.sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}
	public long getPrivilegeMask() {
		return this.privilegeMask;
	}

	public void setPrivilegeMask(long privilegeMask) {
		this.privilegeMask = privilegeMask;
	}

	public DTOPerson getPerson() {
		return this.person;
	}

	public void setPerson(DTOPerson person) {
		this.person = person;
	}

	public DTOTaskRepository getRepository() {
		return this.repository;
	}

	public void setRepository(DTOTaskRepository repository) {
		this.repository = repository;
	}

}
