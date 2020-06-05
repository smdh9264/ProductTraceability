import request from '@/utils/request'

// 获取路由
export const getRouters = () => {
  return request({
    url: '/user/menu/routes',
    method: 'get'
  })
  
}
// 获取路由
export const getMenu = () => {
  return request({
    url: '/user/menu/tree',
    method: 'get'
  })
  
}