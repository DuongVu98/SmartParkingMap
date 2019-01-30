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

        <script type="text/javascript" src="app/map/init-map.js"></script>
        <script type="text/javascript" src="app/map/app.js"></script>
        <script type="text/javascript" src="app/map/places/placesCtrl.js"></script>
        <script type="text/javascript" src="app/map/services/common-services.js"></script>
        <script type="text/javascript" src="app/map/services/placesResource.js"></script>
    </head>
    <body ng-app="placesManagement">
        <!-- page view -->
        <header class="container-fluid display-2 bg-primary text-center font-weight-bold">Smart Paking map</header>
        <h3 class="font-weight-bold">Ho Chi Minh city</h3>
        <div class="row">
            <div style="height:500px;border-style:groove;border-color:gray;overflow:auto;" class="col-lg-3">
                <div id="locations"></div>
            </div>
            <div class="col-md-9">
                <div id="floating-panel" class="row">
                    <div class="row col-md-6">
                        <b>Distance: </b><p id="distance-value">test</p>
                    </div>
                    <div class="row col-md-6">
                        <b>Duration: </b><p id="duration-value">test</p>
                    </div>
                </div>
                <div id="map" ng-model="map"></div>
            </div>
        </div>
        <div class="text-center" id="test" ng-controller="placesListCtrl as vm">Test
            <div ng-repeat="place in vm.places">{{place.name}}</div>
        </div>
        <!-- page view -->

        <!-- This is Thuan's API key -->
        <!-- script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDSbtA0_Tz3jt215tYXIOTKArJR5zHWfYI&callback=initParkingMap"
        defer></script-->

        <!-- This is Tung's API key -->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCu77FS-25mnr0N-64wK7dZZ51YU22eWzc" defer></script>

        <!-- This is My API key -->
        <!-- script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCFiTa_g-zJvj2RltUKDRcwP-VLY4s5a24&callback=initParkingMap"
        defer></script-->
    </body>
</html>
