(function (ng) {
    var mod = ng.module("reclamoModule");
    mod.constant("reclamoContext", "api/reclamos");
    mod.controller('reclamoDetailCtrl', ['$scope', '$http', 'reclamoContext',
        function ($scope, $http, reclamoContext, $state) {
            if (($state.param.reclamoId !== undefined)&& ($state.param.reclamoId !== null)) {
            $http.get(reclamoContext + '/'+ $state.param.reclamoId).then(function (response) {
                $scope.reclamoDetailRecords = response.data;
            });
        }
        }
    ]);
}
)(window.angular);