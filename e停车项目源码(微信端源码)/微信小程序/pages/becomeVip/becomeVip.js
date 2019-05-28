// pages/becomeVip/becomeVip.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
 
  },

  /**
   * 生命周期函数--监听页面加载
   */

  vip:function(){
    if (getApp().globalData.VIP!=1){
      wx.showModal({
        title: '提示',
        content: '确定要支付吗？',
        success: function (res) {
          if (res.confirm) {
            getApp().globalData.VIP = 1;
            wx.showToast({
                title: '支付成功',
            })
            wx.request({
              url: 'http://localhost:8080/WXServlet/WXServlet',
              data: {
                /*userName: getApp().globalData.userName,
                carID: getApp().globalData.carID,*/
                key: "becomeVip",
                nickname: getApp().globalData.nickname,
                VIP: getApp().globalData.VIP
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

          } else {

          }
        }
      })
    }else{
      wx.showModal({
        title: '提示',
        content: '您已是会员',
        success: function (res) {
          if (res.confirm) {
           
          } else {

          }
    }
   })
  }
},
  exit:function(){
    wx.navigateTo({
      url: '../index/index',
    })
  },
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