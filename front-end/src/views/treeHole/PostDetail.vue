<template>
  <page-view title="帖子详情">
    <a-affix :offsetTop="this.top">
      <a-card >
        <h3>{{post_title}}</h3>
      </a-card>
    </a-affix>
    <a-card style="width:100%">
      <a-card-meta title='post.content' description='post_sendTime'>
        <img style="width:60px"
           slot="avatar"
           src="post_headPortrait"
        />
      </a-card-meta>
      <p>楼主</P>
    </a-card>
    <template>
    <a-card style="top:10px">
      <a-list bordered :dataSource="data" class="comment-list">
          <a-list-item slot="renderItem" slot-scope="item, index">
            <a-comment :author="item.speakerName" :avatar="item.speaker_headPortrait">
              <p slot="content">{{item.content}}</p>
              <p>{{item.index}}楼</p>
              <a-tooltip slot="datetime">
                <span>{{item.sendTime}}</span>
              </a-tooltip>
            </a-comment>
          </a-list-item>
      </a-list>
      <!-- <div id="pagination" >
        <a-pagination @change="onChange" :current="current" :totol="this.totalPage*10" />
      </div> -->
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
import { postDetail, sendComment } from '@/api/Treehole'
import Fuse from 'fuse.js'
import moment from 'moment';

export default {
  inject: ['reload'],
  name: 'PostDetail',
  components: {
    PageView
  },
  data() {
    return {
        comments: [],
        submitting: false,
        value: '',
        moment,
        data: [],
        allData: [],
        post_title: '',
        post_content: '',
        post_sendTime: '',
        post_headPortrait: '',//楼主的头像
        postID: this.$route.params.id,
        sendInfo:'',//评论是否成功信息
      };
   },
   methods: {
      async addComment(){
        sendComment(this.value).then((response) => {
        this.sendInfo = response.info1
        if(this.sendInfo === 'ok'){
          this.$notification.open({
          message: '评论成功',
          description: '本条树洞评论成功',
          icon: <a-icon type="check" style="color: #108ee9" />,
        });
          this.Data = [...response.data]
          this.DataShow = this.Data
        }
        else{
          this.$notification.open({
          message: '评论失败',
          description: '本条树洞评论失败',
          icon: <a-icon type="warning" style="color: #108ee9" />,
        });
        }
       })
      },
      handleSubmit() {
        if (!this.value) {
          return;
        }
        this.submitting = true;
        setTimeout(() => {
          this.submitting = false;
          addComment(),
          this.value = '';
        }, 1000);
      },
      handleChange(e) {
        this.value = e.target.value;
      },
    },
    mounted() {
      postDetail({}).then((response)=>{
        console.log(response);
        console.log(this.postID);
        this.allData=response.data;
        this.post_title=this.allData.title;
        this.post_content=this.allData.content;
        this.post_sendTime=this.allData.sendTime;
        this.post_headPortrait=this.allData.headPortrait;
        this.data=this.allData.data;
      })
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
