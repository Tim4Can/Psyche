/* eslint-disable */
import {UserLayout, BasicLayout, RouteView, BlankLayout, PageView} from '@/layouts'
import {bxAnaalyse, codeAPI, chat} from '@/core/icons'
import {addAccessoryInWarehouse} from '@/api/accessory'

export const asyncRouterMap = [
  {
    path: '/',
    name: 'index',
    component: BasicLayout,
    meta: {title: '首页'},
    redirect: '/homepage',
    children: [
      {
        path: '/homepage',
        name: 'homepage',
        meta: {title: '首页', keepAlive: true, icon: 'home'},
        component: () => import( '@/views/user/Homepage' ),
      },
      // warehouse
      {
        path: '/warehouse',
        name: 'warehouse',
        redirect: '/warehouse/preview',
        component: RouteView,
        meta: {title: '树洞', keepAlive: true, icon: chat},
        children: [
          {
            path: '/warehouse/preview',
            name: 'Preview',
            component: () => import( '@/views/warehouse/WarehousePreview' ),
            meta: {
              title: '帖子', keepAlive: false, icon: 'exception'
            }
          },
          {
            path: '/warehouse/detail',
            name: 'Detail',
            //hidden: true,
            component: () => import( '@/views/warehouse/WarehouseDetail' ),
            meta: {
              title: '详情', keepAlive: false,icon: 'copy'
            }
          },
          {
            path: '/warehouse/map',
            name: 'Map',
            hidden: true,
            component: () => import( '@/views/warehouse/Map' ),
            meta: {title: '地图', keepAlive: false, icon: 'picture'}
          }
        ]
      },
      // equipment
      {
        path: '/equipment',
        name: 'equipment',
        hidden: true,
        redirect: '/equipment/preview',
        meta: {title: '器材', keepAlive: true, icon: 'sliders'},
        component: RouteView,
        children: [
          {
            path: '/equipment/preview',
            name: 'EquipPreview',
            component: () => import( '@/views/equipment/EquipmentPreview' ),
            meta: {
              title: '仓储器材', keepAlive: false, icon: 'database'
            }
          },
          {
            path: '/equipment/using:pageNo([1-9]\\d*)?',
            name: 'EquipUsing',
            component: () => import( '@/views/equipment/EquipmentUsing' ),
            meta: {
              title: '在用器材', keepAlive: false, icon: 'api'
            }
          },
          {
            path: '/equipment/detail/:id',
            name: 'EquipDetail',
            hidden: true,
            component: () => import( '@/views/equipment/EquipInfo' ),
            meta: {
              title: '器材详情', keepAlive: false, icon: 'bars'
            },
          },
        ]
      },
      // accessory
      {
        path: '/accessory',
        name: 'accessory',
        hidden: true,
        meta: {title: '配件', keepAlive: true, icon: 'tool'},
        component: RouteView,
        children: [
          {
            path: '/accessory/Accessory',
            name: 'AccessoryInWarehouse',
            component: () => import( '@/views/accessory/Accessory' ),
            meta: {
              title: '配件管理', keepAlive: false, icon: 'bars'
            }
          }
        ]
      },
      // sheets
      {
        path: '/sheets',
        name: 'sheets',
        redirect: '/sheets/workSheet',
        component: RouteView,
        meta: {title: '线上预约', keepAlive: true, icon: "table"},
        children: [
          {
            path: '/sheets/repairSheet',
            name: 'repairSheet',
            component: () => import( '@/views/sheets/repairSheet' ),
            meta: {title: '老师信息', keepAlive: false, icon: 'exception'}
          },
          {
            path: '/sheets/checkSheet',
            name: 'checkSheet',
            //hidden: true,
            component: () => import( '@/views/sheets/checkSheet' ),
            meta: {title: '老师详情', keepAlive: false, icon: 'copy'}
          },
          {
            path: '/sheets/workSheet',
            name: 'workSheet',
            component: () => import( '@/views/sheets/workSheet' ),
            meta: {title: '我的预约', keepAlive: false, icon: 'snippets'}
          },
          {
            path: '/sheets/components/:details',
            name: 'repairDetail',
            hidden: true,
            component: () => import( '@/views/sheets/components/repairSheetDetail' ),
            meta: {
              title: '报修单详情', keepAlive: false, icon: 'bars'
            },
          },
        ]
      },

      // staff
      {
        path: '/staff/staffManage',
        name: 'staffManage',
        component: () => import( '@/views/staff/staffManage' ),
        meta: {title: '个人中心', keepAlive: true, icon: 'user'}
      },
      {
        path: '/server',
        name: 'server',
        hidden: true,
        redirect: '/server/KibanaMonitor',
        component: RouteView,
        meta: {title: '服务器', keepAlive: true, icon: bxAnaalyse},
        children: [
          {
            path: '/server/KibanaMonitor',
            name: 'KibanaMonitor',
            component: () => import( '@/views/server/KibanaMonitor' ),
            meta: {title: '监控', keepAlive: false, icon: bxAnaalyse}
          },
          {
            path: '/server/Swagger',
            name: 'Swagger',
            component: () => import( '@/views/server/Swagger' ),
            meta: {title: 'API', keepAlive: false, icon: codeAPI}
          },
        ]
      },
      {
        path: '/chat',
        name: 'chat',
        hidden: true,
        component: () => import( '@/views/chat/Rocket'),
        meta: {title: '聊天', keepAlive: true, icon: chat},
      }
    ]
  },
  {
    path: '*', redirect: '/404', hidden: true
  }
]

/**
 * 基础路由
 * @type { *[] }
 */
export const constantRouterMap = [
  {
    path: '/user',
    component: UserLayout,
    redirect: '/user/login',
    hidden: true,
    children: [
      {
        path: 'login',
        name: 'login',
        component: () => import(/* webpackChunkName: "user" */ '@/views/user/Login' )
      }
    ]
  },

  {
    path: '/test',
    component: BlankLayout,
    redirect: '/test/home',
    children: [
      {
        path: 'home',
        name: 'TestHome',
        component: () => import( '@/views/Home' )
      }
    ]
  },

  {
    path: '/404',
    component: () => import(/* webpackChunkName: "fail" */ '@/views/exception/404' )
  }

]
