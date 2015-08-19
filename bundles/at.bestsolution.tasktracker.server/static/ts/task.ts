/// <reference path="../typings/jquery/jquery.d.ts"/>
/// <reference path="../typings/mdl/mdl.d.ts"/>
/// <reference path="common.ts"/>

/// <reference path="model/DTOTask.ts"/>
/// <reference path="model/TaskService.ts"/>
/// <reference path="model/DTOComment.ts"/>
/// <reference path="model/CommentService.ts"/>

var task : DTOTask = null;

function initTaskPage() {
	var taskId = parseLocationSearch()["id"];
	
	var taskService = new TaskService(rootPath);
	taskService.getCompleteTask(taskId, handleTaskData);
}

function handleTaskData(data : DTOTask, err : any) {
	task = data;
	console.log("Task", data);
	
	$("#nav-task-repository-label").html(data.repository.name);
	$("#nav-task-repository-link").attr("href", "repository.html?id=" + data.repository.sid);

	if( data.state == "RESOLVED" ) {
		$("#submit-task-change").text("Reopen");
	}
	
    var versionOptionList : string[] = [];
	
	var optionList = data.repository.versionList.map( function ( o ) {
		return '<option value="' + o.sid + '">' + o.codename + '</option>';
	});

    $("#bug-form-task-version").each( function () {
		$(this).html(
			'<option value="" disabled selected>Version</option>'
			+
			optionList.join("\n")
		);
	} );
	
	$("#bug-form-task-fix").each( function () {
		$(this).html(
			'<option value="" disabled selected>Fixed in Version</option>'
			+
			optionList.join("\n")
		);
	} );

	$("#task-title").each( function() {
		$(this).html(data.sid + " - " + data.title );
	} );

	$("#form-task-title").each( function() {
		var evt = document.createEvent("HTMLEvents");
	    evt.initEvent("input", false, true);
		$(this).val(data.title).get(0).dispatchEvent(evt);
		if( data.state == "RESOLVED" ) {
			$(this).attr("disabled","true");
		}
	} );

	$("#form-task-description").each( function() {
		var evt = document.createEvent("HTMLEvents");
	    evt.initEvent("input", false, true);
		$(this).val(data.description).get(0).dispatchEvent(evt);
		if( data.state == "RESOLVED" ) {
			$(this).attr("disabled","true");
		}
	} );
	
	var commentList = task.commentList.map(commentToHTML);
	
	console.log(commentList);
	
	$("#comment-list").each( function() {
		$(this).html(
			commentList.join("\n")
		);
	});
}

function commentToHTML(o:DTOComment) {
	return    '<div class="mdl-card mdl-shadow--2dp demo-card-wide">'
				+ '	<div class="mdl-card__title">'
				+ '		<h2 class="mdl-card__title-text">' + o.sid + ' - ' + o.title+'</h2>'
				+ '	</div>'
				+ '	<div class="mdl-card__supporting-text">'
				+ o.description
				+ '	</div>'
				+ '</div>';
}

function updateTask() {
	task.title = $("#form-task-title").val();
	task.description = $("#form-task-description").val();
	
	var taskService = new TaskService(rootPath);
	taskService.update(task,function(err : any) {
		
	});
}

function submitComment() {
	var comment = new DTOComment();
	
	var proxyTask = new DTOTask();
	proxyTask.metaProxy = true;
	proxyTask.sid = task.sid;
	comment.task = proxyTask;
	comment.title = $("#form-task-comment-title").val();
	comment.description = $("#form-task-comment-description").val();
	
	var commentService = new CommentService(rootPath);
	commentService.create(comment, function(comment: DTOComment, err : any) {
		$("#comment-list").each( function() {
			$(this).append(commentToHTML(comment));
		});
	});
}