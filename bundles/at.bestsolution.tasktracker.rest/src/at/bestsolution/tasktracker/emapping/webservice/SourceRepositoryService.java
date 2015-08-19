package at.bestsolution.tasktracker.emapping.webservice;

@javax.ws.rs.Path("/sourcerepository")
@org.osgi.service.component.annotations.Component(service={SourceRepositoryService.class})
public class SourceRepositoryService extends at.bestsolution.tasktracker.emapping.webservice.base.BaseSourceRepositoryService {
	@org.osgi.service.component.annotations.Reference(
		cardinality=org.osgi.service.component.annotations.ReferenceCardinality.MANDATORY,
		policyOption=org.osgi.service.component.annotations.ReferencePolicyOption.GREEDY
	)
	@Override
	public void setSessionFactory(at.bestsolution.persistence.SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public void unsetSessionFactory(at.bestsolution.persistence.SessionFactory sessionFactory) {
		super.unsetSessionFactory(sessionFactory);
	}
}
