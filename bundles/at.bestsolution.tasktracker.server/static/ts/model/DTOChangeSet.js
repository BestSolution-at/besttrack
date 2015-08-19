/// <reference path="DTOTask.ts"/>
/// <reference path="DTOSourceRepository.ts"/>
/// <reference path="DTOPerson.ts"/>
var DTOChangeSet = (function () {
    function DTOChangeSet(jsonObject) {
        this.metaClassname = "ChangeSet";
        this.metaProxy = false;
        if (jsonObject) {
            this.metaProxy = jsonObject.metaProxy;
            this.sid = jsonObject.sid;
            this.id = jsonObject.id;
            this.comment = jsonObject.comment;
            this.task = jsonObject.task ? new DTOTask(jsonObject.task) : null;
            this.sourceRepository = jsonObject.sourceRepository ? new DTOSourceRepository(jsonObject.sourceRepository) : null;
            this.person = jsonObject.person ? new DTOPerson(jsonObject.person) : null;
        }
    }
    return DTOChangeSet;
})();
