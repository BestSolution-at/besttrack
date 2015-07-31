var rootPath = "/services";

function parseLocationSearch() {
	var rv = {};

	if( location.search.length > 1 ) {
	 	var paramList = location.search.substring(1).split("&");
	 	for( var i = 0; i < paramList.length; i++ ) {
	 		rv[paramList[i].split("=")[0]] = paramList[i].split("=")[1];
	 	}
	}

	return rv;
}