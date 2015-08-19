/// <reference path="DTOTask.ts"/>
/// <reference path="DTOCommentAttachment.ts"/>

class DTOComment {
	metaClassname : String = "Comment"
	metaProxy : boolean = false

	// simple attributes
	sid : number
	title : string
	description : string

	// reference attributes
	task : DTOTask
	attachmentList : DTOCommentAttachment[]
	constructor(jsonObject? : any) {
		if(jsonObject) {
			this.metaProxy = jsonObject.metaProxy

			this.sid = jsonObject.sid;
			this.title = jsonObject.title;
			this.description = jsonObject.description;

			this.task = jsonObject.task ? new DTOTask(jsonObject.task) : null;
			if( jsonObject.attachmentList ) {
				this.attachmentList = jsonObject.attachmentList.map( function( o ) { return new DTOCommentAttachment(o); } );
			}
		}
	}
}
