/// <reference path="../../typings/jquery/jquery.d.ts"/>
/// <reference path="../util/bestUtils.ts"/>
/// <reference path="DTOCommentAttachment.ts"/>

class CommentAttachmentService {
	urlPrefix : string

	constructor(urlPrefix : string) {
		this.urlPrefix = urlPrefix
	}

	getAll( callback : Consumer<DTOCommentAttachment[]> ) {
		this.listRequest(this.urlPrefix + "/commentattachment", callback);
	}

	get( id : number, callback : Consumer<DTOCommentAttachment> ) {
		this.valueRequest(this.urlPrefix + "/commentattachment/"+id, callback);
	}

	create( entity : DTOCommentAttachment, callback : Consumer<DTOCommentAttachment> ) {
		$.ajax({
    		url: this.urlPrefix + "/commentattachment",
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			var entity : DTOCommentAttachment;
			if( data ) {
				entity = new DTOCommentAttachment(data);
			}
			callback(entity, null);
		} );
	}

	update( entity : DTOCommentAttachment, callback : Consumer<DTOCommentAttachment> ) {
		$.ajax({
    		url: this.urlPrefix + "/commentattachment/"+entity.sid,
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			var entity : DTOCommentAttachment;
			if( data ) {
				entity = new DTOCommentAttachment(data);
			}
			callback(entity, null);
		} );
	}

	private listRequest(path : string, callback : Consumer<DTOCommentAttachment[]> ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any[]) {
			var entityList : DTOCommentAttachment[] = data.map( function( o ) { return new DTOCommentAttachment(o); } );
			callback(entityList, null);
		});
	}

	private valueRequest(path : string, callback : Consumer<DTOCommentAttachment> ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any) {
			var entity : DTOCommentAttachment;
			if( data ) {
				entity = new DTOCommentAttachment(data);
			}
			callback(entity, null);
		});
	}

}