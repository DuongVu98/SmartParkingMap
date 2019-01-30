
    // var init=angular.module("initMap",["placesManagement"]);
    // init.controller("placeMarker",["places",initMap]);

    var house= {lat: 10.790958, lng: 106.692874};

    function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 13,
            center: house
        });

        // function placeMarker(locations){
        //     var marker= new google.maps.Marker({position: locations[i], map: map, title: locations[i].name});
        //     var infowindow= new google.maps.InfoWindow({content: locations[i].name});
        //     marker.addListener('click',function(){
        //         infowindow.open(map, marker);
        //     });
        // }
        //
        // for(var i=0; i<places.length; i++){
        //     placeMarker(places);
        // }
   }
