package at.bestsolution.tasktracker.emapping.webservice;

@javax.ws.rs.Path("/comment")
@org.osgi.service.component.annotations.Component(service={CommentService.class})
public class CommentService extends at.bestsolution.tasktracker.emapping.webservice.base.BaseCommentService {
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
