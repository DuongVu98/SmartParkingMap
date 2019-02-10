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

        $scope.directionActive=function ($event) {
            console.log($event.target.value);
            $scope.test=$event.target.textContent;

            var obj=$event.target.value;
            newPlace={lat: obj.lat, lng: obj.lng}
            newPlace=obj;
            calculateAndDisplayRoute(directionsService,directionsDisplay);
        }
    }

    function initDirections(places){
        directionsService = new google.maps.DirectionsService;
	    directionsDisplay = new google.maps.DirectionsRenderer;
        distanceService = new google.maps.DistanceMatrixService();

        directionsDisplay.setMap(map);
    }

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
}());
