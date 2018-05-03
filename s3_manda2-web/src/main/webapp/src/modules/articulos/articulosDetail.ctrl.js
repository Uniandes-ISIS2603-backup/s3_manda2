
/** Artículos con lo scopes */
(function (ng) {
        var mod = ng.module("articulosModule");
        mod.constant("articulosContext2", "api/articulos");
        mod.controller('articulosDetailCtrl', ['$scope', '$http', 'articulosContext2',
            function ($scope, $http, articulosContext2) {
                $http.get('data/articulos.json').then(function (response) {
                    $scope.articulosDetailRecords = response.data;
                });
            }
        ]);
    }
)(window.angular);