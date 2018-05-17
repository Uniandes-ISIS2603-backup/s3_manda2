(function (ng) {
        var mod = ng.module("reservaModule");
        mod.constant("reservaContext", "api/organizaciones");
        mod.controller('reservaDeleteCtrl', ['$scope', '$http', 'reservaContext', '$state',

            function ($scope, $http, reservaContext, $state) {
                var idReserva = $state.params.reservaId;

                $scope.deleteReserva = function () {
                    $http.delete(reservaContext + '/' + idReserva, {}).then(function (response) {
                        $state.go('reservasList', {reservaId: response.data.id}, {reload: true});
                    });
                };
            }
        ]);
    }
)(window.angular);