(function (ng) {
    var mod = ng.module("reclamoModule");
    mod.constant("reclamoContext", "api/reclamos");
    mod.controller('reclamoCtrl', ['$scope', '$http', 'reclamoContext',
        function ($scope, $http, reclamoContext) {
            $http.get(reclamoContext).then(function (response) {
            
                $scope.reclamosRecords = response.data;
                console.log($scope);
            });
        }
    ]);
}
)(window.angular);