<template>
  <page-view title="帖子详情">
    <a-card >
      <h3>阳光明媚的周一。</h3>
    </a-card>
    <a-card style="width:100%">
        <a-card-meta title="周一要上课了呀。">
        <img style="width:60px"
           slot="avatar"
           src="/avatar2.jpg"
        />
        </a-card-meta>
        <p>楼主</P>
    </a-card>
    <template>
    <a-card style="top:10px">
      <a-list bordered :dataSource="data"
          class="comment-list"
          :header="`${data.length} replies`"
          itemLayout="horizontal"
        >
          <a-list-item slot="renderItem" slot-scope="item, index">
            <a-comment :author="item.author" :avatar="item.avatar">
              <p slot="content">{{item.content}}</p>
              <p>{{item.index}}楼</p>
              <a-tooltip slot="datetime" :title="item.datetime.format('YYYY-MM-DD HH:mm:ss')">
                <span>{{item.datetime.fromNow()}}</span>
              </a-tooltip>
            </a-comment>
          </a-list-item>
        </a-list>
     </a-card>
    </template>
    <template>
      <div>
        <a-comment>
          <a-avatar
            slot="avatar"
            src="/avatar2.jpg"
          />
          <div slot="content">
            <a-form-item>
              <a-textarea :rows="4" @change="handleChange" :value="value"></a-textarea>
            </a-form-item>
            <a-form-item>
              <a-button htmlType="submit" :loading="submitting" @click="handleSubmit" type="primary">
                回复
              </a-button>
            </a-form-item>
          </div>
        </a-comment>
      </div>
    </template>
  </page-view>
</template>

<script>
import { PageView } from '@/layouts'
import Fuse from 'fuse.js'
import moment from 'moment';

export default {
  inject: ['reload'],
  name: 'Detail',
  components: {
    PageView
  },
  data() {
    return {
        comments: [],
        submitting: false,
        moment,
        data: [
          {
            author: '刘一',
            avatar: '/avatar2.jpg',
            content:
              '天气不错哦。',
            index:
              '1',
            datetime: moment().subtract(0, 'days'),
          },
          {
            author: '王一一',
            avatar: '/avatar2.jpg',
            content:
              '冬天到了，多添衣哦~',
            index:
              '2',
            datetime: moment().subtract(0, 'days'),
          },
        ],
      };
   },
   methods: {
      handleSubmit() {
        if (!this.value) {
          return;
        }

        this.submitting = true;

        setTimeout(() => {
          this.submitting = false;
          this.comments = [
            {
              author: '林一',
              avatar: '/avatar2.jpg',
              content: this.value,
              datetime: moment().fromNow(),
            },
            ...this.comments,
          ];
          this.value = '';
        }, 1000);
      },
      handleChange(e) {
        this.value = e.target.value;
      },
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
