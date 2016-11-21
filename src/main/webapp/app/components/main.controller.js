angular.module('demo', []).controller('Hello', function ($scope, $http) {
    $http.get('/character').then(function (response) {
        $scope.character = response.data;
    })
});

// app.controller('MainController', ['$scope', function ($scope) {
//     $scope.title = 'Top Sellers in Books';
// } ]);