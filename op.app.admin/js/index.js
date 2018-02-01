var cms = angular.module("cms_index", ['ui.router']);

cms.controller("tab",function($scope,$http){
    //json
    $http.get('config/index.json').then(function success(res){
        //tab栏内容
        $scope.tabsArr = res.data.tabsArr;
        //tab栏class
        $scope.class = res.data.class;
    },function error(){

    });

    // tab栏的active
    $scope.action = function(){

    }
});
//引入js
document.write("<script language='javascript' src='js/homepage/registrant.js'></script>");


//配置路由
cms.config(function($stateProvider,$urlRouterProvider){
    $urlRouterProvider.otherwise('/home/registrant');
    $stateProvider.state('registrant',{
        url:"/home/registrant",
        templateUrl:'contain/homepage/registrant.html',
        controller:'home_registrant'
    }).state('registrant.form',{
        templateUrl:'contain/homepage/regform.html',
        controller:'home_registrant_form'
    });
    //.state('/',{template:'这是首页页面'})
});
