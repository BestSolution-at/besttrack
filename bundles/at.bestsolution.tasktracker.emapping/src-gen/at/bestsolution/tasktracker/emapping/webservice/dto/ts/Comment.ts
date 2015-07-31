/// <reference path="Task.ts"/>
/// <reference path="CommentAttachment.ts"/>

class Comment {
	metaClassname : String = "Comment"
	metaProxy : boolean = false

	// simple attributes
	sid : number
	title : string
	description : string

	// reference attributes
	task : Task
	attachmentList : CommentAttachment[]
	constructor(jsonObject? : any) {
		if(jsonObject) {
			this.metaProxy = jsonObject.metaProxy

			this.sid = jsonObject.sid;
			this.title = jsonObject.title;
			this.description = jsonObject.description;

			this.task = jsonObject.task ? new Task(jsonObject.task) : null;
			if( jsonObject.attachmentList ) {
				this.attachmentList = jsonObject.attachmentList.map( function( o ) { return new CommentAttachment(o); } );
			}
		}
	}
}
