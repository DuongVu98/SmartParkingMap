(function(){
    "use strict";
    angular
    .module("placesManagement")
    .controller("directionsCtrl",["placesResource","$scope",getPlaces]);
    // .factory("places",["placesResource",passPlaces]);
    var home = {lat: 10.790958, lng: 106.692874};
    var des = {lat: 10.799744, lng: 106.706362};

    var directionsService = "";
    var directionsDisplay = "";
    var distanceService = "";

    var newPlace="";

    function getPlaces(placesResource, $scope){
        var vm=this;
        placesResource.query(function(data){
            vm.places=data;
            initDirections(data);
            console.log(1234);
        });

        // place-click event funtion
        $scope.directionActive=function ($event) {
            console.log($event.target.value);
            $scope.placeName=$event.target.textContent;

            newPlace=$event.target.value;
            // direction display
            calculateAndDisplayRoute(directionsService,directionsDisplay);

            // distance display
            getDistance(distanceService, function(disdur){
                // console.log(disdur);
                $scope.dis=disdur[0];
                $scope.dur=disdur[1];
            });
        }
        $scope.mouseEffect=function($event){
            $scope.effect=true;
        }
    }

    function initDirections(places){
        directionsService = new google.maps.DirectionsService;
	    directionsDisplay = new google.maps.DirectionsRenderer;
        distanceService = new google.maps.DistanceMatrixService();

        directionsDisplay.setMap(map);
    }

    // original direction function
    function calculateAndDisplayRoute(service, display){
        service.route({
            origin: home,
            destination: newPlace,
            travelMode: 'DRIVING'
        },function(response, status){
            if(status === 'OK'){
                display.setDirections(response);
            }else if (status === google.maps.DirectionsStatus.OVER_QUERY_LIMIT) {
                delayFactor++;
                setTimeout(function(){
                    console.log(delayFactor);
                    calculateAndDisplayRoute(service, display);
                },delayFactor*1000);
            }else{
                window.alert('Directions request failed due to ' + status);
            }
        });
    }

    // original distance function
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
                callback(disdur);
            }else{
                alert("Unable to find the distance via road");
            }
        });
    }
}());
