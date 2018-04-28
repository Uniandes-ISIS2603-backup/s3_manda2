(
    function (ng) {
        var mod = ng.modile('reclamoModule');
        mod.constant('reclamoContext', 'api/reclamos');
        mod.controller('reclamoCreateCtrl', ['$scope', '$http', 'reclamoContext', '$state',
            function ($scope, $http, reclamoContext, $state) {
                $scope.data = {};
                $scope.createReclamo = function () {
                    $http.post(reclamoContext, {
                        id: $scope.reclamoNumero,
                        mensaje: $scope.reclamoMensaje}
                    ).then(function (response) {
                        $state.go('reclamoList', {idReclamo: response.numero}, {reload: true});
                    });
                };
            }]);
})
(window.angular);
