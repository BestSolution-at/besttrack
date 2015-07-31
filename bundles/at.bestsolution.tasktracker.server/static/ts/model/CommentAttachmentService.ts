/// <reference path="../../typings/jquery/jquery.d.ts"/>

/// <reference path="CommentAttachment.ts"/>

interface CommentAttachmentValueCallback {
	( entity : CommentAttachment, err: any ) : void
}

interface CommentAttachmentListCallback {
	( entity : CommentAttachment[], err: any ) : void
}

interface CommentAttachmentCreationCallback {
	( id : number, err : any ) : void
}

class CommentAttachmentService {
	urlPrefix : string

	constructor(urlPrefix : string) {
		this.urlPrefix = urlPrefix
	}

	getAll( callback : CommentAttachmentListCallback ) {
		this.listRequest(this.urlPrefix + "/commentattachment", callback);
	}

	get( id : number, callback : CommentAttachmentValueCallback ) {
		this.valueRequest(this.urlPrefix + "/commentattachment/"+id, callback);
	}

	create( entity : CommentAttachment, callback : CommentAttachmentCreationCallback ) {
		$.ajax({
    		url: this.urlPrefix + "/commentattachment",
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			callback(data.value, null);
		} );
	}

	private listRequest(path : string, callback : CommentAttachmentListCallback ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any[]) {
			var entityList : CommentAttachment[] = data.map( function( o ) { return new CommentAttachment(o); } );
			callback(entityList, null);
		});
	}

	private valueRequest(path : string, callback : CommentAttachmentValueCallback ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any) {
			var entity : CommentAttachment;
			if( data ) {
				entity = new CommentAttachment(data);
			}
			callback(entity, null);
		});
	}

}