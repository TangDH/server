var app = getApp()
var a = wx.getSystemInfoSync();
Page({
    data: {
        historyArr: ["雪碧", "百事可乐", "Apple", "海飞丝", "宏基", "达能", "Aoiin Entertainment"],
        suggestArr: ["雪碧", "达能", "Aoiin Entertainment", "百事可乐", "Apple", "海飞丝", "宏基"],
        messageSearch: {
            brandName: '',
            tradeName: ''
        },
        style: {
            width: 100,
            height: 50,
            background: "#000"
        },
        pheight: a.windowHeight,
        pwidth: a.windowWidth,
        bnc: "",
        tnc: "",
        bfoc: false,
        tfoc: false,
        bvalue: "",
        tvalue: "",
        formTop: "30",
        historyTop: 1000,
        ifhis: 0,
        ani: "",
        ifshow: true,
        down: "down",
        suggestshow: "block",
        tipshow: "none",
        eye: "/img/eyeon.png",
        buttonloc: 0
    },
    formSubmit: function (e) {
        var that = this;
        if (e.detail.value.brandName == "" || e.detail.value.tradeName == "") {
            wx.showToast({
                title: "请输入信息",
                mask: true
            });
        } else {
            that.setData({
                messageSearch: {
                    brandName: e.detail.value.brandName,
                    tradeName: e.detail.value.tradeName
                }
            })
            wx.navigateTo({
                url: '../reportment/reportment?' + 'brandName=' + that.data.bvalue
            })

        }
    },
    bfouse: function (e) {
        // var value = e.detail.value;
        // 存储this
        var that = this;
        // 更新控制是否聚焦的变量bfoc
        that.setData({ bfoc: true });
        // 判断是否两个输入框均被聚焦
        if (that.data.tfoc && that.data.bfoc) {
            // 若为是，则最新的点击无效
            that.setData({ bfoc: false })
        }
        // 若为否，则进入动作
        else {
            // console.log("fouse:"+value)
            that.setData({
                bnc: 'bnc',
                bncf: 'bncf',
                formTop: '0',
                ani: "ani",
                historyTop: 45,
                ifhis: 1,
                buttonloc: 1000,
                down: ""
            })
        }
    },
    bblur: function (e) {
        // 存储input内容
        var value = this.data.bvalue;
        // console.log("blur:" +value)
        // 存储this 
        var that = this;
        // console.log(value);
        // 更新bfoc 
        that.setData({ bfoc: false });
        // 若为空，则预留值归位
        if (value == "") {
            that.setData({
                bnc: '',
                bncf: '',
                formTop: '30',
                ani: "",
                historyTop: 1000,
                ifhis: 0,
                buttonloc: 0,
                down: "down"
            })
        }
        // 若value不为空则保持左上角
        else {
            that.setData({
                bnc: 'bnc',
                bncf: 'bncf',
                formTop: '30',
                ani: "",
                historyTop: 1000,
                ifhis: 0,
                buttonloc: 0,
                down: "down"
            })
        }
    },
    bni: function (e) {
        var that = this;
        that.setData({
            messageSearch: {
                brandName: e.detail.value,
                tradeName: this.data.messageSearch.tradeName
            }
        })
        // console.log(that.data.messageSearch.brandName);
    },
    bbon: function(){
        var that = this;
        if(that.data.bvalue == ""){
            that.clearb();
            console.log(1);
        }
    },
    clearb: function () {
        var that = this;
        that.setData({
            bvalue: "",
            bnc: '',
            bncf: '',
        });
        console.log(1);
        //避免提前获取value值导致程序出错
        // setTimeout(function () {
        //     // that.bblur();
        // }, 0);
    },
    changeBvalue: function (e) {
        var e = e;
        this.setData({
            bvalue: e.detail.value
        })
    },
    changeTvalue: function (e) {
        var e = e;
        this.setData({
            tvalue: e.detail.value
        })
    },
    taptab: function (e) {
        var that = this;
        var a = e.target.dataset.classification;
        that.setData({
            bvalue: a
        });
        this.bblur();
        // console.log(e.target.dataset.classification);
    },
    deletehis: function () {
        // 删除历史
    },
    hidefa: function () {
        var that = this;
        this.data.ifshow = !this.data.ifshow;
        // console.log(that.data.ifshow)
        if (that.data.ifshow) {
            that.setData({
                eye: "/img/eyeon.png",
                suggestshow: "block",
                tipshow: "none"
            })
        }
        else {
            that.setData({
                eye: "/img/eyeoff.png",
                suggestshow: "none",
                tipshow: "block"
            })
        }
    }
})