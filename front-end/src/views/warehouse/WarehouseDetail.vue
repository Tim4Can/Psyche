<template>
  <page-view title="帖子详情">
    <a-card >
  <a-comment style="height:120px;">
    <template slot="actions">
      <span>
        <a-tooltip title="Like">
          <a-icon type="like" :theme="action === 'liked' ? 'filled' : 'outlined'" @click="like" />
        </a-tooltip>
        <span style="padding-left: '8px';cursor: 'auto'">
          {{likes}}
        </span>
      </span>
      <span>
        <a-tooltip title="Dislike">
          <a-icon
            type="dislike"
            :theme="action === 'disliked' ? 'filled' : 'outlined'"
            @click="dislike"
          />
        </a-tooltip>
        <span style="padding-left: '8px';cursor: 'auto'">
          {{dislikes}}
        </span>
      </span>
      <span>Reply to</span>
    </template>
    <a slot="author">林一</a>
    <a-avatar
      src="/avatar2.jpg"
      alt="林一"
      slot="avatar"
    />
    <p slot="content">
      阳光明媚的周一。
    </p>
    <a-tooltip slot="datetime" :title="moment().format('YYYY-MM-DD HH:mm:ss')">
      <span>{{moment().fromNow()}}</span>
    </a-tooltip>
  </a-comment>
</a-card>
      <a-list size="small" bordered :dataSource="data"
          class="comment-list"
          :header="`${data.length} replies`"
          itemLayout="horizontal"
        >
          <a-list-item slot="renderItem" slot-scope="item, index">
            <a-comment :author="item.author" :avatar="item.avatar">
              <template slot="actions">
                <span v-for="action in item.actions">{{action}}</span>
              </template>
              <p slot="content">{{item.content}}</p>
              <a-tooltip slot="datetime" :title="item.datetime.format('YYYY-MM-DD HH:mm:ss')">
                <span>{{item.datetime.fromNow()}}</span>
              </a-tooltip>
            </a-comment>
          </a-list-item>
        </a-list>
    <template>
      <div>
        <a-list
          v-if="comments.length"
          :dataSource="comments"
          :header="`${comments.length} ${comments.length > 1 ? 'replies' : 'reply'}`"
          itemLayout="horizontal"
        >
          <a-list-item slot="renderItem" slot-scope="item, index">
            <a-comment
              :author="item.author"
              :avatar="item.avatar"
              :content="item.content"
              :datetime="item.datetime"
            >
            </a-comment>
          </a-list-item>
        </a-list>
        <a-comment>
          <a-avatar
            slot="avatar"
            src="/avatar2.jpg"
            alt="Han Solo"
          />
          <div slot="content">
            <a-form-item>
              <a-textarea :rows="4" @change="handleChange" :value="value"></a-textarea>
            </a-form-item>
            <a-form-item>
              <a-button htmlType="submit" :loading="submitting" @click="handleSubmit" type="primary">
                Add Comment
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
        likes: 0,
        dislikes: 0,
        action: null,
        comments: [],
        submitting: false,
        value: '',
        moment,
        data: [
          {
            actions: ['Reply to'],
            author: '刘一',
            avatar: '/avatar2.jpg',
            content:
              '天气不错哦。',
            datetime: moment().subtract(0, 'days'),
          },
          {
            actions: ['Reply to'],
            author: '王一一',
            avatar: '/avatar2.jpg',
            content:
              '冬天到了，多添衣哦~',
            datetime: moment().subtract(0, 'days'),
          },
        ],
        moment,
      };
   },
   methods: {
      like() {
        this.likes = 1;
        this.dislikes = 0;
        this.action = 'liked';
      },
      dislike() {
        this.likes = 0;
        this.dislikes = 1;
        this.action = 'disliked';
      },
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
