/// <reference path="Comment.ts"/>

class CommentAttachment {
	metaClassname : String = "CommentAttachment"
	metaProxy : boolean = false

	// simple attributes
	sid : number
	title : string
	mimetype : string
	description : string

	// reference attributes
	comment : Comment
	constructor(jsonObject? : any) {
		if(jsonObject) {
			this.metaProxy = jsonObject.metaProxy

			this.sid = jsonObject.sid;
			this.title = jsonObject.title;
			this.mimetype = jsonObject.mimetype;
			this.description = jsonObject.description;

			this.comment = jsonObject.comment ? new Comment(jsonObject.comment) : null;
		}
	}
}
