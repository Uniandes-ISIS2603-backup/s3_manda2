(function (ng) {
        var mod = ng.module("empleadoModule");
        mod.constant("empleadoContext", "api/empleados");
        mod.controller('empleadoCtrl', ['$scope', '$http', 'empleadoContext',
            function ($scope, $http, empleadoContext) {
                $http.get(empleadoContext).then(function (response) {
                    $scope.empleadosRecords = response.data;
                });
            }
        ]);
    }
)(window.angular);

