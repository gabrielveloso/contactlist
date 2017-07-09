// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
// 'starter.services' is found in services.js
// 'starter.controllers' is found in controllers.js
angular.module('app', ["ngRoute"])

.controller("testeCtrl", function($scope, $http) {
  $scope.lista = "gabriel";
  
  $scope.nova = "PÁGINA LOGIN";
  
  $http.get('usuarios').then(
			function successCallback(response) {
				console.log(response.data);
			},
			function errorCallback(response) {
				
			}
	);
  
  $scope.credentials = {};
	$scope.login = function(credentials) {
		var headers = credentials ? {authorization : "Basic "
			+ btoa(credentials.username + ":" + credentials.password)
		} : {};

		$http.get("logar", {headers : headers}).then(function(response) {
			if (response.data.authenticated) {
				$rootScope.authenticated = true;
				console.log("Login OK");
				$scope.errorMessage = false;
				$location.path("/logado");
			} else {
				$location.path("/");
				$rootScope.authenticated = false;
				console.log("Login Error");
				$scope.errorMessage = true;
			} 
		},  function errorCallback(response) {
			$rootScope.authenticated = false;
			console.log("Login Error Callback");
			$scope.errorMessage = true;
		});

	};
});