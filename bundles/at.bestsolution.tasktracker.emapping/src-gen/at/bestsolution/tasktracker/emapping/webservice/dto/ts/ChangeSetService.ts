/// <reference path="../../typings/jquery/jquery.d.ts"/>

/// <reference path="ChangeSet.ts"/>

interface ChangeSetValueCallback {
	( entity : ChangeSet, err: any ) : void
}

interface ChangeSetListCallback {
	( entity : ChangeSet[], err: any ) : void
}

interface ChangeSetCreationCallback {
	( id : number, err : any ) : void
}

class ChangeSetService {
	urlPrefix : string

	constructor(urlPrefix : string) {
		this.urlPrefix = urlPrefix
	}

	getAll( callback : ChangeSetListCallback ) {
		this.listRequest(this.urlPrefix + "/changeset", callback);
	}

	get( id : number, callback : ChangeSetValueCallback ) {
		this.valueRequest(this.urlPrefix + "/changeset/"+id, callback);
	}

	create( entity : ChangeSet, callback : ChangeSetCreationCallback ) {
		$.ajax({
    		url: this.urlPrefix + "/changeset",
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			callback(data.value, null);
		} );
	}

	private listRequest(path : string, callback : ChangeSetListCallback ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any[]) {
			var entityList : ChangeSet[] = data.map( function( o ) { return new ChangeSet(o); } );
			callback(entityList, null);
		});
	}

	private valueRequest(path : string, callback : ChangeSetValueCallback ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any) {
			var entity : ChangeSet;
			if( data ) {
				entity = new ChangeSet(data);
			}
			callback(entity, null);
		});
	}

}