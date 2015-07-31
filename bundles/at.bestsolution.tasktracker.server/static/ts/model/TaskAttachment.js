/// <reference path="Task.ts"/>
var TaskAttachment = (function () {
    function TaskAttachment(jsonObject) {
        this.metaClassname = "TaskAttachment";
        this.metaProxy = false;
        if (jsonObject) {
            this.metaProxy = jsonObject.metaProxy;
            this.sid = jsonObject.sid;
            this.title = jsonObject.title;
            this.mimetype = jsonObject.mimetype;
            this.description = jsonObject.description;
            this.task = jsonObject.task ? new Task(jsonObject.task) : null;
        }
    }
    return TaskAttachment;
})();
