/// <reference path="../../typings/jquery/jquery.d.ts"/>
/// <reference path="../util/bestUtils.ts"/>
/// <reference path="DTOTaskRepository.ts"/>

class TaskRepositoryService {
	urlPrefix : string

	constructor(urlPrefix : string) {
		this.urlPrefix = urlPrefix
	}

	getAll( callback : Consumer<DTOTaskRepository[]> ) {
		this.listRequest(this.urlPrefix + "/taskrepository", callback);
	}

	get( id : number, callback : Consumer<DTOTaskRepository> ) {
		this.valueRequest(this.urlPrefix + "/taskrepository/"+id, callback);
	}

	create( entity : DTOTaskRepository, callback : Consumer<DTOTaskRepository> ) {
		$.ajax({
    		url: this.urlPrefix + "/taskrepository",
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			var entity : DTOTaskRepository;
			if( data ) {
				entity = new DTOTaskRepository(data);
			}
			callback(entity, null);
		} );
	}

	update( entity : DTOTaskRepository, callback : Consumer<DTOTaskRepository> ) {
		$.ajax({
    		url: this.urlPrefix + "/taskrepository/"+entity.sid,
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			var entity : DTOTaskRepository;
			if( data ) {
				entity = new DTOTaskRepository(data);
			}
			callback(entity, null);
		} );
	}

	private listRequest(path : string, callback : Consumer<DTOTaskRepository[]> ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any[]) {
			var entityList : DTOTaskRepository[] = data.map( function( o ) { return new DTOTaskRepository(o); } );
			callback(entityList, null);
		});
	}

	private valueRequest(path : string, callback : Consumer<DTOTaskRepository> ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any) {
			var entity : DTOTaskRepository;
			if( data ) {
				entity = new DTOTaskRepository(data);
			}
			callback(entity, null);
		});
	}

}