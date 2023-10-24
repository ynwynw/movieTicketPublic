// pages/address/address-add/index.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    member: null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getMember()
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
  
  getMember: function () {
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/member/info',
      header: {
        token: app.globalData.token
      },
      data: {
        
      },
      success: function (res) {
        that.setData({
          member: res.data.member
        });
      }
    })
  },

  bindSave: function (e) {
    var that = this;
    var nickname = e.detail.value.nickname;
    var mobile = e.detail.value.mobile;

    if (nickname == "") {
      wx.showModal({
        title: '提示',
        content: '请填写昵称',
        showCancel: false
      })
      return
    }
    if (mobile == "") {
      wx.showModal({
        title: '提示',
        content: '请填写手机号码',
        showCancel: false
      })
      return
    }

    var data = e.detail.value;
    data.id = this.data.member.id
   
    wx.request({
      url: app.globalData.domain + '/api/member/update',
      header: {
        token: app.globalData.token
      },
      method: 'POST',
      data: data,
      success: function (res) {
        if (res.data.code != 0) {
          // 错误 
          wx.hideLoading();
          wx.showModal({
            title: '错误',
            content: res.data.msg,
            showCancel: false
          })
          return;
        }
        // 跳转到结算页面
        wx.navigateBack({})
      }
    })
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