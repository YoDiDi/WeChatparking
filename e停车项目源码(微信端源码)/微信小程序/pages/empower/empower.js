// pages/empower/empower.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
      
  },
 jump:function(){
   getApp().globalData.nickname = getApp().globalData.userInfo.nickName;
   wx.request({
     url: 'http://localhost:8080/WXServlet/WXServlet',
     data: {
       userName: getApp().globalData.userName,
       carID: getApp().globalData.carID,
       nickname: getApp().globalData.nickname,
       VIP: getApp().globalData.VIP
     },
     method: "GET",
     header: {
       'content-type': 'application/json',// 默认值
       'Content-Type': 'application/x-www-form-urlencoded'
     },
     success: function (res) {
       console.log(res.data);
       var str = res.data;
       var arr = str.split("|");
       console.log(arr[4])
       getApp().globalData.nickname = arr[0];
       getApp().globalData.userName = arr[1];
       getApp().globalData.carID = arr[2];
       getApp().globalData.VIP = arr[3];
       if(arr[4] != "null")
       getApp().globalData.position = arr[4] + "停车场-" + arr[5] + "区-" + arr[6] + "号";
     },
     fail: function (res) {
       console.log(".....fail.....");
     }
   })
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