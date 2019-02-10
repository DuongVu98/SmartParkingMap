(function(){
    "use strict";
    angular
    .module("placesManagement")
    .controller("distanceCtrl",["$scope",getPlaces]);

    var home = {lat: 10.790958, lng: 106.692874};
    var distanceService ="";

    function getPlaces($scope){

        distanceService = new google.maps.DistanceMatrixService();

        $scope.directionActive=function ($event) {
            var newPlace=$event.target.value;
            getDistance(distanceService, function(disdur){
                $scope.dis=disdur[0];
                $scope.dur=disdur[1];
                console.log("distance");
            });
        }
    }

    function getDistance(service, callback){
        service.getDistanceMatrix({
            origins:[home],
            destinations:[newPlace],
            travelMode:'DRIVING',
            unitSystem: google.maps.UnitSystem.METRIC,
            avoidHighways:false,
            avoidTolls: false
        },function(response, status){
            if(status == google.maps.DistanceMatrixStatus.OK && response.rows[0].elements[0].status != "ZERO_RESULTS"){
                var distance = response.rows[0].elements[0].distance.text;
                var duration = response.rows[0].elements[0].duration.text;
                var disdur=[distance,duration];
                console.log(disdur);
                callback(disdur);
            }else{
                alert("Unable to find the distance via road");
            }
        });
    }
}());
