(function (ng) {
        var mod = ng.module("reclamoModule");
        mod.constant("reclamoContext", "api/reclamos");
        mod.controller('reclamoDetailCtrl', ['$scope', '$http', 'reclamoContext','$state',
            function ($scope, $http, reclamoContext, $state) {
                if (($state.params.reclamoId !== undefined) && ($state.params.reclamoId !== null)) {
                    $http.get(reclamoContext + '/' + $state.params.reclamoId).then(function (response) {
                        $scope.reclamoDetailRecords = response.data;
                    });
                }
            }
        ]);
    }
)(window.angular);