(function(){
    "use strict";
    angular
    .module("placesManagement")
    .controller("placesListCtrl",["placesResource",getPlaces]);
    // .factory("places",["placesResource",passPlaces]);

    function getPlaces(placesResource){
        var vm=this;
        placesResource.query(function(data){
            vm.places=data;
            initMap(data);
        });
    }

    function initMap(places) {
        function placeMarker(locations){
            var marker= new google.maps.Marker({
                position: locations[i],
                map: map,
                title: locations[i].name,
                animation: google.maps.Animation.DROP,
                icon: "res/placeholder.png"
            });
            var infowindow= new google.maps.InfoWindow({content: locations[i].name});
            marker.addListener('click',function(){
                infowindow.open(map, marker);
            });
        }

        for(var i=0; i<places.length; i++){
            placeMarker(places);
        }
   }
}());
