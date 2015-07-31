/// <reference path="TaskRepository.ts"/>
/// <reference path="Comment.ts"/>
/// <reference path="ChangeSet.ts"/>
/// <reference path="Person.ts"/>
/// <reference path="Version.ts"/>
/// <reference path="TaskAttachment.ts"/>

class Task {
	metaClassname : String = "Task"
	metaProxy : boolean = false

	// simple attributes
	sid : number
	title : string
	description : string
	state : any
	externalBugId : string

	// reference attributes
	repository : TaskRepository
	commentList : Comment[]
	changeSetList : ChangeSet[]
	reporter : Person
	assignee : Person
	targetVersion : Version
	productVersion : Version
	attachmentList : TaskAttachment[]
	constructor(jsonObject? : any) {
		if(jsonObject) {
			this.metaProxy = jsonObject.metaProxy

			this.sid = jsonObject.sid;
			this.title = jsonObject.title;
			this.description = jsonObject.description;
			this.state = jsonObject.state;
			this.externalBugId = jsonObject.externalBugId;

			this.repository = jsonObject.repository ? new TaskRepository(jsonObject.repository) : null;
			if( jsonObject.commentList ) {
				this.commentList = jsonObject.commentList.map( function( o ) { return new Comment(o); } );
			}
			if( jsonObject.changeSetList ) {
				this.changeSetList = jsonObject.changeSetList.map( function( o ) { return new ChangeSet(o); } );
			}
			this.reporter = jsonObject.reporter ? new Person(jsonObject.reporter) : null;
			this.assignee = jsonObject.assignee ? new Person(jsonObject.assignee) : null;
			this.targetVersion = jsonObject.targetVersion ? new Version(jsonObject.targetVersion) : null;
			this.productVersion = jsonObject.productVersion ? new Version(jsonObject.productVersion) : null;
			if( jsonObject.attachmentList ) {
				this.attachmentList = jsonObject.attachmentList.map( function( o ) { return new TaskAttachment(o); } );
			}
		}
	}
}
