<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>HCMIU Parking Map</title>
        <style>

            /* Optional: Makes the sample page fill the window. */
        </style>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <link href="css/map-style.css" rel="stylesheet">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-resource/1.6.9/angular-resource.js"></script>

        <!-- This is Tung's API key -->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCu77FS-25mnr0N-64wK7dZZ51YU22eWzc&callback=createMap" defer></script>


        <%--app script  --%>
        <script type="text/javascript" src="app/map/app.js"></script>

        <%-- controller script --%>
        <script type="text/javascript" src="app/map/places/placesCtrl.js"></script>
        <script type="text/javascript" src="app/map/places/directionsCtrl.js"></script>
        <script type="text/javascript" src="app/map/places/distanceCtrl.js"></script>

        <%-- services script --%>
        <script type="text/javascript" src="app/map/services/common-services.js"></script>
        <script type="text/javascript" src="app/map/services/placesResource.js"></script>
    </head>
    <body ng-app="placesManagement" ng-controller="placesListCtrl as vm">
        <!-- page view -->
        <header class="container-fluid display-2 bg-primary text-center font-weight-bold">Smart Paking map</header>
        <h3 class="font-weight-bold">Ho Chi Minh city</h3>

        <div ng-controller="distanceCtrl">
        <div class="row" ng-controller="directionsCtrl">
            <div id="locations" style="height:500px;background:#E9ECED;border-color:gray;overflow:auto;border-radius:15px;padding:5px;" class="label-box col-lg-3">
                <div id="{{place.id}}" ng-click="directionActive($event)" class="places-label border-bottom rounded border-dark" ng-repeat="place in vm.places" ng-value="place">{{place.name}}</div>
            </div>
            <div class="col-md-9">
                <div id="floating-panel" class="row">
                    <div class="row col-md-6">
                        <b>Distance: </b><p id="distance-value">{{dis}}</p>
                    </div>
                    <div class="row col-md-6">
                        <b>Duration: </b><p id="duration-value">{{dur}}</p>
                    </div>
                </div>
                <div id="map"></div>
            </div>
            <div id="test" class="text-center">place name: {{test}}</div>
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
