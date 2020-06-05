
module.exports = {
  // webpack-dev-server 相关配置
  devServer: {
    // port: 8080,
    proxy: {

      '/': {
        target: 'http://localhost:9998',
        changeOrigin: true,
        ws:true,
        pathRewrite: {
          '^/' : '/'
        }
      }
    },
    disableHostCheck: true
  }
}
