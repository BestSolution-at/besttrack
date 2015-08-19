/// <reference path="../../typings/jquery/jquery.d.ts"/>
/// <reference path="../util/bestUtils.ts"/>
/// <reference path="DTOTaskAttachment.ts"/>

class TaskAttachmentService {
	urlPrefix : string

	constructor(urlPrefix : string) {
		this.urlPrefix = urlPrefix
	}

	getAll( callback : Consumer<DTOTaskAttachment[]> ) {
		this.listRequest(this.urlPrefix + "/taskattachment", callback);
	}

	get( id : number, callback : Consumer<DTOTaskAttachment> ) {
		this.valueRequest(this.urlPrefix + "/taskattachment/"+id, callback);
	}

	create( entity : DTOTaskAttachment, callback : Consumer<DTOTaskAttachment> ) {
		$.ajax({
    		url: this.urlPrefix + "/taskattachment",
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			var entity : DTOTaskAttachment;
			if( data ) {
				entity = new DTOTaskAttachment(data);
			}
			callback(entity, null);
		} );
	}

	update( entity : DTOTaskAttachment, callback : Consumer<DTOTaskAttachment> ) {
		$.ajax({
    		url: this.urlPrefix + "/taskattachment/"+entity.sid,
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			var entity : DTOTaskAttachment;
			if( data ) {
				entity = new DTOTaskAttachment(data);
			}
			callback(entity, null);
		} );
	}

	private listRequest(path : string, callback : Consumer<DTOTaskAttachment[]> ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any[]) {
			var entityList : DTOTaskAttachment[] = data.map( function( o ) { return new DTOTaskAttachment(o); } );
			callback(entityList, null);
		});
	}

	private valueRequest(path : string, callback : Consumer<DTOTaskAttachment> ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any) {
			var entity : DTOTaskAttachment;
			if( data ) {
				entity = new DTOTaskAttachment(data);
			}
			callback(entity, null);
		});
	}

}