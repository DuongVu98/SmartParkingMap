<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.7.8/angular.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.7.8/angular-resource.js"></script>

    <script src="../app/services/places.service.js"></script>
    <script src="../app/services/common.service.js"></script>

    <title>Home</title>
</head>

<body ng-app="home">
    <h1>Home</h1>
    <places-list></places-list>

    <!-- <div ng-include="'../app/placesList/places-list.html'"></div> -->

    <!-- <div ng-include="'./test.html'"></div>
    <div ng-include="'test.html'"></div>
    <div ng-inlcude src="test.html"></div>
    <ng-include src="'test.html'"></ng-include> -->

    <!-- <div ng-include="'./test.jsp'"></div>
    <div ng-include="'test.jsp'"></div>
    <div ng-inlcude src="test.jsp"></div>
    <ng-include src="'test.jsp'"></ng-include> -->

    <script>
        angular.module("home", []).directive("placesList", function () {
            return {
                templateUrl: "../app/placesList/places-list.html"
                // template: "<h1>hello</h1>"
            };
        });
    </script>
</body>

</html>