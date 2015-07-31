/// <reference path="RepositoryPerson.ts"/>
/// <reference path="SourceRepository.ts"/>
/// <reference path="Version.ts"/>
var TaskRepository = (function () {
    function TaskRepository(jsonObject) {
        this.metaClassname = "TaskRepository";
        this.metaProxy = false;
        if (jsonObject) {
            this.metaProxy = jsonObject.metaProxy;
            this.sid = jsonObject.sid;
            this.name = jsonObject.name;
            this.description = jsonObject.description;
            this.externalId = jsonObject.externalId;
            if (jsonObject.personList) {
                this.personList = jsonObject.personList.map(function (o) { return new RepositoryPerson(o); });
            }
            if (jsonObject.sourceRepositoryList) {
                this.sourceRepositoryList = jsonObject.sourceRepositoryList.map(function (o) { return new SourceRepository(o); });
            }
            if (jsonObject.versionList) {
                this.versionList = jsonObject.versionList.map(function (o) { return new Version(o); });
            }
            if (jsonObject.children) {
                this.children = jsonObject.children.map(function (o) { return new TaskRepository(o); });
            }
            this.parent = jsonObject.parent ? new TaskRepository(jsonObject.parent) : null;
        }
    }
    return TaskRepository;
})();
