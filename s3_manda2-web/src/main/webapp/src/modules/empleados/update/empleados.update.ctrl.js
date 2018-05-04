(function (ng) {
    var mod = ng.module("empleadoModule");
    mod.constant("empleadoContext", "api/empleados");
    mod.controller('empleadoUpdateCtrl', ['$scope', '$http', 'empleadoContext', '$state', '$rootScope',

        function ($scope, $http, empleadoContext, $state, $rootScope) {
            $rootScope.edit = true;
            var id = $state.params.empleadoId;

            $http.get(empleadoContext + '/' + id).then(function (response) {
                var empleado = response.data;
                $scope.empleadoId = empleado.id;
                $scope.empleadoNombre = empleado.nombre;
                $scope.empleadoFechaIngreso = new Date(empleado.fechaIngreso);
                $scope.empleadoCedula = empleado.cedula;
                $scope.empleadoCalificacion = empleado.calificacion;
                $scope.empleadoIdentificacion = empleado.identificacion;
                $scope.empleadoEPS = empleado.EPS;
            });
            $scope.createEmpleado = function () {
                $http.put(empleadoContext + "/" + id, {
                    id: $state.params.id,
                    nombre: $scope.empleadoNombre,
                    fechaIngreso: $scope.empleadoFechaIngreso,
                    cedula: $scope.empleadoCedula,
                    calificacion: $scope.empleadoCalificacion,
                    identificacion: $scope.empleadoIdentificacion,
                    EPS: $scope.empleadoEPS
                }).then(function (response) {
                   $state.go('empleadosList', {empleadoId: response.data.id}, {reload: true});   
                });
            };
        }]);
}
)(window.angular);