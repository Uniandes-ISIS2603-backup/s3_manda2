(function(ng){
     var mod = ng.module('vueltaModule');
     mod.constant("vueltaContext", "api/vueltascondemoraenoficina");
     mod.controller('vueltaUpdateCtrl', ['$scope', '$http', 'vueltaContext', '$state','$rootScope',
          function ($scope, $http, vueltaContext, $state, $rootScope){
              $rootScope.update = true;
               var idVuelta = $state.params.idVuelta;
               $scope.data = {'id':1};
               
                $scope.createVuelta = function(){
                    $http.put(vueltaContext, $scope.data).then(function (response){
                   $state.go('vueltacondemoraList', {idVuelta: response.id}, {reload:true});
  });
                };
            }]);
})(window.angular);

