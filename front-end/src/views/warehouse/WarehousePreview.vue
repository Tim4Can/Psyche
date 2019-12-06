<template>
  <page-view title="全部帖子">
      <template>
        <a-card title="全部">
          <a-list :pagination="pagination">
        <a-list-item>
        <router-link :to="{ name: 'Detail' }">
        <a-card :bordered="false" style="width:100%">
          <a-card-meta title="阳光明媚的周一。" description="周一要上课了呀。">
          </a-card-meta>
        </a-card>
        </router-link>
        </a-list-item>
        <a-list-item>
        <a-card :bordered="false" style="width:100%">
          <a-card-meta title="感恩节快乐！" description="感谢这个世界，感谢你！">
          </a-card-meta>
        </a-card>
        </a-list-item>
        <a-list-item>
          <a-card :bordered="false" style="width:100%">
          <a-card-meta title="快要期末考试了" description="好好复习，好好考试，挺过这个月。">
          </a-card-meta>
          </a-card>
        </a-list-item>
        </a-list>
        </a-card>
      </template>
      <template>
      <a-card style="top:30px">
        <a-comment>
          <a-avatar
            slot="avatar"
            src="/avatar2.jpg"
          />
          <div slot="content">
            </a-form-item>
                  <a-form-item
                    label="题目"
                    :labelCol="{lg: {span: 7}, sm: {span: 7}}"
                    :wrapperCol="{lg: {span: 10}, sm: {span: 17} }">
                    <a-input
                      type="title"
                      v-decorator="[
            'title',
            {rules: [{ required: true, message: '请输入题目' }]}
          ]"
                      name="old_password"
                      placeholder="请输入题目"/>
            </a-form-item>
            <a-form-item>
              <a-textarea :rows="4" @change="handleChange" :value="value"></a-textarea>
            </a-form-item>
            <a-form-item>
              <a-radio>匿名</a-radio>
              <a-button htmlType="submit" :loading="submitting" @click="handleSubmit" type="primary">
                发帖
              </a-button>
            </a-form-item>
          </div>
        </a-comment>
      </a-card>
    </template>
  </page-view>
</template>

<script>
import Vue from 'vue'
import Fuse from 'fuse.js'
import Lightbox from 'vue-easy-lightbox'
import { PageView } from '@/layouts'
import moment from 'moment';

Vue.use(Lightbox)

  export default {
    components: {
        PageView
    },
    data() {
      return {
         moment,
         pagination: {
          onChange: page => {
            console.log(page);
          },
          pageSize: 3,
        },
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
