(function(){
    "use strict";
    angular
    .module("placesManagement")
    .controller("directionsCtrl",["placesResource",getPlaces]);
    // .factory("places",["placesResource",passPlaces]);

    function getPlaces(placesResource){
        var vm=this;
        placesResource.query(function(data){
            vm.places=data;
            initDirections(data);
            console.log(1234);
        });
    }

    function initDirections(places){
        var directionsService = new google.maps.DirectionsService;
	    var directionsDisplay = new google.maps.DirectionsRenderer;
        var distanceService = new google.maps.DistanceMatrixService();

        directionsDisplay.setMap(map);
        calculateAndDisplayRoute(directionsService,directionsDisplay);
    }

    function calculateAndDisplayRoute(service, display){
        service.route({
            origin: {lat: 10.790958, lng: 106.692874},
            destination: {lat: 10.799744, lng: 106.706362},
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
