(function(){
    angular
    .module("placesListManagement")
    .controller("placesListController", ["placesResource", placesListController]);

    function placesListController(){
        var vm = this;
        placesResource.query(function(data){
            vm.places=data;
            makeList(data);
        });
    }

    function makeList(places){
        
    }
}());