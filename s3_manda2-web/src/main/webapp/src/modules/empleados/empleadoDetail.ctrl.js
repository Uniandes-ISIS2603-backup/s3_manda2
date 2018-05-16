(function (ng) {
        var mod = ng.module("empleadoModule");
        mod.constant("empleadoContext", "api / empleados");
        mod.controller('empleadoDetailCtrl', ['$scope', '$http', 'empleadoContext',
            function ($scope, $http, empleadoContext, $state) {
                if (($state.param.empleadoId !== undefined) && ($state.param.empleadoId !== null)) {
                    $http.get(empleadoContext + '/' + $state.param.empleadoId).then(function (response) {
                        $scope.empleadoseleccionado = response.data;
                    });
                }
            }
        ]);
    }
)(window.angular);
