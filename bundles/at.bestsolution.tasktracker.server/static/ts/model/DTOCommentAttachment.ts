/// <reference path="DTOComment.ts"/>

class DTOCommentAttachment {
	metaClassname : String = "CommentAttachment"
	metaProxy : boolean = false

	// simple attributes
	sid : number
	title : string
	mimetype : string
	description : string

	// reference attributes
	comment : DTOComment
	constructor(jsonObject? : any) {
		if(jsonObject) {
			this.metaProxy = jsonObject.metaProxy

			this.sid = jsonObject.sid;
			this.title = jsonObject.title;
			this.mimetype = jsonObject.mimetype;
			this.description = jsonObject.description;

			this.comment = jsonObject.comment ? new DTOComment(jsonObject.comment) : null;
		}
	}
}
