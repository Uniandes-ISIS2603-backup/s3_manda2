(function (ng) {
        var mod = ng.module("clienteModule");
        mod.constant("clientesContext", "api/clientes");
        mod.controller('clienteUpdateCtrl', ['$scope', '$http', 'clientesContext', '$state', '$rootScope',

            function ($scope, $http, clientesContext, $state, $rootScope) {
                $rootScope.edit = true;

                var idCliente = $state.params.clienteId;

                $http.get(clientesContext + '/' + idCliente).then(function (response) {
                    var cliente = response.data;
                    $scope.clienteId = cliente.id;
                    $scope.clienteNombre = cliente.nombre;
                    $scope.clienteLogin = cliente.login;
                    $scope.clienteFechaIngreso = new Date(cliente.fechaIngreso);
                    $scope.clienteCedula = cliente.cedula;
                    $scope.clienteCalificacion = cliente.calificacion;
                    $scope.clientePagoAnticipado = cliente.pagoAnticipado;
                    $scope.clienteHorasDeServicioSemanal = cliente.horasDeServicioSemanal;
                });
                $scope.createCliente = function () {
                    console.log($scope.clienteNombre);
                    console.log($scope.clienteCedula);
                    $http.put(clientesContext + "/" + idCliente, {
                        id: $state.params.clienteId,
                        nombre: $scope.clienteNombre,
                        login: $scope.clienteLogin,
                        fechaIngreso: $scope.clienteFechaIngreso,
                        cedula: $scope.clienteCedula,
                        calificacion: $scope.clienteCalificacion,
                        pagoAnticipado: $scope.clientePagoAnticipado,
                        horasDeServicioSemanal: $scope.clienteHorasDeServicioSemanal
                    }).then(function (response) {
                        //Author created successfully
                        $state.go('clientesList', {clienteId: response.data.id}, {reload: true});
                    });
                };
            }
        ]);
    }
)(window.angular);