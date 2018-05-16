(function (ng) {
        var mod = ng.module("vueltaModule");
        mod.constant("vueltaContext", "api/vueltascondemoraenoficina");
        mod.controller('vueltaCreateCtrl', ['$scope', '$http', 'vueltaContext', '$state',
            function ($scope, $http, vueltaContext, $state) {
                $scope.data = {'id': 1};

                $scope.createVuelta = function () {
                    $http.post(vueltaContext, $scope.data).then(function (response) {
                        $state.go('vueltacondemoraList', {idVuelta: response.id}, {reload: true});
                    });

                };
            }]);
    }
)(window.angular);


