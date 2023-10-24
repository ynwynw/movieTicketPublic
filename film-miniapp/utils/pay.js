function wxpay(app, money, orderNum, goodsName, callback) {
  wx.request({
    header: {
      "token": app.globalData.token
    },
    url: app.globalData.domain + '/app/pay/wechat/unifiedOrder',
    data: {
      storeId: app.globalData.storeId,
      orderNum: orderNum,
      totalAmount: money,
      goodsName: goodsName
    },
    success: function (res) {
      if (res.data.code == 0) {
        // 发起支付
        wx.requestPayment({
          timeStamp: res.data.data.timeStamp,
          nonceStr: res.data.data.nonceStr,
          package: res.data.data.package,
          signType: 'MD5',
          paySign: res.data.data.paySign,
          fail: function (resp) {
            wx.showToast({
              title: '支付失败',
              icon: 'none'
            })
            callback(1);
          },
          success: function () {
            wx.showToast({
              title: '支付成功',
              icon: 'none'
            })
            callback(0);
          }
        })
      } else {
        wx.showToast({
          title: res.data.msg,
          icon: 'none'
        })
        callback(1);
      }
    }
  })
}

module.exports = {
  wxpay: wxpay
}