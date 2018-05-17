(function (ng) {
        var mod = ng.module("reclamoModule");
        mod.constant("reclamoContext", "api/reclamos");
        mod.controller('reclamoCtrl', ['$scope', '$http', 'reclamoContext',
            function ($scope, $http, reclamoContext) {
            $scope.reclamosRecords=[
                {mensaje:'Mariana se comio todos los platanitos'},
                {mensaje:'Mariana se comio todos los platanitos'}
                    ,{mensaje:'Mariana se comio todos los platanitos'},
                {mensaje:'Mariana se comio todos los platanitos'},
                {mensaje:'Mariana se comio todos los platanitos'}
                ,{mensaje:'Mariana se comio todos los platanitos'},
                {mensaje:'Mariana se comio todos los platanitos'}
            ];
                $http.get(reclamoContext).then(function (response) {
                    $scope.reclamosRecords = response.data;
                    console.log($scope);
                });
            }
        ]);
    }
)(window.angular);