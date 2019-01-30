(function(){
    "use strict";

    angular
    .module("common.services")
    .factory("placesResource",["$resource",getPlacesByUrl]);

    function getPlacesByUrl($resource){
        return $resource("http://localhost:8080/SmartParkingMap/rest/place/all-places");
    }
}());
