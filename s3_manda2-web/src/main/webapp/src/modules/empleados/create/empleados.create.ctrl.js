(function (ng) {
    var mod = ng.module("empleadoModule");
    mod.constant("empleadosContext", "api/empleados");
    mod.controller('empleadoNewCtrl', ['$scope', '$http', 'empleadosContext', '$state', '$rootScope',
        
        function ($scope, $http, empleadosContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};
       
            $scope.createEmpleado = function () {
                $http.post(empleadosContext, {
                    id: $scope.empleadoId,
                    nombre: $scope.empleadoNombre,
                    fechaIngreso: $scope.empleadoFechaIngreso,
                    cedula: $scope.empleadoCedula,
                    calificacion: $scope.empleadoCalificacion,
                    identificacion: $scope.empleadoIdentificacion,
                    EPS: $scope.empleadoEPS
                }).then(function (response) {
                    $state.go('empleadosList', {empleadoId: response.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);


