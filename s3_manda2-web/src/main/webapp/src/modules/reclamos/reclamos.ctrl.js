(function (ng) {
    var mod = ng.module("reclamoModule");
    mod.constant("reclamoContext", "api/reclamos");
    mod.controller('reclamoCtrl', ['$scope', '$http', 'reclamoContext',
        function ($scope, $http, reclamoContext) {
            $http.get('data/reclamos.json').then(function (response) {
                $scope.reclamosRecords = response.data;
            });
        }
    ]);
}
)(window.angular);