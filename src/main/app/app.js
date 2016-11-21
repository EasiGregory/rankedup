'use strict';
(function () {
    var gems = [
        {
            name: 'Azurite',
            price: 3.95,
            description: "Something cool",
            canPurchase: true,
            soldOut: false
        },
        {
            name: 'Dudurite',
            price: 7.95,
            description: "Something cooler",
            canPurchase: false,
            soldOut: false
        }
    ];
    var myApp = angular.module('myApp', []);

    myApp.controller('StoreController', function () {
        this.products = gems;
    });
})();

// var myApp = angular.module('myApp', []);
