/// <reference path="DTOPerson.ts"/>
/// <reference path="DTOTaskRepository.ts"/>
var DTORepositoryPerson = (function () {
    function DTORepositoryPerson(jsonObject) {
        this.metaClassname = "RepositoryPerson";
        this.metaProxy = false;
        if (jsonObject) {
            this.metaProxy = jsonObject.metaProxy;
            this.sid = jsonObject.sid;
            this.privilegeMask = jsonObject.privilegeMask;
            this.person = jsonObject.person ? new DTOPerson(jsonObject.person) : null;
            this.repository = jsonObject.repository ? new DTOTaskRepository(jsonObject.repository) : null;
        }
    }
    return DTORepositoryPerson;
})();
