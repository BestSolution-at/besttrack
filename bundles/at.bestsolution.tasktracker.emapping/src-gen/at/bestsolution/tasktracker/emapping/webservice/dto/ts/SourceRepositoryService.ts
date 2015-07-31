/// <reference path="../../typings/jquery/jquery.d.ts"/>

/// <reference path="SourceRepository.ts"/>

interface SourceRepositoryValueCallback {
	( entity : SourceRepository, err: any ) : void
}

interface SourceRepositoryListCallback {
	( entity : SourceRepository[], err: any ) : void
}

interface SourceRepositoryCreationCallback {
	( id : number, err : any ) : void
}

class SourceRepositoryService {
	urlPrefix : string

	constructor(urlPrefix : string) {
		this.urlPrefix = urlPrefix
	}

	getAll( callback : SourceRepositoryListCallback ) {
		this.listRequest(this.urlPrefix + "/sourcerepository", callback);
	}

	get( id : number, callback : SourceRepositoryValueCallback ) {
		this.valueRequest(this.urlPrefix + "/sourcerepository/"+id, callback);
	}

	create( entity : SourceRepository, callback : SourceRepositoryCreationCallback ) {
		$.ajax({
    		url: this.urlPrefix + "/sourcerepository",
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			callback(data.value, null);
		} );
	}

	private listRequest(path : string, callback : SourceRepositoryListCallback ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any[]) {
			var entityList : SourceRepository[] = data.map( function( o ) { return new SourceRepository(o); } );
			callback(entityList, null);
		});
	}

	private valueRequest(path : string, callback : SourceRepositoryValueCallback ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any) {
			var entity : SourceRepository;
			if( data ) {
				entity = new SourceRepository(data);
			}
			callback(entity, null);
		});
	}

}