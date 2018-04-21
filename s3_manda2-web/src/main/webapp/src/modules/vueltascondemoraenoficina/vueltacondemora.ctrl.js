(function(ng){
    var mod = ng.module("vueltaModule");
    mod.constant("vueltaContext", "data/vueltas.json");
    mod.controller('vueltaCtrl', ['$scope', '$http', 'vueltaContext',
        function ($scope, $http, vueltaContext) {
            $http.get(vueltaContext).then(function (response){
                $scope.vueltasRecords = response.data;
            });
        }               
    ]);
}
)(window.angular);

