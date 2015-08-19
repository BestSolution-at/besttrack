/// <reference path="../typings/jquery/jquery.d.ts"/>
/// <reference path="../typings/mdl/mdl.d.ts"/>
/// <reference path="common.ts"/>

/// <reference path="model/DTOTaskRepository.ts"/>
/// <reference path="model/TaskRepositoryService.ts"/>
/// <reference path="model/DTOTask.ts"/>
/// <reference path="model/TaskService.ts"/>

var repository : DTOTaskRepository;

function initRepositoryPage() {
	var repoId = parseLocationSearch()["id"];
	

	if( repoId ) {
		console.log("Loading repository data for " + repoId);
		var taskRepoService = new TaskRepositoryService(rootPath);
		
		
		taskRepoService.get(repoId, handleRepositoryData);
	}
}

function handleRepositoryData(data : DTOTaskRepository) {
	console.log("Repository data: ", data);
	repository = data;
	$( '#repo-name' ).each(function() {
		$(this).html(data.name);
	});
	
	var taskService = new TaskService(rootPath);
	taskService.openTaskInRepository(data.sid, handleRepositoryTasks)
}

function handleRepositoryTasks(data : DTOTask[]) {
	console.log("Tasks data: ", data)

	var html = [];
	html.push('<table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp">');
	html.push('<thead>');
	html.push('	<tr>');
	html.push('		<th>Bug-Id</th>');
	if( repository.externalId ) {
		html.push('		<th>External Bug-Id</th>');
	}
	html.push('		<th class="mdl-data-table__cell--non-numeric" width="100%">Title</th>');
	html.push('		<th>Target Version</th>');
	html.push('		<th>Fix Version</th>');
	html.push('	</tr>');
	html.push('</thead>');

	html.push('<tbody>');
	data.forEach( function(value) {
		html.push('	<tr>');
		html.push('		<td><a href="task.html?id='+value.sid+'">'+value.sid+'</a></td>');
		if( repository.externalId ) {
			html.push('		<td>' + (value.externalBugId ? value.externalBugId : "") + '</td>');
		}
		html.push('		<td class="mdl-data-table__cell--non-numeric">'+value.title+'</td>');
		html.push('		<td></td>');
		html.push('		<td></td>');
		html.push('	</tr>');		
	} )
	
	html.push('</tbody>');
	html.push('</table>');

	$( '#tasklist' ).each(function() {
		$(this).html(html.join("\n"));
		componentHandler.upgradeElement($(this).get(0).children[0]);
	});
}
