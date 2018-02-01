//首页registrant控制器
cms.controller('home_registrant',function ($scope, $http) {
    //TODO:should be from server
    $http.get('config/registrant.json').then(function success(res){
        $scope.editList = res.data.editList;
        $scope.bannerList = res.data.bannerList;
    },function error(res){

    });
    $http.get('config/test-sort.json').then(function success(res){
        var sortList = res.data;
        //分类
        (function(list){
            $scope.level1 = [];
            $scope.level2 = [];
            $scope.level3 = [];
            for(var i = 0; i < list.length; i++){
                if(list[i].level == 1){
                    // console.log("1");
                    $scope.level1.push(list[i]);
                }else if(list[i].level == 2){
                    // console.log("2");
                    $scope.level2.push(list[i]);
                }else if(list[i].level == 3){
                    // console.log("3");
                    $scope.level3.push(list[i]);
                } else {
                    console.error("wrong")
                }
            }
            console.log("one:"+$scope.level1.length+"&two:"+$scope.level2.length+"&three:"+$scope.level3.length);
        })(sortList)
    },function error(res){

    });
    //变量
    $scope.ifshow = false;
    $scope.olevel1 = 0;
    $scope.olevel2 = 0;
    $scope.olevel3 = [];
    $scope.level2List = [];
    $scope.level3List = [];

    $scope.userInfo = {
        "trademark":"",
        "category":{
            "level1":"",
            "level2":"",
            "level3":[]
        },
        "type":"1", //1为普通注册，2为加急注册，3为注册+预审+退费担保
        "registrant":{
            "name":"",
            "phone":"",
            "address":"",
            "regtype":"" //1为自然人，2为个体工商户，3为公司或其他组织
        }
    };
    //事件
    $scope.inputValue = function(level){
        var lis = "#olevel"+level+" ul.select-dropdown li";
        var options = "#olevel"+level+" option";
        var optionArr = $(lis);
        var select = "#olevel"+(level+1)+" select";
        var clickfn = function(){
            console.log("#olevel"+(level+1)+" select");
            $(select).empty();
            for(var li = 0; li < optionArr.length; li++) {
                this.li = li;
                if($(optionArr[li]).hasClass('active')){
                    $scope["olevel"+level] = $(options)[this.li].value;
                    $scope.selectFilter(level+1);
                }
            }
        };
        if(level == 1){
            optionArr.click(clickfn);
        }else {
            clickfn();
        }
    };
    $scope.selectFilter = function(level){
        var list = $scope["level"+level];
        var ul = "#olevel"+level+" ul.select-dropdown";
        var select = "#olevel"+level+" select";
        var input = '#olevel'+level+" input";
        // $(ul).empty();
        for(var i = 0; i < list.length; i++){
            if(list[i].parentid == $scope["olevel"+(level-1)]){
                // if(level == 2){
                //     $(ul).append("<li class=''><span>"+list[i].name+"</span></li>");
                // }
                // else {
                //     $(ul).append('<li class=""><span><input type="checkbox"><label></label>'+list[i].name+'</span></li>')
                // }
                $(select).append("<option value='"+list[i].id+"'>"+list[i].name+"</option>");
            }
        }
        // $('select').material_select();
        $(ul+" li").click(function(){
            $scope.inputValue(level);
        });
        if(level == 2) {
            $(ul+" li").click(function(){
                // $(ul+" li").removeClass('active selected');
                // $(this).addClass('active selected');
                // $(input)[0].value = this.innerText;
                $scope.inputValue(2);
            });
        }else {
            $(ul+" li").click(function(){
                $scope.inputValue(3);
                // $(input).addClass('active');
                // $(ul+" li").removeClass('selected');
                // $(this).addClass('active selected');
                // $(ul).css('display','block');
            });
        }

    };
    $scope.bindSelect = function(){
        $scope.ifshow = true;
        $scope.inputValue(1);
    };
    $scope.closeinfo = function(){
        $scope.ifshow = false;
    };
    //上传修改后信息
    $scope.updateInfo = function () {
        $http.post('config/registrant.json',$scope.userInfo).then(function success(res){
            $scope.bannerList[0] = $scope.userInfo;

        },function error(res){

        });
    };
    //编辑内容
    $scope.imgupload = 0;
    //判断img是否加载
    $scope.ifimg = function(){
        if(this.$index == 1 && $scope.editList[1].model){
            var imgObj = new Image();
            imgObj.src = $scope.editList[1].model;
            if(imgObj.width>0){
                $scope.imgupload = 1;
            }
            else {
                $scope.imgupload = 2;
            }
        }
    };
    $scope.ifimage = function(){
        if(this.$index == 1 && $scope.editList[1].model != ""){
            if($scope.imgupload != 2){
                $scope.imgupload = 0;
            }
        }
    };
    $scope.topid = false;
    //判断是否点击
    $scope.isSelected = function(){
        return $scope.selected.indexOf(this)>=0;
    }
});


cms.controller('home_registrant_form',function ($scope, $http) {
    $scope.a = function(){
        console.log(122233);
    }();
});
//上传配置
// document.write("<script language='javascript' src='js/homepage/uploadimg.js'></script>");