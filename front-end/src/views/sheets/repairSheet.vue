<template>
  <page-view title="老师信息">
    <div>
      <a-card>
        <div style="padding: 20px;">
          <a-row :gutter="16">
            <a-col :span="8">
              <a-card hoverable style="width: 300px">
                <img
                     alt="example"
                     src="https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png"
                     slot="cover"
                />
                <template class="ant-card-actions" slot="actions">
                   <a-button type="primary" block>预约</a-button>
                </template>
                <a-card-meta title="李一" description="被看见、被听见、被理解、被接受。">
                <a-avatar
                   slot="avatar"
                   src="/avatar2.jpg"
                />
                </a-card-meta>
              </a-card>
            </a-col>
            <a-col :span="8">
              <a-card hoverable style="width: 300px">
                <img
                     alt="example"
                     src="https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png"
                     slot="cover"
                />
                <template class="ant-card-actions" slot="actions">
                   <a-button type="primary" block>预约</a-button>
                </template>
                <a-card-meta title="Card title" description="This is the description">
                <a-avatar
                   slot="avatar"
                   src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
                />
                </a-card-meta>
              </a-card>
            </a-col>
            <a-col :span="8">
              <a-card hoverable style="width: 300px">
                <img
                     alt="example"
                     src="https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png"
                     slot="cover"
                />
                <template class="ant-card-actions" slot="actions">
                   <a-button type="primary" block>预约</a-button>
                </template>
                <a-card-meta title="Card title" description="This is the description">
                <a-avatar
                   slot="avatar"
                   src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
                />
                </a-card-meta>
              </a-card>
            </a-col>
          </a-row>
            <br/>
            <br/>
          <a-row :gutter="16">
            <a-col :span="8">
              <a-card hoverable style="width: 300px">
                <img
                     alt="example"
                     src="https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png"
                     slot="cover"
                />
                <template class="ant-card-actions" slot="actions">
                   <a-button type="primary" block>预约</a-button>
                </template>
                <a-card-meta title="Card title" description="This is the description">
                <a-avatar
                   slot="avatar"
                   src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
                />
                </a-card-meta>
              </a-card>
            </a-col>
            <a-col :span="8">
              <a-card hoverable style="width: 300px">
                <img
                     alt="example"
                     src="https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png"
                     slot="cover"
                />
                <template class="ant-card-actions" slot="actions">
                   <a-button type="primary" block>预约</a-button>
                </template>
                <a-card-meta title="Card title" description="This is the description">
                <a-avatar
                   slot="avatar"
                   src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
                />
                </a-card-meta>
              </a-card>
            </a-col>
            <a-col :span="8">
              <a-card hoverable style="width: 300px">
                <img
                     alt="example"
                     src="https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png"
                     slot="cover"
                />
                <template class="ant-card-actions" slot="actions">
                   <a-button type="primary" block>预约</a-button>
                </template>
                <a-card-meta title="Card title" description="This is the description">
                <a-avatar
                   slot="avatar"
                   src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
                />
                </a-card-meta>
              </a-card>
            </a-col>
          </a-row>
        </div>
      </a-card>
    </div>
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
  watch: {
    '$route' (to, from) {
      const toDepth = to.path.split('/').length
      const fromDepth = from.path.split('/').length
      this.transitionName = toDepth < fromDepth ? 'slide-right' : 'slide-left'
    }
  }
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
