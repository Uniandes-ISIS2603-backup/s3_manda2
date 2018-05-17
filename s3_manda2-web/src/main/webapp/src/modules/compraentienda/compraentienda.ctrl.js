(function (ng) {
        var mod = ng.module("compraModule");
        mod.constant("compra", "api/comprasentienda");
        mod.controller('compraCtrl', ['$scope', '$http', 'compra',
            function ($scope, $http, compra) {
                $http.get(compra).then(function (response) {
                    $scope.comprasRecords = response.data;
                });
            }
        ]);
    }
)(window.angular);