/// <reference path="DTOTaskRepository.ts"/>
/// <reference path="DTOComment.ts"/>
/// <reference path="DTOChangeSet.ts"/>
/// <reference path="DTOPerson.ts"/>
/// <reference path="DTOVersion.ts"/>
/// <reference path="DTOTaskAttachment.ts"/>

class DTOTask {
	metaClassname : String = "Task"
	metaProxy : boolean = false

	// simple attributes
	sid : number
	title : string
	description : string
	state : any
	externalBugId : string

	// reference attributes
	repository : DTOTaskRepository
	commentList : DTOComment[]
	changeSetList : DTOChangeSet[]
	reporter : DTOPerson
	assignee : DTOPerson
	targetVersion : DTOVersion
	productVersion : DTOVersion
	attachmentList : DTOTaskAttachment[]
	constructor(jsonObject? : any) {
		if(jsonObject) {
			this.metaProxy = jsonObject.metaProxy

			this.sid = jsonObject.sid;
			this.title = jsonObject.title;
			this.description = jsonObject.description;
			this.state = jsonObject.state;
			this.externalBugId = jsonObject.externalBugId;

			this.repository = jsonObject.repository ? new DTOTaskRepository(jsonObject.repository) : null;
			if( jsonObject.commentList ) {
				this.commentList = jsonObject.commentList.map( function( o ) { return new DTOComment(o); } );
			}
			if( jsonObject.changeSetList ) {
				this.changeSetList = jsonObject.changeSetList.map( function( o ) { return new DTOChangeSet(o); } );
			}
			this.reporter = jsonObject.reporter ? new DTOPerson(jsonObject.reporter) : null;
			this.assignee = jsonObject.assignee ? new DTOPerson(jsonObject.assignee) : null;
			this.targetVersion = jsonObject.targetVersion ? new DTOVersion(jsonObject.targetVersion) : null;
			this.productVersion = jsonObject.productVersion ? new DTOVersion(jsonObject.productVersion) : null;
			if( jsonObject.attachmentList ) {
				this.attachmentList = jsonObject.attachmentList.map( function( o ) { return new DTOTaskAttachment(o); } );
			}
		}
	}
}
