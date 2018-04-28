(function (ng) {
    var mod = ng.module('reservasModule');
    mod.constant('reservasContext', 'api/reservas');
    mod.controller('reservasCreateCtrl', ['$scope', '$http', 'reservasContext', '$state', '$stateParams',
        function ($scope, $http, reservasContext, $state, $stateParams) {

            $http({
                method: 'POST',
                url: reservasContext,
                data: $stateParams
            }).then(function (response) {
                $scope.reservaActual = response.data;
            });
        }]);
})(window.angular);