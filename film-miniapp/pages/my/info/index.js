// pages/member-info/index.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  getMemberInfo: function () {
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/member/info',
      data: {
        token: app.globalData.token
      },
      success: function (res) {
        that.setData({
          memberInfo: res.data.member
        });
      }
    })
  },

  getBorrowCount: function () {
    var that = this;
    wx.request({
      url: app.globalData.domain + '/app/bms/order/countBorrow',
      data: {
        token: app.globalData.token
      },
      success: function (res) {
        that.setData({
          borrowCount: res.data.total
        });
      }
    })
  },

  getSignCount: function () {
    var that = this;
    wx.request({
      url: app.globalData.domain + '/app/signin/countSign',
      data: {
        token: app.globalData.token
      },
      success: function (res) {
        that.setData({
          signCount: res.data.total
        });
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getMemberInfo();
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
    this.getMemberInfo();
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

  edit: function () {
    wx.navigateTo({
      url: '/pages/my/edit/index',
    })
  }
})