/// <reference path="DTOTask.ts"/>
/// <reference path="DTOCommentAttachment.ts"/>
var DTOComment = (function () {
    function DTOComment(jsonObject) {
        this.metaClassname = "Comment";
        this.metaProxy = false;
        if (jsonObject) {
            this.metaProxy = jsonObject.metaProxy;
            this.sid = jsonObject.sid;
            this.title = jsonObject.title;
            this.description = jsonObject.description;
            this.task = jsonObject.task ? new DTOTask(jsonObject.task) : null;
            if (jsonObject.attachmentList) {
                this.attachmentList = jsonObject.attachmentList.map(function (o) { return new DTOCommentAttachment(o); });
            }
        }
    }
    return DTOComment;
})();
