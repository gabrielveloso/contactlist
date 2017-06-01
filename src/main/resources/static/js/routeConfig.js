angular.module("app").config(function($routeProvider, $httpProvider) {
	
	//$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
	
	$routeProvider.when("/", {
		templateUrl: "views/home.html",
		controller: "testeCtrl"		
	});

	$routeProvider.otherwise({
		redirectTo: "/"
	});

});