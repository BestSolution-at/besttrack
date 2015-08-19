/// <reference path="../../typings/jquery/jquery.d.ts"/>
/// <reference path="../util/bestUtils.ts"/>
/// <reference path="DTOChangeSet.ts"/>

class ChangeSetService {
	urlPrefix : string

	constructor(urlPrefix : string) {
		this.urlPrefix = urlPrefix
	}

	getAll( callback : Consumer<DTOChangeSet[]> ) {
		this.listRequest(this.urlPrefix + "/changeset", callback);
	}

	get( id : number, callback : Consumer<DTOChangeSet> ) {
		this.valueRequest(this.urlPrefix + "/changeset/"+id, callback);
	}

	create( entity : DTOChangeSet, callback : Consumer<DTOChangeSet> ) {
		$.ajax({
    		url: this.urlPrefix + "/changeset",
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			var entity : DTOChangeSet;
			if( data ) {
				entity = new DTOChangeSet(data);
			}
			callback(entity, null);
		} );
	}

	update( entity : DTOChangeSet, callback : Consumer<DTOChangeSet> ) {
		$.ajax({
    		url: this.urlPrefix + "/changeset/"+entity.sid,
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			var entity : DTOChangeSet;
			if( data ) {
				entity = new DTOChangeSet(data);
			}
			callback(entity, null);
		} );
	}

	private listRequest(path : string, callback : Consumer<DTOChangeSet[]> ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any[]) {
			var entityList : DTOChangeSet[] = data.map( function( o ) { return new DTOChangeSet(o); } );
			callback(entityList, null);
		});
	}

	private valueRequest(path : string, callback : Consumer<DTOChangeSet> ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any) {
			var entity : DTOChangeSet;
			if( data ) {
				entity = new DTOChangeSet(data);
			}
			callback(entity, null);
		});
	}

}