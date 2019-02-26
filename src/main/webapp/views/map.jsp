<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>HCMIU Parking Map</title>

        <jsp:include page="/views/_header.jsp"></jsp:include>

    </head>
    <body ng-app="placesManagement" ng-controller="placesListCtrl as vm">
        <!-- page view -->
        <header class="container-fluid display-2 bg-primary text-center font-weight-bold">Smart Paking map</header>
        <h3 class="font-weight-bold">Ho Chi Minh city</h3>

        <div class="row" ng-controller="directionsCtrl">
            <div class="col-md-9">
                <div id="map"></div>
            </div>

            <div class="col-lg-3">
                <div id="locations-box" class="label-box">
                    <div id="{{place.id}}" ng-click="directionActive($event)" class="places-label border-bottom border-dark" ng-repeat="place in vm.places" ng-value="place">{{place.name}}</div>
                </div>

                <div id="floating-panel">
                    <p id="panel-name" class="bg-primary">{{placeName}}</p>
                    <p class="panel-prob"><i class="fas fa-map-marker-alt"></i>{{dis}}</p>
                    <p class="panel-prob"><i class="far fa-clock"></i>{{dur}}</p>
                </div>
            </div>


        </div>

        <!-- page view -->
        <script>
        var map;
        function createMap(){
            map = new google.maps.Map(document.getElementById('map'), {
                zoom: 13,
                center: {lat: 10.790958, lng: 106.692874}
            });
        }

        </script>
        <!-- This is Thuan's API key -->
        <!-- script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDSbtA0_Tz3jt215tYXIOTKArJR5zHWfYI&callback=initParkingMap"
        defer></script-->

        <!-- This is My API key -->
        <!-- script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCFiTa_g-zJvj2RltUKDRcwP-VLY4s5a24&callback=initParkingMap"
        defer></script-->
    </body>
</html>
