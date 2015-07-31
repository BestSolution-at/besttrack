/**
 */
package at.bestsolution.tasktracker.model.tasktracker.impl;

import at.bestsolution.tasktracker.model.tasktracker.Person;
import at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson;
import at.bestsolution.tasktracker.model.tasktracker.TaskRepository;
import at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository Person</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.impl.RepositoryPersonImpl#getPerson <em>Person</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.impl.RepositoryPersonImpl#getRepository <em>Repository</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.impl.RepositoryPersonImpl#getPrivilegeMask <em>Privilege Mask</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RepositoryPersonImpl extends BaseObjectImpl implements RepositoryPerson {
	/**
	 * The cached value of the '{@link #getPerson() <em>Person</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerson()
	 * @generated
	 * @ordered
	 */
	protected Person person;

	/**
	 * The default value of the '{@link #getPrivilegeMask() <em>Privilege Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrivilegeMask()
	 * @generated
	 * @ordered
	 */
	protected static final long PRIVILEGE_MASK_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getPrivilegeMask() <em>Privilege Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrivilegeMask()
	 * @generated
	 * @ordered
	 */
	protected long privilegeMask = PRIVILEGE_MASK_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepositoryPersonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TasktrackerPackage.Literals.REPOSITORY_PERSON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person getPerson() {
		if (person != null && person.eIsProxy()) {
			InternalEObject oldPerson = (InternalEObject)person;
			person = (Person)eResolveProxy(oldPerson);
			if (person != oldPerson) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TasktrackerPackage.REPOSITORY_PERSON__PERSON, oldPerson, person));
			}
		}
		return person;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person basicGetPerson() {
		return person;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPerson(Person newPerson, NotificationChain msgs) {
		Person oldPerson = person;
		person = newPerson;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TasktrackerPackage.REPOSITORY_PERSON__PERSON, oldPerson, newPerson);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPerson(Person newPerson) {
		if (newPerson != person) {
			NotificationChain msgs = null;
			if (person != null)
				msgs = ((InternalEObject)person).eInverseRemove(this, TasktrackerPackage.PERSON__REPOSITORY_LIST, Person.class, msgs);
			if (newPerson != null)
				msgs = ((InternalEObject)newPerson).eInverseAdd(this, TasktrackerPackage.PERSON__REPOSITORY_LIST, Person.class, msgs);
			msgs = basicSetPerson(newPerson, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TasktrackerPackage.REPOSITORY_PERSON__PERSON, newPerson, newPerson));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskRepository getRepository() {
		if (eContainerFeatureID() != TasktrackerPackage.REPOSITORY_PERSON__REPOSITORY) return null;
		return (TaskRepository)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepository(TaskRepository newRepository, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRepository, TasktrackerPackage.REPOSITORY_PERSON__REPOSITORY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepository(TaskRepository newRepository) {
		if (newRepository != eInternalContainer() || (eContainerFeatureID() != TasktrackerPackage.REPOSITORY_PERSON__REPOSITORY && newRepository != null)) {
			if (EcoreUtil.isAncestor(this, newRepository))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRepository != null)
				msgs = ((InternalEObject)newRepository).eInverseAdd(this, TasktrackerPackage.TASK_REPOSITORY__PERSON_LIST, TaskRepository.class, msgs);
			msgs = basicSetRepository(newRepository, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TasktrackerPackage.REPOSITORY_PERSON__REPOSITORY, newRepository, newRepository));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getPrivilegeMask() {
		return privilegeMask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrivilegeMask(long newPrivilegeMask) {
		long oldPrivilegeMask = privilegeMask;
		privilegeMask = newPrivilegeMask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TasktrackerPackage.REPOSITORY_PERSON__PRIVILEGE_MASK, oldPrivilegeMask, privilegeMask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TasktrackerPackage.REPOSITORY_PERSON__PERSON:
				if (person != null)
					msgs = ((InternalEObject)person).eInverseRemove(this, TasktrackerPackage.PERSON__REPOSITORY_LIST, Person.class, msgs);
				return basicSetPerson((Person)otherEnd, msgs);
			case TasktrackerPackage.REPOSITORY_PERSON__REPOSITORY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRepository((TaskRepository)otherEnd, msgs);
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
			case TasktrackerPackage.REPOSITORY_PERSON__PERSON:
				return basicSetPerson(null, msgs);
			case TasktrackerPackage.REPOSITORY_PERSON__REPOSITORY:
				return basicSetRepository(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TasktrackerPackage.REPOSITORY_PERSON__REPOSITORY:
				return eInternalContainer().eInverseRemove(this, TasktrackerPackage.TASK_REPOSITORY__PERSON_LIST, TaskRepository.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TasktrackerPackage.REPOSITORY_PERSON__PERSON:
				if (resolve) return getPerson();
				return basicGetPerson();
			case TasktrackerPackage.REPOSITORY_PERSON__REPOSITORY:
				return getRepository();
			case TasktrackerPackage.REPOSITORY_PERSON__PRIVILEGE_MASK:
				return getPrivilegeMask();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TasktrackerPackage.REPOSITORY_PERSON__PERSON:
				setPerson((Person)newValue);
				return;
			case TasktrackerPackage.REPOSITORY_PERSON__REPOSITORY:
				setRepository((TaskRepository)newValue);
				return;
			case TasktrackerPackage.REPOSITORY_PERSON__PRIVILEGE_MASK:
				setPrivilegeMask((Long)newValue);
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
			case TasktrackerPackage.REPOSITORY_PERSON__PERSON:
				setPerson((Person)null);
				return;
			case TasktrackerPackage.REPOSITORY_PERSON__REPOSITORY:
				setRepository((TaskRepository)null);
				return;
			case TasktrackerPackage.REPOSITORY_PERSON__PRIVILEGE_MASK:
				setPrivilegeMask(PRIVILEGE_MASK_EDEFAULT);
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
			case TasktrackerPackage.REPOSITORY_PERSON__PERSON:
				return person != null;
			case TasktrackerPackage.REPOSITORY_PERSON__REPOSITORY:
				return getRepository() != null;
			case TasktrackerPackage.REPOSITORY_PERSON__PRIVILEGE_MASK:
				return privilegeMask != PRIVILEGE_MASK_EDEFAULT;
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
		result.append(" (privilegeMask: ");
		result.append(privilegeMask);
		result.append(')');
		return result.toString();
	}

} //RepositoryPersonImpl
