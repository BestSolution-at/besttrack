/// <reference path="../../typings/jquery/jquery.d.ts"/>
/// <reference path="../util/bestUtils.ts"/>
/// <reference path="DTOSourceRepository.ts"/>

class SourceRepositoryService {
	urlPrefix : string

	constructor(urlPrefix : string) {
		this.urlPrefix = urlPrefix
	}

	getAll( callback : Consumer<DTOSourceRepository[]> ) {
		this.listRequest(this.urlPrefix + "/sourcerepository", callback);
	}

	get( id : number, callback : Consumer<DTOSourceRepository> ) {
		this.valueRequest(this.urlPrefix + "/sourcerepository/"+id, callback);
	}

	create( entity : DTOSourceRepository, callback : Consumer<DTOSourceRepository> ) {
		$.ajax({
    		url: this.urlPrefix + "/sourcerepository",
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			var entity : DTOSourceRepository;
			if( data ) {
				entity = new DTOSourceRepository(data);
			}
			callback(entity, null);
		} );
	}

	update( entity : DTOSourceRepository, callback : Consumer<DTOSourceRepository> ) {
		$.ajax({
    		url: this.urlPrefix + "/sourcerepository/"+entity.sid,
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			var entity : DTOSourceRepository;
			if( data ) {
				entity = new DTOSourceRepository(data);
			}
			callback(entity, null);
		} );
	}

	private listRequest(path : string, callback : Consumer<DTOSourceRepository[]> ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any[]) {
			var entityList : DTOSourceRepository[] = data.map( function( o ) { return new DTOSourceRepository(o); } );
			callback(entityList, null);
		});
	}

	private valueRequest(path : string, callback : Consumer<DTOSourceRepository> ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any) {
			var entity : DTOSourceRepository;
			if( data ) {
				entity = new DTOSourceRepository(data);
			}
			callback(entity, null);
		});
	}

}