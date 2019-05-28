// pages/information/information.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
  
  },
name:function(e){
  getApp().globalData.userName = e.detail.value
  console.log(getApp().globalData.userName)
},
carID:function(e){
  getApp().globalData.carID = e.detail.value
  console.log(getApp().globalData.carID)
},
submit:function(){

 /* console.log(getApp().globalData.carID)
  var provinces = "京\津\沪\渝\蒙\新\藏\宁\桂\港\澳\黑\吉\辽\晋\冀\青\鲁\豫\苏\皖\浙\闽\赣\湘\鄂\粤\琼\甘\陕\贵\云\川";
  var province = provinces.split("\\");
  var carId = getApp().globalData.carID.split();*/
  wx.request({
    url: 'http://localhost:8080/WXServlet/WXServlet',
    data: {
      key: "submitInformation",
      userName: getApp().globalData.userName,
      carID: getApp().globalData.carID,
      nickname: getApp().globalData.nickname
    },
    method: "POST",
    header: {
      //'content-type': 'application/json' // 默认值
      'Content-Type': 'application/x-www-form-urlencoded'
    },
    success: function (res) {
      console.log(res.data);
    },
    fail: function (res) {
      console.log(".....fail.....");
    }
  })
  wx.redirectTo({
    url: '../index/index',
  })

},

exit:function(){
  wx.redirectTo({
    url: '../index/index',
  })
},
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})


