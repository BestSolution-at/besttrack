/// <reference path="Task.ts"/>
/// <reference path="CommentAttachment.ts"/>
var Comment = (function () {
    function Comment(jsonObject) {
        this.metaClassname = "Comment";
        this.metaProxy = false;
        if (jsonObject) {
            this.metaProxy = jsonObject.metaProxy;
            this.sid = jsonObject.sid;
            this.title = jsonObject.title;
            this.description = jsonObject.description;
            this.task = jsonObject.task ? new Task(jsonObject.task) : null;
            if (jsonObject.attachmentList) {
                this.attachmentList = jsonObject.attachmentList.map(function (o) { return new CommentAttachment(o); });
            }
        }
    }
    return Comment;
})();
