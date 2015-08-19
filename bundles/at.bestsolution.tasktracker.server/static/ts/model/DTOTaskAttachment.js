/// <reference path="DTOTask.ts"/>
var DTOTaskAttachment = (function () {
    function DTOTaskAttachment(jsonObject) {
        this.metaClassname = "TaskAttachment";
        this.metaProxy = false;
        if (jsonObject) {
            this.metaProxy = jsonObject.metaProxy;
            this.sid = jsonObject.sid;
            this.title = jsonObject.title;
            this.mimetype = jsonObject.mimetype;
            this.description = jsonObject.description;
            this.task = jsonObject.task ? new DTOTask(jsonObject.task) : null;
        }
    }
    return DTOTaskAttachment;
})();
