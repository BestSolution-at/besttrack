/// <reference path="../../typings/jquery/jquery.d.ts"/>
/// <reference path="../util/bestUtils.ts"/>
/// <reference path="DTOComment.ts"/>

class CommentService {
	urlPrefix : string

	constructor(urlPrefix : string) {
		this.urlPrefix = urlPrefix
	}

	getAll( callback : Consumer<DTOComment[]> ) {
		this.listRequest(this.urlPrefix + "/comment", callback);
	}

	get( id : number, callback : Consumer<DTOComment> ) {
		this.valueRequest(this.urlPrefix + "/comment/"+id, callback);
	}

	create( entity : DTOComment, callback : Consumer<DTOComment> ) {
		$.ajax({
    		url: this.urlPrefix + "/comment",
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			var entity : DTOComment;
			if( data ) {
				entity = new DTOComment(data);
			}
			callback(entity, null);
		} );
	}

	update( entity : DTOComment, callback : Consumer<DTOComment> ) {
		$.ajax({
    		url: this.urlPrefix + "/comment/"+entity.sid,
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			var entity : DTOComment;
			if( data ) {
				entity = new DTOComment(data);
			}
			callback(entity, null);
		} );
	}

	private listRequest(path : string, callback : Consumer<DTOComment[]> ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any[]) {
			var entityList : DTOComment[] = data.map( function( o ) { return new DTOComment(o); } );
			callback(entityList, null);
		});
	}

	private valueRequest(path : string, callback : Consumer<DTOComment> ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any) {
			var entity : DTOComment;
			if( data ) {
				entity = new DTOComment(data);
			}
			callback(entity, null);
		});
	}

	commentsPerTask( tid : number, callback : Consumer<Comment> ) {
		this.listRequest( this.urlPrefix + "/comment/comments-per-task?tid="+tid+"", callback  );
	}
}