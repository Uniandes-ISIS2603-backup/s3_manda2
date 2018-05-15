(function(ng){
     var mod = ng.module('vueltaModule');
     mod.constant("vueltaContext", "api/vueltascondemoraenoficina");
     mod.controller('vueltaDeleteCtrl', ['$scope', '$http', 'vueltaContext', '$state',
         function ($scope, $http, vueltaContext, $state){
             var vueltaId = $state.params.vueltaId;
             
             $scope.deleteVuelta = function(){
                    $http.delete(vueltaContext + '/'+ vueltaId, {}).then(function (response){
                   $state.go('vueltacondemoraList', {vueltaId: response.id}, {reload:true});
          });
            };
        }]);
})(window.angular);