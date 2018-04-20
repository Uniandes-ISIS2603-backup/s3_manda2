(function (ng) {
    var mod = ng.module("reclamoModule");
    mod.constant("reclamoContext2", "api/reclamos");
    mod.controller('reclamoDetailCtrl', ['$scope', '$http', 'reclamoContext2',
        function ($scope, $http, reclamoContext2) {
            $http.get('data/reclamosDetail.json').then(function (response) {
                $scope.reclamoDetailRecords = response.data;
            });
        }
    ]);
}
)(window.angular);