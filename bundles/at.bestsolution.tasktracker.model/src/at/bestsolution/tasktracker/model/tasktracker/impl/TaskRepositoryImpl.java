/**
 */
package at.bestsolution.tasktracker.model.tasktracker.impl;

import at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson;
import at.bestsolution.tasktracker.model.tasktracker.SourceRepository;
import at.bestsolution.tasktracker.model.tasktracker.TaskRepository;
import at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage;
import at.bestsolution.tasktracker.model.tasktracker.Version;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.impl.TaskRepositoryImpl#getName <em>Name</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.impl.TaskRepositoryImpl#getPersonList <em>Person List</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.impl.TaskRepositoryImpl#getSourceRepositoryList <em>Source Repository List</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.impl.TaskRepositoryImpl#getVersionList <em>Version List</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.impl.TaskRepositoryImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.impl.TaskRepositoryImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.impl.TaskRepositoryImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.impl.TaskRepositoryImpl#isExternalId <em>External Id</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.impl.TaskRepositoryImpl#isPublicRepo <em>Public Repo</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TaskRepositoryImpl extends BaseObjectImpl implements TaskRepository {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPersonList() <em>Person List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersonList()
	 * @generated
	 * @ordered
	 */
	protected EList<RepositoryPerson> personList;

	/**
	 * The cached value of the '{@link #getSourceRepositoryList() <em>Source Repository List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceRepositoryList()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceRepository> sourceRepositoryList;

	/**
	 * The cached value of the '{@link #getVersionList() <em>Version List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionList()
	 * @generated
	 * @ordered
	 */
	protected EList<Version> versionList;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<TaskRepository> children;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected TaskRepository parent;

	/**
	 * The default value of the '{@link #isExternalId() <em>External Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExternalId()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXTERNAL_ID_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExternalId() <em>External Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExternalId()
	 * @generated
	 * @ordered
	 */
	protected boolean externalId = EXTERNAL_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #isPublicRepo() <em>Public Repo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPublicRepo()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PUBLIC_REPO_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPublicRepo() <em>Public Repo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPublicRepo()
	 * @generated
	 * @ordered
	 */
	protected boolean publicRepo = PUBLIC_REPO_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TasktrackerPackage.Literals.TASK_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TasktrackerPackage.TASK_REPOSITORY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RepositoryPerson> getPersonList() {
		if (personList == null) {
			personList = new EObjectContainmentWithInverseEList<RepositoryPerson>(RepositoryPerson.class, this, TasktrackerPackage.TASK_REPOSITORY__PERSON_LIST, TasktrackerPackage.REPOSITORY_PERSON__REPOSITORY);
		}
		return personList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SourceRepository> getSourceRepositoryList() {
		if (sourceRepositoryList == null) {
			sourceRepositoryList = new EObjectContainmentWithInverseEList<SourceRepository>(SourceRepository.class, this, TasktrackerPackage.TASK_REPOSITORY__SOURCE_REPOSITORY_LIST, TasktrackerPackage.SOURCE_REPOSITORY__REPOSITORY);
		}
		return sourceRepositoryList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Version> getVersionList() {
		if (versionList == null) {
			versionList = new EObjectContainmentWithInverseEList<Version>(Version.class, this, TasktrackerPackage.TASK_REPOSITORY__VERSION_LIST, TasktrackerPackage.VERSION__REPOSITORY);
		}
		return versionList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TasktrackerPackage.TASK_REPOSITORY__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TaskRepository> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList<TaskRepository>(TaskRepository.class, this, TasktrackerPackage.TASK_REPOSITORY__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskRepository getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (TaskRepository)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TasktrackerPackage.TASK_REPOSITORY__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskRepository basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(TaskRepository newParent) {
		TaskRepository oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TasktrackerPackage.TASK_REPOSITORY__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExternalId() {
		return externalId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExternalId(boolean newExternalId) {
		boolean oldExternalId = externalId;
		externalId = newExternalId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TasktrackerPackage.TASK_REPOSITORY__EXTERNAL_ID, oldExternalId, externalId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPublicRepo() {
		return publicRepo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublicRepo(boolean newPublicRepo) {
		boolean oldPublicRepo = publicRepo;
		publicRepo = newPublicRepo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TasktrackerPackage.TASK_REPOSITORY__PUBLIC_REPO, oldPublicRepo, publicRepo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TasktrackerPackage.TASK_REPOSITORY__PERSON_LIST:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPersonList()).basicAdd(otherEnd, msgs);
			case TasktrackerPackage.TASK_REPOSITORY__SOURCE_REPOSITORY_LIST:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSourceRepositoryList()).basicAdd(otherEnd, msgs);
			case TasktrackerPackage.TASK_REPOSITORY__VERSION_LIST:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getVersionList()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TasktrackerPackage.TASK_REPOSITORY__PERSON_LIST:
				return ((InternalEList<?>)getPersonList()).basicRemove(otherEnd, msgs);
			case TasktrackerPackage.TASK_REPOSITORY__SOURCE_REPOSITORY_LIST:
				return ((InternalEList<?>)getSourceRepositoryList()).basicRemove(otherEnd, msgs);
			case TasktrackerPackage.TASK_REPOSITORY__VERSION_LIST:
				return ((InternalEList<?>)getVersionList()).basicRemove(otherEnd, msgs);
			case TasktrackerPackage.TASK_REPOSITORY__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TasktrackerPackage.TASK_REPOSITORY__NAME:
				return getName();
			case TasktrackerPackage.TASK_REPOSITORY__PERSON_LIST:
				return getPersonList();
			case TasktrackerPackage.TASK_REPOSITORY__SOURCE_REPOSITORY_LIST:
				return getSourceRepositoryList();
			case TasktrackerPackage.TASK_REPOSITORY__VERSION_LIST:
				return getVersionList();
			case TasktrackerPackage.TASK_REPOSITORY__DESCRIPTION:
				return getDescription();
			case TasktrackerPackage.TASK_REPOSITORY__CHILDREN:
				return getChildren();
			case TasktrackerPackage.TASK_REPOSITORY__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case TasktrackerPackage.TASK_REPOSITORY__EXTERNAL_ID:
				return isExternalId();
			case TasktrackerPackage.TASK_REPOSITORY__PUBLIC_REPO:
				return isPublicRepo();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TasktrackerPackage.TASK_REPOSITORY__NAME:
				setName((String)newValue);
				return;
			case TasktrackerPackage.TASK_REPOSITORY__PERSON_LIST:
				getPersonList().clear();
				getPersonList().addAll((Collection<? extends RepositoryPerson>)newValue);
				return;
			case TasktrackerPackage.TASK_REPOSITORY__SOURCE_REPOSITORY_LIST:
				getSourceRepositoryList().clear();
				getSourceRepositoryList().addAll((Collection<? extends SourceRepository>)newValue);
				return;
			case TasktrackerPackage.TASK_REPOSITORY__VERSION_LIST:
				getVersionList().clear();
				getVersionList().addAll((Collection<? extends Version>)newValue);
				return;
			case TasktrackerPackage.TASK_REPOSITORY__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case TasktrackerPackage.TASK_REPOSITORY__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends TaskRepository>)newValue);
				return;
			case TasktrackerPackage.TASK_REPOSITORY__PARENT:
				setParent((TaskRepository)newValue);
				return;
			case TasktrackerPackage.TASK_REPOSITORY__EXTERNAL_ID:
				setExternalId((Boolean)newValue);
				return;
			case TasktrackerPackage.TASK_REPOSITORY__PUBLIC_REPO:
				setPublicRepo((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TasktrackerPackage.TASK_REPOSITORY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TasktrackerPackage.TASK_REPOSITORY__PERSON_LIST:
				getPersonList().clear();
				return;
			case TasktrackerPackage.TASK_REPOSITORY__SOURCE_REPOSITORY_LIST:
				getSourceRepositoryList().clear();
				return;
			case TasktrackerPackage.TASK_REPOSITORY__VERSION_LIST:
				getVersionList().clear();
				return;
			case TasktrackerPackage.TASK_REPOSITORY__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case TasktrackerPackage.TASK_REPOSITORY__CHILDREN:
				getChildren().clear();
				return;
			case TasktrackerPackage.TASK_REPOSITORY__PARENT:
				setParent((TaskRepository)null);
				return;
			case TasktrackerPackage.TASK_REPOSITORY__EXTERNAL_ID:
				setExternalId(EXTERNAL_ID_EDEFAULT);
				return;
			case TasktrackerPackage.TASK_REPOSITORY__PUBLIC_REPO:
				setPublicRepo(PUBLIC_REPO_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TasktrackerPackage.TASK_REPOSITORY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TasktrackerPackage.TASK_REPOSITORY__PERSON_LIST:
				return personList != null && !personList.isEmpty();
			case TasktrackerPackage.TASK_REPOSITORY__SOURCE_REPOSITORY_LIST:
				return sourceRepositoryList != null && !sourceRepositoryList.isEmpty();
			case TasktrackerPackage.TASK_REPOSITORY__VERSION_LIST:
				return versionList != null && !versionList.isEmpty();
			case TasktrackerPackage.TASK_REPOSITORY__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case TasktrackerPackage.TASK_REPOSITORY__CHILDREN:
				return children != null && !children.isEmpty();
			case TasktrackerPackage.TASK_REPOSITORY__PARENT:
				return parent != null;
			case TasktrackerPackage.TASK_REPOSITORY__EXTERNAL_ID:
				return externalId != EXTERNAL_ID_EDEFAULT;
			case TasktrackerPackage.TASK_REPOSITORY__PUBLIC_REPO:
				return publicRepo != PUBLIC_REPO_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", externalId: ");
		result.append(externalId);
		result.append(", publicRepo: ");
		result.append(publicRepo);
		result.append(')');
		return result.toString();
	}

} //TaskRepositoryImpl
