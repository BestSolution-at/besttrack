/// <reference path="Person.ts"/>
/// <reference path="TaskRepository.ts"/>
var RepositoryPerson = (function () {
    function RepositoryPerson(jsonObject) {
        this.metaClassname = "RepositoryPerson";
        this.metaProxy = false;
        if (jsonObject) {
            this.metaProxy = jsonObject.metaProxy;
            this.sid = jsonObject.sid;
            this.privilegeMask = jsonObject.privilegeMask;
            this.person = jsonObject.person ? new Person(jsonObject.person) : null;
            this.repository = jsonObject.repository ? new TaskRepository(jsonObject.repository) : null;
        }
    }
    return RepositoryPerson;
})();
