//app.js
App({
  onLaunch: function () {
    var favorite = wx.getStorageSync('favorite')
    if(!favorite){
      wx.setStorageSync('favorite', [])
    }
    this.login(function () {

    });
  },
  //登录
  login: function (callback) {
    var that = this;
    wx.login({
      success: function (res) {
        wx.request({
          url: that.globalData.domain + '/api/wechat/login',
          data: {
            code: res.code
          },
          success: function (res) {
            if (res.data.code == 1) {
              that.globalData.sessionKey = res.data.sessionKey; //暂时，不应该在网络传输
              // 去注册
              callback(1)
              return;
            }
            if (res.data.code != 0) {
              // 登录错误 
              wx.hideLoading();
              wx.showModal({
                title: '提示',
                content: '无法登录，请重试',
                showCancel: false
              })
              return;
            }
            that.globalData.token = res.data.token;
            that.globalData.userInfo = res.data.userInfo;

            callback(0);
          }
        })
      }
    })
  },

  //注册
  register: function (userInfo, callback) {
    var that = this;
    wx.login({
      success: function (res) {
        var code = res.code; // 微信登录接口返回的 code 参数，下面注册接口需要用到
        // 下面开始调用注册接口
        wx.request({
          url: that.globalData.domain + '/api/wechat/register',
          data: {
            code: code,
            avatarUrl: userInfo.avatarUrl,
            nickname: userInfo.nickName,
            gender: userInfo.gender
          }, // 设置请求的 参数
          success: (res) => {
            if (res.data.code == 0) {
              wx.hideLoading();
              that.login(callback);
            } else {
              // 登录错误 
              wx.hideLoading();
              wx.showModal({
                title: '提示',
                content: '无法登录，请重试',
                showCancel: false
              })
            }

          }
        })
      }
    })
  },

  globalData: {
    userInfo: null,
    //domain: "http://mall.wfuhui.com"
    domain: "http://127.0.0.1:10001"
  }
})