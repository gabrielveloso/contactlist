angular.module("app").config(function($routeProvider, $httpProvider) {
	
	//$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
	
	$routeProvider.when("/login", {
		templateUrl: "home.html",
		controller: "testeCtrl"		
	}) .when("/logado", {
        templateUrl : "views/teste.htm"
    })

	$routeProvider.otherwise({
		redirectTo: "/"
	});

});