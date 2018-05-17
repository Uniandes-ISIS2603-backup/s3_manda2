(function (ng) {
        var mod = ng.module("reclamoModule");
        mod.constant("reclamoContext", "api/reclamos");
        mod.controller('reclamoDeleteCtrl', ['$scope', '$http', 'reclamoContext', '$state',

            function ($scope, $http, reclamoContext, $state) {
                console.log($state.params.reclamoId);
                var idReclamo = $state.params.reclamoId;

                $scope.deleteReclamo = function () {
                    console.log(reclamoContext);
                    console.log(idReclamo);
                    $http.delete(reclamoContext + '/' + idReclamo, {}).then(function (response) {
                        $state.go('reclamosList', {reclamoId: response.data.id}, {reload: true});
                    });
                };
            }
        ]);
    }
)(window.angular);