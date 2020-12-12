module.exports = {
  "devServer": {
    host: '0.0.0.0',
    disableHostCheck: true,
    "proxy": {
      "/api": {
        "target": "http://localhost:3000/api",
        "changeOrigin": true,
        "pathRewrite": {
          "^/api": ""
        }
      }
    }
  },
  "outputDir": "../backend/public",
  "transpileDependencies": [
    "vuetify"
  ]
}
//module.exports = {
//  configureWebpack: {
//      // other webpack options to merge in ... },
//  //devServer Options don't belong into `configureWebpack`
//  devServer: {
//    host: '0.0.0.0',
//    hot: true,
//    disableHostCheck: true,
//  },
//};