(function (ng) {
    var mod = ng.module("empleadoModule");
    mod.constant("empleadoContext", "api / empleados");
    mod.controller('empleadoDetailCtrl', ['$scope', '$http', 'empleadoContext','$state',
        function ($scope, $http, empleadoContext, $state) {
            if (($state.params.empleadoId !== undefined) && ($state.params.empleadoId !== null)) {
                $http.get(empleadoContext + '/' + $state.params.empleadoId).then(function (response) {
                    $scope.empleadoseleccionado = response.data;
                });
            }
        }
    ]);
}
)(window.angular);
