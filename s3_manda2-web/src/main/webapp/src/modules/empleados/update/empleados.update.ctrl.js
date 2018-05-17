(function (ng) {
        var mod = ng.module("empleadoModule");
        mod.constant("empleadosContext", "api/empleados");
        mod.controller('empleadoUpdateCtrl', ['$scope', '$http', 'empleadosContext', '$state', '$rootScope',

            function ($scope, $http, empleadosContext, $state, $rootScope) {
                $rootScope.edit = true;

                var idEmpleado= $state.params.empleadoId;

                $http.get(empleadosContext + '/' + idEmpleado).then(function (response) {
                    var empleado = response.data;
                    $scope.empleadoId = empleado.id;
                    $scope.empleadoNombre = empleado.nombre;
                    $scope.empleadoLogin = empleado.login;
                    $scope.empleadoFechaIngreso = new Date(empleado.fechaDeIngreso);
                    $scope.empleadoCedula = empleado.cedula;
                    $scope.empleadoCalificacion = empleado.calificacion;
                    $scope.empleadoIdentificacion = empleado.identificacion;
                    $scope.empleadoEPS = empleado.eps;
                });
                console.log("hola");
                $scope.createEmpleado = function () {
                    console.log($scope.empleadoNombre);
                    $http.put(empleadosContext + "/" + idEmpleado, {
                        id: $state.params.empleadoId,
                        nombre: $scope.empleadoNombre,
                        login: $scope.empleadoLogin,
                        fechaIngreso: $scope.empleadoFechaIngreso,
                        cedula: $scope.empleadoCedula,
                        calificacion: $scope.empleadoCalificacion,
                        identificacion: $scope.empleadoIdentificacion,
                        EPS: $scope.empleadoEPS
                    }).then(function (response) {
                        //Empleado created successfully
                        $state.go('empleadosList', {empleadoId: response.data.id}, {reload: true});
                    });
                };
            }
        ]);
    }
)(window.angular);