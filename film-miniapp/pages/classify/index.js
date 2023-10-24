// pages/classify/index.js

const app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    activeIndex: 0,
    categoryList: [],
    secondaryCategoryList: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getCategory(0);
    this.getMovieList(-1)
  },

  tabClick: function (e) {
    this.setData({
      activeIndex: e.currentTarget.id
    });
    this.getMovieList(e.currentTarget.dataset.id);
  },

  getCategory: function(parentId){
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/category/list',
      data: { },
      success: function (res) {
        if (res.data.code == 0) {
          var categoryList = res.data.categoryList;
          categoryList.unshift({
            id: -1,
            categoryName: '全部'
          })
          that.setData({
            categoryList: categoryList
          });
        }
      }
    })
  },

  getMovieList: function (categoryId) {
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/movie/list',
      data: {
        categoryId: categoryId
      },
      success: function (res) {
        that.setData({
          movieList: res.data.movieList
        });
      }
    })
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