(function (ng) {
        var mod = ng.module('reclamoModule');
        mod.constant('reclamoContext', 'api/reclamos');
        mod.controller('reclamoCreateCtrl', ['$scope', '$http', 'reclamoContext', '$state',
            function ($scope, $http, reclamoContext, $state) {
                $scope.data = {};
                $scope.createReclamo = function () {
                    $http.post(reclamoContext, {
                        id:$scope.reclamoId,
                        numero: $scope.reclamoNumero,
                        mensaje: $scope.reclamoMensaje}
                    ).then(function (response) {
                        $state.go('reclamosList', {idReclamo: response.id}, {reload: true});
                    });
                };
            }]);
})(window.angular);
