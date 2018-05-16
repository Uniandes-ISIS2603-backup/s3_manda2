(function (ng) {
    var mod = ng.module('compraModule');
    mod.constant("compraContext", "api/comprasentienda");
    mod.controller('compraDeleteCtrl', ['$scope', '$http', 'vueltaContext', '$state', '$rootScope',
        function ($scope, $http, compraContext, $state, $rootScope) {
            $rootScope.update = true;
            var idCompra = $state.params.idCompra;
            $scope.data = {'id': 1};

            $scope.createCompra = function () {
                $http.put(compraContext, $scope.data).then(function (response) {
                    $state.go('compraentiendaList', {idCompra: response.id}, {reload: true});
                });
            };
        }]);
})(window.angular);
