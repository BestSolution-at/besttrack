/// <reference path="DTORepositoryPerson.ts"/>
var DTOPerson = (function () {
    function DTOPerson(jsonObject) {
        this.metaClassname = "Person";
        this.metaProxy = false;
        if (jsonObject) {
            this.metaProxy = jsonObject.metaProxy;
            this.sid = jsonObject.sid;
            this.firstname = jsonObject.firstname;
            this.lastname = jsonObject.lastname;
            if (jsonObject.repositoryList) {
                this.repositoryList = jsonObject.repositoryList.map(function (o) { return new DTORepositoryPerson(o); });
            }
        }
    }
    return DTOPerson;
})();
