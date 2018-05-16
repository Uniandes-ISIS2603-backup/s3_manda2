(function (ng) {
    var mod = ng.module('tarjetacreditoModule');
    mod.constant('tarjetacreditoContext', 'api/tarjetascreditos');
    mod.controller('tarjetacreditoCreateCtrl', ['$scope', '$http', 'tarjetacreditoContext', '$state',
        function ($scope, $http, tarjetacreditoContext, $state) {
            $scope.data = {'id': 1};

            $scope.createTarjetacredito = function () {
                $http.post(tarjetacreditoContext, $scope.data).then(function (response) {
                    $state.go('tarjetacreditoList', {idTarjetacredito: response.id}, {reload: true});
                });
            };
        }]);
})(window.angular);