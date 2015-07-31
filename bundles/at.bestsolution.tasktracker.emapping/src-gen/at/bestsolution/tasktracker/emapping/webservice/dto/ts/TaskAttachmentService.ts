/// <reference path="../../typings/jquery/jquery.d.ts"/>

/// <reference path="TaskAttachment.ts"/>

interface TaskAttachmentValueCallback {
	( entity : TaskAttachment, err: any ) : void
}

interface TaskAttachmentListCallback {
	( entity : TaskAttachment[], err: any ) : void
}

interface TaskAttachmentCreationCallback {
	( id : number, err : any ) : void
}

class TaskAttachmentService {
	urlPrefix : string

	constructor(urlPrefix : string) {
		this.urlPrefix = urlPrefix
	}

	getAll( callback : TaskAttachmentListCallback ) {
		this.listRequest(this.urlPrefix + "/taskattachment", callback);
	}

	get( id : number, callback : TaskAttachmentValueCallback ) {
		this.valueRequest(this.urlPrefix + "/taskattachment/"+id, callback);
	}

	create( entity : TaskAttachment, callback : TaskAttachmentCreationCallback ) {
		$.ajax({
    		url: this.urlPrefix + "/taskattachment",
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			callback(data.value, null);
		} );
	}

	private listRequest(path : string, callback : TaskAttachmentListCallback ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any[]) {
			var entityList : TaskAttachment[] = data.map( function( o ) { return new TaskAttachment(o); } );
			callback(entityList, null);
		});
	}

	private valueRequest(path : string, callback : TaskAttachmentValueCallback ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any) {
			var entity : TaskAttachment;
			if( data ) {
				entity = new TaskAttachment(data);
			}
			callback(entity, null);
		});
	}

}