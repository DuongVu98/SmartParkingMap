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
            console.log(1234);
        });
    }
    // function passPlaces(placesResource){
    //     return placesResource.query();
    // }



    function initMap(places) {
        var house= {lat: 10.790958, lng: 106.692874};
        
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 13,
            center: house
        });
        // var map=document.getElementById("map");
        function placeMarker(locations){
            var marker= new google.maps.Marker({position: locations[i], map: map, title: locations[i].name});
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
