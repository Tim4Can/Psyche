<template>
  <page-view title="个人中心">
    <div>
          <template>
          <a-row :gutter="16">
             <a-col :span="8">
              <a-card hoverable style="width: 260px">
                <a-card-meta title="175001 林一" description="人类存在的目的，是在纯粹存在的黑暗中燃起一点光亮。">
                <a-avatar
                   slot="avatar"
                   src="/avatar2.jpg"
                />
                </a-card-meta>
                <br/>
                   <div>昵称：yiyi</div>
              </a-card>
              <br/>
              <a-button type="primary">修改密码</a-button>
             </a-col>
             <a-col :span="8">
              <div>
              <div>发帖</div>
              <template>
                <a-list itemLayout="horizontal" :dataSource="data">
                  <a-list-item slot="renderItem" slot-scope="item, index">
                    <a-list-item-meta
                      description="几天前"
                    >
                      <a slot="title" href="https://vue.ant.design/">{{item.title}}</a>
                      <a-avatar
                        slot="avatar"
                        src="/avatar2.jpg"
                      />
                    </a-list-item-meta>
                  </a-list-item>
                </a-list>
              </template>
              </div>
             </a-col>
             <a-col :span="8">
              <div>
              <div>收藏的文章</div>
              <template>
                <a-card hoverable style="width: 260px">
                <a-card-meta title="做个吃瓜群众没什么不好" description="八卦可能比我们想的更复杂、更具有社会重要性。">
                </a-card-meta>
                </a-card>
                <a-card hoverable style="width: 260px">
                <a-card-meta title="自卑，是带刺的" description="你以为自卑只是自己的事，其实它伤害了很多人。">
                </a-card-meta>
                </a-card>
              </template>
              </div>
             </a-col>
           </a-row>
          </template>
    </div>
  </page-view>
</template>

<script>
import { STable } from '@/components'
import { PageView } from '@/layouts'
import { getStaffSheet, deleteStaffSheetRow, modifyStaffSheetRow, addStaffSheetRow } from '@/api/staff'
import Fuse from 'fuse.js'
import md5 from 'md5'
import ARow from "ant-design-vue/es/grid/Row";
import ACol from "ant-design-vue/es/grid/Col";

const data = [
    {
      title: '阳光明媚的周五。',
    },
    {
      title: '今天也是元气满满的一天呢！',
    },
    {
      title: '再努力坚持一下！！',
    },
    {
      title: '来到这儿的第一天~~~',
    },
  ];
export default {
  components: {
    ACol,
    ARow,
    PageView,
    STable
  },
  data () {
    return {
      data,
    }
  },
}
</script>

<style lang="less" scoped>
.addButton{
    position: absolute;
    z-index: 999;
    right:1em;
    top:0em;
  }
</style>