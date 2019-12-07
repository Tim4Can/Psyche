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
              <div style="margin-left:40px">
              <li>国家一级咨询师</li>
              <li> 国际催眠治疗师</li>
              <li> 央视极速少年专家</li>
              <li> 欧文亚隆团体咨询师</li>
              </div>
             </a-col>
             <a-col :span="12">
              <h2>选择预约时间</h2>
              <a-row :gutter="16">
              <a-card>
                <a-col :span="5">
                  </br>
                  <a-row>
                    <p>10:00~11:00</P>
                  </a-row>
                  <a-row>
                    <p>11:00~12:00</P>
                  </a-row>
                  <a-row>
                    <p>14:00~15:00</P>
                  </a-row>
                  <a-row>
                    <p>15:00~16:00</P>
                  </a-row>
                </a-col>
                <a-col>
                <a-row>
                <a-col :span="2">
                  <h4>周一</h4>
                  <a-button-group>
                  <a-row>
                    <a-button  disabled />
                  </a-row>
                  <a-row>
                    <a-button />
                  </a-row>
                  <a-row>
                    <a-button />
                  </a-row>
                  <a-row>
                    <a-button />
                  </a-row>
                  </a-button-group>
                </a-col>
                <a-col :span="2">
                  <h4>周二</h4>
                  <a-button-group>
                  <a-row>
                    <a-button />
                  </a-row>
                  <a-row>
                    <a-button />
                  </a-row>
                  <a-row>
                    <a-button />
                  </a-row>
                  <a-row>
                    <a-button />
                  </a-row>
                  </a-button-group>
                </a-col>
                <a-col :span="2">
                  <h4>周三</h4>
                  <a-button-group>
                  <a-row>
                    <a-button />
                  </a-row>
                  <a-row>
                    <a-button />
                  </a-row>
                  <a-row>
                    <a-button />
                  </a-row>
                  <a-row>
                    <a-button />
                  </a-row>
                  </a-button-group>
                </a-col>
                <a-col :span="2">
                  <h4>周四</h4>
                  <a-button-group>
                  <a-row>
                    <a-button />
                  </a-row>
                  <a-row>
                    <a-button />
                  </a-row>
                  <a-row>
                    <a-button />
                  </a-row>
                  <a-row>
                    <a-button />
                  </a-row>
                  </a-button-group>
                </a-col>
                <a-col :span="2">
                  <h4>周五</h4>
                  <a-button-group>
                  <a-row>
                    <a-button />
                  </a-row>
                  <a-row>
                    <a-button />
                  </a-row>
                  <a-row>
                    <a-button />
                  </a-row>
                  <a-row>
                    <a-button />
                  </a-row>
                  </a-button-group>
                </a-col>
                </a-row>
                </a-col>
              </a-card>
              </a-row>
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
