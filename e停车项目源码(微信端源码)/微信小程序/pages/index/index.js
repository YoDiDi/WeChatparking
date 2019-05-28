//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    vipImg: "../../img/vip.png",
    novipImg: "../../img/novip.png",
    VIP: getApp().globalData.VIP,
    userName: getApp().globalData.userName,
    carID: getApp().globalData.carID,
    enterTime: getApp().globalData.enterTime,
    position: getApp().globalData.position,
    toLatitude: 0,
    toLongitude: 0
  },
  //事件处理函数
  bindViewTap: function () {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  become: function () {
    if (this.data.userName != "#" && this.data.carID != "#") {
      wx.redirectTo({
        url: '../becomeVip/becomeVip',
      })
    } else {
      this.completeInfomation()
    }
  },
  completeInfomation: function () {
    wx.showModal({
      title: '提示',
      content: '您还没有完善信息,是否进入完善',
      success: function (res) {
        if (res.confirm) {
          wx.redirectTo({
            url: '../information/information',
          })
        } else {

        }
      }
    })
  },
  changeInformation: function () {
    console.log(getApp().globalData.nickname)
    wx.redirectTo({
      url: '../information/information',
    })

  },


  onLoad: function () {

    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse) {
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  getUserInfo: function (e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })

  },

  selectGarage: function () {
    if (this.data.userName != "#" && this.data.carID != "#") {
      if (getApp().globalData.position == null || getApp().globalData.position == "position") {
        wx.redirectTo({
          url: '../selectParkingSpace/selectParkingSpace',
        })
      } else {
        wx.showModal({
          title: '提示',
          content: '你已预定过停车场,是否更改预定',
          success: function (res) {
            if (res.confirm) {
              /**使得position变回原值而不是null */
              getApp().globalData.position = "position"
              wx.request({
                url: 'http://localhost:8080/WXServlet/WXServlet',
                data: {
                  key: "cancelReservation",
                  nickname: getApp().globalData.nickname
                },
                method: "POST",
                header: {
                  'content-type': 'application/json', // 默认值
                  'Content-Type': 'application/x-www-form-urlencoded'
                },
                success: function (res) {

                },
                fail: function (res) {
                  console.log(".....fail.....");
                }
              })
              wx.redirectTo({
                url: '../selectParkingSpace/selectParkingSpace',
              })
            } else {

            }
          }
        })
      }
    } else {
      this.completeInfomation()
    }
  },

  toGarage: function () {
    var position = getApp().globalData.position;
    var arr = position.split("-");
    for (var i = 0; i < arr.length; i++) {
      console.log(arr[i])
    }
    var countyTemp = arr[0].slice(0, arr[0].length - 3)
    var areaTemp = arr[1].slice(0, arr[1].length - 1)
    var numTemp = arr[2].slice(0, arr[2].length - 1)
    /*console.log(county + "|" + area + "|" + num)*/
    var that = this
    wx.request({
      url: 'http://localhost:8080/WXServlet/WXServlet',
      data: {
        key: "setIsEmptyAndGetPosition",
        county: countyTemp,
        area: areaTemp,
        num: numTemp,
        nickname: getApp().globalData.nickname,
        
      },
      method: "POST",
      header: {
        //'content-type': 'application/json' // 默认值
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      success: function (res) {
        console.log(res.data)
        var arr2 = res.data.split("|")
        console.log(arr2[0] + "|" + arr2[1])
        that.setData({
          toLatitude: Number(arr2[0]),
          toLongitude: Number(arr2[1])
        })
      },
      fail: function (res) {
        console.log(".....fail.....");
      }
    })

    wx.openLocation({
      latitude: this.data.toLatitude,
      longitude: this.data.toLongitude,
      name: getApp().globalData.position,
      scale: 15
    })
  },
  onShow: function () {
    this.setData({
      position: getApp().globalData.position,
      VIP: getApp().globalData.VIP,
      userName: getApp().globalData.userName,
      carID: getApp().globalData.carID
    })
  }
})