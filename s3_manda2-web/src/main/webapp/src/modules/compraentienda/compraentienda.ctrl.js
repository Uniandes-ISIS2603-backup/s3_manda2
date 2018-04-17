(function (ng){
    var mod = ng.module("compraModule");
    mod.constant("compraContext", "api/comprasentienda");
     mod.controller('compraCtrl',['$scope', '$http', 'compraContext',
          function ($scope, $http, compraContext) { 
              $http.get('compraContext').then(function (response) {  
              $scope.comprasRecords = response.data;
          });
    }
    ]);
}
)(window.angular);