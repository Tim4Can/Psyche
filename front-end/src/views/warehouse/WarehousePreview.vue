<template>
  <page-view title="全部帖子">
    <a-card>

    </a-card>
  </page-view>
</template>

<script>
import { PageView } from '@/layouts'
import Fuse from 'fuse.js'

export default {
  inject: ['reload'],
  name: 'Detail',
  components: {
    PageView
  },
  data() {
    return {

      }
   },
}

</script>

<style lang="less" scoped>
@import '~ant-design-vue/lib/style/themes/default.less';
#layout .ant-layout-header {
  background: #fff;
  color: #666;
}
.button-group {
  margin-top: 1rem;
  margin-bottom: 1rem;
  .button {
    margin-right: 5rem;
    margin-left: 0.5rem;
  }
}

.modal {
  margin-top: 1rem;
  margin-bottom: 1rem;
  .modal-number {
    margin-left: 0.6rem;
  }
}
</style>
