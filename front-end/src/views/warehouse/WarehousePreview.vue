<template>
  <page-view title="全部帖子">
    <div>
      <template>
      <a-card>
        <a-list itemLayout="horizontal" :dataSource="data">
          <a-list-item slot="renderItem" slot-scope="item, index">
            <a-list-item-meta description='Psyche'>
              <a slot="title" href="https://vue.ant.design/">{{item.title}}</a>
              <a-avatar
                slot="avatar"
                src="/avatar2.jpg"
              />
            </a-list-item-meta>
          </a-list-item>
        </a-list>
      </a-card>
      </template>
    </div>
  </page-view>
</template>

<script>
import Vue from 'vue'
import Fuse from 'fuse.js'
import Lightbox from 'vue-easy-lightbox'
import { PageView } from '@/layouts'

Vue.use(Lightbox)
const data = [
    {
      title: '阳光明媚的周一。',
    },
    {
      title: '啦啦啦~',
    },
    {
      title: '感恩节快乐！',
    },
    {
      title: '初冬没有下雪。。。',
    },
  ];
  export default {
    components: {
        PageView
    },
    data() {
      return {
        data,
      };
    },
  };
</script>

<style lang="less" scoped>
@import '~ant-design-vue/lib/style/themes/default.less';
.button-group {
  margin-bottom: 1rem;
  .button {
    margin-left: 0.5rem;
    margin-left: 0.5rem;
  }
}
</style>
