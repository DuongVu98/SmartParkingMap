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

    var locationInfoWindow = "";
    var locationMarker="";
    var myPos = home;
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
            // distance display
            getDistance(distanceService, function(disdur){
                console.log(disdur);
                $scope.dis=disdur[0];
                $scope.dur=disdur[1];
            });
            // direction display
            calculateAndDisplayRoute(directionsService,directionsDisplay);
        }

        //get user location
        if(navigator.geolocation){
            locationInfoWindow = new google.maps.InfoWindow;
            navigator.geolocation.getCurrentPosition(function(position){
                myPos= {
                    lat: position.coords.latitude,
                    lng: position.coords.longitude
                };
                console.log(myPos);
                locationMarker= new google.maps.Marker({position: myPos, map: map,});
                locationInfoWindow.setPosition(myPos);
                locationInfoWindow.setContent('You are here');
                locationInfoWindow.open(map,locationMarker);
                map.setCenter(myPos);
            });
	    }
    }

    function initDirections(places){
        directionsService = new google.maps.DirectionsService;
	    directionsDisplay = new google.maps.DirectionsRenderer;
        distanceService = new google.maps.DistanceMatrixService();

        directionsDisplay.setMap(map);
    }

    // original direction-displaying function (from user location)
    function calculateAndDisplayRoute(service, display){
        service.route({
            origin: myPos,
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

    // original distance-getting function
    function getDistance(service, callback){
        service.getDistanceMatrix({
            origins:[myPos],
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
