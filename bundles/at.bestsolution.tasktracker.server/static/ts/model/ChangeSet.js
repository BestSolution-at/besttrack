/// <reference path="Task.ts"/>
/// <reference path="SourceRepository.ts"/>
/// <reference path="Person.ts"/>
var ChangeSet = (function () {
    function ChangeSet(jsonObject) {
        this.metaClassname = "ChangeSet";
        this.metaProxy = false;
        if (jsonObject) {
            this.metaProxy = jsonObject.metaProxy;
            this.sid = jsonObject.sid;
            this.id = jsonObject.id;
            this.comment = jsonObject.comment;
            this.task = jsonObject.task ? new Task(jsonObject.task) : null;
            this.sourceRepository = jsonObject.sourceRepository ? new SourceRepository(jsonObject.sourceRepository) : null;
            this.person = jsonObject.person ? new Person(jsonObject.person) : null;
        }
    }
    return ChangeSet;
})();
