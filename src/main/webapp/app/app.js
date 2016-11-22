'use strict';
(function () {
    var myApp = angular.module('myApp', []);

    myApp.controller('CharacterController', function ($scope, $http) {
        $http.get('/character').then(function (response) {
            $scope.character = response.data;
        })
    });

    myApp.controller('StoreController', ['$http', function ($http) {
        var store = this;
        store.products = [];
        $http.get('/assets/store-products.json').success(function (data) {
            store.products = data;
        });
    }]);
})();

// var myApp = angular.module('myApp', []);
