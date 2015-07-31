/// <reference path="../../typings/jquery/jquery.d.ts"/>

/// <reference path="TaskRepository.ts"/>

interface TaskRepositoryValueCallback {
	( entity : TaskRepository, err: any ) : void
}

interface TaskRepositoryListCallback {
	( entity : TaskRepository[], err: any ) : void
}

interface TaskRepositoryCreationCallback {
	( id : number, err : any ) : void
}

class TaskRepositoryService {
	urlPrefix : string

	constructor(urlPrefix : string) {
		this.urlPrefix = urlPrefix
	}

	getAll( callback : TaskRepositoryListCallback ) {
		this.listRequest(this.urlPrefix + "/taskrepository", callback);
	}

	get( id : number, callback : TaskRepositoryValueCallback ) {
		this.valueRequest(this.urlPrefix + "/taskrepository/"+id, callback);
	}

	create( entity : TaskRepository, callback : TaskRepositoryCreationCallback ) {
		$.ajax({
    		url: this.urlPrefix + "/taskrepository",
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			callback(data.value, null);
		} );
	}

	private listRequest(path : string, callback : TaskRepositoryListCallback ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any[]) {
			var entityList : TaskRepository[] = data.map( function( o ) { return new TaskRepository(o); } );
			callback(entityList, null);
		});
	}

	private valueRequest(path : string, callback : TaskRepositoryValueCallback ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any) {
			var entity : TaskRepository;
			if( data ) {
				entity = new TaskRepository(data);
			}
			callback(entity, null);
		});
	}

}