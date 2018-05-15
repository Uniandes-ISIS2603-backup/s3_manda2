(function (ng) {
        var mod = ng.module("clienteModule");
        mod.constant("clientesContext", "api/clientes");
        mod.controller('clienteNewCtrl', ['$scope', '$http', 'clientesContext', '$state', '$rootScope',

            function ($scope, $http, clientesContext, $state, $rootScope) {
                $rootScope.edit = false;

                $scope.data = {};

                $scope.createCliente = function () {
                    $http.post(clientesContext, {
                        id: $scope.clienteId,
                        nombre: $scope.clienteNombre,
                        fechaIngreso: $scope.clienteFechaIngreso,
                        cedula: $scope.clienteCedula,
                        calificacion: $scope.clienteCalificacion,
                        pagoAnticipado: $scope.clientePagoAnticipado,
                        horasDeServicioSemanal: $scope.clienteHorasDeServicioSemanal
                    }).then(function (response) {
                        $state.go('clientesList', {clienteId: response.data.id}, {reload: true});
                    });
                };
            }
        ]);
    }
)(window.angular);