(function (ng){
    let mod = ng.module('billeteraModulo');
    mod.constant("billeteraContext",'api/billeteras');
    mod.controller('billeterasDetailCtrl', ['$scope', '$http', "billeteraContext", '$stateParams',
        function($scope, $http, billeteraContext,$stateParams){

            $http.get(billeteraContext +'/'+ $stateParams.billetera_id, {} ).then(function (response){
                $scope.billeteraIdRecords =  response.data;
            });
        }

    ]);
})(window.angular);


