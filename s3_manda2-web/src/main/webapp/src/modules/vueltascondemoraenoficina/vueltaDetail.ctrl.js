(function(ng){
    var mod = ng.module("vueltaModule");
    mod.constant("vueltaContext", "api/vueltascondemoraenoficina");
    mod.controller('vueltaDetailCtrl', ['$scope', '$http', 'vueltaContext', '$state',
        function ($scope, $http, vueltaContext, $state) {
 if (($state.params.vueltaId !== undefined)&& ($state.params.vueltaId !== null)) {
            $http.get(vueltaContext + '/' + $state.params.vueltaId).then(function (response) {
                $scope.vueltaActual = response.data;
            });
        }
    }
    ]);
}
)(window.angular);