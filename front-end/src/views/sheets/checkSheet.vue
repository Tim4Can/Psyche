<template>
  <page-view title="老师详情">
    <a-card>
          <template>
          <a-row :gutter="16">
             <a-col :span="8">
              <a-card hoverable style="width: 260px">
                <img
                     alt="example"
                     src="https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png"
                     slot="cover"
                />

                <a-card-meta title="李一" description="被看见、被听见、被理解、被接受。">
                <a-avatar
                   slot="avatar"
                   src="/avatar2.jpg"
                />
                </a-card-meta>
              </a-card>
             </a-col>
             <a-col :span="8">
              <div>
              <h1>基本信息</h1>
              <li>国家一级咨询师</li>
              <li> 国际催眠治疗师</li>
              <li> 央视极速少年专家</li>
              <li> 欧文亚隆团体咨询师</li>
              </div>
             </a-col>
             <a-col :span="8">
              <h2>选择预约时间</h2>
              <template>
                <a-cascader :options="options" @change="onChange" />
              </template>
             </a-col>
           </a-row>
          </template>
    </a-card>
  </page-view>
</template>

<script>
import Vue from 'vue'
import Fuse from 'fuse.js'
import Lightbox from 'vue-easy-lightbox'
import { PageView } from '@/layouts'

Vue.use(Lightbox)

export default {
  components: {
    PageView
  },
  data() {
      return {
        options: [
          {
            value: '周一',
            label: '周一',
            children: [
                  {
                    value: '9:00~10:00',
                    label: '9:00~10:00',
                  },
                  {
                    value: '11:00~12:00',
                    label: '11:00~12:00',
                  },
                  {
                    value: '14:00~15:00',
                    label: '14:00~15:00',
                  },
                  {
                    value: '16:00~17:00',
                    label: '16:00~17:00',
                  },
                ],
          },
          {
            value: '周二',
            label: '周二',
            children: [
                  {
                    value: '9:00~10:00',
                    label: '9:00~10:00',
                  },
                  {
                    value: '11:00~12:00',
                    label: '11:00~12:00',
                  },
                  {
                    value: '14:00~15:00',
                    label: '14:00~15:00',
                  },
                  {
                    value: '16:00~17:00',
                    label: '16:00~17:00',
                  },
                ],
          },
          {
            value: '周三',
            label: '周三',
            children: [
                  {
                    value: '9:00~10:00',
                    label: '9:00~10:00',
                  },
                  {
                    value: '11:00~12:00',
                    label: '11:00~12:00',
                  },
                  {
                    value: '14:00~15:00',
                    label: '14:00~15:00',
                  },
                  {
                    value: '16:00~17:00',
                    label: '16:00~17:00',
                  },
                ],
          },
          {
            value: '周四',
            label: '周四',
            children: [
                  {
                    value: '9:00~10:00',
                    label: '9:00~10:00',
                  },
                  {
                    value: '11:00~12:00',
                    label: '11:00~12:00',
                  },
                  {
                    value: '14:00~15:00',
                    label: '14:00~15:00',
                  },
                  {
                    value: '16:00~17:00',
                    label: '16:00~17:00',
                  },
                ],
          },
          {
            value: '周五',
            label: '周五',
            children: [
                  {
                    value: '9:00~10:00',
                    label: '9:00~10:00',
                  },
                  {
                    value: '11:00~12:00',
                    label: '11:00~12:00',
                  },
                  {
                    value: '14:00~15:00',
                    label: '14:00~15:00',
                  },
                  {
                    value: '16:00~17:00',
                    label: '16:00~17:00',
                  },
                ],
          },
        ],
      };
    },
    methods: {
      onChange(value) {
        console.log(value);
      },
    },
}

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
