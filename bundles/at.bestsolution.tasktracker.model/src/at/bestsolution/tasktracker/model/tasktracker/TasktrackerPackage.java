/**
 */
package at.bestsolution.tasktracker.model.tasktracker;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerFactory
 * @model kind="package"
 * @generated
 */
public interface TasktrackerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tasktracker";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.bestsolution.at/emap/tasktracker/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tasktracker";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TasktrackerPackage eINSTANCE = at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl.init();

	/**
	 * The meta object id for the '{@link at.bestsolution.tasktracker.model.tasktracker.impl.BaseObjectImpl <em>Base Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.BaseObjectImpl
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getBaseObject()
	 * @generated
	 */
	int BASE_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Sid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_OBJECT__SID = 0;

	/**
	 * The number of structural features of the '<em>Base Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_OBJECT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Base Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.tasktracker.model.tasktracker.impl.TaskRepositoryImpl <em>Task Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TaskRepositoryImpl
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getTaskRepository()
	 * @generated
	 */
	int TASK_REPOSITORY = 1;

	/**
	 * The feature id for the '<em><b>Sid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_REPOSITORY__SID = BASE_OBJECT__SID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_REPOSITORY__NAME = BASE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Person List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_REPOSITORY__PERSON_LIST = BASE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source Repository List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_REPOSITORY__SOURCE_REPOSITORY_LIST = BASE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Version List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_REPOSITORY__VERSION_LIST = BASE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_REPOSITORY__DESCRIPTION = BASE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_REPOSITORY__CHILDREN = BASE_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_REPOSITORY__PARENT = BASE_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>External Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_REPOSITORY__EXTERNAL_ID = BASE_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Public Repo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_REPOSITORY__PUBLIC_REPO = BASE_OBJECT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Task Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_REPOSITORY_FEATURE_COUNT = BASE_OBJECT_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>Task Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_REPOSITORY_OPERATION_COUNT = BASE_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.tasktracker.model.tasktracker.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.PersonImpl
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 2;

	/**
	 * The feature id for the '<em><b>Sid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__SID = BASE_OBJECT__SID;

	/**
	 * The feature id for the '<em><b>Firstname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__FIRSTNAME = BASE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lastname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__LASTNAME = BASE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Repository List</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__REPOSITORY_LIST = BASE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = BASE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_OPERATION_COUNT = BASE_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.tasktracker.model.tasktracker.impl.TaskImpl <em>Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TaskImpl
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getTask()
	 * @generated
	 */
	int TASK = 3;

	/**
	 * The feature id for the '<em><b>Sid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__SID = BASE_OBJECT__SID;

	/**
	 * The feature id for the '<em><b>Repository</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__REPOSITORY = BASE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__TITLE = BASE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__DESCRIPTION = BASE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Comment List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__COMMENT_LIST = BASE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Change Set List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__CHANGE_SET_LIST = BASE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Reporter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__REPORTER = BASE_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Assignee</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__ASSIGNEE = BASE_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__STATE = BASE_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Target Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__TARGET_VERSION = BASE_OBJECT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Product Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__PRODUCT_VERSION = BASE_OBJECT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Attachment List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__ATTACHMENT_LIST = BASE_OBJECT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>External Bug Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__EXTERNAL_BUG_ID = BASE_OBJECT_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_FEATURE_COUNT = BASE_OBJECT_FEATURE_COUNT + 12;

	/**
	 * The number of operations of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_OPERATION_COUNT = BASE_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.tasktracker.model.tasktracker.impl.CommentImpl <em>Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.CommentImpl
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getComment()
	 * @generated
	 */
	int COMMENT = 4;

	/**
	 * The feature id for the '<em><b>Sid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__SID = BASE_OBJECT__SID;

	/**
	 * The feature id for the '<em><b>Task</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__TASK = BASE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__TITLE = BASE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__DESCRIPTION = BASE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Attachment List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__ATTACHMENT_LIST = BASE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_FEATURE_COUNT = BASE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_OPERATION_COUNT = BASE_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.tasktracker.model.tasktracker.impl.ChangeSetImpl <em>Change Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.ChangeSetImpl
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getChangeSet()
	 * @generated
	 */
	int CHANGE_SET = 5;

	/**
	 * The feature id for the '<em><b>Sid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET__SID = BASE_OBJECT__SID;

	/**
	 * The feature id for the '<em><b>Task</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET__TASK = BASE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET__ID = BASE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source Repository</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET__SOURCE_REPOSITORY = BASE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET__COMMENT = BASE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Person</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET__PERSON = BASE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Change Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET_FEATURE_COUNT = BASE_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Change Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET_OPERATION_COUNT = BASE_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.tasktracker.model.tasktracker.impl.SourceRepositoryImpl <em>Source Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.SourceRepositoryImpl
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getSourceRepository()
	 * @generated
	 */
	int SOURCE_REPOSITORY = 6;

	/**
	 * The feature id for the '<em><b>Sid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_REPOSITORY__SID = BASE_OBJECT__SID;

	/**
	 * The feature id for the '<em><b>Source Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_REPOSITORY__SOURCE_URL = BASE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Web Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_REPOSITORY__WEB_URL = BASE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_REPOSITORY__TYPE = BASE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Repository</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_REPOSITORY__REPOSITORY = BASE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Source Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_REPOSITORY_FEATURE_COUNT = BASE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Source Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_REPOSITORY_OPERATION_COUNT = BASE_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.tasktracker.model.tasktracker.impl.VersionImpl <em>Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.VersionImpl
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getVersion()
	 * @generated
	 */
	int VERSION = 7;

	/**
	 * The feature id for the '<em><b>Sid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__SID = BASE_OBJECT__SID;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__VALUE = BASE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__DATE = BASE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Codename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__CODENAME = BASE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Repository</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__REPOSITORY = BASE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_FEATURE_COUNT = BASE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_OPERATION_COUNT = BASE_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.tasktracker.model.tasktracker.impl.AttachmentImpl <em>Attachment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.AttachmentImpl
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getAttachment()
	 * @generated
	 */
	int ATTACHMENT = 8;

	/**
	 * The feature id for the '<em><b>Sid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT__SID = BASE_OBJECT__SID;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT__TITLE = BASE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mimetype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT__MIMETYPE = BASE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Binary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT__BINARY = BASE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT__DESCRIPTION = BASE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Attachment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_FEATURE_COUNT = BASE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Attachment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_OPERATION_COUNT = BASE_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.tasktracker.model.tasktracker.impl.CommentAttachmentImpl <em>Comment Attachment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.CommentAttachmentImpl
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getCommentAttachment()
	 * @generated
	 */
	int COMMENT_ATTACHMENT = 9;

	/**
	 * The feature id for the '<em><b>Sid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_ATTACHMENT__SID = ATTACHMENT__SID;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_ATTACHMENT__TITLE = ATTACHMENT__TITLE;

	/**
	 * The feature id for the '<em><b>Mimetype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_ATTACHMENT__MIMETYPE = ATTACHMENT__MIMETYPE;

	/**
	 * The feature id for the '<em><b>Binary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_ATTACHMENT__BINARY = ATTACHMENT__BINARY;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_ATTACHMENT__DESCRIPTION = ATTACHMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_ATTACHMENT__COMMENT = ATTACHMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Comment Attachment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_ATTACHMENT_FEATURE_COUNT = ATTACHMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Comment Attachment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_ATTACHMENT_OPERATION_COUNT = ATTACHMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.tasktracker.model.tasktracker.impl.TaskAttachmentImpl <em>Task Attachment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TaskAttachmentImpl
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getTaskAttachment()
	 * @generated
	 */
	int TASK_ATTACHMENT = 10;

	/**
	 * The feature id for the '<em><b>Sid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_ATTACHMENT__SID = ATTACHMENT__SID;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_ATTACHMENT__TITLE = ATTACHMENT__TITLE;

	/**
	 * The feature id for the '<em><b>Mimetype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_ATTACHMENT__MIMETYPE = ATTACHMENT__MIMETYPE;

	/**
	 * The feature id for the '<em><b>Binary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_ATTACHMENT__BINARY = ATTACHMENT__BINARY;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_ATTACHMENT__DESCRIPTION = ATTACHMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Task</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_ATTACHMENT__TASK = ATTACHMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Task Attachment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_ATTACHMENT_FEATURE_COUNT = ATTACHMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Task Attachment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_ATTACHMENT_OPERATION_COUNT = ATTACHMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.tasktracker.model.tasktracker.impl.RepositoryPersonImpl <em>Repository Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.RepositoryPersonImpl
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getRepositoryPerson()
	 * @generated
	 */
	int REPOSITORY_PERSON = 11;

	/**
	 * The feature id for the '<em><b>Sid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_PERSON__SID = BASE_OBJECT__SID;

	/**
	 * The feature id for the '<em><b>Person</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_PERSON__PERSON = BASE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Repository</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_PERSON__REPOSITORY = BASE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Privilege Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_PERSON__PRIVILEGE_MASK = BASE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Repository Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_PERSON_FEATURE_COUNT = BASE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Repository Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_PERSON_OPERATION_COUNT = BASE_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.tasktracker.model.tasktracker.TaskState <em>Task State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.tasktracker.model.tasktracker.TaskState
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getTaskState()
	 * @generated
	 */
	int TASK_STATE = 12;

	/**
	 * The meta object id for the '{@link at.bestsolution.tasktracker.model.tasktracker.SourceRepositoryType <em>Source Repository Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.tasktracker.model.tasktracker.SourceRepositoryType
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getSourceRepositoryType()
	 * @generated
	 */
	int SOURCE_REPOSITORY_TYPE = 13;

	/**
	 * The meta object id for the '<em>Blob</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.sql.Blob
	 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getBlob()
	 * @generated
	 */
	int BLOB = 14;


	/**
	 * Returns the meta object for class '{@link at.bestsolution.tasktracker.model.tasktracker.BaseObject <em>Base Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Object</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.BaseObject
	 * @generated
	 */
	EClass getBaseObject();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.BaseObject#getSid <em>Sid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sid</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.BaseObject#getSid()
	 * @see #getBaseObject()
	 * @generated
	 */
	EAttribute getBaseObject_Sid();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository <em>Task Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Repository</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.TaskRepository
	 * @generated
	 */
	EClass getTaskRepository();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getName()
	 * @see #getTaskRepository()
	 * @generated
	 */
	EAttribute getTaskRepository_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getPersonList <em>Person List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Person List</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getPersonList()
	 * @see #getTaskRepository()
	 * @generated
	 */
	EReference getTaskRepository_PersonList();

	/**
	 * Returns the meta object for the containment reference list '{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getSourceRepositoryList <em>Source Repository List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Repository List</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getSourceRepositoryList()
	 * @see #getTaskRepository()
	 * @generated
	 */
	EReference getTaskRepository_SourceRepositoryList();

	/**
	 * Returns the meta object for the containment reference list '{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getVersionList <em>Version List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Version List</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getVersionList()
	 * @see #getTaskRepository()
	 * @generated
	 */
	EReference getTaskRepository_VersionList();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getDescription()
	 * @see #getTaskRepository()
	 * @generated
	 */
	EAttribute getTaskRepository_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getChildren()
	 * @see #getTaskRepository()
	 * @generated
	 */
	EReference getTaskRepository_Children();

	/**
	 * Returns the meta object for the reference '{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getParent()
	 * @see #getTaskRepository()
	 * @generated
	 */
	EReference getTaskRepository_Parent();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#isExternalId <em>External Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External Id</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.TaskRepository#isExternalId()
	 * @see #getTaskRepository()
	 * @generated
	 */
	EAttribute getTaskRepository_ExternalId();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#isPublicRepo <em>Public Repo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Public Repo</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.TaskRepository#isPublicRepo()
	 * @see #getTaskRepository()
	 * @generated
	 */
	EAttribute getTaskRepository_PublicRepo();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.tasktracker.model.tasktracker.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.Person#getFirstname <em>Firstname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Firstname</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Person#getFirstname()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Firstname();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.Person#getLastname <em>Lastname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lastname</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Person#getLastname()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Lastname();

	/**
	 * Returns the meta object for the reference list '{@link at.bestsolution.tasktracker.model.tasktracker.Person#getRepositoryList <em>Repository List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Repository List</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Person#getRepositoryList()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_RepositoryList();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.tasktracker.model.tasktracker.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Task
	 * @generated
	 */
	EClass getTask();

	/**
	 * Returns the meta object for the reference '{@link at.bestsolution.tasktracker.model.tasktracker.Task#getRepository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Repository</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Task#getRepository()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_Repository();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.Task#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Task#getTitle()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_Title();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.Task#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Task#getDescription()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link at.bestsolution.tasktracker.model.tasktracker.Task#getCommentList <em>Comment List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Comment List</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Task#getCommentList()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_CommentList();

	/**
	 * Returns the meta object for the containment reference list '{@link at.bestsolution.tasktracker.model.tasktracker.Task#getChangeSetList <em>Change Set List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Change Set List</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Task#getChangeSetList()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_ChangeSetList();

	/**
	 * Returns the meta object for the reference '{@link at.bestsolution.tasktracker.model.tasktracker.Task#getReporter <em>Reporter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reporter</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Task#getReporter()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_Reporter();

	/**
	 * Returns the meta object for the reference '{@link at.bestsolution.tasktracker.model.tasktracker.Task#getAssignee <em>Assignee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assignee</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Task#getAssignee()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_Assignee();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.Task#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Task#getState()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_State();

	/**
	 * Returns the meta object for the reference '{@link at.bestsolution.tasktracker.model.tasktracker.Task#getTargetVersion <em>Target Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Version</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Task#getTargetVersion()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_TargetVersion();

	/**
	 * Returns the meta object for the reference '{@link at.bestsolution.tasktracker.model.tasktracker.Task#getProductVersion <em>Product Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Product Version</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Task#getProductVersion()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_ProductVersion();

	/**
	 * Returns the meta object for the containment reference list '{@link at.bestsolution.tasktracker.model.tasktracker.Task#getAttachmentList <em>Attachment List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attachment List</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Task#getAttachmentList()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_AttachmentList();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.Task#getExternalBugId <em>External Bug Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External Bug Id</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Task#getExternalBugId()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_ExternalBugId();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.tasktracker.model.tasktracker.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comment</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Comment
	 * @generated
	 */
	EClass getComment();

	/**
	 * Returns the meta object for the container reference '{@link at.bestsolution.tasktracker.model.tasktracker.Comment#getTask <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Task</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Comment#getTask()
	 * @see #getComment()
	 * @generated
	 */
	EReference getComment_Task();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.Comment#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Comment#getTitle()
	 * @see #getComment()
	 * @generated
	 */
	EAttribute getComment_Title();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.Comment#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Comment#getDescription()
	 * @see #getComment()
	 * @generated
	 */
	EAttribute getComment_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link at.bestsolution.tasktracker.model.tasktracker.Comment#getAttachmentList <em>Attachment List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attachment List</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Comment#getAttachmentList()
	 * @see #getComment()
	 * @generated
	 */
	EReference getComment_AttachmentList();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.tasktracker.model.tasktracker.ChangeSet <em>Change Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Change Set</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.ChangeSet
	 * @generated
	 */
	EClass getChangeSet();

	/**
	 * Returns the meta object for the container reference '{@link at.bestsolution.tasktracker.model.tasktracker.ChangeSet#getTask <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Task</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.ChangeSet#getTask()
	 * @see #getChangeSet()
	 * @generated
	 */
	EReference getChangeSet_Task();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.ChangeSet#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.ChangeSet#getId()
	 * @see #getChangeSet()
	 * @generated
	 */
	EAttribute getChangeSet_Id();

	/**
	 * Returns the meta object for the reference '{@link at.bestsolution.tasktracker.model.tasktracker.ChangeSet#getSourceRepository <em>Source Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Repository</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.ChangeSet#getSourceRepository()
	 * @see #getChangeSet()
	 * @generated
	 */
	EReference getChangeSet_SourceRepository();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.ChangeSet#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.ChangeSet#getComment()
	 * @see #getChangeSet()
	 * @generated
	 */
	EAttribute getChangeSet_Comment();

	/**
	 * Returns the meta object for the reference '{@link at.bestsolution.tasktracker.model.tasktracker.ChangeSet#getPerson <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Person</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.ChangeSet#getPerson()
	 * @see #getChangeSet()
	 * @generated
	 */
	EReference getChangeSet_Person();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.tasktracker.model.tasktracker.SourceRepository <em>Source Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Repository</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.SourceRepository
	 * @generated
	 */
	EClass getSourceRepository();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.SourceRepository#getSourceUrl <em>Source Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Url</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.SourceRepository#getSourceUrl()
	 * @see #getSourceRepository()
	 * @generated
	 */
	EAttribute getSourceRepository_SourceUrl();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.SourceRepository#getWebUrl <em>Web Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Web Url</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.SourceRepository#getWebUrl()
	 * @see #getSourceRepository()
	 * @generated
	 */
	EAttribute getSourceRepository_WebUrl();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.SourceRepository#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.SourceRepository#getType()
	 * @see #getSourceRepository()
	 * @generated
	 */
	EAttribute getSourceRepository_Type();

	/**
	 * Returns the meta object for the container reference '{@link at.bestsolution.tasktracker.model.tasktracker.SourceRepository#getRepository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Repository</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.SourceRepository#getRepository()
	 * @see #getSourceRepository()
	 * @generated
	 */
	EReference getSourceRepository_Repository();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.tasktracker.model.tasktracker.Version <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Version
	 * @generated
	 */
	EClass getVersion();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.Version#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Version#getValue()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_Value();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.Version#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Version#getDate()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_Date();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.Version#getCodename <em>Codename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Codename</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Version#getCodename()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_Codename();

	/**
	 * Returns the meta object for the container reference '{@link at.bestsolution.tasktracker.model.tasktracker.Version#getRepository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Repository</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Version#getRepository()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_Repository();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.tasktracker.model.tasktracker.Attachment <em>Attachment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attachment</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Attachment
	 * @generated
	 */
	EClass getAttachment();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.Attachment#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Attachment#getTitle()
	 * @see #getAttachment()
	 * @generated
	 */
	EAttribute getAttachment_Title();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.Attachment#getMimetype <em>Mimetype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mimetype</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Attachment#getMimetype()
	 * @see #getAttachment()
	 * @generated
	 */
	EAttribute getAttachment_Mimetype();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.Attachment#getBinary <em>Binary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Binary</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Attachment#getBinary()
	 * @see #getAttachment()
	 * @generated
	 */
	EAttribute getAttachment_Binary();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.Attachment#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.Attachment#getDescription()
	 * @see #getAttachment()
	 * @generated
	 */
	EAttribute getAttachment_Description();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.tasktracker.model.tasktracker.CommentAttachment <em>Comment Attachment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comment Attachment</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.CommentAttachment
	 * @generated
	 */
	EClass getCommentAttachment();

	/**
	 * Returns the meta object for the container reference '{@link at.bestsolution.tasktracker.model.tasktracker.CommentAttachment#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Comment</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.CommentAttachment#getComment()
	 * @see #getCommentAttachment()
	 * @generated
	 */
	EReference getCommentAttachment_Comment();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.tasktracker.model.tasktracker.TaskAttachment <em>Task Attachment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Attachment</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.TaskAttachment
	 * @generated
	 */
	EClass getTaskAttachment();

	/**
	 * Returns the meta object for the container reference '{@link at.bestsolution.tasktracker.model.tasktracker.TaskAttachment#getTask <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Task</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.TaskAttachment#getTask()
	 * @see #getTaskAttachment()
	 * @generated
	 */
	EReference getTaskAttachment_Task();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson <em>Repository Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repository Person</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson
	 * @generated
	 */
	EClass getRepositoryPerson();

	/**
	 * Returns the meta object for the reference '{@link at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson#getPerson <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Person</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson#getPerson()
	 * @see #getRepositoryPerson()
	 * @generated
	 */
	EReference getRepositoryPerson_Person();

	/**
	 * Returns the meta object for the container reference '{@link at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson#getRepository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Repository</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson#getRepository()
	 * @see #getRepositoryPerson()
	 * @generated
	 */
	EReference getRepositoryPerson_Repository();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson#getPrivilegeMask <em>Privilege Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Privilege Mask</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson#getPrivilegeMask()
	 * @see #getRepositoryPerson()
	 * @generated
	 */
	EAttribute getRepositoryPerson_PrivilegeMask();

	/**
	 * Returns the meta object for enum '{@link at.bestsolution.tasktracker.model.tasktracker.TaskState <em>Task State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Task State</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.TaskState
	 * @generated
	 */
	EEnum getTaskState();

	/**
	 * Returns the meta object for enum '{@link at.bestsolution.tasktracker.model.tasktracker.SourceRepositoryType <em>Source Repository Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Source Repository Type</em>'.
	 * @see at.bestsolution.tasktracker.model.tasktracker.SourceRepositoryType
	 * @generated
	 */
	EEnum getSourceRepositoryType();

	/**
	 * Returns the meta object for data type '{@link java.sql.Blob <em>Blob</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Blob</em>'.
	 * @see java.sql.Blob
	 * @model instanceClass="java.sql.Blob"
	 * @generated
	 */
	EDataType getBlob();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TasktrackerFactory getTasktrackerFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link at.bestsolution.tasktracker.model.tasktracker.impl.BaseObjectImpl <em>Base Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.BaseObjectImpl
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getBaseObject()
		 * @generated
		 */
		EClass BASE_OBJECT = eINSTANCE.getBaseObject();

		/**
		 * The meta object literal for the '<em><b>Sid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_OBJECT__SID = eINSTANCE.getBaseObject_Sid();

		/**
		 * The meta object literal for the '{@link at.bestsolution.tasktracker.model.tasktracker.impl.TaskRepositoryImpl <em>Task Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TaskRepositoryImpl
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getTaskRepository()
		 * @generated
		 */
		EClass TASK_REPOSITORY = eINSTANCE.getTaskRepository();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_REPOSITORY__NAME = eINSTANCE.getTaskRepository_Name();

		/**
		 * The meta object literal for the '<em><b>Person List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_REPOSITORY__PERSON_LIST = eINSTANCE.getTaskRepository_PersonList();

		/**
		 * The meta object literal for the '<em><b>Source Repository List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_REPOSITORY__SOURCE_REPOSITORY_LIST = eINSTANCE.getTaskRepository_SourceRepositoryList();

		/**
		 * The meta object literal for the '<em><b>Version List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_REPOSITORY__VERSION_LIST = eINSTANCE.getTaskRepository_VersionList();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_REPOSITORY__DESCRIPTION = eINSTANCE.getTaskRepository_Description();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_REPOSITORY__CHILDREN = eINSTANCE.getTaskRepository_Children();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_REPOSITORY__PARENT = eINSTANCE.getTaskRepository_Parent();

		/**
		 * The meta object literal for the '<em><b>External Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_REPOSITORY__EXTERNAL_ID = eINSTANCE.getTaskRepository_ExternalId();

		/**
		 * The meta object literal for the '<em><b>Public Repo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_REPOSITORY__PUBLIC_REPO = eINSTANCE.getTaskRepository_PublicRepo();

		/**
		 * The meta object literal for the '{@link at.bestsolution.tasktracker.model.tasktracker.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.PersonImpl
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em><b>Firstname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__FIRSTNAME = eINSTANCE.getPerson_Firstname();

		/**
		 * The meta object literal for the '<em><b>Lastname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__LASTNAME = eINSTANCE.getPerson_Lastname();

		/**
		 * The meta object literal for the '<em><b>Repository List</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__REPOSITORY_LIST = eINSTANCE.getPerson_RepositoryList();

		/**
		 * The meta object literal for the '{@link at.bestsolution.tasktracker.model.tasktracker.impl.TaskImpl <em>Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TaskImpl
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getTask()
		 * @generated
		 */
		EClass TASK = eINSTANCE.getTask();

		/**
		 * The meta object literal for the '<em><b>Repository</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__REPOSITORY = eINSTANCE.getTask_Repository();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK__TITLE = eINSTANCE.getTask_Title();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK__DESCRIPTION = eINSTANCE.getTask_Description();

		/**
		 * The meta object literal for the '<em><b>Comment List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__COMMENT_LIST = eINSTANCE.getTask_CommentList();

		/**
		 * The meta object literal for the '<em><b>Change Set List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__CHANGE_SET_LIST = eINSTANCE.getTask_ChangeSetList();

		/**
		 * The meta object literal for the '<em><b>Reporter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__REPORTER = eINSTANCE.getTask_Reporter();

		/**
		 * The meta object literal for the '<em><b>Assignee</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__ASSIGNEE = eINSTANCE.getTask_Assignee();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK__STATE = eINSTANCE.getTask_State();

		/**
		 * The meta object literal for the '<em><b>Target Version</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__TARGET_VERSION = eINSTANCE.getTask_TargetVersion();

		/**
		 * The meta object literal for the '<em><b>Product Version</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__PRODUCT_VERSION = eINSTANCE.getTask_ProductVersion();

		/**
		 * The meta object literal for the '<em><b>Attachment List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__ATTACHMENT_LIST = eINSTANCE.getTask_AttachmentList();

		/**
		 * The meta object literal for the '<em><b>External Bug Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK__EXTERNAL_BUG_ID = eINSTANCE.getTask_ExternalBugId();

		/**
		 * The meta object literal for the '{@link at.bestsolution.tasktracker.model.tasktracker.impl.CommentImpl <em>Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.CommentImpl
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getComment()
		 * @generated
		 */
		EClass COMMENT = eINSTANCE.getComment();

		/**
		 * The meta object literal for the '<em><b>Task</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMENT__TASK = eINSTANCE.getComment_Task();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMENT__TITLE = eINSTANCE.getComment_Title();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMENT__DESCRIPTION = eINSTANCE.getComment_Description();

		/**
		 * The meta object literal for the '<em><b>Attachment List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMENT__ATTACHMENT_LIST = eINSTANCE.getComment_AttachmentList();

		/**
		 * The meta object literal for the '{@link at.bestsolution.tasktracker.model.tasktracker.impl.ChangeSetImpl <em>Change Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.ChangeSetImpl
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getChangeSet()
		 * @generated
		 */
		EClass CHANGE_SET = eINSTANCE.getChangeSet();

		/**
		 * The meta object literal for the '<em><b>Task</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANGE_SET__TASK = eINSTANCE.getChangeSet_Task();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHANGE_SET__ID = eINSTANCE.getChangeSet_Id();

		/**
		 * The meta object literal for the '<em><b>Source Repository</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANGE_SET__SOURCE_REPOSITORY = eINSTANCE.getChangeSet_SourceRepository();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHANGE_SET__COMMENT = eINSTANCE.getChangeSet_Comment();

		/**
		 * The meta object literal for the '<em><b>Person</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANGE_SET__PERSON = eINSTANCE.getChangeSet_Person();

		/**
		 * The meta object literal for the '{@link at.bestsolution.tasktracker.model.tasktracker.impl.SourceRepositoryImpl <em>Source Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.SourceRepositoryImpl
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getSourceRepository()
		 * @generated
		 */
		EClass SOURCE_REPOSITORY = eINSTANCE.getSourceRepository();

		/**
		 * The meta object literal for the '<em><b>Source Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_REPOSITORY__SOURCE_URL = eINSTANCE.getSourceRepository_SourceUrl();

		/**
		 * The meta object literal for the '<em><b>Web Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_REPOSITORY__WEB_URL = eINSTANCE.getSourceRepository_WebUrl();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_REPOSITORY__TYPE = eINSTANCE.getSourceRepository_Type();

		/**
		 * The meta object literal for the '<em><b>Repository</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_REPOSITORY__REPOSITORY = eINSTANCE.getSourceRepository_Repository();

		/**
		 * The meta object literal for the '{@link at.bestsolution.tasktracker.model.tasktracker.impl.VersionImpl <em>Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.VersionImpl
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getVersion()
		 * @generated
		 */
		EClass VERSION = eINSTANCE.getVersion();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__VALUE = eINSTANCE.getVersion_Value();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__DATE = eINSTANCE.getVersion_Date();

		/**
		 * The meta object literal for the '<em><b>Codename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__CODENAME = eINSTANCE.getVersion_Codename();

		/**
		 * The meta object literal for the '<em><b>Repository</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__REPOSITORY = eINSTANCE.getVersion_Repository();

		/**
		 * The meta object literal for the '{@link at.bestsolution.tasktracker.model.tasktracker.impl.AttachmentImpl <em>Attachment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.AttachmentImpl
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getAttachment()
		 * @generated
		 */
		EClass ATTACHMENT = eINSTANCE.getAttachment();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHMENT__TITLE = eINSTANCE.getAttachment_Title();

		/**
		 * The meta object literal for the '<em><b>Mimetype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHMENT__MIMETYPE = eINSTANCE.getAttachment_Mimetype();

		/**
		 * The meta object literal for the '<em><b>Binary</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHMENT__BINARY = eINSTANCE.getAttachment_Binary();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHMENT__DESCRIPTION = eINSTANCE.getAttachment_Description();

		/**
		 * The meta object literal for the '{@link at.bestsolution.tasktracker.model.tasktracker.impl.CommentAttachmentImpl <em>Comment Attachment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.CommentAttachmentImpl
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getCommentAttachment()
		 * @generated
		 */
		EClass COMMENT_ATTACHMENT = eINSTANCE.getCommentAttachment();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMENT_ATTACHMENT__COMMENT = eINSTANCE.getCommentAttachment_Comment();

		/**
		 * The meta object literal for the '{@link at.bestsolution.tasktracker.model.tasktracker.impl.TaskAttachmentImpl <em>Task Attachment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TaskAttachmentImpl
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getTaskAttachment()
		 * @generated
		 */
		EClass TASK_ATTACHMENT = eINSTANCE.getTaskAttachment();

		/**
		 * The meta object literal for the '<em><b>Task</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_ATTACHMENT__TASK = eINSTANCE.getTaskAttachment_Task();

		/**
		 * The meta object literal for the '{@link at.bestsolution.tasktracker.model.tasktracker.impl.RepositoryPersonImpl <em>Repository Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.RepositoryPersonImpl
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getRepositoryPerson()
		 * @generated
		 */
		EClass REPOSITORY_PERSON = eINSTANCE.getRepositoryPerson();

		/**
		 * The meta object literal for the '<em><b>Person</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY_PERSON__PERSON = eINSTANCE.getRepositoryPerson_Person();

		/**
		 * The meta object literal for the '<em><b>Repository</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY_PERSON__REPOSITORY = eINSTANCE.getRepositoryPerson_Repository();

		/**
		 * The meta object literal for the '<em><b>Privilege Mask</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPOSITORY_PERSON__PRIVILEGE_MASK = eINSTANCE.getRepositoryPerson_PrivilegeMask();

		/**
		 * The meta object literal for the '{@link at.bestsolution.tasktracker.model.tasktracker.TaskState <em>Task State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.tasktracker.model.tasktracker.TaskState
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getTaskState()
		 * @generated
		 */
		EEnum TASK_STATE = eINSTANCE.getTaskState();

		/**
		 * The meta object literal for the '{@link at.bestsolution.tasktracker.model.tasktracker.SourceRepositoryType <em>Source Repository Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.tasktracker.model.tasktracker.SourceRepositoryType
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getSourceRepositoryType()
		 * @generated
		 */
		EEnum SOURCE_REPOSITORY_TYPE = eINSTANCE.getSourceRepositoryType();

		/**
		 * The meta object literal for the '<em>Blob</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.sql.Blob
		 * @see at.bestsolution.tasktracker.model.tasktracker.impl.TasktrackerPackageImpl#getBlob()
		 * @generated
		 */
		EDataType BLOB = eINSTANCE.getBlob();

	}

} //TasktrackerPackage
