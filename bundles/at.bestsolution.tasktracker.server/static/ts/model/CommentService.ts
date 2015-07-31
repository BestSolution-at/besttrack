/// <reference path="../../typings/jquery/jquery.d.ts"/>

/// <reference path="Comment.ts"/>

interface CommentValueCallback {
	( entity : Comment, err: any ) : void
}

interface CommentListCallback {
	( entity : Comment[], err: any ) : void
}

interface CommentCreationCallback {
	( id : number, err : any ) : void
}

class CommentService {
	urlPrefix : string

	constructor(urlPrefix : string) {
		this.urlPrefix = urlPrefix
	}

	getAll( callback : CommentListCallback ) {
		this.listRequest(this.urlPrefix + "/comment", callback);
	}

	get( id : number, callback : CommentValueCallback ) {
		this.valueRequest(this.urlPrefix + "/comment/"+id, callback);
	}

	create( entity : Comment, callback : CommentCreationCallback ) {
		$.ajax({
    		url: this.urlPrefix + "/comment",
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			callback(data.value, null);
		} );
	}

	private listRequest(path : string, callback : CommentListCallback ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any[]) {
			var entityList : Comment[] = data.map( function( o ) { return new Comment(o); } );
			callback(entityList, null);
		});
	}

	private valueRequest(path : string, callback : CommentValueCallback ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any) {
			var entity : Comment;
			if( data ) {
				entity = new Comment(data);
			}
			callback(entity, null);
		});
	}

	selectAllForTask( tid : number, callback : CommentListCallback ) {
		this.listRequest( this.urlPrefix + "/comment/commentsPerTask?tid="+tid+"", callback  );
	}
}