// pages/selectParkingSpace/selectParkingSpace.js
const countys = ["南谯区", "琅琊区"] /*[]*/
const areas = ["A", "B", "C", "D"]
const nums = []
for(let i = 0; i < 20; i++){
  nums[i] = i+1;
}
Page({

  /**
   * 页面的初始数据
   */
  data: {
    latitude: null,
    longitude: null,
    toLatitude:0.1,
    toLongitude:0.1,
    markers:[],
    countys,
    county: countys[0],
    areas,
    area:areas[0],
    nums,
    num: nums[0],
    value:[0,0,0],
    isEmpty:1
  },
 map:function(){
   wx.getLocation({
     success: function (res) { 
     getApp().globalData.latitude = res.latitude;
     getApp().globalData.longitude = res.longitude;
     },
   })
   this.setData({
     latitude: getApp().globalData.latitude,
     longitude: getApp().globalData.longitude,
     markers: [{
       id: 0,
       longitude: getApp().globalData.longitude,
       latitude: getApp().globalData.latitude,
       iconPath: '../../img/car0.png',
       width: 32,
       height: 32,
     }]
   })
 },

 GO:function(){
     wx.openLocation({
       latitude: this.data.toLatitude,
       longitude: this.data.toLongitude,
       name: this.data.county + "停车场-" + this.data.area + "区-" + this.data.num + "号",
       scale: 15
     })

  
 },
bindChange:function(res){
  const val = res.detail.value;
  console.log(res);
  this.setData({
    county:this.data.countys[val[0]],
    area:this.data.areas[val[1]],
    num:this.data.nums[val[2]]
  })
var countyTemp = this.data.county 
var areaTemp = this.data.area
var numTemp = this.data.num
var that = this
   wx.request({
    url: 'http://localhost:8080/WXServlet/WXServlet',
    data: {
      key: "getIsEmpty",
      county: countyTemp,
      area: areaTemp,
      num: numTemp,
    },
    method: "POST",
    header: {
      //'content-type': 'application/json' // 默认值
      'Content-Type': 'application/x-www-form-urlencoded'
    },
    success: function (res) {
      that.setData({
        isEmpty: res.data.charCodeAt()
      })
      console.log("res.data.charCodeAt()=" + res.data.charCodeAt().toString())
    },
    fail: function (res) {
      console.log(".....fail.....");
    }
  })
 
},


booking:function(){
  var that = this
  console.log(getApp().globalData.position+"222")
if(this.data.isEmpty == 1){
  this.isEmptyNotice()
} else if (getApp().globalData.position != "position"){
  wx.showModal({
    title: '提示',
    content: '您已预定完成',
    success: function (res) { },
    fail: function (res) { },
    complete: function (res) { },
  })
}
  else{
  var countyTemp = this.data.county
  var areaTemp = this.data.area
  var numTemp = this.data.num
  getApp().globalData.position = countyTemp + "停车场-" + areaTemp + "区-" + numTemp +"号"
  wx.request({
    url: 'http://localhost:8080/WXServlet/WXServlet',
    data: {
      key: "setIsEmptyAndGetPosition",
      county: countyTemp,
      area: areaTemp,
      num: numTemp,
      nickname:getApp().globalData.nickname
    },
    method: "POST",
    header: {
      //'content-type': 'application/json' // 默认值
      'Content-Type': 'application/x-www-form-urlencoded'
    },
    success: function (res) {
        console.log(res.data)
        var arr = res.data.split("|")
        console.log(arr[0] + "|" + arr[1])
        that.setData({
          toLatitude: Number(arr[0]),
          toLongitude: Number(arr[1])
        })
    },
    fail: function (res) {
      console.log(".....fail.....");
    }
  })
  wx.showToast({
    title: '预定成功',
  })
}
  console.log(getApp().globalData.nickname)

},
isEmptyNotice:function(){
  wx.showModal({
    title: '提示',
    content: '本车位已被占用',
    success: function (res) { },
    fail: function (res) { },
    complete: function (res) { },
  })
},
index:function(){
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
  
  },

})