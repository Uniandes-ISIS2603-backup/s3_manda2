(function (ng) {
    var mod = ng.module('tarjetacreditoModule');
    mod.constant('tarjetacreditoContext', 'api/tarjetascreditos');
    mod.controller('tarjetacreditoUpdateCtrl', ['$scope', '$http', 'tarjetacreditoContext', '$state', '$rootScope',
        function ($scope, $http, tarjetacreditoContext, $state, $rootScope) {
            $rootScope.update = true;
            var idTarjetacredito = $state.params.idTarjetacredito;
            $scope.data = {'id': 1};

            $scope.createTarjetacredito = function () {
                $http.put(tarjetacreditoContext + '/' + idTarjetacredito, $scope.data).then(function (response) {
                    $state.go('tarjetacreditoList', {idTarjetacredito: response.data.id}, {reload: true});
                });
            };
        }]);
})(window.angular);