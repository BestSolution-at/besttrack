package at.bestsolution.tasktracker.emapping.webservice;

@javax.ws.rs.Path("/commentattachment")
@org.osgi.service.component.annotations.Component(service={CommentAttachmentService.class})
public class CommentAttachmentService extends at.bestsolution.tasktracker.emapping.webservice.base.BaseCommentAttachmentService {
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
