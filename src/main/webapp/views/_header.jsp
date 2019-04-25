<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <link rel="icon" href="res/icon2.png" type="image/gif">

    <!-- <link rel="stylesheet" href="../node_modules/bootstrap/dist/css/bootstrap.min.css"> -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link href="css/map-style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

    <script src="../node_modules/jquery/dist/jquery.js"></script>

    <!-- <script src="../node_modules/angular/angular.js"></script> -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.7.7/angular.min.js"></script>
    <!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script> -->
    <!-- <script src="../node_modules/angular-resource/angular-resource.js"></script> -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-resource/1.7.7/angular-resource.js"></script>

    <!-- This is Tung's API key -->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCu77FS-25mnr0N-64wK7dZZ51YU22eWzc&callback=createMap" defer></script>


    <%--app script  --%>
    <script type="text/javascript" src="app/map/app.module.js"></script>

    <%-- controller script --%>
    <script type="text/javascript" src="app/map/places/places.controller.js"></script>
    <script type="text/javascript" src="app/map/places/directions.controller.js"></script>

    <%-- services script --%>
    <script type="text/javascript" src="app/map/services/common.service.js"></script>
    <script type="text/javascript" src="app/map/services/places.service.js"></script>
