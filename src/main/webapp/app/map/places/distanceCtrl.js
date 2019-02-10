(function(){
    angular
    .module("placesManagement")
    .controller("directionsCtrl",["placesResource","$scope",getPlaces]);

    var home = {lat: 10.790958, lng: 106.692874};
    var distanceService = new google.maps.DistanceMatrixService();

    function getPlaces(placesResource, $scope){
        var vm=this;
        placesResource.query(function(data){
            vm.places=data;
        });

        $scope.directionActive=function ($event) {
            var newPlace=$event.target.value;
            getDistance(distanceService, function(disdur){
                $scope.dis=disdur[0];
                $scope.dur=disdur[1];
            });
        }
    }

    function getDistance(service, orgn, des,callback){
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
