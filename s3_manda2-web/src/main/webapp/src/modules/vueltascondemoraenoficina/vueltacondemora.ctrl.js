(function (ng) {
        var mod = ng.module("vueltaModule");
        mod.constant("vueltaContext", "api/vueltascondemoraenoficina");
        mod.controller('vueltaCtrl', ['$scope', '$http', 'vueltaContext',
            function ($scope, $http, vueltaContext) {
                $http.get(vueltaContext).then(function (response) {
                    $scope.vueltasRecords = response.data;
                });
            }
        ]);
    }
)(window.angular);

