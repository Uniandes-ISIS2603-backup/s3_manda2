(function (ng) {
    let mod = ng.module('vueltaModule');
    mod.constant("vueltaContext", 'api/vueltascondemoraenoficina');
    mod.controller('vueltasDetailCtrl', ['$scope', '$http', "vueltaContext", '$stateParams',
        function ($scope, $http, vueltaContext, $stateParams) {

            $http.get(vueltaContext + '/' + $stateParams.vuelta_id, {}).then(function (response) {
                $scope.vueltaActual = response.data;
            });
        }
    ]);
})(window.angular);


