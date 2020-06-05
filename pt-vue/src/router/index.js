import Vue from 'vue'
import VueRouter from 'vue-router'
import PtRouter from './pt-router'
import LayOutRouter from './layout'
import ViewsRouter from './views'
import Store from '@/store'
Vue.use(VueRouter)
let Router = new VueRouter

PtRouter.install(Router, Store)
// Router.$avueRouter.formatRoutes(Store.state.user.menu, true)
Router.addRoutes([...ViewsRouter, ...LayOutRouter])
export default Router

