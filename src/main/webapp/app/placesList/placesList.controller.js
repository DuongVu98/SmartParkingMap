(function(){
    "use strict";
    angular
    .module("placesListManagement")
    .controller("placesListController", ["placesResource", placesListController]);

    function placesListController(placesResource){
        var vm = this;
        placesResource.query(function(data){
            vm.places=data;
            makeList(data);
        });
    }

    function makeList(places){
        
    }
}());