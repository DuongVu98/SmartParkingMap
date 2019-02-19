<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link href="css/map-style.css" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-resource/1.6.9/angular-resource.js"></script>

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
